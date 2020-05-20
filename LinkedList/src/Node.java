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
		if(head == null) return null;
		ArrayList<Integer> listOfNumbers = new ArrayList<>();
		Node n = head;
		listOfNumbers.add(n.data);
		while(n.next != null) {
			Node linkToList = n; 
			if(listOfNumbers.contains(n.data)) {
				n = n.next;
			}
			else {
				listOfNumbers.add(n.data);
				linkToList.next = n;
			}
			
			
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
