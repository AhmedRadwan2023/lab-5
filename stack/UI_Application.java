package eg.edu.alexu.csd.datastructure.stack;
import java.util.Scanner;
import java.util.EmptyStackException;
import java.util.InputMismatchException;

public class UI_Application {
	
	private static Scanner input;

	public static void main (String[] args) {
		
		stack s = new stack();
		while(true) {
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1: Push");
		System.out.println("2: Pop");
		System.out.println("3: Peek");
		System.out.println("4: Get Size");
		System.out.println("5: Check if empty");
		System.out.println("6: close the program");   

			try {
		input = new Scanner(System.in);
		int number = input.nextInt();
		
		switch (number) {
		
		case 1 :   System.out.println("Enter the value");
				   String c = input.next();
		           s.push(c);
		           break;
 
		case 2 : try {
				System.out.println(s.pop());
				}
				catch(EmptyStackException e) {
					System.out.println("Empty stack");
				}
				break;
		
		case 3 : try {
				 System.out.println(s.peek());
				 }
				catch(EmptyStackException e) {
				System.out.println("Empty stack");
				}
				break;

		case 4 : 
		        System.out.println(s.size());
		        break;

		case 5 : 
		        System.out.println(s.isEmpty());
		    
		case 6 : break;
		
		default :  System.out.println("Enter a number from 1 to 6"); break;

		}
		if(number == 6) {
			break;
		}
		}
			catch(InputMismatchException e) {
				System.out.println("Enter a number from 1 to 6");
				
			}
			
			
		}	
	}
}
			
			