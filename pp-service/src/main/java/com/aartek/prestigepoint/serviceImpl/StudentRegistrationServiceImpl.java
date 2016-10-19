/**
 * 
 */
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
import com.aartek.prestigepoint.repository.StudentRegistrationRepository;
import com.aartek.prestigepoint.service.StudentRegistrationService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.util.ImageFormat;
import com.aartek.prestigepoint.util.SendMail;

/**
 * @author deepak
 * 
 */
@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

	private static final Logger logger = Logger.getLogger(StudentRegistrationServiceImpl.class);
	@Autowired
	private StudentRegistrationRepository stuRegRepository;

	@Value("${pp.imagePath}")
	private String imagePath;

	public boolean addStudentInfo(Registration registration) {
		boolean status = false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		if (registration != null) {
			Emi emi = new Emi();
			emi.setAmount(0);
			emi.setIsDeleted(IConstant.IS_DELETED);
			emi.setDate(dateFormat.format(date));
			registration.setStatus(IConstant.STATUS);
			List<Emi> emis = new ArrayList<Emi>();
			emis.add(emi);
			registration.setEmiList(emis);
			Registration registration2 = stuRegRepository.addStudentInfo(registration);
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
				SendMail.confirmationMail(registration2.getEmailId(), registration2.getPassword(),
						registration2.getFirstName(), registration2.getRegistrationId());

				return true;
			} else {
				return false;
			}
		}
		return status;
	}

	public Registration editStuRegs(Integer registrationId) {
		Registration singleEntity = stuRegRepository.editStuRegs(registrationId);
		return singleEntity;

	}

	public Registration stuSignIn(Registration registration) {
		Registration loginMember = (Registration) registration;
		List<Object> memberList = null;
		if (registration != null) {
			if (loginMember.getEmailId() != null && loginMember.getPassword() != null) {
				memberList = stuRegRepository.studentSignIn(loginMember.getEmailId(), loginMember.getPassword());
			}
		}
		if (memberList.size() == 0) {
			loginMember = null;
		} else {
			loginMember = (Registration) memberList.get(0);
		}
		return loginMember;
	}
}
