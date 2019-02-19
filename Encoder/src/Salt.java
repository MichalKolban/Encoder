import java.util.Random;

public class Salt {

	public String generateSalt() {

		String characters = "abcdefghijklmnoprsqwuyxABCDEFGHIJKLMNOPRSTKWU0987654321!@#$%^&*()_+";
		String randomString = "";

		int length = 5;

		Random rand = new Random();

		char[] text = new char[length];

		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rand.nextInt(characters.length()));
		}

		for (int i = 0; i < text.length; i++) {
			randomString += text[i];
		}
		return randomString;
	}
}