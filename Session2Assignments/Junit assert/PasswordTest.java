package PasswordTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordTest {
	

	@Test
	public void validatePasswordEmptyString() {
		assertFalse(new PasswordFunction().validatePassword(" "));
	}

	@Test
	public void validatePasswordNoCaps() {
		assertFalse(new PasswordFunction().validatePassword("!10therwisevalid"));
	}

	@Test
	public void validatePasswordNoLowers() {
		assertFalse(new PasswordFunction().validatePassword("!10THERWISEVALID"));
	}

	@Test
	public void validatePasswordNoSpaces() {
		assertFalse(new PasswordFunction().validatePassword("!1Otherwise Valid"));
	}

	@Test
	public void validatePasswordNoSpecial() {
		assertFalse(new PasswordFunction().validatePassword("M1ss1ngSp3c14l"));
	}

	@Test
	public void validatePasswordNull() {
		assertFalse(new PasswordFunction().validatePassword(null));
	}

	@Test
	public void validatePasswordTooLong() {
		assertFalse(new PasswordFunction().validatePassword("1234567890123456789014545456"));
	}

	@Test
	public void validatePasswordTooShort() {
		assertFalse(new PasswordFunction().validatePassword("12"));
	}

}
