package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.Registration;

public interface RegistrationService {

  public boolean addStudentInfo(Registration registration);

  public List<Registration> getAllStudentDetails();

  public List<Registration> getCourseWiseStudentDetails(Integer courseId);

  public List<Registration> getBatchWiseStudentDetails(Integer batchId);

  public List<String> getallStudentEmailId();

  public List<String> getallEnquiryEmailId();

  public Registration makeAsPaidUser(Integer registrationId);

  public boolean updateStudentAsPaid(Registration registration);

  public Registration editSudentDetails(Integer registrationId);

  public void deleteStudentDetails(Integer registrationId);

  public List<Registration> getStudentDetailsByName(String firstName);



}
