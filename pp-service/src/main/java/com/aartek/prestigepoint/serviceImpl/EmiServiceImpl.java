package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Emi;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.EmiRepository;
import com.aartek.prestigepoint.service.EmiService;
import com.aartek.prestigepoint.util.DateFormat;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.util.SendMail;

@Service
public class EmiServiceImpl implements EmiService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(EmiServiceImpl.class);
	@Autowired
	private EmiRepository emiRepository;

	public List<Emi> getFeesDetails(Integer registrationId) {
		List<Emi> emis = new ArrayList<Emi>();
		emis = emiRepository.getFeesDetails(registrationId);
		return emis;
	}

	public boolean addEmiInfo(Emi emi) {
		boolean status = false;
		if (emi != null) {

			emi.setIsDeleted(IConstant.IS_DELETED);
			System.out.println("date 1=" + emi.getDate());
			emi.setDate(DateFormat.getYYYYMMDDDate(emi.getDate()));
			String emiDate = emi.getDate();
			System.out.println("date 2=" + emiDate);
			Registration registration = emi.getRegistration();
			Integer stuRegistrationId = registration.getRegistrationId();
			status = emiRepository.addEmiInfo(emi);
			List<Registration> studentDetails = emiRepository.getEmiDetails(stuRegistrationId);
			registration = studentDetails.get(0);
			SendMail.emiMail(registration.getEmailId(), registration.getSubmittedFee(), registration.getFirstName(),
					registration.getTotalFee(), emi.getAmount(), emi.getDate());

			return status;
		} else {
			return status;
		}

	}

	public boolean editEmiInfo(Emi emi) {
		boolean status = false;

		if (emi.getEmiId() != null) {

			emi.setIsDeleted(IConstant.IS_DELETED);
			System.out.println("date 1=" + emi.getDate());
			emi.setDate(DateFormat.getYYYYMMDDDate(emi.getDate()));
			String emiDate = emi.getDate();
			System.out.println("date 2=" + emiDate);
			@SuppressWarnings("unused")
			Integer amount = emi.getAmount();

			Registration registration = emi.getRegistration();
			Integer stuRegistrationId = registration.getRegistrationId();
			status = emiRepository.editEmiInfo(emi);
			List<Registration> studentDetails = emiRepository.getEmiDetails(stuRegistrationId);
			registration = studentDetails.get(0);
			SendMail.editEmiMail(registration.getEmailId(), registration.getSubmittedFee(),
					registration.getFirstName(), registration.getTotalFee(), emi.getAmount(), emi.getDate());

			return status;
		} else {
			return status;
		}

	}

	public List<Registration> getRegistrationDetails(Integer registrationId) {
		List<Registration> list = new ArrayList<Registration>();
		list = emiRepository.getRegistrationDetails(registrationId);
		return list;
	}

	public Integer getRegistrationId(Integer emiId) {
		List<Emi> emis = new ArrayList<Emi>();
		Integer registrationId = null;
		emis = emiRepository.getRegistrationId(emiId);
		if (emis != null) {
			Emi emi = (Emi) emis.get(0);
			registrationId = emi.getRegistration().getRegistrationId();
		}
		return registrationId;
	}

	public void deleteEmiDetails(Integer emiId) {
		emiRepository.deleteEmiDetails(emiId);
	}

	public Emi editEmi(Integer emiId) {
		List<Object> list = new ArrayList<Object>();
		Emi emi = null;
		list = emiRepository.editEmi(emiId);

		for (Object object : list) {
			emi = (Emi) object;
		}
		return emi;

	}

	public List<Emi> getAllEmiId() {
		List<Emi> list = new ArrayList<Emi>();
		list = emiRepository.getAllEmiId();
		return list;

	}

	public Emi editEimForSingleRecord(Integer emiId) {
		List<Object> list = new ArrayList<Object>();
		Emi emi = null;
		list = emiRepository.editEmi(emiId);
		for (Object object : list) {
			emi = (Emi) object;
			emi.setDate(DateFormat.getMMDDYYYYDate(emi.getDate()));
		}
		return emi;
	}

}
