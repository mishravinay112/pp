package com.aartek.prestigepoint.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.aartek.prestigepoint.model.PhotoInFooter;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.model.Scroller;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.service.FooterPhotoService;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.service.ScrollerService;
import com.aartek.prestigepoint.service.StudentRegistrationService;

@Controller
public class UserLoginController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(UserLoginController.class);

	@Autowired
	private FooterPhotoService footerPhotoService;

	@Autowired
	private StudentRegistrationService stuRegService;

	@Autowired
	private QuestionAnswerService questionAnswerService;
	@Autowired
	private ScrollerService scrollerService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Map<String, Object> map, Model model,HttpServletRequest req,Date d) {

		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		model.addAttribute("subjectList", subjects);

		List<Scroller> scrollers = null;
		scrollers = scrollerService.getAllScrollImages();
		model.addAttribute("allImages", scrollers);

		return "welcome";
	}

	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String aboutUs(Map<String, Object> map, Model model) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		model.addAttribute("subjectList", subjects);
		return "aboutUs";

	}

	@RequestMapping(value = "/features", method = RequestMethod.GET)
	public String features(Map<String, Object> map, Model model) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		model.addAttribute("subjectList", subjects);
		return "features";
	}

	@RequestMapping(value = "/termAndCondition", method = RequestMethod.GET)
	public String termAndCondition(Map<String, Object> map, Model model) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		model.addAttribute("subjectList", subjects);
		return "termAndCondition";
	}

	@RequestMapping(value = "/placementCell", method = RequestMethod.GET)
	public String placementCell(Map<String, Object> map, Model model) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		model.addAttribute("subjectList", subjects);
		return "placementCell";
	}

	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public String course(Map<String, Object> map, Model model) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		model.addAttribute("subjectList", subjects);
		return "course";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Map<String, Object> map, Model model, @RequestParam(required = false) String invalid,
			@RequestParam(required = false) String forgotMessage) {
		map.put("Registration", new Registration());
		model.addAttribute("invalid", invalid);
		model.addAttribute("forgotMessage", forgotMessage);
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		model.addAttribute("subjectList", subjects);
		return "login";
	}

	@RequestMapping(value = "/stuSignIn", method = RequestMethod.POST)
	public String signInAction(@ModelAttribute("Regestration") Registration registration, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
		registration = stuRegService.stuSignIn(registration);

		if (registration == null) {
			model.addAttribute("invalid", "Invalid user name and password");
			return "redirect:/login.do";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("registration", registration);
			return "redirect:/welcome.do";
		}
	}

	/* start end blog */
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blog(Map<String, Object> map, Model model) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		model.addAttribute("subjectList", subjects);
		return "blog";
	}

	@RequestMapping("/logout")
	public String showLogout(Map<String, Object> map, Model model, HttpServletRequest request,
			HttpServletResponse httpResponse) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login.do";
	}

	@RequestMapping(value = "/menu")
	public String menu(Map<String, Object> map, Model model) {

		return "menu";
	}

}
