/**
 * Purpose:User Registration System needs to ensure all validations
	are in place during the User Entry
 * @author Ananya K
 * @version 1.0
 * @since 23/06/2021
 * 
 */
package bridgelabz.UserRegistrationSystem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserRegistration {
	private static final Logger LOG = LogManager.getLogger(UserRegistration.class);

	/**
	 * This method validates first name, last name,phone number,email,password. it
	 * uses the switch statement to select the regex required for validation.
	 * 
	 * @param name
	 * @param field
	 * @return
	 * @throws Exception
	 */
	static IValidateFunction validateFunction = (String name, InputField field) -> {
		try {
			String regex = null;
			if (null != field) {
				switch (field) {
				case FIRST_NAME:
					regex = "[A-Z]{1}[a-z]{2,}";
					break;
				case LAST_NAME:
					regex = "[A-Z]{1}[a-z]{2,}";
					break;
				case EMAIL:
					regex = "^[a-zA-Z0-9]+(.?)[a-zA-Z0-9]+@+[a-zA-Z0-9]+(.+)[a-zA-Z0-9]+(.*)[a-zA-Z]{2,}$";
					break;
				case PHONE_NO:
					regex = "[9]{1}[1]{1}+\s{1}+[0-9]{10}";
					break;
				case PASSWORD:
					regex = "^(?=.*[A-Z])(?=.*[0-9])(?=\\S+$)(?=.*[a-z])(?=[^\\p{Punct}]*[\\p{Punct}][^\\p{Punct}]*$).{8,}$";
					break;
				}
				Pattern p = Pattern.compile(regex);
				if (name == null) {
					return false;
				}
				Matcher m = p.matcher(name);
				String result = m.matches() ? field.name() + " " + name + " is valid"
						: field.name() + " " + name + " is not valid";
				if (!m.matches()) {
					throw new UserRegistrationException(result);
				}
				LOG.debug(result);
				return m.matches();
			}
			return false;
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return false;
	};

	public static void main(String[] args) throws UserRegistrationException {
		Scanner sc = new Scanner(System.in);
		LOG.info("Enter first name");
		String fn = sc.nextLine();
		validateFunction.validate(fn, InputField.FIRST_NAME);
		LOG.info("Enter last name");
		String ln = sc.nextLine();
		validateFunction.validate(ln, InputField.LAST_NAME);
		LOG.info("Enter email");
		String email = sc.nextLine();
		validateFunction.validate(email, InputField.EMAIL);
		LOG.info("Enter phone number");
		String phno = sc.nextLine();
		validateFunction.validate(phno, InputField.PHONE_NO);
		LOG.info("Enter password");
		String password = sc.nextLine();
		validateFunction.validate(password, InputField.PASSWORD);
		sc.close();
	}
}
