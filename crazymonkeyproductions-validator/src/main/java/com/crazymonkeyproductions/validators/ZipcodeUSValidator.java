package com.crazymonkeyproductions.validators;

import com.crazymonkeyproductions.constraints.ZipcodeUS;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ZipcodeUSValidator implements ConstraintValidator<ZipcodeUS, String> {

	private static final String ZIPCODE_REGEX = "^\\d{5}(?:[-\\s]\\d{4})?$";

	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		if (null == input || input.length() == 0) {
			return true;
		}
		return input.matches(ZIPCODE_REGEX);
	}
}
