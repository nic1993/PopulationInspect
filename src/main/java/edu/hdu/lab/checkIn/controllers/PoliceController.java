package edu.hdu.lab.checkIn.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hdu.lab.checkIn.dto.PoliceBasic;
import edu.hdu.lab.checkIn.mapper.BuildingMapper;
import edu.hdu.lab.checkIn.mapper.CommunityMapper;
import edu.hdu.lab.checkIn.mapper.InspectLogMapper;
import edu.hdu.lab.checkIn.mapper.PoliceMapper;
import edu.hdu.lab.checkIn.mapper.RoomMapper;
import edu.hdu.lab.checkIn.model.Building;
import edu.hdu.lab.checkIn.model.BuildingExample;
import edu.hdu.lab.checkIn.model.CommunityExample;
import edu.hdu.lab.checkIn.model.PoliceExample;
import edu.hdu.lab.checkIn.model.RoomExample;
import edu.hdu.lab.checkIn.services.LoginService;
import edu.hdu.lab.checkIn.services.PoliceService;
import edu.hdu.lab.checkIn.utils.FormVerify;
import edu.hdu.lab.checkIn.utils.JsonUtils;

@Controller
@RequestMapping("/police")
public class PoliceController {

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
	private LoginService loginService;

	@Autowired
	private InspectLogMapper inspectLogMapper;
	/**
	 * LOGIN_STATUS
	 */

	public final static int LOGIN_STATUS_LOGIN_SUCCESS = 1;
	public final static int LOGIN_STATUS_WRONG_PASSWORD = 2;
	public final static int LOGIN_STATUS_POLI_NOT_FOUND = 3;

	public final static String LOGIN_STATUS_POLI_NOT_FOUND_STR = "No Such Police Exist,Please Check Your Police Code.";
	public final static String LOGIN_STATUS_WRONG_PASSWORD_STR = "Wrong Password.";
	public final static String LOGIN_STATUS_LOGIN_SUCCESS_STR = "Login Success .";

	/*
	 * TODO Add Login Page
	 */
	/**
	 * 路由： 登陆
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String policeLogin() {
		return "police/login";
	}

	/**
	 * 警员登陆信息验证（*）
	 * 
	 * @param poliCode
	 * @param poliPwd
	 * @param loginIp
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String authorizePolice(@RequestParam("poli_code") String poliCode,
			@RequestParam("poli_pwd") String poliPwd,
			@RequestParam("ip") String loginIp, HttpServletRequest request) {
		int loginStatusCode = -1;
		String loginStatusStr = "";

		Map<String, Object> resultMap = new HashMap<String, Object>(3);

		/**
		 * From Text Filter.
		 */
		poliCode = FormVerify.TextFilter(poliCode);
		poliPwd = FormVerify.TextFilter(poliPwd);
		loginIp = FormVerify.TextFilter(loginIp);

		PoliceBasic poliExpected = policeService.getPoliceByPoliCode(poliCode);

		if (poliExpected == null || poliExpected.getIsDeleted()) {
			loginStatusCode = LOGIN_STATUS_POLI_NOT_FOUND;
			loginStatusStr = LOGIN_STATUS_POLI_NOT_FOUND_STR;
		} else if (loginService.isPasswardMatch(poliPwd, poliExpected)) {
			loginStatusCode = LOGIN_STATUS_LOGIN_SUCCESS;
			loginStatusStr = LOGIN_STATUS_LOGIN_SUCCESS_STR;

			resultMap.put("police", poliExpected);
			policeService.updateLoginInfo(poliExpected.getPoliId(), loginIp,
					new Date());
		} else {
			loginStatusCode = LOGIN_STATUS_WRONG_PASSWORD;
			loginStatusStr = LOGIN_STATUS_WRONG_PASSWORD_STR;
		}

		resultMap.put("loginStatusCode", loginStatusCode);
		resultMap.put("loginStatusStr", loginStatusStr);

		return JsonUtils.createGson().toJson(resultMap);
	}

	/**
	 * 警员的超期未巡检记录
	 * 
	 * @param poli_id
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/inspectlog/overdue", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getOverDueInspectLog(
			@RequestParam("poli_id") Integer poli_id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		resultMap.put("overdue_num",policeMapper.getOverData(poli_id));
		resultMap.put("quick_overdue_num",policeMapper.getQuickOverData(poli_id));
		return JsonUtils.createGson().toJson(resultMap);
		
	}

	/**
	 * 一般警员生成树（*）
	 * 
	 * @param poli_id
	 *            警员ID
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/jurisdiction", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getCommunitybyPoliid(
			@RequestParam("poli_id") Integer poli_id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		// 根据警员id获取Community
		CommunityExample communityexample = new CommunityExample();
		communityexample.createCriteria().andPoliIdEqualTo(poli_id);
		resultMap.put("community",
				communityMapper.selectByExample(communityexample));
		// 根据警员id获取独立building
		BuildingExample buildingexample = new BuildingExample();
		buildingexample.createCriteria().andPoliIdEqualTo(poli_id);
		resultMap.put("building",
				buildingMapper.selectByExample(buildingexample));
		return JsonUtils.createGson().toJson(resultMap);
	}

	/**
	 * 根据Poliid返回统计信息
	 * 
	 * @param poli_id
	 *            警员ID
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/jurisdiction/statistics", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getStatisInfoByPoliId(
			@RequestParam("poli_id") Integer poli_id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		// 根据警员id获取building
		List<Building> selectByExample = policeMapper.getBuilbyPoliid(poli_id);

		resultMap.put("room_number", policeMapper.getRoomNumbyPoliid(poli_id));
		resultMap.put("over_due_room_number", policeMapper.getOverRoomNumByPoliId(poli_id));
		resultMap.put("focus_room_number", policeMapper.getImpoRoomNumbyPoliid(poli_id));
		resultMap.put("person_number", policeMapper.getPersonNumbyPoliid(poli_id));
		resultMap.put("focus_person_number", policeMapper.getImpoPersonNumbyPoliid(poli_id));
		// 计算得到空房数
		resultMap.put("empty_room_number", policeMapper
				.getEmptyRoomNumbyPoliid(poli_id));
		// 获取所有的小区
		// 6.根据Poli_id获取房间各种分类数
		resultMap.put("room_classify_info",
				policeMapper.getRoomSortNumbyPoliid(poli_id));
		// 7.根据Poli_id获取自住人数/租住人数/工作人数
		resultMap.put("person_classify_info",
				policeMapper.getPersSortNumbyPoliid(poli_id));
		// 9.根据Poli_id楼宇数
		resultMap.put("building_number", selectByExample.size());
		// 10.根据Poli_id获取超期未巡检楼宇数
		resultMap.put("over_due_building_number",
				policeMapper.getOverBuilNumbyPoliid(poli_id));
		// 11.根据Poli_id获取重点关注楼宇数
		resultMap.put("focus_building_number",
				policeMapper.getImpoBuilNumbyPoliid(poli_id));
		// 12.根据Poli_id获取小区数
		// 根据警员id获取Community
		CommunityExample communityexample = new CommunityExample();
		communityexample.createCriteria().andPoliIdEqualTo(poli_id);
		resultMap.put("community_number",
				communityMapper.countByExample(communityexample));
		PoliceExample example = new PoliceExample();
		example.createCriteria().andPoliIdEqualTo(poli_id);
		resultMap.put("indebuliding_number",
				policeMapper.countByExample(example));
		// 13.根据Poli_id获取超期未巡检小区数
		resultMap.put("over_due_community_number",
				policeMapper.getOverCommNumbyPoliid(poli_id));
		// 14.根据Poli_id获取重点关注小区数；
		resultMap.put("focus_community_number",
				policeMapper.getImpoCommNumbyPoliid(poli_id));
		// 15.根据Poli_id获取房间各种分类数
		resultMap.put("room_subclassify_info",
						policeMapper.getRoomSubSortNumbyPoliid(poli_id));
		// 16.根据Poli_id获取重点单位
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("poli_id", poli_id);
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
	 * 根据警员ID 设定开始时间和截止时间 获取检查记录 TODO There is a bug to Fix
	 * 
	 * @param poil_id
	 * @param startTime
	 * @param endTime
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/inspectlog/filter/time", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getInsp(
			@RequestParam("poli_id") Integer poli_id,
			@RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startTime,
			@RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endTime,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			HttpServletRequest request) {
		int resultCode = 0;
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		Map<String, Object> map = new HashMap<String, Object>(2);
		endTime.setHours(23);
		endTime.setMinutes(59);
		endTime.setSeconds(59);
		map.put("poil_id", poli_id);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		if (page != null && size != null) {
			map.put("page", size * (page -1));
			map.put("size", size);
		}
		resultMap.put("inspect", inspectLogMapper.getInspbyTime(map));
		return JsonUtils.createGson().toJson(resultMap);
	}

}
