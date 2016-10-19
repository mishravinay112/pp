/**
 * 
 */
package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Registration;

/**
 * @author deepak
 * 
 */
public interface StudentRegistrationRepository {

	public Registration addStudentInfo(Registration registration);

	public Registration editStuRegs(Integer registrationId);

	public List<Object> studentSignIn(String emailId, String password);

}
