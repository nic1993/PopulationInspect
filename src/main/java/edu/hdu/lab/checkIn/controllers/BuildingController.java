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

import edu.hdu.lab.checkIn.dto.RoomStatis;
import edu.hdu.lab.checkIn.mapper.BuildingMapper;
import edu.hdu.lab.checkIn.mapper.CommunityMapper;
import edu.hdu.lab.checkIn.mapper.DictionaryMapper;
import edu.hdu.lab.checkIn.mapper.PersonMapper;
import edu.hdu.lab.checkIn.mapper.PoliceMapper;
import edu.hdu.lab.checkIn.mapper.RoomMapper;
import edu.hdu.lab.checkIn.model.Building;
import edu.hdu.lab.checkIn.model.CommunityExample;
import edu.hdu.lab.checkIn.model.Dictionary;
import edu.hdu.lab.checkIn.model.DictionaryExample;
import edu.hdu.lab.checkIn.model.Room;
import edu.hdu.lab.checkIn.model.RoomExample;
import edu.hdu.lab.checkIn.services.PoliceService;
import edu.hdu.lab.checkIn.services.RoomService;
import edu.hdu.lab.checkIn.utils.JsonUtils;
import edu.hdu.lab.checkIn.utils.WebUtils;

@Controller
public class BuildingController {
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
	
	@Autowired
	private PersonMapper personMapper;

	@Autowired
	private RoomService roomService;

	@Autowired
	private DictionaryMapper dictionaryMapper;

	/**
	 * 根据 建筑ID 获取 建筑的统计信息
	 * 
	 * @param buil_id
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/building/statistics", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getStatisInfoByBuilId(
			@RequestParam("buil_id") Integer buil_id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		// 1.根据buil_id获取单元数，和房间数

		HashMap<String, Integer> roomNumAndUnitbyBuilid = policeMapper
				.getRoomNumAndUnitbyBuilid(buil_id);

		resultMap.put("unit_number", roomNumAndUnitbyBuilid.get("unit_number"));

		Integer room_num = Integer.valueOf(String
				.valueOf(roomNumAndUnitbyBuilid.get("room_number")));
		resultMap.put("room_number", room_num);

		// 2.根据buil_id获取未巡检房间数
		resultMap.put("over_due_room_number",
				policeMapper.getOverRoomNumbyBuilid(buil_id));
		// 3.根据buil_id获取重点房间数
		resultMap.put("focus_room_number", policeMapper.getImpoRoomNumbyBuilid(buil_id));

		// 4.根据buil_id获取总人数
		resultMap.put("person_number",
				policeMapper.getPersonNumbyBuilid(buil_id));

		// 5.根据buil_id获取重点关注人数
		resultMap.put("focus_person_number",
				policeMapper.getImpoPersonNumbyBuilid(buil_id));

		// 6.根据buil_id获取房间各种分类数
		resultMap.put("room_classify_info",
				policeMapper.getRoomSortNumbyBuilid(buil_id));
		

		// 7.根据buil_id获取自住人数/租住人数/工作人数
		resultMap.put("person_classify_info",
				policeMapper.getPersSortNumbyBuilid(buil_id));

		// 8.根据buil_id获取空房数
		resultMap.put("empty_room_number", policeMapper
				.getEmptyRoomNumbyBuilid(buil_id));
		
		// 9.根据buil_id获取房间各种子分类数
		resultMap.put("room_subclassify_info",
						policeMapper.getRoomSubSortNumbyBuilid(buil_id));
		// 10.根据buil_id获取重点单位
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("buil_id", buil_id);
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
		return JsonUtils.createGson().toJson(resultMap);
		
				
	}

	/**
	 * 根据build ID 获取 单元列表
	 * 
	 * @param buil_id
	 *            建筑ID
	 * @param request
	 * @return 单元列表
	 */
	@ResponseBody
	@RequestMapping(value = "/building/unit", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getUnitByBuilId(@RequestParam("buil_id") Integer buil_id,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		resultMap.put("unit", policeMapper.getUnitByBuidid(buil_id));
		return JsonUtils.createGson().toJson(resultMap);
	}

	/**
	 * 
	 * @param buil_id
	 *            建筑ID
	 * @param unit_num
	 *            单元数
	 * @param request
	 * @return JSON floor 楼层List
	 */
	@ResponseBody
	@RequestMapping(value = "/building/unit/floor", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getFloorByBuilIdUnitNum(
			@RequestParam("buil_id") Integer buil_id,
			@RequestParam("unit_num") Integer unit_num,
			HttpServletRequest request) {

		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		// 根据buil_id获取单元数
		resultMap.put("floor",
				policeMapper.getFloorByBuididAndUnit(buil_id, unit_num));
		return JsonUtils.createGson().toJson(resultMap);
	}

	/**
	 * 根据Buil_
	 * 
	 * @param buil_id
	 *            建筑ID
	 * @param unit_num
	 *            单元数
	 * @param floor_num
	 *            楼层数
	 * @param request
	 * @return ROOM List 房间列表
	 */
	@ResponseBody
	@RequestMapping(value = "/building/unit/floor/room", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getRoomByBuilIUnitNumFloorNum(
			@RequestParam("buil_id") Integer buil_id,
			@RequestParam("unit_num") Integer unit_num,
			@RequestParam("floor_num") Integer floor_num,
			HttpServletRequest request) {

		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		RoomExample example = new RoomExample();
		// 根据buil_id获取单元数
		example.createCriteria().andBuilIdEqualTo(buil_id)
				.andRoomUnitEqualTo(unit_num).andRoomFloorEqualTo(floor_num);
		example.setOrderByClause("ROOM_NO");
		List<Room> roomCollection = roomMapper.selectByExample(example);

		/* TODO 在room 里面添加信息：房间人数 ，改房间是否超期 */
		for (Room room : roomCollection) {
			RoomStatis roomStatis = roomService.getRoomStatisInfoByRoomId(room
					.getRoomId());
			room.setRoomStatis(roomStatis);
		}

		resultMap.put("room", roomCollection);
		return JsonUtils.createGson().toJson(resultMap);
	}

	@ResponseBody
	@RequestMapping(value = "/building/roomClass", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getBuilIRoomClass(
			@RequestParam(value = "poli_id", required = true) Integer poli_id,
			@RequestParam(value = "comm_id", required = false) Integer comm_id,
			@RequestParam(value = "roomClass", required = false) String roomClass,
			@RequestParam(value = "roomSubclass", required = false) String roomSubclass,
			HttpServletRequest request) {

		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("poli_id", poli_id);
		if (comm_id!=null) {
			map.put("comm_id", comm_id);
		}
		if (roomClass != null) {
			// 获取分类
			DictionaryExample example = new DictionaryExample();
			example.createCriteria().andDictClassEqualTo("FJFL");
			List<Dictionary> dictionary = dictionaryMapper
					.selectByExample(example);
			// 遍历分类
			for (Dictionary dictionary2 : dictionary) {
				if (roomClass.contains(dictionary2.getDictItem())) {
					map.put("roomClass", dictionary2.getDictItem());
					resultMap.put(
							dictionary2.getDictItem(),
							buildingMapper.getBuildbyRoomClass(
									map));
				}
			}
		}
		if (roomSubclass != null) {
			DictionaryExample example = new DictionaryExample();
			example.createCriteria().andDictClassEqualTo("FJZL");
			List<Dictionary> dictionary = dictionaryMapper
					.selectByExample(example);
			for (Dictionary dictionary2 : dictionary) {
				if (roomSubclass.contains(dictionary2.getDictItem())) {
					resultMap.put(dictionary2.getDictItem(), buildingMapper
							.getBuildbyRoomSubClass(map));
				}
			}
		}
		return JsonUtils.createGson().toJson(resultMap);
	}

	@ResponseBody
	@RequestMapping(value = "/building/OverDate", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getBuilIOverDate(
			@RequestParam(value = "poli_id", required = true) Integer poli_id,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		resultMap.put("building", buildingMapper.getOverBuilbyPoliid(poli_id));
		return JsonUtils.createGson().toJson(resultMap);
	}

	// 辖区小区总数/超期未巡检小区数（饼图）；超期未巡检小区信息（列表显示）；
	// 辖区楼宇（建筑）总数/超期未巡检楼宇（建筑）数（饼图）；超期未巡检楼宇（建筑）信息（列表显示）；
	// 辖区房间总数/超期未巡检房间数（饼图）；超期未巡检房间信息（列表显示）；
	@ResponseBody
	@RequestMapping(value = "/overInfo/OverDate", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getCommOverDate(
			@RequestParam(value = "poli_id", required = true) Integer poli_id,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		// 1.community
		// 1.1根据警员id获取查询超期为巡检的的小区数
		resultMap.put("over_due_community_number",
				policeMapper.getOverCommNumbyPoliid(poli_id));
		// 1.2根据Poli_id获取小区数
		// 根据警员id获取Community
		CommunityExample communityexample = new CommunityExample();
		communityexample.createCriteria().andPoliIdEqualTo(poli_id);
		resultMap.put("community_number",
				communityMapper.countByExample(communityexample));
		// 1.3根据警员id获取超期小区
		resultMap.put("over_due_community",
				communityMapper.getCommunitybyOverDate(poli_id));
//		// 1.4根据警员id获取预警小区
				resultMap.put("quick_over_due_community",
						communityMapper.getCommunitybyQuickOverDate(poli_id));
		// 2.building
		// 2.1根据警员id获取查询超期未巡检的的建筑数
		resultMap.put("over_due_building_number",
				policeMapper.getOverBuilNumbyPoliid(poli_id));
		// 2.2根据Poli_id获取建筑数
		List<Building> selectByExample = policeMapper.getBuilbyPoliid(poli_id);
		resultMap.put("building_number", selectByExample.size());
		// 2.3根据警员id获取超期的建筑
		resultMap.put("over_due_building",
				buildingMapper.getOverBuilbyPoliid(poli_id));
		// 2.4根据警员id获取预警建筑
		resultMap.put("quick_over_due_building",
				buildingMapper.getQuickOverBuilbyPoliid(poli_id));
		// 3.room
		// 3.1根据警员id获取查询超期未巡检的的房间
		List<Room> overDueRoomByPoliid = roomMapper.getOverDueRoomByPoliid(poli_id);
		resultMap.put("over_due_room",
				overDueRoomByPoliid);
		// 3.2根据警员id获取超期的房间数
				resultMap.put("over_due_room_num",
						overDueRoomByPoliid.size());
		// 3.3根据警员id获取房间数
				resultMap.put("room_num",
						roomMapper.getRoomNumByPoliid(poli_id));
		// 3.4根据警员id获取预警房间
		resultMap.put("quick_over_due_room",
				roomMapper.getQuickOverDueRoomByPoliid(poli_id));
		return JsonUtils.createGson().toJson(resultMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "/overInfo/OverDateInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getCommOverDateInfo(
			@RequestParam(value = "poli_id", required = true) Integer poli_id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("poli_id", poli_id);
		if (page != null && size != null) {
			map.put("page", size * (page -1));
			map.put("size", size);
		}
		// 4.1根据警员id获取超期人员
		resultMap.put("over_due_person",
				personMapper.getOverPersbyPoliid(map));
		// 4.2根据警员id获取预警人员
		resultMap.put("quick_over_due_person",
				personMapper.getQuickOverPersbyPoliid(map));
		return JsonUtils.createGson().toJson(resultMap);
	}
	
	
	/**
	 * 根据buil_id 获取building
	 * @param buil_id 建筑id
	 * @param request
	 * @return
	 */ 
	@ResponseBody
	@RequestMapping(value = "/building/buil_id", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getCommBybuildID(
			@RequestParam("buil_id") Integer buil_id,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		resultMap.put("building",
		buildingMapper.selectByPrimaryKey(buil_id));
		return JsonUtils.createGson().toJson(resultMap);
	}
	
	/**
	 * 新建building
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/building/add.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String NewBuilBybuildID(
			@RequestParam("poli_id") Integer poli_id,
			@RequestParam("commId") Integer commId,
			@RequestParam(value = "ramark",required = false) String ramark,
			@RequestParam("builName") String builName,
			@RequestParam(value = "builType",required = false) String builType,
			@RequestParam(value = "builGpse",required = false) Float builGpse,
			@RequestParam(value = "builGpsn",required = false) Float builGpsn,
			@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		Building record=new Building();
		record.setPoliId(poli_id);
		record.setCommId(commId);
		record.setRamark(ramark);
		record.setBuilGpse(builGpse);
		record.setBuilGpsn(builGpsn);
		record.setBuilName(builName);
		record.setBuilType(builType);
		record.setIsDeleted(false);
//		resultMap.put("resultCode",
//		buildingMapper.insert(record));
//		return JsonUtils.createGson().toJson(resultMap);
		int resultCode = buildingMapper.insert(record);
		return WebUtils.produceResult(callback, resultCode);
	}
	
	/**
	 * 根据comm_id 修改building
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/building/edit.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String UpdateCommBybuildID(
			@RequestParam(value ="poli_id", required = false) Integer poli_id,
			@RequestParam(value ="builId", required = true) Integer builId,
			@RequestParam(value ="commId", required = true) Integer commId,
			@RequestParam(value ="ramark", required = false) String ramark,
			@RequestParam(value ="builName", required = false) String builName,
			@RequestParam(value ="builType", required = false) String builType,
			@RequestParam(value ="isDeleted", required = false) Boolean isDeleted,
			@RequestParam(value ="builGpse", required = false) Float builGpse,
			@RequestParam(value ="builGpsn", required = false) Float builGpsn,
			@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		Building record=new Building();
		record.setPoliId(poli_id);
		record.setCommId(commId);
		record.setBuilId(builId);
		record.setRamark(ramark);
		record.setBuilGpse(builGpse);
		record.setBuilGpsn(builGpsn);
		record.setBuilName(builName);
		record.setBuilType(builType);
		record.setIsDeleted(isDeleted);
//		resultMap.put("resultCode",
//		buildingMapper.updateByPrimaryKeySelective(record));
//		return JsonUtils.createGson().toJson(resultMap);
		int resultCode = buildingMapper.updateByPrimaryKeySelective(record);
		return WebUtils.produceResult(callback, resultCode);
		
	}
	
	

}
