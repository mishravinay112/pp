package com.aartek.prestigepoint.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.AdminLogin;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.service.RegistrationService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.util.SendMail;
import com.aartek.prestigepoint.util.SendMailProperty;

/**
 * 
 * @author Meenal Pathre
 *
 */
@Controller
public class MailController {

	@Autowired
	private RegistrationService registrationService;

	private static Logger log = LoggerFactory.getLogger(MailController.class);

	/**
	 * Display mail sending page
	 * 
	 * @param map
	 * @param model
	 * @param request
	 * @param emailId
	 * @return
	 */
	@RequestMapping("/sendMail")
	public String showSendMail(Map<String, Object> map, Model model,
			@RequestParam(required = false) String emailId) {
		log.info("this is mailer");
		map.put("Registration", new Registration());
		model.addAttribute("emailId", emailId);
		return "sendMail";
	}

	/**
	 * Use for send mail to particular address or all students or all enquires.
	 * 
	 * @param registration
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @param attachFile
	 * @return
	 * @throws MessagingException
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String sendEmail(
			@ModelAttribute("Registration") Registration registration,
			String[] attachedFiles) throws MessagingException {
		// reads form input
		List<String> emailList = new ArrayList<String>();
		final String emailTo = registration.getEmailId();
		final String subject = registration.getSubject();
		final String message = registration.getMessage();
		if ( emailTo.isEmpty() || emailTo == null ) {
			if (registration.getAllStudent() != null) {
				if (registration.getAllStudent().equals("allstudent")) {
					emailList = registrationService.getallStudentEmailId();
					final String[] email = emailList
							.toArray(new String[emailList.size()]);
					InternetAddress[] addressTo = new InternetAddress[email.length];
					for (int i = 0; i < email.length; i++) {
						addressTo[i] = new InternetAddress(email[i]);

					}
					Message message1 = new MimeMessage(
							SendMailProperty.mailProperty());
					message1.setFrom(new InternetAddress(
							IConstant.FROM_EMAIL_ID));
					message1.setRecipients(Message.RecipientType.TO, addressTo);
					message1.setSubject(subject);
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setContent(message, "text/html");
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
					messageBodyPart = new MimeBodyPart();
					if (attachedFiles != null && attachedFiles.length > 0) {
						for (String aFile : attachedFiles) {
							MimeBodyPart attachPart = new MimeBodyPart();

							try {
								attachPart.attachFile(aFile);
							} catch (IOException ex) {

								log.error("context", ex);
							}

							multipart.addBodyPart(attachPart);
						}
					}

					message1.setContent(multipart);
					Transport.send(message1);
					log.info("Sent message successfully....");
				}
			}
			if (registration.getAllEnquiry() != null) {
				if (registration.getAllEnquiry().equals("allenquiry")) {
					emailList = registrationService.getallEnquiryEmailId();
					final String[] email = emailList
							.toArray(new String[emailList.size()]);
					InternetAddress[] addressTo = new InternetAddress[email.length];
					for (int i = 0; i < email.length; i++) {
						addressTo[i] = new InternetAddress(email[i]);

					}
					Message message1 = new MimeMessage(
							SendMailProperty.mailProperty());
					message1.setFrom(new InternetAddress(
							IConstant.FROM_EMAIL_ID));
					message1.setRecipients(Message.RecipientType.TO, addressTo);
					message1.setSubject(subject);
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setContent(message, "text/html");
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
					messageBodyPart = new MimeBodyPart();
					if (attachedFiles != null && attachedFiles.length > 0) {
						for (String aFile : attachedFiles) {
							MimeBodyPart attachPart = new MimeBodyPart();

							try {
								attachPart.attachFile(aFile);
							} catch (IOException ex) {
								log.error("IOException", ex);
								ex.printStackTrace();
							}

							multipart.addBodyPart(attachPart);
						}
					}

					message1.setContent(multipart);
					Transport.send(message1);
					log.info("Sent message successfully....");
				}
			}
		}

		if (!emailTo.isEmpty() && emailTo != null) {
			final String[] email2 = emailTo.split(",");
			SendMail.sendMail(registration.getEmailId(),
					registration.getSubject(), registration.getMessage());
		}

		return "redirect:/mailSuccess.do";
	}

	/**
	 * Use for show mail sending success message.
	 * 
	 * @param map
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/mailSuccess")
	public String showSuccessPage(Map<String, Object> map, Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		AdminLogin loginMember = (AdminLogin) session.getAttribute("login");
		if (loginMember != null) {
			return "mailSuccess";
		} else {
			return "redirect:/login.do";
		}
	}

	/**
	 * Use for get email address for sending mail.
	 * 
	 * @param model
	 * @param map
	 * @param request
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/getEmailId", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String sendSingleMail(ModelMap model, Map<String, Object> map,
			HttpServletRequest request,
			@RequestParam(required = false) String emailId) {
		model.addAttribute("emailId", emailId);
		return "redirect:/sendMail.do";
	}
}
