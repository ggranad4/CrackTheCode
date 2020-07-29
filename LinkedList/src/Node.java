import java.util.ArrayList;

public class Node {
	Node next = null;
	int data;
	public Node (int d) {
		data = d;
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next= end;
		end.next = null;
	}
	Node deleteNode(Node head, int d) {
		if(head == null) return null;
		Node n = head;
		
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	Node deleteDuplicates(Node head) {
		if(head == null) head = null;
		ArrayList<Integer> listOfNumbers = new ArrayList<>();
		Node n = head;
		Node previous = null;
		//2-->1-->2-->null
		while(n != null) {
			if(listOfNumbers.contains(n.data) ) {
				n = previous;
				n.next = n.next.next;
			}
			else {
				listOfNumbers.add(n.data);
				previous = n;
			}
			n = n.next;
		}
		return head;
	}
	
	void showList() {
		Node n = this;
		while(n.next != null) {
			System.out.print(n.data + " --> ");
			n = n.next;
		
		}
		System.out.println(n.data);
	}
	
	void kthElementToLast(int findKth) {
		Node n = this;
		while (n.next != null) {
			if(n.data == findKth) {
				System.out.print("Kth Element = ");
				while(n.next.next != null) {
					System.out.print(n.data + " --> ");
					n = n.next;
				}
				System.out.print(n.data + " --> ");
			}
			n = n.next;
			
		}
		System.out.print( n.data );
		
	}
	
	void deleteNode(int deleteNode) {
		Node n = this;
		Node previous = null;
		
		while(n.next != null) {
			
			if(n.data == deleteNode) {
				previous.next = n.next;
				n = previous;
			}
			previous = n;
			n = n.next;
		}
	}
	
	void partition(int integerSetter) {
		Node n = this;
		ArrayList<Integer> listOfIntegersBelow = new ArrayList<>();
		
		ArrayList<Integer> listOfIntegersAbove = new ArrayList<>();
		
		while(n != null) {
			if(integerSetter > n.data) {
				listOfIntegersBelow.add(n.data);
			}
			else {
				listOfIntegersAbove.add(n.data);
			}
			n = n.next;
		}
		for(Integer number: listOfIntegersBelow) {
			System.out.print(number + " --> ");
		}
		System.out.print("        -->         ");
		for(Integer number: listOfIntegersAbove) {
			System.out.print(number + " --> ");
			
		}
		
	}
	
	int addLinkedLists(Node linkedList1, Node linkedList2) throws Exception {
		Node n1 = linkedList1;
		Node n2 = linkedList2;
				
		if(linkedList1 == null || linkedList2 == null) {
			throw new Exception("Cannot have empty linkedList");
		}
		StringBuilder num1 = new StringBuilder();
		StringBuilder num2 = new StringBuilder();
		
		while(n1 != null) {
			num1.append(n1.data);
			n1 = n1.next;
		}
		while(n2 != null) {
			num2.append(n2.data);
			n2 = n2.next;
		}
		
		int numberOne = Integer.valueOf(num1.reverse().toString());
		int numberTwo = Integer.valueOf(num2.reverse().toString());
		
		return numberOne + numberTwo;
		}

	  
	boolean isPalindrome() {
		Node n = this;
		StringBuilder sb = new StringBuilder();
		
		while(n != null) {
			sb.append(n.data);
			n = n.next;
		}
		String normal = sb.toString();
		String reverse = sb.reverse().toString();
		System.out.println(normal + " " + reverse);
		if(normal.equals(reverse)){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
}
