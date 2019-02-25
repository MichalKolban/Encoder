import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * TODO:
		 * 
		 * try catch + exceptions
		 * 
		 */

		Salt salt = new Salt();
		final String secretKey = "==MyNameIsMichaelScott==";
		String answear = "Yes";

		do {

			String encodedData = "";
			Scanner sc = new Scanner(System.in);
			Scanner answerUser = new Scanner(System.in);

			System.out.println("======== Encryption ===F=====");
			System.out.println("1 - Basic Encode");
			System.out.println("2 - Basic & Advanced Encode");
			System.out.println("0 - Exit ");

			int choose = sc.nextInt();
			switch (choose) {

			case 1:
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter data to basic encode");
				String dataBasic = sc1.nextLine();
				String simpleEncode = BasicEncode.basicEncode(dataBasic) + salt.generateSalt();
				System.out.println("Your encoded data :" + "\n" + simpleEncode + "\n");

				encodedData = simpleEncode + '/';
				break;

			case 2:
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter data to advanced encode");
				String dataPro = sc2.nextLine();
				String proEncode = BasicEncode.basicEncode(dataPro);
				String proEncode2 = ProEncode.proEncode(proEncode, secretKey) + salt.generateSalt();
				System.out.println("Your encoded data :" + "\n" + proEncode2 + "\n");

				encodedData = proEncode2 + '|';
				break;

			case 0:
				System.out.println("Program is shutting down...");
				break;
			default:
				System.out.println("Wrong input");
			}
			if (choose == 1 || choose == 2) {

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
						System.out.println("Your decoded data : " + "\n" + decodeData);
						System.out.println("Want to re-run the program ? Yes / No");
						answear = answerUser.next();
					} else if (encodedData.contains("|")) {
						String splitOne = encodedData.substring(0, encodedData.length() - 6);
						String decodeDataPro = ProEncode.proDecode(splitOne, secretKey);
						String decodeData = BasicEncode.basicDecode(decodeDataPro);
						System.out.println("Your decoded data : ");
						System.out.println(decodeData);
						System.out.println("Want to re-run the program ? Yes / No");
						answear = answerUser.next();
					}
					break;
				case 2:
					System.out.println("Program is shutting down...");
					System.exit(2);
				}
			} else {
				System.out.println("Wrong input");
			}
		} while (answear.equalsIgnoreCase("Yes"));
	}
}
