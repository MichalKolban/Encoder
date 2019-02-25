
public class BasicEncode {

	/*
	 * Simple swiping letters forward -> 8
	 * is some cases u need to switch in IDE to UTF-8
	 */

	public static String basicEncode(String key) {
		String result = "";
		char move;
		for (int i = 0; i < key.length(); i++) {
			move = key.charAt(i);
			move += 8;
			result += move;
		}

		return result;
	}

	public static String basicDecode(String key) {
		String result = "";
		char move;
		for (int i = 0; i < key.length(); i++) {
			move = key.charAt(i);
			move -= 8;
			result += move;
		}

		return result;
	}

}
