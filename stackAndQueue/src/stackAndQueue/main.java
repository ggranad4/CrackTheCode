package stackAndQueue;

public class main {
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(11);
		stack.push(1);
		stack.push(109);
		stack.push(-11);
		stack.push(12);
		stack.push(0);
		
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.min());
		
		

	}
}
