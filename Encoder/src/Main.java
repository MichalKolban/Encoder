import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * TODO: while to always running program try catch
		 */

		Salt salt = new Salt();

		final String secretKey = "==MyNameIsMichaelScott==";

		Scanner sc = new Scanner(System.in);

		System.out.println("===== PROGRAM =====");
		System.out.println(" ");
		System.out.println("1 - Basic Encode");
		System.out.println("2 - Basic & Advanced Encode");
		System.out.println("3 - Decode");
		System.out.println("0 - Exit ");

		int opt1 = sc.nextInt();

		switch (opt1) {
		case 1:
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter data to basic encode");
			String data = sc1.nextLine();
			String encode1 = BasicEncode.basicEncode(data);
			System.out.println("Your encoded data");
			System.out.println(encode1);
			break;
		case 2:
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Enter data to advanced encode");
			String data2 = sc2.nextLine();
			String encode21 = BasicEncode.basicEncode(data2);
			String encode22 = ProEncode.proEncode(encode21, secretKey);
			System.out.println("Your encoded data");
			System.out.println(encode22);
			break;
		case 3:
			// in progrss
			Scanner sc3 = new Scanner(System.in);
			System.out.println("Enter data to decode");
			String data3 = sc.nextLine();
		}

	}
}
