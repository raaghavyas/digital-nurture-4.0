/* 
Exercise 1: Implementing the Singleton Pattern
Scenario: 
You need to ensure that a logging utility class in your application has only one instance throughout the application life cycle to ensure consistent logging.
Steps:
1.Create a New Java Project:
	Create a new Java project named SingletonPatternExample.
2.Define a Singleton Class:
	Create a class named Logger that has a private static instance of itself.
	Ensure the constructor of Logger is private.
	Provide a public static method to get the instance of the Logger class.
3.Implement the Singleton Pattern:
	Write code to ensure that the Logger class follows the Singleton design pattern.
4.Test the Singleton Implementation:
	Create a test class to verify that only one instance of Logger is created and used across the application.
*/

// Main.java
package singleton;

public class Main {
	public static void main(String[] args) {
		Logger l1 = Logger.getInstance();
		Logger l2 = Logger.getInstance();
		
		if(l1 == l2) {
			System.out.println("Only ONE instance of Logger is "
					+ "created and used across the application.");
		}
		
		else {
			System.out.println("MULTIPLE instance of Logger is "
					+ "created and used across the application.");
		}
	}
}

// Logger.java
package singleton;

public class Logger{
	private static Logger instance;
	
	private Logger() {
		System.out.println("Logger constructor");
	}
	
	public static Logger getInstance() {
		return instance;
	}
}
