package edu.hdu.lab.checkIn.controllers;

import java.util.Date;
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
import edu.hdu.lab.checkIn.mapper.PersonMapper;
import edu.hdu.lab.checkIn.mapper.RoomMapper;
import edu.hdu.lab.checkIn.model.Person;
import edu.hdu.lab.checkIn.model.Room;
import edu.hdu.lab.checkIn.services.RoomService;
import edu.hdu.lab.checkIn.utils.JsonUtils;
import edu.hdu.lab.checkIn.utils.WebUtils;

@Controller
public class RoomController {
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PersonMapper personMapper;

	@Autowired
	private RoomService roomService;

	@Autowired
	private RoomMapper roomMapper;

	/* TODO : 人员信息缺少 登记时间 和 照片地址 */
	@ResponseBody
	@RequestMapping(value = "/room/person", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getPersonByRoomId(@RequestParam("room_id") Integer room_id,
			HttpServletRequest request) {
		List<Person> personCollection = personMapper.getPersonByRoomId(room_id);
		return JsonUtils.createGson().toJson(personCollection);
	}

	@ResponseBody
	@RequestMapping(value = "/room/statis", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getRoomStatis(@RequestParam("room_id") Integer roomId,
			HttpServletRequest request) {

		RoomStatis roomStatis = roomService.getRoomStatisInfoByRoomId(roomId);

		return JsonUtils.createGson().toJson(roomStatis);

	}

	@ResponseBody
	@RequestMapping(value = "/room/class/update.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String updateRoomClass(@RequestParam("room_id") Integer roomId,
			@RequestParam("room_class") String roomClass,
			@RequestParam("room_subclass") String roomSubClass,
			HttpServletRequest request) {

		Map<String, Object> resultMap = new HashMap<String, Object>(1);
		Room room = roomMapper.selectByPrimaryKey(roomId);
		room.setRoomClass(roomClass);
		room.setRoomSubclass(roomSubClass);

		int resultCode = roomMapper.updateByPrimaryKeySelective(room);
		resultMap.put("resultCode", resultCode);
		return JsonUtils.createGson().toJson(resultMap);
	}

	@ResponseBody
	@RequestMapping(value = "/room/id", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getRoomByID(@RequestParam("room_id") Integer roomId,
			HttpServletRequest request) {

		Map<String, Object> resultMap = new HashMap<String, Object>(1);
		Room room = roomMapper.selectByPrimaryKey(roomId);

		resultMap.put("room", room);
		return JsonUtils.createGson().toJson(resultMap);
	}

	/**
	 * 新建room
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/room/add.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String NewRoom(
			@RequestParam("builId") Integer builId,
			@RequestParam(value = "isFocus", required = false) Boolean isFocus,
			@RequestParam(value = "ramark", required = false) String ramark,
			@RequestParam(value = "roomClass", required = false) String roomClass,
			@RequestParam(value = "roomFloor", required = false) Integer roomFloor,
			@RequestParam("roomNo") String roomNo,
			@RequestParam(value = "roomSubclass", required = false) String roomSubclass,
			@RequestParam(value = "roomUnit", required = false) Integer roomUnit,
			@RequestParam(value = "recLastinspect", required = false) String recLastinspect,
			@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request) {
		Room record = new Room();
		record.setBuilId(builId);
		record.setCountInspect(0);
		record.setIsDeleted(false);
		record.setIsFocus(isFocus);
		record.setRamark(ramark);
		record.setRecLastinspect(new Date().toString());
		record.setRoomClass(roomClass);
		record.setRoomFloor(roomFloor);
		record.setRoomNo(roomNo);
		record.setRoomSubclass(roomSubclass);
		record.setRoomUnit(roomUnit);
		record.setTimeLastinspect(new Date());
		// resultMap.put("resultCode",
		// roomMapper.insert(record));
		// return JsonUtils.createGson().toJson(resultMap);
		int resultCode = roomMapper.insert(record);
		return WebUtils.produceResult(callback, resultCode);
	}

	/**
	 * 修改room
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/room/edit.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String updateRoom(
			@RequestParam(value = "roomId", required = true) Integer roomId,
			@RequestParam(value = "builId", required = false) Integer builId,
			@RequestParam(value = "isFocus", required = false) Boolean isFocus,
			@RequestParam(value = "ramark", required = false) String ramark,
			@RequestParam(value = "roomClass", required = false) String roomClass,
			@RequestParam(value = "roomFloor", required = false) Integer roomFloor,
			@RequestParam(value = "roomNo", required = false) String roomNo,
			@RequestParam(value = "roomSubclass", required = false) String roomSubclass,
			@RequestParam(value = "roomUnit", required = false) Integer roomUnit,
			@RequestParam(value = "recLastinspect", required = false) String recLastinspect,
			@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request) {
		Room record = new Room();
		record.setBuilId(builId);
		record.setCountInspect(0);
		record.setIsDeleted(false);
		record.setIsFocus(isFocus);
		record.setRamark(ramark);
		record.setRecLastinspect(recLastinspect);
		record.setRoomClass(roomClass);
		record.setRoomFloor(roomFloor);
		record.setRoomNo(roomNo);
		record.setRoomSubclass(roomSubclass);
		record.setRoomUnit(roomUnit);
		record.setTimeLastinspect(new Date());
		record.setRoomId(roomId);
		// resultMap.put("resultCode",
		// roomMapper.updateByPrimaryKeySelective(record));
		// return JsonUtils.createGson().toJson(resultMap);
		int resultCode = roomMapper.updateByPrimaryKeySelective(record);
		return WebUtils.produceResult(callback, resultCode);
	}

	// 获取空房间信息
	@ResponseBody
	@RequestMapping(value = "/room/getEmptyRoom", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getEmptyRoom(
			@RequestParam(value = "buil_id", required = false) Integer buil_id,
			@RequestParam(value = "comm_id", required = false) Integer comm_id,
			@RequestParam(value = "poli_id", required = false) Integer poli_id,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("poli_id", poli_id);
		map.put("comm_id", comm_id);
		map.put("buil_id", buil_id);
		return JsonUtils.createGson().toJson(roomMapper.searchEmptyRoom(map));
	}

	@ResponseBody
	@RequestMapping(value = "/room/searchRoom", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String statiByRoomClass(
			@RequestParam(value = "buil_id", required = false) Integer buil_id,
			@RequestParam(value = "comm_id", required = false) Integer comm_id,
			@RequestParam(value = "poli_id", required = false) Integer poli_id,
			@RequestParam(value = "room_class", required = false) String room_class,
			@RequestParam(value = "room_subclass", required = false) String room_subclass,
			@RequestParam(value = "room_isfocus", required = false) Integer room_isfocus,
			@RequestParam(value = "focus_level", required = false) Integer focus_level,
			@RequestParam(value = "isDrug", required = false) Integer isDrug,
			@RequestParam(value = "isBoom", required = false) Integer isBoom,
			@RequestParam(value = "isToxic", required = false) Integer isToxic,
			@RequestParam(value = "isDanger", required = false) Integer isDanger,
			@RequestParam(value = "pers_type", required = false) Integer pers_type,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("poli_id", poli_id);
		map.put("comm_id", comm_id);
		map.put("buil_id", buil_id);
		map.put("room_class", room_class);
		map.put("room_subclass", room_subclass);
		map.put("room_isfocus", room_isfocus);
		map.put("focus_level", focus_level);
		map.put("isDrug", isDrug);
		map.put("isBoom", isBoom);
		map.put("isToxic", isToxic);
		map.put("isDanger", isDanger);
		map.put("pers_type", pers_type);
		if (page != null && size != null) {
			map.put("page", size * (page -1));
			map.put("size", size);
		}
		if (roomMapper.countRoom(map) == 0) {
			return JsonUtils.createGson()
					.toJson(roomMapper.searchRoomOnly(map));
		} else {
			return JsonUtils.createGson().toJson(roomMapper.searchRoom(map));
		}

	}
}
