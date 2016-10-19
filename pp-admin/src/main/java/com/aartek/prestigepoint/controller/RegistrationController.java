package com.aartek.prestigepoint.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.prestigepoint.model.AddPlacedStudent;
import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.model.Course;
import com.aartek.prestigepoint.model.CurrentStatus;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.model.Year;
import com.aartek.prestigepoint.service.BatchService;
import com.aartek.prestigepoint.service.CourseService;
import com.aartek.prestigepoint.service.RegistrationService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.RegistrationValidator;

@Controller
public class RegistrationController {

	private static final Logger log = Logger.getLogger(RegistrationController.class);
	@Autowired
	private CourseService courseService;

	@Autowired
	private BatchService batchService;

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private RegistrationValidator registrationValidator;

	/**
	 * Show registration page
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @param request
	 * @return
	 */
	@RequestMapping("/registration")
	public String showregistrationPage(Map<String, Object> map, Model model,
			@RequestParam(required = false) String message) {
		map.put("Registration", new Registration());
		List<CurrentStatus> currentStatusList = null;
		List<Course> courseList = courseService.getAllCourseName();
		if (courseList != null) {
			model.addAttribute("course", courseList);
		}
		List<Batch> batchList = batchService.getAllBatchName();
		if (batchList != null) {
			model.addAttribute("batch", batchList);
		}
		List<Year> yearList = courseService.getAllYearName();
		if (yearList != null) {
			model.addAttribute("year", yearList);
		}
		currentStatusList = courseService.getAllCurrentStatus();
		if (currentStatusList != null) {
			model.addAttribute("currentStatus", currentStatusList);
		}
		model.addAttribute("message", message);
		return "registration";
	}

	/**
	 * Use for register student.
	 * 
	 * @param registration
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registerStudent", method = { RequestMethod.GET, RequestMethod.POST })
	public String addStudent(@ModelAttribute("Registration") Registration registration, BindingResult result,
			ModelMap model) {
		int currentId = registration.getCurrentStatus().getCurrent_status_Id();
		boolean status = false;
		List<CurrentStatus> currentStatusList = null;
		registrationValidator.validate(registration, result);
		if (result.hasErrors()) {
			List<Course> courseList = courseService.getAllCourseName();
			if (courseList != null) {
				model.addAttribute("course", courseList);
			}
			List<Batch> batchList = batchService.getAllBatchName();
			if (batchList != null) {
				model.addAttribute("batch", batchList);
			}
			List<Year> yearList = courseService.getAllYearName();
			if (yearList != null) {
				model.addAttribute("year", yearList);
			}
			currentStatusList = courseService.getAllCurrentStatus();
			if (currentStatusList != null) {
				model.addAttribute("currentStatus", currentStatusList);
			}
			return "registration";
		}
		if (registration.getRegistrationId() != null) {
			status = registrationService.updateStudentAsPaid(registration);
			if (currentId == 8) {
				model.addAttribute("firstName", registration.getFirstName());
				model.addAttribute("lastName", registration.getLastName());
				model.addAttribute("registrationId", registration.getRegistrationId());
				return "redirect:/addPlacedStudent.do";
			}
			if (status) {
				model.addAttribute("message", IConstant.PROFILE_UPDATE_SUCCESS_MESSAGE);
			} else {
				model.addAttribute("message", IConstant.PROFILE_UPDATE_FAILURE_MESSAGE);
			}
		} else {
			status = registrationService.addStudentInfo(registration);
			if (status) {
				model.addAttribute("message", IConstant.REGISTRATION_SUCCESS_MESSAGE);
			} else {
				model.addAttribute("message", IConstant.REGISTRATION_FAILURE_MESSAGE);
			}
			return "redirect:/getStudentDetails.do";
		}
		return "redirect:/getStudentDetails.do";
	}

	@RequestMapping(value = "/amountByCourseTypeId", method = RequestMethod.GET)
	@ResponseBody
	public Integer getAmountByPassTypeId(@RequestParam Integer courseIdId) {
		Integer amount = null;
		if (courseIdId != null) {
			amount = courseService.getFeeByCourseType(courseIdId);
		}
		return amount;
	}

	/**
	 * Use for show student details page.
	 * 
	 * @param map
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/viewStudentDetails")
	public String showviewStudentDetailsPage(Map<String, Object> map, Model model) {
		map.put("Registration", new Registration());
		List<CurrentStatus> currentStatusList = null;
		List<Course> courseList = courseService.getAllCourseName();
		if (courseList != null) {
			model.addAttribute("course", courseList);
		}
		List<Batch> batchList = batchService.getAllBatchName();
		if (batchList != null) {
			model.addAttribute("batch", batchList);
		}
		List<Year> yearList = courseService.getAllYearName();
		if (yearList != null) {
			model.addAttribute("year", yearList);
		}
		currentStatusList = courseService.getAllCurrentStatus();
		if (currentStatusList != null) {
			model.addAttribute("currentStatus", currentStatusList);
		}
		return "viewStudentDetails";
	}

	/**
	 * Method for show all register student list
	 * 
	 * @param registration
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getStudentDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String viewDetails(@ModelAttribute("Registration") Registration registration,
			ModelMap model, Map<String, Object> map, HttpServletRequest request,
			@RequestParam(required = false) Integer registrationId) {
		List<Registration> studentDetails = null;
		String method = request.getMethod();
		if (("GET").equals(method) && registrationId != null) {
			List<Course> courseList = courseService.getAllCourseName();
			if (courseList != null) {
				model.addAttribute("course", courseList);
			}
			List<Batch> batchList = batchService.getAllBatchName();
			if (batchList != null) {
				model.addAttribute("batch", batchList);
			}
			List<Year> yearList = courseService.getAllYearName();
			if (yearList != null) {
				model.addAttribute("year", yearList);
			}
			List<CurrentStatus> currentStatusList = courseService.getAllCurrentStatus();
			if (currentStatusList != null) {
				model.addAttribute("currentStatus", currentStatusList);
			}
			registration = registrationService.editSudentDetails(registrationId);
			map.put("Registration", registration);
			model.addAttribute("batch", batchList);
			model.addAttribute("course", courseList);
			model.addAttribute("year", yearList);
			model.addAttribute("currentStatus", currentStatusList);
			model.addAttribute("studentDetails", studentDetails);
			return "registration";

		} else {
			List<Course> courseList = courseService.getAllCourseName();
			if (courseList != null) {
				model.addAttribute("course", courseList);
			}
			List<Batch> batchList = batchService.getAllBatchName();
			if (batchList != null) {
				model.addAttribute("batch", batchList);
			}
			if (registration != null) {
				if (registration.getSearchType() != null) {
					if (registration.getSearchType().equals("all")) {
						studentDetails = registrationService.getAllStudentDetails();
						model.addAttribute("studentDetails", studentDetails);
					}
				}
				if (registration.getCourse() != null) {
					if (!(registration.getCourse().getCourseId() == 0)
							&& (registration.getCourse().getCourseId() != null)) {
						studentDetails = registrationService.getCourseWiseStudentDetails(registration.getCourse()
								.getCourseId());
						model.addAttribute("studentDetails", studentDetails);
					}
				}
				if (registration.getBatch() != null) {
					if (!(registration.getBatch().getBatchId() == 0) && (registration.getBatch().getBatchId() != null)) {
						studentDetails = registrationService.getBatchWiseStudentDetails(registration.getBatch()
								.getBatchId());
						model.addAttribute("studentDetails", studentDetails);
					}
				}
			} else {
				model.addAttribute("message", "Please select atleast one");
			}
		}
		return "viewStudentDetails";
	}

	@RequestMapping(value = "/getStudentDetailsByName", method = { RequestMethod.GET, RequestMethod.POST })
	public String viewDetailsByName(@ModelAttribute("Registration") Registration registration,
			ModelMap model,HttpServletRequest request,
			@RequestParam(required = false) Integer registrationId) {
		String firstName = request.getParameter("registration");
		model.addAttribute("firstName", firstName);
		List<Registration> studentDetails = registrationService.getStudentDetailsByName(firstName);
		model.addAttribute("studentDetails", studentDetails);
	    log.info("firstName is=" + firstName);
		return "viewStudentDetails";
	}

	/**
	 * View all student list for send a mail.
	 * 
	 * @param registration
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getStudentList", method = { RequestMethod.GET, RequestMethod.POST })
	public String viewList(@ModelAttribute("Registration") Registration registration, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request) {

		List<Course> courseList = courseService.getAllCourseName();
		if (courseList != null) {
			model.addAttribute("course", courseList);
		}
		List<Batch> batchList = batchService.getAllBatchName();
		if (batchList != null) {
			model.addAttribute("batch", batchList);
		}
		if (registration != null) {
			if (registration.getSearchType() != null) {
				if (registration.getSearchType().equals("all")) {
					List<Registration> studentDetails = registrationService.getAllStudentDetails();
					model.addAttribute("studentDetails", studentDetails);
				}
			}
			if (registration.getCourse() != null) {
				if (!(registration.getCourse().getCourseId() == 0) && (registration.getCourse().getCourseId() != null)) {
					List<Registration> studentDetails = registrationService.getCourseWiseStudentDetails(registration
							.getCourse().getCourseId());
					model.addAttribute("studentDetails", studentDetails);
				}
			}
			if (registration.getBatch() != null) {
				if (!(registration.getBatch().getBatchId() == 0) && (registration.getBatch().getBatchId() != null)) {
					List<Registration> studentDetails = registrationService.getBatchWiseStudentDetails(registration
							.getBatch().getBatchId());
					model.addAttribute("studentDetails", studentDetails);
				}
			}
		} else {
			model.addAttribute("message", "Please select atleast one");
		}
		return "sendMail";
	}

	/**
	 * Make student as paid user(prestigepoint user)
	 * 
	 * @param registration
	 * @param message
	 * @param model
	 * @param map
	 * @param request
	 * @param registrationId
	 * @return
	 */
	@RequestMapping(value = "/setStudentDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String setDetails(@ModelAttribute("Registration") Registration registration, String message, ModelMap model,
			Map<String, Object> map, HttpServletRequest request, Integer registrationId,
			AddPlacedStudent addPlacedStudent) {
		String method = request.getMethod();
		if (("GET").equals(method)) {
			registration = registrationService.makeAsPaidUser(registrationId);
			map.put("Registration", new Registration());
			List<Course> courseList = courseService.getAllCourseName();

			if (courseList != null) {
				model.addAttribute("course", courseList);
			}
			List<Batch> batchList = batchService.getAllBatchName();
			if (batchList != null) {
				model.addAttribute("batch", batchList);
			}
			List<Year> yearList = courseService.getAllYearName();
			if (courseList != null) {
				model.addAttribute("year", yearList);
			}
			List<CurrentStatus> currentStatusList = courseService.getAllCurrentStatus();
			if (currentStatusList != null) {
				model.addAttribute("currentStatus", currentStatusList);
			}
			model.addAttribute("message", message);
			model.addAttribute("Registration", registration);
			return "registration";
		} else {
			return "viewStudentDetails";
		}

	}

	@RequestMapping(value = "/deleteStudentDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteCatageory(@ModelAttribute("Registration") Registration registration, ModelMap model,
			@RequestParam(required = false) Integer registrationId) {
		registrationService.deleteStudentDetails(registrationId);
		model.addAttribute("message", IConstant.STUDENT_DELETE_MESSAGE);
		
		return "redirect:/registration.do";
		
	}
}
