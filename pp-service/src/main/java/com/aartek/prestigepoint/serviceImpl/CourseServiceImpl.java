package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Course;
import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.model.CurrentStatus;
import com.aartek.prestigepoint.model.Year;
import com.aartek.prestigepoint.repository.CourseRepository;
import com.aartek.prestigepoint.service.CourseService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class CourseServiceImpl implements CourseService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CourseServiceImpl.class);

	@Autowired
	private CourseRepository courseRepository;

	/**
	 * Method for save course details.
	 * 
	 * @param course
	 */
	public boolean addCourse(Course course) {
		boolean status = false;
		if (course != null) {
			course.setIsDeleted(IConstant.IS_DELETED);
			status = courseRepository.addCourse(course);
			return status;
		} else {
			return status;
		}
	}

	/**
	 * Method use for get all course name that are register.
	 */
	public List<Course> getAllCourseName() {
		List<Course> list = new ArrayList<Course>();
		list = courseRepository.getAllCourseName();
		return list;
	}

	/**
	 * Method for edit course information.
	 * 
	 * @param courseId
	 */
	public Course editCourse(Integer courseId) {
		List<Object> list = new ArrayList<Object>();
		Course course = null;
		list = courseRepository.editCourse(courseId);
		for (Object object : list) {
			course = (Course) object;
		}
		return course;
	}

	/**
	 * Delete course information from data base.
	 * 
	 * @param courseId
	 */
	public void deleteCourse(Integer courseId) {
		courseRepository.deleteCourse(courseId);
	}

	/**
	 * Method get all enquiry for display in grid
	 */
	public List<Enquiry> getAllEnquiryDetails() {
		List<Enquiry> list = new ArrayList<Enquiry>();
		list = courseRepository.getAllEnquiryDetails();
		return list;
	}

	/**
	 * Method get all year from data base.
	 */
	public List<Year> getAllYearName() {
		List<Year> list = new ArrayList<Year>();
		list = courseRepository.getAllYearName();
		return list;
	}

	/**
	 * Method get all status from data base.
	 */
	public List<CurrentStatus> getAllCurrentStatus() {
		List<CurrentStatus> list = new ArrayList<CurrentStatus>();
		list = courseRepository.getAllCurrentStatus();
		return list;

	}

	/**
	 * Method for get fee corresponding to course.
	 * 
	 * @param courseIdId
	 */
	public Integer getFeeByCourseType(Integer courseIdId) {
		Integer amount = null;
		if (courseIdId != null) {
			amount = courseRepository.getFeeByCourseType(courseIdId);
		}
		return amount;
	}
}
