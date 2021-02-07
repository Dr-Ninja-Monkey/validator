package com.crazymonkeyproductions.validators;

import com.crazymonkeyproductions.constraints.Alpha;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AlphaValidator implements ConstraintValidator<Alpha, String> {

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
		return input.length() >= min && input.length() < max && input.matches("^([a-zA-Z])*$");
	}

}
