package edu.hdu.lab.checkIn.serviceImpls;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hdu.lab.checkIn.dto.PoliceBasic;
import edu.hdu.lab.checkIn.mapper.PoliceMapper;
import edu.hdu.lab.checkIn.model.Police;
import edu.hdu.lab.checkIn.services.PoliceService;
import edu.hdu.lab.checkIn.utils.JsonUtils;

@Service("PoliceService")
public class PoliceServiceImpl implements PoliceService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PoliceMapper policeMapper;

	@Override
	public PoliceBasic getPoliceByPoliCode(String poli_code_str) {
		// throw exception 
		return policeMapper.login(poli_code_str);
	}

	@Override
	public int updatePolice(Police police) {
		return policeMapper.updateByPrimaryKeySelective(police);
	}

	
	@Override
	public void updateLoginInfo(Integer poliId, String ipLastlogin, Date timeLastlogin) {
		
		Police poliTemp = new Police();
		poliTemp.setPoliId(poliId);
		poliTemp.setIpLastlogin(ipLastlogin);
		poliTemp.setTimeLastlogin(timeLastlogin);
		
		this.updatePolice(poliTemp);
	}

	@Override
	public String getOverDueInspectLog(Integer poliId) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>(3);
		
		resultMap.put("room_overinspect",policeMapper.getOverRoomNumByPoliId(poliId));
		resultMap.put("buil_overinspect",policeMapper.getOverBuilNumbyPoliid(poliId));
		resultMap.put("comm_overinspect",policeMapper.getOverCommNumbyPoliid(poliId));
		
		return JsonUtils.createGson().toJson(resultMap);
	}

}
