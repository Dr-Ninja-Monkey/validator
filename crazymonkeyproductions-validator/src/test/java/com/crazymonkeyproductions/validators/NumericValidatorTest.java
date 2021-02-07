package com.crazymonkeyproductions.validators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericValidatorTest {

	NumericValidator testObj = new NumericValidator();

	@Test
	@DisplayName("Numeric test")
	void isValidNumeric() {
		assertTrue(testObj.isValid("123456", null));
	}

	@Test
	@DisplayName("Null input")
	void isValidNullValue() {
		assertTrue(testObj.isValid(null, null));
	}

	@Test
	@DisplayName("Empty String input")
	void isValidEmptyValue() {
		assertTrue(testObj.isValid("", null));
	}

	@Test
	@DisplayName("Alpha input")
	void isValidAlphaInput() {
		assertFalse(testObj.isValid("a", null));
	}

	@Test
	@DisplayName("Special character input")
	void isValid() {
		assertFalse(testObj.isValid(" ", null));
	}

}
