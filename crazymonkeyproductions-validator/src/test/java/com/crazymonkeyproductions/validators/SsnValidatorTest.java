package com.crazymonkeyproductions.validators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SsnValidatorTest {

	private SsnValidator testObj = new SsnValidator();

	@Test
	@DisplayName("Valid SSN without hyphens")
	void isValidSSNWithoutHyphens() {
		assertTrue(testObj.isValid("123456789", null));
	}

	@Test
	@DisplayName("Valid SSN with hyphens")
	void isValidSSNWithHyphens() {
		assertTrue(testObj.isValid("123-45-6789", null));
	}

	@Test
	@DisplayName("Null input")
	void isValidSSNNullValue() {
		assertTrue(testObj.isValid(null, null));
	}

	@Test
	@DisplayName("Empty String input")
	void isValidSSNEmptyValue() {
		assertTrue(testObj.isValid("", null));
	}

	@Test
	@DisplayName("Invalid SSN with hyphens, starts with 000")
	void isValidSSNThatStartsWith000() {
		assertFalse(testObj.isValid("000-45-6789", null));
	}

	@Test
	@DisplayName("Invalid SSN with hyphens, starts with 666")
	void isValidSSNThatStartsWith666() {
		assertFalse(testObj.isValid("666-45-6789", null));
	}

	@Test
	@DisplayName("Invalid SSN with hyphens, starts with 9")
	void isValidSSNThatStartsWith9() {
		assertFalse(testObj.isValid("900-45-6789", null));
	}

	@Test
	@DisplayName("Invalid SSN without hyphens, starts with 000")
	void isValidSSNThatStartsWith000NoHyphens() {
		assertFalse(testObj.isValid("000456789", null));
	}

	@Test
	@DisplayName("Invalid SSN without hyphens, starts with 666")
	void isValidSSNThatStartsWith666NoHyphens() {
		assertFalse(testObj.isValid("666456789", null));
	}

	@Test
	@DisplayName("Invalid SSN without hyphens, starts with 9")
	void isValidSSNThatStartsWith9NoHyphens() {
		assertFalse(testObj.isValid("900456789", null));
	}

	@Test
	@DisplayName("Incorrect Hyphens")
	void isValidSSNIncorrectHyphensAtEnd() {
		assertFalse(testObj.isValid("123-456789", null));
	}

	@Test
	@DisplayName("Incorrect Hyphens")
	void isValidSSNIncorrectHyphensAtStart() {
		assertFalse(testObj.isValid("12345-6789", null));
	}

	@Test
	@DisplayName("Alpha character")
	void isValidSSNAlphaCharacters() {
		assertFalse(testObj.isValid("aaa-aa-aaaa", null));
	}
	
	@Test
	@DisplayName("Alpha character with no hyphens")
	void isValidSSNAlphaCharactersNoHyphens() {
		assertFalse(testObj.isValid("aaaaaaaaa", null));
	}

	@Test
	@DisplayName("Incorrect length with hyphens")
	void isValidSSNIncorrectLengthWithHyphens() {
		assertFalse(testObj.isValid("123-45-67", null));
	}

	@Test
	@DisplayName("Incorrect length without hyphens")
	void isValidSSNIncorrectLengthWithoutHyphens() {
		assertFalse(testObj.isValid("1234567", null));
	}

	@Test
	@DisplayName("Invalid SSN with hyphens, starts with 9")
	void isValidSSNZerosInTheMiddleHyphens() {
		assertFalse(testObj.isValid("123-00-6789", null));
	}

	@Test
	@DisplayName("Invalid SSN without hyphens, starts with 9")
	void isValidSSNZerosInTheMiddleNoHyphens() {
		assertFalse(testObj.isValid("123006789", null));
	}

	@Test
	@DisplayName("Invalid SSN with hyphens Zeros at the end")
	void isValidSSNZerosAtTheEndHyphens() {
		assertFalse(testObj.isValid("123-45-0000", null));
	}

	@Test
	@DisplayName("Invalid SSN without hyphens Zeros at the end")
	void isValidSSNZerosAtTheEndNoHyphens() {
		assertFalse(testObj.isValid("123450000", null));
	}
}
