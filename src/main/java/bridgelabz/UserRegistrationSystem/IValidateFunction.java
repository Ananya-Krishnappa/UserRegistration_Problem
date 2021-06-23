package bridgelabz.UserRegistrationSystem;

@FunctionalInterface
public interface IValidateFunction {
	boolean validate(String name, InputField field);
}
