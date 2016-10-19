package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.AdminLogin;
import com.aartek.prestigepoint.repository.LoginRepository;
import com.aartek.prestigepoint.service.LoginService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class LoginServiceImpl implements LoginService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
	@Autowired
	private LoginRepository loginRepository;

	public AdminLogin userSignIn(AdminLogin login) {
		AdminLogin loginMember = (AdminLogin) login;
		List<Object> memberList = null;
		if (login != null) {
			if (loginMember.getEmailId() != null && loginMember.getPassword() != null) {
				memberList = loginRepository.adminSignIn(loginMember.getEmailId(), loginMember.getPassword());
			}
		}
		if (memberList.size() == 0) {
			loginMember = null;
		} else {
			loginMember = (AdminLogin) memberList.get(0);
		}
		return loginMember;
	}

	public boolean signUp(AdminLogin login) {
		boolean status = false;
		if (login != null) {
			login.setIsDeleted(IConstant.IS_DELETED);
			login.setStatusId("1");
			status = loginRepository.signUp(login);
			return status;
		} else {
			return status;
		}
	}
}
