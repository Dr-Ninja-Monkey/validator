package com.crazymonkeyproductions.validators;

import com.crazymonkeyproductions.constraints.SSN;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SsnValidator implements ConstraintValidator<SSN, String> {

	@Override
	public boolean isValid(String ssnField, ConstraintValidatorContext cxt) {
		if (null == ssnField || ssnField.length() == 0) {
			return true;
		}
		return isValidSsnWithoutHyphens(ssnField) || isValidSsnWithHyphens(ssnField);
	}

	private boolean isValidSsnWithoutHyphens(String ssnField) {
		return ssnField.matches("^(?!666|000|9\\d{2})\\d{3}(?!00)\\d{2}(?!0{4})\\d{4}$");
	}

	private boolean isValidSsnWithHyphens(String ssnField) {
		return ssnField.matches("^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$");
	}
}
