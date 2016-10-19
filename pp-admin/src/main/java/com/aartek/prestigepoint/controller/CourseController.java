package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.Course;
import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.service.CourseService;
import com.aartek.prestigepoint.util.IConstant;

/**
 * 
 * @author Dell
 *
 */
@Controller
public class CourseController {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	/**
	 * Method for show add course page.
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @param request
	 * @return
	 */
	@RequestMapping("/addCourse")
	public String showaddCoursePage(Map<String, Object> map, Model model, @RequestParam(required = false) String message) {
		List<Course> courseList = courseService.getAllCourseName();
		if (courseList != null) {
			model.addAttribute("courseList", courseList);
		}
		map.put("Course", new Course());
		model.addAttribute("message", message);
		return "addCourse";

	}

	/**
	 * Use for save and update course information.
	 * 
	 * @param course
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value = "/addCourseAction", method = { RequestMethod.GET, RequestMethod.POST })
	public String addCourseInfo(@ModelAttribute("Course") Course course, ModelMap model, Map<String, Object> map,
			HttpServletRequest request, @RequestParam(required = false) Integer courseId) {
		boolean status = false;
		List<Course> courseList = courseService.getAllCourseName();
		String method = request.getMethod();
		if (("GET").equals(method)) {
			course = courseService.editCourse(courseId);
			model.addAttribute("courseList", courseList);
			map.put("Course", course);
			return "addCourse";
		} else {
			model.addAttribute("courseList", courseList);
			if (course.getCourseId() != null) {
				status = courseService.addCourse(course);
				if (status) {
					model.addAttribute("message", IConstant.COURSE_EDIT_SUCCESS_MESSAGE);
				} else {
					model.addAttribute("message", IConstant.COURSE_EDIT_FAILURE_MESSAGE);
				}
			} else {
				status = courseService.addCourse(course);
				if (status) {
					model.addAttribute("message", IConstant.COURSE_SUCCESS_MESSAGE);
				} else {
					model.addAttribute("message", IConstant.COURSE_FAILURE_MESSAGE);
				}
			}
			model.put("Course", new Course());
		}
		return "redirect:/addCourse.do";
	}

	/**
	 * Method for delete course details.
	 * 
	 * @param course
	 * @param result
	 * @param model
	 * @param request
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value = "/deleteCourse", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteCourse(@ModelAttribute("Course") Course course, ModelMap model,
			@RequestParam(required = false) Integer courseId) {
		courseService.deleteCourse(courseId);
		model.addAttribute("message", IConstant.COURSE_DELETE_MESSAGE);
		return "redirect:/addCourse.do";
	}

	/**
	 * Method use for display all enquiry information.
	 * 
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/viewEnquiryDetails")
	public String showviewEnquiryDetailsPage(Model model) {
		List<Enquiry> enquiryList = courseService.getAllEnquiryDetails();
		if (enquiryList != null) {
			model.addAttribute("enquiryList", enquiryList);
		}
		return "viewEnquiryDetails";
	}

}
