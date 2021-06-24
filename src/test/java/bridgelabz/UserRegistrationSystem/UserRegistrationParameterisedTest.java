package bridgelabz.UserRegistrationSystem;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserRegistrationParameterisedTest {

	UserRegistration userRegistration;

	@BeforeEach
	public void init() {
		userRegistration = new UserRegistration();
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
