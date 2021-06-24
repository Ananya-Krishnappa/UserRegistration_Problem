package bridgelabz.UserRegistrationSystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserRegistrationTest {
	UserRegistration userRegistration;

	@BeforeEach
	public void init() {
		userRegistration = new UserRegistration();
	}

	@Test
	public void validate_shouldReturnFalseWhenNameAndFieldAreNull() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate(null, null);
		assertFalse(result);
	}

	@Test
	public void validate_shouldReturnFalseWhenNameIsNull() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate(null, InputField.FIRST_NAME);
		assertFalse(result);
	}

	@Test
	public void validate_shouldReturnTrueWhenFirstNameStartsWithCaps() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("Ananya", InputField.FIRST_NAME);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnFalseWhenFirstNameNotStartsWithCaps() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("ananya", InputField.FIRST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenFirstNameHasLessThanThreeChars() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("An", InputField.FIRST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnTrueWhenFirstNameHasThreeChars() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("Ana", InputField.FIRST_NAME);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnTrueWhenFirstNameHasMoreThanThreeChars() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("Anany", InputField.FIRST_NAME);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnFalseWhenFirstNameHasDigits() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("Anany1", InputField.FIRST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenFirstNameHasSpecialChars() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("Anany@", InputField.FIRST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenFirstNameHasSpace() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("An any@", InputField.FIRST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenFirstNameHasMoreThanOneCaps() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("AnAany", InputField.FIRST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenLastNameIsNull() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate(null, InputField.LAST_NAME);
		assertFalse(result);
	}

	@Test
	public void validate_shouldReturnTrueWhenLastNameStartsWithCaps() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("Ananya", InputField.LAST_NAME);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnFalseWhenLastNameNotStartsWithCaps() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("ananya", InputField.LAST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenLastNameHasLessThanThreeChars() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("An", InputField.LAST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnTrueWhenLastNameHasThreeChars() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("Ana", InputField.LAST_NAME);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnTrueWhenLastNameHasMoreThanThreeChars() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("Anany", InputField.LAST_NAME);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnFalseWhenLastNameHasDigits() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("Anany1", InputField.LAST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenLastNameHasSpecialChars() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("Anany@", InputField.LAST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenLastNameHasSpace() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("An any@", InputField.LAST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenLastNameHasMoreThanOneCaps() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("AnAany", InputField.LAST_NAME);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnTrueWhenPhoneNumHasTwoDigitCountryCode() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("91 1234566789", InputField.PHONE_NO);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnTrueWhenPhoneNumHasTwoDigitCountryCodeFollowedBySpace()
			throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("91 1234566789", InputField.PHONE_NO);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnTrueWhenPhNoHasTwoDigitCountryCodeFollowedBySpaceAndTenDigitPhNo()
			throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("91 1234566789", InputField.PHONE_NO);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasTwoDigitCountryCodeNoSpaceAndTenDigitPhNo()
			throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("911234566789", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasTwoDigitCountryCodeSpaceAndLessThanTenDigitPhNo()
			throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("91 12345667", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasTwoDigitCountryCodeSpaceAndMoreThanTenDigitPhNo()
			throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("91 123456672345", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasMoreThanTwoDigitCountryCode() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("912 123456672345", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasLessThanTwoDigitCountryCode() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("9 123456672345", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasNoTwoDigitCountryCode() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate(" 123456672345", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasOnlyCountryCode() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("91", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasNoCountryCode() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("9134567890", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasAlpha() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("91as567890", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasSpecialChars() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("91@#567890", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPhNoHasSpaceInBetween() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("91 1234 567890", InputField.PHONE_NO);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnTrueWhenPasswordHasMinOneUpperLowerDigitSpecialCharAndEightChars()
			throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("Anany12@q", InputField.PASSWORD);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnFalseWhenPasswordHasMinOneUpperLowerDigitSpecialCharAndLessThanEightChars()
			throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("Anny12@", InputField.PASSWORD);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnTrueWhenPasswordHasMinOneUpperLowerDigitSpecialCharAndMoreThanEightChars()
			throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("Anny12@qwert", InputField.PASSWORD);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnTrueWhenPasswordHasMoreThanOneUpperLowerDigitAndOneSpecialCharAndMoreThanEightChars()
			throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("Anny12K@qwert", InputField.PASSWORD);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnFalseWhenPasswordHasNoUpper() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("nny12@qwert", InputField.PASSWORD);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPasswordHasNoLower() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("ASD123$TYK", InputField.PASSWORD);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPasswordHasNoNumber() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("ASDasd$TYK", InputField.PASSWORD);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPasswordHasNoSpecialChar() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("ASDasd8TYK", InputField.PASSWORD);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPasswordHasMoreThanOneSpecialChar() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("AS&as%8TYK", InputField.PASSWORD);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenPasswordHasSpace() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("AS as%8TYK", InputField.PASSWORD);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenEmailDomainStartsWithDot() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("abc@.com.my", InputField.EMAIL);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenEmailHasMoreThanTwoConsecutiveDots() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("abc..2002@gmail.com", InputField.EMAIL);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnTrueWhenEmailMustContainAmpersand() throws UserRegistrationException {
		boolean result = userRegistration.iValidateFunction.validate("abc@yahoo.com", InputField.EMAIL);
		assertTrue(result);
	}

	@Test
	public void validate_shouldReturnFalseWhenEmailPartOfDomainAfterLastDotHasDigits()
			throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("abc@gmail.com.1a", InputField.EMAIL);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenEmailPartOfDomainAfterLastDotMustBeTwoChars()
			throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("abc123@gmail.a", InputField.EMAIL);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenEmailFirstCharCannotStartWithDot() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate(".abc@abc.com", InputField.EMAIL);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenEmailAllowOnlyCharDigitUnderscoreAndDash()
			throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("abc()*@gmail.com", InputField.EMAIL);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenEmailTldAllowsOnlyCharAndDigit() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("abc@%*.com", InputField.EMAIL);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenEmailsLastCharCannotEndWithDot() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("abc.@gmail.com", InputField.EMAIL);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void validate_shouldReturnFalseWhenEmailCannotHaveMultipleTlds() throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate("abc@gmail.com.aa.au ", InputField.EMAIL);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@ParameterizedTest
	@ValueSource(strings = { "abc@gmail.com.1a", "abc123@gmail.a", ".abc@abc.com", "abc()*@gmail.com", "abc@%*.com" })
	void parameterisedTest_shouldReturnFalseWhenEmailsAreInvalid(String email) throws UserRegistrationException {
		Exception exception = assertThrows(UserRegistrationException.class, () -> {
			userRegistration.iValidateFunction.validate(email, InputField.EMAIL);
		});

		String expectedMessage = "is not valid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
}
