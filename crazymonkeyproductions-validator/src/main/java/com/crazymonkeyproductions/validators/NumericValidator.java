package com.crazymonkeyproductions.validators;

import com.crazymonkeyproductions.constraints.Numeric;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumericValidator implements ConstraintValidator<Numeric, String> {

	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		if (null == input || input.length() == 0) {
			return true;
		}
		return input.matches("^([0-9])*$");
	}
}
