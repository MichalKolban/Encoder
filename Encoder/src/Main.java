import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * TODO:
		 * 
		 * while to always running program try catch
		 * 
		 */

		Salt salt = new Salt();

		final String secretKey = "==MyNameIsMichaelScott==";

		String encodedData = "";

		Scanner sc = new Scanner(System.in);

		System.out.println("======== Encryption ===F=====");
		System.out.println("1 - Basic Encode");
		System.out.println("2 - Basic & Advanced Encode");
		System.out.println("0 - Exit ");

		int optionOne = sc.nextInt();

		switch (optionOne) {
		case 1:
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter data to basic encode");
			String dataBasic = sc1.nextLine();
			String simpleEncode = BasicEncode.basicEncode(dataBasic) + salt.generateSalt();
			System.out.println("Your encoded data :");
			System.out.println(simpleEncode);
			System.out.println();

			encodedData = simpleEncode + '/';
			break;
		case 2:
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Enter data to advanced encode");
			String dataPro = sc2.nextLine();
			String proEncode = BasicEncode.basicEncode(dataPro);
			String proEncode2 = ProEncode.proEncode(proEncode, secretKey) + salt.generateSalt();
			System.out.println("Your encoded data :");
			System.out.println(proEncode2);
			System.out.println();

			encodedData = proEncode2 + '|';
			break;
		case 0:
			System.out.println("Program is shutting down...");
			break;
		default:
			System.out.println("Wrong input");
		}

		if (optionOne == 1 || optionOne == 2) {

			System.out.println("Whant to decode ?");
			System.out.println("1 - Yes");
			System.out.println("2 - No");
			System.out.println();
			Scanner sc3 = new Scanner(System.in);
			int choose2 = sc3.nextInt();

			switch (choose2) {
			case 1:
				if (encodedData.contains("/")) {
					String splitOne = encodedData.substring(0, encodedData.length() - 6);
					String decodeData = BasicEncode.basicDecode(splitOne);
					System.out.println("Your decoded data : ");
					System.out.println(decodeData);
				} else if (encodedData.contains("|")) {
					String splitOne = encodedData.substring(0, encodedData.length() - 6);
					String decodeDataPro = ProEncode.proDecode(splitOne, secretKey);
					String decodeData = BasicEncode.basicDecode(decodeDataPro);
					System.out.println("Your decoded data : ");
					System.out.println(decodeData);
				}
				break;
			case 2:
				System.out.println("Program is shutting down...");
				break;
			}

		} else {
			System.out.println();
		}
	}
}
