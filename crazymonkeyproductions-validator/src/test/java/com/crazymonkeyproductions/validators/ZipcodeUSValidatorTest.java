package com.crazymonkeyproductions.validators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ZipcodeUSValidatorTest {

	private ZipcodeUSValidator testObj = new ZipcodeUSValidator();

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
	@DisplayName("Valid 5 digit Zipcode")
	void isValidZipcodeFiveDigits() {
		assertTrue(testObj.isValid("12345", null));
	}

	@Test
	@DisplayName("Valid 9 digit Zipcode with Spaces")
	void isValidZipcodeNineDigitsWithSpaces() {
		assertTrue(testObj.isValid("12345 6789", null));
	}

	@Test
	@DisplayName("Valid 9 digit Zipcode with hyphen")
	void isValidZipcodeNineDigitsWithHyphen() {
		assertTrue(testObj.isValid("12345-6789", null));
	}

	@Test
	@DisplayName("Invalid 10 digit Zipcode with hyphen")
	void isValidZipcodeFailTenDigits() {
		assertFalse(testObj.isValid("12345-67890", null));
	}

	@Test
	@DisplayName("Invalid 4 digit Zipcode")
	void isValidZipcodeFailFourDigits() {
		assertFalse(testObj.isValid("1234", null));
	}

	@Test
	@DisplayName("Invalid 9 digit Zipcode no space or hyphen")
	void isValidZipcodeFailNineDigitsNoHyphenOrSpaces() {
		assertFalse(testObj.isValid("123456789", null));
	}

	@Test
	@DisplayName("Invalid Zipcode With Alpha")
	void isValidZipcodeAlpha() {
		assertFalse(testObj.isValid("aaaaa", null));
	}
}
