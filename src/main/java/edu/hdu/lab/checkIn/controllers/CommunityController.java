package edu.hdu.lab.checkIn.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hdu.lab.checkIn.mapper.BuildingMapper;
import edu.hdu.lab.checkIn.mapper.CommunityMapper;
import edu.hdu.lab.checkIn.mapper.PoliceMapper;
import edu.hdu.lab.checkIn.mapper.RoomMapper;
import edu.hdu.lab.checkIn.model.Building;
import edu.hdu.lab.checkIn.model.BuildingExample;
import edu.hdu.lab.checkIn.model.Community;
import edu.hdu.lab.checkIn.model.RoomExample;
import edu.hdu.lab.checkIn.services.PoliceService;
import edu.hdu.lab.checkIn.utils.JsonUtils;
import edu.hdu.lab.checkIn.utils.WebUtils;

@Controller
@RequestMapping("/community")
public class CommunityController {
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private PoliceService policeService;

	@Autowired
	private PoliceMapper policeMapper;

	@Autowired
	private CommunityMapper communityMapper;

	@Autowired
	private BuildingMapper buildingMapper;

	@Autowired
	private RoomMapper roomMapper;
	
	
	/**
	 * 根据comm_id返回统计信息
	 * @param comm_id 小区ID
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/statistics", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getStatisInfoByCommId(
			@RequestParam("comm_id") Integer comm_id,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		// 1.根据comm_id获取房间数
		resultMap.put("room_number", policeMapper.getRoomNumbyCommid(comm_id));
		// 2.根据comm_id获取未巡检房间数
		resultMap.put("over_due_room_number", policeMapper.getOverRoomNumbyCommid(comm_id));

		// 3.根据comm_id获取重点房间数
		resultMap.put("focus_room_number", policeMapper.getImpoRoomNumbyCommid(comm_id));
		
		// 4.根据comm_id获取总人数
		resultMap.put("person_number", policeMapper.getPersonNumbyCommid(comm_id));
		// 5.根据buil_id获取重点关注人数
		resultMap.put("focus_person_number", policeMapper.getImpoPersonNumbyCommid(comm_id));
		
		// 7.计算空房数
		resultMap.put("empty_room_number", policeMapper
				.getEmptyRoomNumbyCommid(comm_id));
		// 8.根据comm_id获取房间各种分类数
		resultMap
				.put("room_classify_info", policeMapper.getRoomSortNumbyCommid(comm_id));
		// 9.根据comm_id获取自住人数/租住人数/工作人数
		resultMap.put("person_classify_info",
				policeMapper.getPersSortNumbyCommid(comm_id));

		// 10.根据comm_id楼宇数
		BuildingExample buildingexample = new BuildingExample();
		buildingexample.createCriteria().andCommIdEqualTo(comm_id);
		Integer selectByExample = buildingMapper
				.countByExample(buildingexample);
		resultMap.put("building_number", selectByExample);
		// 11.根据comm_id获取超期未巡检楼宇数
		resultMap.put("over_due_building_number",
				policeMapper.getOverBuilNumbyCommid(comm_id));
		// 12.根据comm_id获取重点关注楼宇数
		resultMap.put("focus_building_number",
				policeMapper.getImpoBuilNumbyCommid(comm_id));
		// 13.根据comm_id获取房间各种子分类数
		resultMap.put("room_subclassify_info",
				policeMapper.getRoomSubSortNumbyCommid(comm_id));
		// 14.根据buil_id获取重点单位
				Map<String, Object> map = new HashMap<String, Object>(2);
				map.put("comm_id", comm_id);
				map.put("danger",1);
				resultMap.put("focus_drug_unit",
										policeMapper.countRoom(map));
				map.put("danger", 2);
				resultMap.put("focus_boom_unit",
						policeMapper.countRoom(map));
				map.put("danger", 3);
				resultMap.put("focus_toxic_unit",
						policeMapper.countRoom(map));
				map.put("danger", 4);
				resultMap.put("focus_danger_unit",
						policeMapper.countRoom(map));
		//15.根据comm_id获取楼宇数
				resultMap.put("building_count", buildingMapper.countBycommID(comm_id));
		return JsonUtils.createGson().toJson(resultMap);
	}

	/**
	 * 根据小区ID 获取Building List
	 * @param comm_id 小区ID
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/building", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getBuildingByCommid(
			@RequestParam("comm_id") Integer comm_id,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		BuildingExample buildingexample = new BuildingExample();
		buildingexample.createCriteria().andCommIdEqualTo(comm_id);
		resultMap.put("building",
		buildingMapper.selectByExample(buildingexample));
		return JsonUtils.createGson().toJson(resultMap);
	}
	
	/**
	 * 根据comm_id 获取community
	 * @param comm_id 小区ID
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/comm_id", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getCommBybuildID(
			@RequestParam("comm_id") Integer comm_id,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		resultMap.put("community",
		communityMapper.selectByPrimaryKey(comm_id));
		return JsonUtils.createGson().toJson(resultMap);
	}
	
	/**
	 * 新建community
	 * @param comm_id 小区ID
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String NewComm(
			@RequestParam("poli_id") Integer poli_id,
			@RequestParam("commName") String commName,
			@RequestParam(value="ramark",required = false) String ramark,
			@RequestParam(value="commGpslist",required = false) String commGpslist,
			@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		Community record=new Community();
		record.setPoliId(poli_id);
		record.setCommName(commName);
		record.setRamark(ramark);
		record.setCommGpslist(commGpslist);
		record.setIsDeleted(false);
//		resultMap.put("resultCode",
//		communityMapper.insert(record));
		int resultCode = communityMapper.insert(record);
//		return JsonUtils.createGson().toJson(resultMap);
		return WebUtils.produceResult(callback, resultCode);
	}
	
	/**
	 * 根据comm_id 修改community
	 * @param comm_id 小区ID
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/edit.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String UpdateComm(
			@RequestParam(value = "comm_id", required = true) Integer comm_id,
			@RequestParam(value = "poli_id", required = false) Integer poli_id,
			@RequestParam(value = "commName", required = false) String commName,
			@RequestParam(value = "ramark", required = false) String ramark,
			@RequestParam(value = "commGpslist", required = false) String commGpslist,
			@RequestParam(value = "isDeleted", required = false) Boolean isDeleted,
			@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		Community record=new Community();
		record.setCommId(comm_id);
		record.setPoliId(poli_id);
		record.setCommName(commName);
		record.setRamark(ramark);
		record.setCommGpslist(commGpslist);
		record.setIsDeleted(isDeleted);
//		resultMap.put("resultCode",
//		communityMapper.updateByPrimaryKeySelective(record));
//		return JsonUtils.createGson().toJson(resultMap);
		int resultCode = communityMapper.updateByPrimaryKeySelective(record);
		return WebUtils.produceResult(callback, resultCode);
	}
}
