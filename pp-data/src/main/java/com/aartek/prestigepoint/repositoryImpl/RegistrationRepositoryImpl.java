package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.RegistrationRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(RegistrationRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Registration addStudentInfo(Registration registration) {
		if (registration != null) {
			hibernateTemplate.saveOrUpdate(registration);
			return registration;
		} else {
			return null;
		}
	}

	public List<Registration> getAllStudentDetails() {
		List<Registration> studentList = null;
		studentList = hibernateTemplate.find("from Registration  where IS_DELETED=" + IConstant.IS_DELETED
				+ "order by registrationId desc");
		return studentList;
	}

	public List<Registration> getStudentDetailsByName(String firstName) {
		List<Registration> studentList = null;
		studentList = hibernateTemplate.find("from Registration r  where  r.firstName='" + firstName
				+ "' or  r.firstName LIKE '%" + firstName + "%' and  r.isDeleted=" + IConstant.IS_DELETED
				+ " order by registrationId desc");
		return studentList;
	}

	public List<Registration> getCourseWiseStudentDetails(Integer courseId) {
		List<Registration> studentList = null;
		studentList = hibernateTemplate.find("from Registration r where r.isDeleted=" + IConstant.IS_DELETED
				+ " and r.course.courseId=" + courseId);
		return studentList;
	}

	public List<Registration> getBatchWiseStudentDetails(Integer batchId) {
		List<Registration> studentList = null;
		studentList = hibernateTemplate.find("from Registration r where r.isDeleted=" + IConstant.IS_DELETED
				+ " and r.batch.batchId=" + batchId);
		return studentList;
	}

	public List<String> getallStudentEmailId() {
		List<String> emailList = null;
		emailList = hibernateTemplate.find("select r.emailId from Registration r where r.isDeleted="
				+ IConstant.IS_DELETED);
		return emailList;
	}

	public List<String> getallEnquiryEmailId() {
		List<String> emailList = null;
		emailList = hibernateTemplate.find("select e.emailId from Enquiry e where e.isDeleted=" + IConstant.IS_DELETED);
		return emailList;
	}

	public List<Object> makeAsPaidUser(Integer registrationId) {
		List<Object> student = null;
		student = hibernateTemplate.find("from Registration r where r.isDeleted=" + IConstant.IS_DELETED
				+ " and r.registrationId=" + registrationId);
		return student;
	}

	public Registration updateStudentAsPaid(Registration registration) {
		if (registration != null) {
			hibernateTemplate.saveOrUpdate(registration);
			return registration;
		} else {
			return null;
		}
	}

	public List<Object> editStudentDetails(Integer registrationId) {
		List<Object> list = null;
		list = hibernateTemplate.find("from Registration r where r.registrationId=" + registrationId);
		return list;
	}

	public void deleteStudentDetails(Integer registrationId) {
		Registration rest = (Registration) hibernateTemplate.get(Registration.class, registrationId);
		rest.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (null != rest) {
			hibernateTemplate.update(rest);
		}
	}
}