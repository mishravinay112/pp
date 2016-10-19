/**
 * 
 */
package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.StudentRegistrationRepository;
import com.aartek.prestigepoint.util.IConstant;

/**
 * @author deepak
 * 
 */
@SuppressWarnings("all")
@Repository
public class StudentRegistrationRepositoryImpl implements StudentRegistrationRepository {

	private static final Logger logger = Logger.getLogger(StudentRegistrationRepositoryImpl.class);

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

	public Registration editStuRegs(Integer registrationId) {
		Registration registration = hibernateTemplate.get(Registration.class, registrationId);
		registration.setIsDeleted(IConstant.IS_DELETED);
		hibernateTemplate.saveOrUpdate(registration);
		return registration;
	}

	public List<Object> studentSignIn(String emailId, String password) {
		List<Object> stuLogin = hibernateTemplate.find(
				"from Registration r where r.emailId = ? and r.password = ? and r.isDeleted=?", emailId, password,
				IConstant.IS_DELETED);
		return stuLogin;
	}
}
