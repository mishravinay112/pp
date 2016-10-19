/**
 * 
 */
package com.aartek.prestigepoint.service;

import com.aartek.prestigepoint.model.Registration;

/**
 * @author deepak
 * 
 */
public interface StudentRegistrationService {

	public boolean addStudentInfo(Registration registration);

	public Registration editStuRegs(Integer registrationId);

	public Registration stuSignIn(Registration registration);
}
