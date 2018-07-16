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
import edu.hdu.lab.checkIn.mapper.PoliceStationMapper;
import edu.hdu.lab.checkIn.mapper.RoomMapper;
import edu.hdu.lab.checkIn.model.Building;
import edu.hdu.lab.checkIn.model.PoliceExample;
import edu.hdu.lab.checkIn.model.RoomExample;
import edu.hdu.lab.checkIn.services.PoliceService;
import edu.hdu.lab.checkIn.utils.JsonUtils;

@Controller
@RequestMapping("/police_station")
public class PoliceStationController {
	private Logger logger = Logger.getLogger(getClass());
	
	

	@Autowired
	private PoliceMapper policeMapper;

	@Autowired
	private RoomMapper roomMapper;
	
	@Autowired
	private PoliceService policeService;
	
	@Autowired
	private CommunityMapper communityMapper;

	@Autowired
	private BuildingMapper buildingMapper;

	@Autowired
	private PoliceStationMapper policeStationMapper;
	
	// 根据派出所获取树#
	@ResponseBody
	@RequestMapping(value = "/jurisdiction", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getCommByStationId(
			@RequestParam("poli_station_id") Integer poli_station_id,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		// 根据派出所id获取Community

		resultMap.put("community", policeMapper.getCommByOffi(poli_station_id));

		resultMap.put("building", policeMapper.getbBuilByOffi(poli_station_id));
		return JsonUtils.createGson().toJson(resultMap);
	}
	
	
	// 根据派出所获取树#
		@ResponseBody
		@RequestMapping(value = "/getPoliIdByStation", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
		public String getPoliByStationId(
				@RequestParam("poli_station_id") Integer poli_station_id,
				HttpServletRequest request) {
			Map<String, Object> resultMap = new HashMap<String, Object>(2);
			PoliceExample example=new PoliceExample();
			example.createCriteria().andPoliRoleEqualTo("01");
			policeMapper.selectByExample(example);
			return JsonUtils.createGson().toJson(resultMap);
		}
	
	// 
	/**
	 * 根据警局ID返回统计信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/jurisdiction/statistics", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getStatisInfoByPoliStationId(
			@RequestParam("poli_station_id") Integer poli_station_id,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		// 获取独立的building
		List<Building> selectByExample = policeMapper.getbBuilByOffi(poli_station_id);
		resultMap.put("indebuilding", selectByExample.size());
		// 获取独立的comm——building
		selectByExample.addAll(policeMapper.getCommBuilByOffi(poli_station_id));
		int room_number = 0;
		int unit_number = 0;
		int overRoom_number = 0;
		int impoRoom_number = 0;
		int person_number = 0;
		int impoPerson_number = 0;
		int emptyRoomNumbyBuilid = 0;

		for (Building building : selectByExample) {
			// 1.根据buil_id获取单元数，和房间数
			Integer builId = building.getBuilId();
			HashMap<String, Integer> roomNumAndUnitbyBuilid = policeMapper
					.getRoomNumAndUnitbyBuilid(builId);
			unit_number += Integer.valueOf(String
					.valueOf(roomNumAndUnitbyBuilid.get("unit_number")));
			room_number += Integer.valueOf(String
					.valueOf(roomNumAndUnitbyBuilid.get("room_number")));
			// 2.根据buil_id获取未巡检房间数
			overRoom_number += policeMapper.getOverRoomNumbyBuilid(builId);
			// 3.根据buil_id获取重点房间数
			RoomExample example = new RoomExample();
			example.createCriteria().andBuilIdEqualTo(builId)
					.andIsFocusEqualTo(true);
			impoRoom_number += roomMapper.countByExample(example);
			// 4.根据buil_id获取总人数
			person_number += policeMapper.getPersonNumbyBuilid(builId);
			// 5.根据buil_id获取重点关注人数
			impoPerson_number += policeMapper.getImpoPersonNumbyBuilid(builId);
			// 6.根据buil_id获取有人的房数
			emptyRoomNumbyBuilid += policeMapper
					.getEmptyRoomNumbyBuilid(builId);
		}
		resultMap.put("unit_number", unit_number);
		resultMap.put("room_number", room_number);
		resultMap.put("over_due_room_number", overRoom_number);
		resultMap.put("focus_room_number", impoRoom_number);
		resultMap.put("person_number", person_number);
		resultMap.put("focus_person_number", impoPerson_number);
		// 计算得到空房数
		resultMap.put("empty_room_number", room_number - emptyRoomNumbyBuilid);
		// 获取所有的小区

		// 6.根据stat_id获取房间各种分类数
		resultMap.put("room_classify_info", policeMapper.getRoomSortNumbyStatid(poli_station_id));
		// 7.根据stat_id获取自住人数/租住人数/工作人数
		resultMap.put("person_classify_info",policeMapper.getPersSortNumbyStatid(poli_station_id));
		// 9.根据stat_id楼宇数
		resultMap.put("building_number", selectByExample.size());
		// 10.根据stat_id获取超期未巡检楼宇数
		resultMap.put("over_due_building_number",policeMapper.getOverBuilNumbyStatid(poli_station_id));
		// 11.根据stat_id获取重点关注楼宇数
		resultMap.put("focus_building_number",policeMapper.getImpoBuilNumbyStatid(poli_station_id));
		// 12.根据stat_id获取小区数
		resultMap.put("community_number",policeMapper.getCommNumbyStatid(poli_station_id));
		// 13.根据stat_id获取超期未巡检小区数
		resultMap.put("over_due_community_number", policeMapper.getOverCommNumbyStatid(poli_station_id));
		// 14.根据Poli_id获取重点关注小区数；
		resultMap.put("focus_community_number", policeMapper.getImpoCommNumbyStatid(poli_station_id));
		// 15.根据Poli_id获取警员数；
		PoliceExample example =new PoliceExample();
		example.createCriteria().andStatIdEqualTo(poli_station_id);
		resultMap.put("police_number", policeMapper.countByExample(example));
		return JsonUtils.createGson().toJson(resultMap);
	}
}
