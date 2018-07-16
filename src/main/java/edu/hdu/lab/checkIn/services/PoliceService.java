package edu.hdu.lab.checkIn.services;


import java.util.Date;

import com.google.gson.JsonElement;

import edu.hdu.lab.checkIn.dto.PoliceBasic;
import edu.hdu.lab.checkIn.model.Police;

public interface PoliceService {

	public PoliceBasic getPoliceByPoliCode(String poli_code_str);
	
	public int updatePolice(Police police);
	
	public void updateLoginInfo(Integer poliId,String loginIP,Date lastLoginTime);

	public String getOverDueInspectLog(Integer poli_id);
}
