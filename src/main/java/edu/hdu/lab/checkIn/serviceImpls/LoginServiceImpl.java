package edu.hdu.lab.checkIn.serviceImpls;

import org.springframework.stereotype.Service;

import edu.hdu.lab.checkIn.dto.PoliceBasic;
import edu.hdu.lab.checkIn.services.LoginService;
import edu.hdu.lab.checkIn.utils.Encryption;

@Service("LoginService")
public class LoginServiceImpl implements LoginService{

	@Override
	public boolean isPasswardMatch(String pwdStr, PoliceBasic poliObj) {
		
		String pwdEncypt = Encryption.encryptMD5(pwdStr);
		
		return pwdEncypt.equals(poliObj.getPoliPass());
	}

}
