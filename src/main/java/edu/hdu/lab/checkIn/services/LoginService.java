package edu.hdu.lab.checkIn.services;

import edu.hdu.lab.checkIn.dto.PoliceBasic;
import edu.hdu.lab.checkIn.model.Police;

public interface LoginService {
	public boolean isPasswardMatch(String pwdStr,PoliceBasic poliExpected);
}
