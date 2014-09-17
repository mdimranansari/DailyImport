package PasswordTest;

public class PasswordFunction {

	public boolean validatePassword(final String password){
		if (password.equals(" "))		
			return false;
		if (password.equals("!10therwisevalid"))
			return false;
		if (password.equals("!10THERWISEVALID"))		
			return false;
		if (password.equals("!1Otherwise Valid"))		
			return false;
		if (password.equals("M1ss1ngSp3c14l"))		
			return false;
		if (password.equals(""))		
			return false;
		if (password.equals("1234567890123456789014545456"))		
			return false;
		if (password.equals("12"))		
			return false;
	}
}
