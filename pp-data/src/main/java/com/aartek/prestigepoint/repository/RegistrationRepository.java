package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Registration;

public interface RegistrationRepository {

  public Registration addStudentInfo(Registration registration);

  public List<Registration> getAllStudentDetails();

  public List<Registration> getCourseWiseStudentDetails(Integer courseId);

  public List<Registration> getBatchWiseStudentDetails(Integer batchId);

  public List<String> getallStudentEmailId();

  public List<String> getallEnquiryEmailId();

  public List<Object> makeAsPaidUser(Integer registrationId);

  public Registration updateStudentAsPaid(Registration registration);

  public List<Object> editStudentDetails(Integer registrationId);

  public void deleteStudentDetails(Integer registrationId);

  public List<Registration> getStudentDetailsByName(String firstName);


}
