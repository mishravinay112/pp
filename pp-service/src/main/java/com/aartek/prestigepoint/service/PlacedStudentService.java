package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.AddPlacedStudent;

public interface PlacedStudentService {

	java.util.List<AddPlacedStudent> viewAllPlacedStudent();

	public boolean addStudentInformation(AddPlacedStudent addPlacedStudent);

	public AddPlacedStudent updatePlacedStudentInformation(Integer studentId);

	public void deletePlacedStudentInformation(Integer studentId);

	public List<AddPlacedStudent> generatePlacedStudentReportMonthlyWise(String fromDate, String toDate);

}
