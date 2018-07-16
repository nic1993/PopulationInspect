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

import edu.hdu.lab.checkIn.mapper.InspectLogMapper;
import edu.hdu.lab.checkIn.mapper.PersonMapper;
import edu.hdu.lab.checkIn.mapper.PoliceMapper;
import edu.hdu.lab.checkIn.mapper.RoomMapper;
import edu.hdu.lab.checkIn.model.InspectLog;
import edu.hdu.lab.checkIn.model.InspectLogExample;
import edu.hdu.lab.checkIn.model.Person;
import edu.hdu.lab.checkIn.model.PoliceExample;
import edu.hdu.lab.checkIn.model.Room;
import edu.hdu.lab.checkIn.utils.JsonUtils;

@Controller
@RequestMapping("/inspectlog")
public class InspectLogController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private RoomMapper roomMapper;

	@Autowired
	private InspectLogMapper inspectLogMapper;
	
	@Autowired
	private PoliceMapper policeMapper;
	
	/**
	 * 添加巡查记录
	 * @param inspRec
	 * @param poliId
	 * @param ramark
	 * @param roomId
	 * @param isDeleted
	 * @param isFocus
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String addInspectLog(
			@RequestParam(value = "insp_rec", required = false) String inspRec,
			@RequestParam(value = "poli_id", required = true) Integer poliId,
			@RequestParam(value = "ramark", required = false) String ramark,
			@RequestParam(value = "room_id", required = true) Integer roomId,
			@RequestParam(value = "is_focus", required = false) Boolean isFocus,
			HttpServletRequest request) {
		
		Boolean isDeleted = false;
		
		InspectLog inspectLog = new InspectLog();
		if(inspRec!=null){
			inspectLog.setInspRec(inspRec);
		}
		inspectLog.setInspTime(new Date());
		inspectLog.setPoliId(poliId);
		inspectLog.setRamark(ramark);
		inspectLog.setRoomId(roomId);

		
		int resultCode = 0;
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		int insert = inspectLogMapper.insert(inspectLog);
		Room room = new Room();
		room = roomMapper.selectByPrimaryKey(roomId);
		if(inspRec!=null){
			room.setRecLastinspect(inspRec);
		}else{
			room.setRecLastinspect("");
		}
		room.setTimeLastinspect(new Date());
		room.setCountInspect(room.getCountInspect() + 1);
		room.setIsDeleted(isDeleted);
		room.setIsFocus(isFocus);
		int update = roomMapper.updateByPrimaryKeySelective(room);
		if (insert == 1 && update == 1) {
			resultCode = 1;
		}
		resultMap.put("resultCode", resultCode);
		return JsonUtils.createGson().toJson(resultMap);
	}

}
