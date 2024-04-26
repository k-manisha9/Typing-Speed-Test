import java.util.Random;
import java.util.Scanner;

public class Test {

	private static final String[] sentences = {
			"Java is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.",
			"It is intended to let application developers write once, and run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.",
			"Java was first released in 1995 and is widely used for developing applications for desktop, web, and mobile devices.",
			"Java is known for its simplicity, robustness, and security features, making it a popular choice for enterprise-level applications.",
			"A general-purpose programming language made for developers to write once run anywhere that is compiled Java code can run on all platforms that support Java." };
	private static final String para[] = {
			"Java is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is intended to let application developers write once, and run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation. Java was first released in 1995 and is widely used for developing applications for desktop, web, and mobile devices. Java is known for its simplicity, robustness, and security features, making it a popular choice for enterprise-level applications.",
			"While we were using the term JDK when we learn about bytecode and JVM. So, as the name suggests, it is a complete Java development kit that includes everything including compiler, Java Runtime Environment (JRE), java debuggers, java docs, etc. For the program to execute in java, we need to install JDK on our computer in order to create, compile and run the java program.",
			"Java is an object-oriented, class-based programming language. The language is designed to have as few dependencies implementations as possible. The intention of using this language is to give relief to the developers from writing codes for every platform. The term WORA, write once and run everywhere is often associated with this language. It means whenever we compile a Java code, we get the byte code (.class file), and that can be executed (without compiling it again) on different platforms provided they support Java. ",
			"JVM is the specification that facilitates the runtime environment in which the execution of the Java bytecode takes place. Whenever one uses the command java, an instance of the JVM is created. JVM facilitates the definition of the memory area, register set, class file format, and fatal error reporting. Note that the JVM is platform dependent.",
			"The principles for creating java were simple, robust, secured, high-performance, portable, multi-threaded, interpreted, dynamic, etc. In 1995 Java was developed by James Gosling, who is known as the Father of Java. Currently, Java is used in mobile devices, internet programming, games, e-business, etc.",
			"The principles for creating java were simple, robust, secured, high-performance, portable, multi-threaded, interpreted, dynamic, etc. In 1995 Java was developed by James Gosling, who is known as the Father of Java. Currently, Java is used in mobile devices, internet programming, games, e-business, etc." };

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Random rndm = new Random();
		System.out.println("--------------Welcome to Typing Speed Test--------------");
		char c = 'y';
		while (c == 'y') {
			String originalText = "";
			System.out.println("What type of text you want to type??");
			System.out.println("1. Sentence\t\t 2. Paragraph");
			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();
			sc.nextLine();

			if (ch == 1) {
				originalText = sentences[rndm.nextInt(sentences.length)];
			} else if (ch == 2) {
				originalText = para[rndm.nextInt(para.length)];
			} else {
				System.out.println("Invalid choice!!");
				System.out.println("Do you want to continue?? Type y for yes and n for no....");
				c = sc.next().charAt(0);
			}

			System.out.println("Type the following text: ");
			System.out.println(originalText);

			System.out.println("Press Enter when you are ready to start the test");
			sc.nextLine();

			// user types the text
			System.out.println("Type the text: ");
			long startTime = System.currentTimeMillis();// start time in milisecond
			String userInput = sc.nextLine();
			long endTime = System.currentTimeMillis();// end time in milisecond

			// calculate elasped time
			long elaspedTime = endTime - startTime;
			double seconds = elaspedTime / 1000.0;// converting to seconds

			int originalLength = originalText.length();
			int userLength = userInput.length();
			int correctCharacters = 0;

			// counting correct characters
			for (int i = 0; i < Math.min(originalLength, userLength); i++) {
				if (originalText.charAt(i) == userInput.charAt(i)) {
					correctCharacters++;
				}
			}

			// calculating accuracy in percentage
			int accuracy = (int) (((double) correctCharacters / originalLength) * 100.0);
			double wpm = (userLength / 5.0) / (seconds / 60);

			System.out.println("----------Test Result-------------");
			System.out.println("Time elapsed: " + seconds + " sec");
			System.out.println("Accuracy: " + accuracy + "%");
			System.out.println("Words Per Minute (WPM): " + wpm);

			// extra characters
			if (userLength > originalLength) {
				int extra = userLength - originalLength;
				System.out.println("Extra characers typed: " + extra);
			} else if (userLength < originalLength) {
				int missing = originalLength - userLength;
				System.out.println("Missing characers: " + missing);
			}

			System.out.println("Do you want to continue?? Type y for yes and n for no....");
			c = sc.next().charAt(0);
		}

	}
}
