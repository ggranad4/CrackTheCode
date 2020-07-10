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

	
}
