package FinalProject.StacksAndCopying;

import java.util.Stack;

/**
 * Lab: Practice with Stack operations
 * See comments for assignment instructions.
 * @author Christian Simpson
 * @version 11/18/22
 *
 */
public class StackCopy {
	
	/**
	 * Make an identical copy of a Stack.
	 * post-condition: s is the same as it was before the method was called.
	 * @param s The Stack to copy.
	 * @return An identical copy of the Stack s.
	 */
	public static <E> Stack<E> copy(Stack<E> s) {
		
		// (1) Complete this method.  Although Java's Stack class provides methods
		//     for access by an index, you are not allowed to use those methods in
		//     this lab assignment.  You are also not allowed to use the clone method
		//     of Java's Stack class.  You are allowed to use only the following
		//     methods of Java's Stack class: empty, peek, pop, and push (and also 
		//     the constructor since you will need to construct a couple Stacks).
		
		// Stack Copy Algorithm: Assumes the Stack to copy is named s (as it is in the parameter of this method.
		//     Let copy be an initially empty Stack.
		Stack<E> copy = new Stack<>();
		//     Let temp be an initially empty Stack.
		Stack<E> temp = new Stack<>();
		//     while s is not empty
		while(!s.empty()) {
		//         Pop s and store the result in element.
			E element = s.pop();
		//         Push element onto temp.
			temp.push(element);
		//end while
		}
		//     while temp is not empty
		while(!temp.empty()) {
		//         Pop temp and store the result in element.
			E element = temp.pop();
		//         Push element onto copy.
			copy.push(element);
		//         Push element onto s.
			s.push(element);
		//     end while
		}
			
		//     return copy
		
		return copy;
	}
	
	/**
	 * Make a reverse copy of a Stack.
	 * post-condition: s is the same as it was before the method was called.
	 * @param s The Stack to copy.
	 * @return A reverse copy of the Stack s.
	 */
	public static <E> Stack<E> reverseCopy(Stack<E> s) {
		
		// (2) Complete this method.  Although Java's Stack class provides methods
		//     for access by an index, you are not allowed to use those methods in
		//     this lab assignment.  You are also not allowed to use the clone method
		//     of Java's Stack class.  You are allowed to use only the following
		//     methods of Java's Stack class: empty, peek, pop, and push (and also 
		//     the constructor since you will need to construct a couple Stacks).
		
		// Stack Reverse Copy Algorithm: Assumes the Stack to copy is named s (as it is in the parameter of this method.
		//     Let reverse be an initially empty Stack.
		Stack<E> reverse = new Stack<>();
		//     Let temp be an initially empty Stack.
		Stack<E> temp = new Stack<>();
		//     while s is not empty
		while(!s.empty()) {
		//         Pop s and store the result in element.
			E element = s.pop();
		//         Push element onto temp.
			temp.push(element);
		//         Push element onto reverse.
			reverse.push(element);
		//     end while
		}
		//     while temp is not empty
		while(!temp.empty()) {
		//         Pop temp and store the result in element.
			E element = temp.pop();
		//         Push element onto s.
			s.push(element);
		//     end while
		}
		//     return reverse
		
		return reverse;
	}

	public static void main(String[] args) {
		
		// (3) Complete this main method to test your methods.

		// Create a Stack of whatever type of element you want, such as Strings,
		// Integers, etc, and put at least 5 different elements in it.

		Stack<String> stackStrings = new Stack<>();
		
		String fitnessGramPacerTest = "The FitnessGram™ Pacer Test is a multistage aerobic capacity "
				+ "test that progressively gets more difficult as it continues.";
		
		String[] stringArray = fitnessGramPacerTest.split(" ");
		
		for(String s : stringArray) {
			stackStrings.push(s);
		}
		// Use the copy method to make a duplicate Stack
		Stack<String> copyStack = copy(stackStrings);
		
		System.out.println("Original Stack");
		// Use a for-each style loop to print the original Stack
		// This type of loop will work with Java's Stack class since it implements
		// the Iterable interface, although you don't typically iterate over a Stack
		// like this.
		for(String s : stackStrings) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		System.out.println("Copy Stack");
		// Use a for-each style loop to print the copy
		for(String s : copyStack) {
			System.out.print(s + " ");
		}

		System.out.println();

		// Use the reverseCopy method to make a copy of the original Stack in reverse order
		Stack<String> reverseStack = reverseCopy(stackStrings);
		
		System.out.println("Original Stack");
		// Use a for-each style loop to print the original Stack
		for(String s : stackStrings) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		System.out.println("Reverse copy Stack");
		// Use a for-each style loop to print the reverse copy  
		for(String s : reverseStack) {
			System.out.print(s + " ");
		}
		
	}

}