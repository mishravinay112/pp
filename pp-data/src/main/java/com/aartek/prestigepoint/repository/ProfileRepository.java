package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Registration;

public interface ProfileRepository {

	public List<Registration> getStudentDetails(int registrationId);

	public boolean updateProfile(Registration registration);

}
