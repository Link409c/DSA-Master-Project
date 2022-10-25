package ManualStack;

import java.util.LinkedList;

public interface ManualStack<E> {
	
	LinkedList<E> getStack();
	
	void setStack(LinkedList<E> aStack);
	
	void push(E e);
	
	E pop();

}