package com.crazymonkeyproductions.validators;

import com.crazymonkeyproductions.constraints.Alpha;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AlphaNumericValidator implements ConstraintValidator<Alpha, String> {

	private static final String ALPHA_NUMERIC_REGEX = "^([a-zA-Z0-9])*$";
	int min = 1;
	int max = Integer.MAX_VALUE;

	@Override
	public void initialize(Alpha constraintAnnotation) {
		this.min = constraintAnnotation.min();
		this.max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		if (null == input || input.length() == 0) {
			return true;
		}
		return input.length() >= min && input.length() < max && input.matches(ALPHA_NUMERIC_REGEX);
	}
}