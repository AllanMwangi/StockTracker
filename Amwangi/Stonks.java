package Amwangi;

import java.util.Stack;

public class Stonks <T>implements Stonks_Interface<T> {

	Stack<T> theStack;
	
	
	//constructor
	public Stonks() 
	{
		theStack= new Stack<T>();
	}
	
	@Override
	public void push(T newEntry) {


		theStack.push(newEntry);
		
	}

	@Override
	public T pop() {
		return theStack.pop();
		
	}

	@Override
	public T peek() {
		return theStack.peek();
		
	}

	@Override
	public boolean isEmpty() {


		return theStack.empty();
		
	}

	@Override
	public void clear() {


		theStack.clear();
	}
	
}