package com.aartek.prestigepoint.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Emi;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.RegistrationRepository;
import com.aartek.prestigepoint.service.RegistrationService;
import com.aartek.prestigepoint.util.AutoGenratedPassword;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.util.ImageFormat;
import com.aartek.prestigepoint.util.SendMail;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private static final Logger logger = Logger.getLogger(RegistrationServiceImpl.class);
	@Autowired
	private RegistrationRepository registrationRepository;

	@Value("${pp.imagePath}")
	private String imagePath;

	public boolean addStudentInfo(Registration registration) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		boolean status = false;
		String autoGeneratedPassword = AutoGenratedPassword.generateRandomPassword();
		if (registration != null) {
			Emi emi = new Emi();
			emi.setAmount(registration.getSubmittedFee());
			emi.setIsDeleted(IConstant.IS_DELETED);
			emi.setDate(dateFormat.format(date));
			registration.setIsDeleted(IConstant.IS_DELETED);
			registration.setStatus(IConstant.PAID_STATUS);
			registration.setPassword(autoGeneratedPassword);
			List<Emi> emis = new ArrayList<Emi>();
			emis.add(emi);
			registration.setEmiList(emis);
			Registration registration2 = registrationRepository.addStudentInfo(registration);
			if (registration2 != null) {
				BufferedImage newImg;
				String imageData = registration.getImgPath().replaceFirst("^data:image/[^;]*;base64,?", "");
				newImg = ImageFormat.decodeToImage(imageData);
				if (newImg != null) {
					try {
						File f = new File(imagePath);
						f.mkdirs();
						ImageIO.write(newImg, "png", new File(imagePath + "/" + registration.getRegistrationId()
								+ ".png"));
					} catch (IOException e) {
						logger.error("IOException",e);
					}
				}
				return true;
			} else {
				return false;
			}
		}
		return status;
	}

	public List<Registration> getAllStudentDetails() {
		List<Registration> list = new ArrayList<Registration>();
		list = registrationRepository.getAllStudentDetails();
		return list;
	}

	public List<Registration> getStudentDetailsByName(String firstName) {
		List<Registration> list = new ArrayList<Registration>();
		list = registrationRepository.getStudentDetailsByName(firstName);
		return list;
	}

	public List<Registration> getCourseWiseStudentDetails(Integer courseId) {
		List<Registration> registrations = new ArrayList<Registration>();
		registrations = registrationRepository.getCourseWiseStudentDetails(courseId);
		return registrations;
	}

	public List<Registration> getBatchWiseStudentDetails(Integer batchId) {
		List<Registration> registrations = new ArrayList<Registration>();
		registrations = registrationRepository.getBatchWiseStudentDetails(batchId);
		return registrations;
	}

	public List<String> getallStudentEmailId() {
		List<String> emailList = new ArrayList<String>();
		emailList = registrationRepository.getallStudentEmailId();
		return emailList;
	}

	public List<String> getallEnquiryEmailId() {
		List<String> emailList = new ArrayList<String>();
		emailList = registrationRepository.getallEnquiryEmailId();
		return emailList;
	}

	public Registration makeAsPaidUser(Integer registrationId) {
		List<Object> stuRegs = null;
		Registration updateStudent = new Registration();
		stuRegs = registrationRepository.makeAsPaidUser(registrationId);
		for (Object object : stuRegs) {
			updateStudent = (Registration) object;
		}
		return updateStudent;
	}

	public boolean updateStudentAsPaid(Registration registration) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		boolean status = false;
		String autoGeneratedPassword = AutoGenratedPassword.generateRandomPassword();
		if (registration != null) {
			Emi emi = new Emi();
			emi.setAmount(registration.getSubmittedFee());
			emi.setIsDeleted(IConstant.IS_DELETED);
			emi.setDate(dateFormat.format(date));
			registration.setIsDeleted(IConstant.IS_DELETED);
			registration.setStatus(IConstant.PAID_STATUS);
			registration.setPassword(autoGeneratedPassword);
			List<Emi> emis = new ArrayList<Emi>();
			emis.add(emi);
			registration.setEmiList(emis);
			Registration registration2 = registrationRepository.updateStudentAsPaid(registration);
			if (registration2 != null) {
				BufferedImage newImg;
				String imageData = registration.getImgPath().replaceFirst("^data:image/[^;]*;base64,?", "");
				newImg = ImageFormat.decodeToImage(imageData);
				if (newImg != null) {
					try {
						File f = new File(imagePath);
						f.mkdirs();
						ImageIO.write(newImg, "png", new File(imagePath + "/" + registration.getRegistrationId()
								+ ".png"));
					} catch (IOException e) {
						logger.error("IOException",e);
					}
				}
				SendMail.sendEmail(registration2.getEmailId(), autoGeneratedPassword, registration2.getFirstName());
				return true;
			} else {
				return false;
			}
		}
		return status;
	}

	public Registration editSudentDetails(Integer registrationId) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();
		Registration rest = null;
		list = registrationRepository.editStudentDetails(registrationId);
		for (Object object : list) {
			rest = (Registration) object;

		}
		return rest;
	}

	public void deleteStudentDetails(Integer registrationId) {
		registrationRepository.deleteStudentDetails(registrationId);

	}

}
