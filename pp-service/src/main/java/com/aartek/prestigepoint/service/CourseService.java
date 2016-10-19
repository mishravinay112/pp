package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.Course;
import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.model.CurrentStatus;
import com.aartek.prestigepoint.model.Year;

public interface CourseService {

	public boolean addCourse(Course course);

	public List<Course> getAllCourseName();

	public Course editCourse(Integer courseId);

	public void deleteCourse(Integer courseId);

	public List<Enquiry> getAllEnquiryDetails();

	public List<Year> getAllYearName();

	public Integer getFeeByCourseType(Integer courseIdId);

	public List<CurrentStatus> getAllCurrentStatus();

}
