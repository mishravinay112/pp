package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.aartek.prestigepoint.model.CurrentBatch;
import com.aartek.prestigepoint.model.Emi;

@Component
public class CurrentBatchValidator {

	public boolean supports(Class<?> clazz) {
		return Emi.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		CurrentBatch currentBatch = (CurrentBatch) target;
		if (currentBatch.getStatus().equals("None")) {
			errors.rejectValue("status", "error.status.rule");
		}
	}
}