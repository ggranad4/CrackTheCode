package stackAndQueue;

import java.util.NoSuchElementException;

public class StackWithMin {
	private StackNode top = null;
	private StackNode topOfMin = null;
	private static class StackNode {
		int data;
		StackNode next;
		
		public StackNode(int d){
			data = d;
		}	
		
	}
	
	public void push(int input) {
		
		StackNode node = new StackNode(input);
		min(node);
		node.next = top;
		top = node;
	}
	
	public Integer pop() {
		if(top == null) throw new NoSuchElementException();
		
		if(top.data == topOfMin.data) {
			topOfMin = topOfMin.next;
		}
		
		int output = top.data;
		top = top.next;
		return output;
	}
	
	public Integer peek() {
		if(top == null) throw new NoSuchElementException();

		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	public void min(StackNode min) {
		if(topOfMin == null) {
			topOfMin = min;
		}
		if(topOfMin.data > min.data) {
			StackNode newMin = new StackNode(min.data);
			newMin.next = topOfMin;
			topOfMin = newMin;
		}
	}
	public Integer min() {
		if(topOfMin == null) throw new NoSuchElementException();
		return topOfMin.data;
	}
	
}
