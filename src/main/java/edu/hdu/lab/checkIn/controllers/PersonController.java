package edu.hdu.lab.checkIn.controllers;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import edu.hdu.lab.checkIn.mapper.PersonMapper;
import edu.hdu.lab.checkIn.model.Person;
import edu.hdu.lab.checkIn.utils.Constants;
import edu.hdu.lab.checkIn.utils.JsonUtils;
import edu.hdu.lab.checkIn.utils.WebUtils;

@Controller
@RequestMapping("/person")
public class PersonController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PersonMapper personMapper;

	/**
	 * 根据人员的ID 获取详细信息
	 * 
	 * @param pers_id
	 *            人员ID
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/info", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getPersonInfobyPersId(
			@RequestParam("pers_id") Integer pers_id, HttpServletRequest request) {
		Person person = personMapper.selectByPrimaryKey(pers_id);
		int resultCode = 0;
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		if (person != null) {
			resultCode = 1;
			resultMap.put("person", person);
		}
		resultMap.put("resultCode", resultCode);
		return JsonUtils.createGson().toJson(resultMap);
	}

	/**
	 * 添加人员信息
	 * 
	 * @param addrCensus
	 * @param addrLive
	 * @param addrWork
	 * @param isDeleted
	 * @param isFocus
	 * @param persIdcard
	 * @param persName
	 * @param persPhone
	 * @param persPhoto
	 * @param persSex
	 * @param ramark
	 * @param roomId
	 * @param timeRegister
	 * @param whyRegister
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String addPerson(
			@RequestParam(value = "addrCensus", required = false) String addrCensus,
			@RequestParam(value = "addrLive", required = false) String addrLive,
			@RequestParam(value = "addrWork", required = false) String addrWork,
			@RequestParam(value = "isDeleted", required = false) Boolean isDeleted,
			@RequestParam(value = "isFocus", required = false) Boolean isFocus,
			@RequestParam(value = "persIdcard", required = false) String persIdcard,
			@RequestParam(value = "persName", required = false) String persName,
			@RequestParam(value = "persPhone", required = false) String persPhone,
			@RequestParam(value = "persPhoto", required = false) CommonsMultipartFile pictureOneFile,
			@RequestParam(value = "persSex", required = false) Boolean persSex,
			@RequestParam(value = "ramark", required = false) String ramark,
			@RequestParam(value = "roomId", required = true) Integer roomId,
			@RequestParam(value = "timeRegister", required = false) String timeRegister,
			@RequestParam(value = "whyRegister", required = false) String whyRegister,
			@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request) {
		Person person = new Person();
		person.setAddrCensus(addrCensus);
		person.setAddrLive(addrLive);
		person.setAddrWork(addrWork);
		person.setIsDeleted(isDeleted);
		person.setIsFocus(isFocus);
		person.setPersIdcard(persIdcard);
		person.setPersName(persName);
		person.setPersPhone(persPhone);
		// person.setPersPhoto(persPhoto);
		person.setPersSex(persSex);
		person.setRamark(ramark);
		person.setRoomId(roomId);
		if (timeRegister != null) {
			try {
				person.setTimeRegister(new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").parse(timeRegister));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		person.setWhyRegister(whyRegister);
		if (pictureOneFile != null) {
			String filesLocation = Constants.STATIC_FILES_PATH;
			File dirFile = new File(filesLocation);
			if (!WebUtils.checkDirAvailabilityAndCreate(dirFile))
				return WebUtils.produceResult(callback,
						Constants.RESULT_CODE_DIR_CREATION_FAILED);
			String pictureOneFileName = WebUtils.fileIsEmpty(pictureOneFile) ? null
					: WebUtils.saveFile(pictureOneFile, filesLocation,
							Constants.FILE_TYPE_IMAGE);
			person.setPersPhoto(pictureOneFileName);
		}
		//int resultCode = 0;
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		int resultCode = personMapper.insertSelective(person);
		//resultMap.put("resultCode", resultCode);

        return WebUtils.produceResult(callback, resultCode);
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String updateUser(
			@RequestParam("persId") Integer persId,
			@RequestParam(value = "addrCensus", required = false) String addrCensus,
			@RequestParam(value = "addrLive", required = false) String addrLive,
			@RequestParam(value = "addrWork", required = false) String addrWork,
			@RequestParam(value = "isDeleted", required = false) Boolean isDeleted,
			@RequestParam(value = "isFocus", required = false) Boolean isFocus,
			@RequestParam(value = "persIdcard", required = false) String persIdcard,
			@RequestParam(value = "persName", required = false) String persName,
			@RequestParam(value = "persPhone", required = false) String persPhone,
			@RequestParam(value = "persPhoto", required = false) CommonsMultipartFile persPhoto,
			@RequestParam(value = "persSex", required = false) Boolean persSex,
			@RequestParam(value = "ramark", required = false) String ramark,
			@RequestParam(value = "roomId", required = true) Integer roomId,
			@RequestParam(value = "timeRegister", required = false) String timeRegister,
			@RequestParam(value = "whyRegister", required = false) String whyRegister,
			@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request) {
		Person pers = new Person();
		pers.setPersId(persId);
		pers.setRoomId(roomId);
		pers.setPersName(persName);
		pers.setAddrCensus(addrCensus);
		pers.setAddrLive(addrLive);
		pers.setAddrWork(addrWork);
		pers.setIsFocus(isFocus);
		pers.setIsDeleted(isDeleted);
		pers.setPersIdcard(persIdcard);
		pers.setPersPhone(persPhone);
		pers.setPersSex(persSex);
		pers.setWhyRegister(whyRegister);
		if (timeRegister != null) {
			try {
				pers.setTimeRegister(new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").parse(timeRegister));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String filesLocation = Constants.STATIC_FILES_PATH;
        File dirFile = new File(filesLocation);
        if (!WebUtils.checkDirAvailabilityAndCreate(dirFile))
            return WebUtils.produceResult(callback, Constants.RESULT_CODE_DIR_CREATION_FAILED);

        String iconFileNewName = WebUtils.fileIsEmpty(persPhoto) ? null : WebUtils.saveFile(persPhoto, filesLocation, Constants.FILE_TYPE_IMAGE);
        
        pers.setPersPhoto(iconFileNewName);        
        int resultCode = personMapper.updateByPrimaryKeySelective(pers);
        
        return WebUtils.produceResult(callback, resultCode);

	}
	
	@ResponseBody
	@RequestMapping(value = "/searchSize.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String searchSize(
			@RequestParam(value = "poli_id", required = true) Integer poli_id,
			@RequestParam(value = "comm_id", required = false) Integer comm_id,
			@RequestParam(value = "buil_id", required = false) Integer buil_id,
			@RequestParam(value = "room_unit", required = false) Integer room_unit,
			@RequestParam(value = "room_floor", required = false) Integer room_floor,
			@RequestParam(value = "room_no", required = false) String room_no,
			@RequestParam(value = "room_class", required = false) String room_class,
			@RequestParam(value = "room_subclass", required = false) String room_subclass,
			@RequestParam(value = "pers_name", required = false) String pers_name,
			@RequestParam(value = "pers_sex", required = false) Boolean pers_sex,
			@RequestParam(value = "pers_idcard", required = false) String pers_idcard,
			@RequestParam(value = "pers_phone", required = false) String pers_phone,
			@RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startTime,
			@RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endTime,
			@RequestParam(value = "why_register", required = false) String why_register,
			@RequestParam(value = "is_focus", required = false) Boolean is_focus,
			@RequestParam(value="focus_level", required = false) Integer focus_level,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			@RequestParam(value = "is_overdue", required = false) Integer is_overdue,
			HttpServletRequest request) {
		if(endTime!=null){
			endTime.setHours(23);
			endTime.setMinutes(59);
			endTime.setSeconds(59);
		}
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("poli_id", poli_id);
		map.put("comm_id", comm_id);
		map.put("buil_id", buil_id);
		map.put("room_unit", room_unit);
		map.put("room_floor", room_floor);
		map.put("room_no", room_no);
		map.put("room_class", room_class);
		map.put("room_subclass", room_subclass);
		map.put("pers_name", pers_name);
		map.put("pers_sex", pers_sex);
		map.put("pers_idcard", pers_idcard);
		map.put("pers_phone", pers_phone);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("why_register", why_register);
		map.put("focus_level", focus_level);
		map.put("is_focus", is_focus);
		map.put("is_overdue",is_overdue);
		if (page != null && size != null) {
			map.put("page", size * (page -1));
			map.put("size", size);
		}
        return JsonUtils.createGson().toJson(personMapper.searchSize(map));
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchPerson.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String searchPerson(
			@RequestParam(value = "poli_id", required = true) Integer poli_id,
			@RequestParam(value = "comm_id", required = false) Integer comm_id,
			@RequestParam(value = "buil_id", required = false) Integer buil_id,
			@RequestParam(value = "room_unit", required = false) Integer room_unit,
			@RequestParam(value = "room_floor", required = false) Integer room_floor,
			@RequestParam(value = "room_no", required = false) String room_no,
			@RequestParam(value = "room_class", required = false) String room_class,
			@RequestParam(value = "room_subclass", required = false) String room_subclass,
			@RequestParam(value = "pers_name", required = false) String pers_name,
			@RequestParam(value = "pers_sex", required = false) Boolean pers_sex,
			@RequestParam(value = "pers_idcard", required = false) String pers_idcard,
			@RequestParam(value = "pers_phone", required = false) String pers_phone,
			@RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startTime,
			@RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endTime,
			@RequestParam(value = "why_register", required = false) String why_register,
			@RequestParam(value = "is_focus", required = false) Boolean is_focus,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			@RequestParam(value="focus_level", required = false) Integer focus_level,
			@RequestParam(value = "is_overdue", required = false) Integer is_overdue,
			HttpServletRequest request) {
		if(endTime!=null){
			endTime.setHours(23);
			endTime.setMinutes(59);
			endTime.setSeconds(59);
		}
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("poli_id", poli_id);
		map.put("comm_id", comm_id);
		map.put("buil_id", buil_id);
		map.put("room_unit", room_unit);
		map.put("room_floor", room_floor);
		map.put("room_no", room_no);
		map.put("room_class", room_class);
		map.put("room_subclass", room_subclass);
		map.put("pers_name", pers_name);
		map.put("pers_sex", pers_sex);
		map.put("pers_idcard", pers_idcard);
		map.put("pers_phone", pers_phone);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("why_register", why_register);
		map.put("is_overdue",is_overdue);
		map.put("is_focus", is_focus);
		map.put("focus_level", focus_level);
		if (page != null && size != null) {
			map.put("page", size * (page -1));
			map.put("size", size);
		}
        return JsonUtils.createGson().toJson(personMapper.searchPerson(map));
	}

}
