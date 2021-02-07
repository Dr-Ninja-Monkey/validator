package com.crazymonkeyproductions.validators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AlphaValidatorTest {

	private AlphaValidator testObj;

	@BeforeEach
	public void init() {
		testObj = new AlphaValidator();
	}

	@Test
	@DisplayName("Valid Alpha Test")
	void isValidAlpha() {
		assertTrue(testObj.isValid("asdfasdf", null));
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
	@DisplayName("Numeric characteres test")
	void isValidNumericCharacters() {
		assertFalse(testObj.isValid("1", null));
	}

	@Test
	@DisplayName("Special characters")
	void isValidSpecialCharacters() {
		assertFalse(testObj.isValid(" ", null));
	}

	@Test
	@DisplayName("Alpha characters with Space")
	void isValidAlphaCharactersWithSpace() {
		assertFalse(testObj.isValid("abc abc", null));
	}

	@Test
	@DisplayName("Alpha less than min amount of characters")
	void isValidAlphaLessThanMinCharacters() {
		testObj.min = 3;
		assertFalse(testObj.isValid("a", null));
	}

	@Test
	@DisplayName("Alpha greater than max amount of characters")
	void isValidAlphaGreaterThanMinCharacters() {
		testObj.max = 5;
		assertFalse(testObj.isValid("abcdef", null));
	}
}
