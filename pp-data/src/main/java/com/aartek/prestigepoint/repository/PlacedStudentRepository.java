package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.AddPlacedStudent;

public interface PlacedStudentRepository {

    public List<AddPlacedStudent> viewAllPlacedStudent();

    public List<Object> updatePlacedStudentInformation(Integer studentId);

    public void deletePlacedStudentInformation(Integer studentId);

    public List<AddPlacedStudent> generatePlacedStudentReportMonthlyWise(String fromDate, String toDate);

    public void addStudentInformation(AddPlacedStudent addPlacedStudent);

}
