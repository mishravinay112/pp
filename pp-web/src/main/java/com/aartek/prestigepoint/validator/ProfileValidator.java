package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.aartek.prestigepoint.model.Registration;

@Component
public class ProfileValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Registration registration = (Registration) target;
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "contact", "error.contact.empty");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.lastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "qualification", "error.qualification.empty");
		ValidationUtils.rejectIfEmpty(errors, "dateOfBirth", "error.dateOfBirth.empty");
		if (registration.getEmailId() != null && registration.getEmailId().trim().length() > 0) {
			boolean b = ValidationUtil.validateEmail(registration.getEmailId());
			if (registration.getEmailId().contains("@") != true && !b) {
				errors.rejectValue("emailId", "error.email.first.rule");
			} else if (registration.getEmailId().contains(".com") != true
					&& registration.getEmailId().contains(".net") != true && !b) {
				errors.rejectValue("emailId", "error.email.second.rule");
			} else if (!b) {
				errors.rejectValue("emailId", "error.email.required");
			}
		}
	}

}
