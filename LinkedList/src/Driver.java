
public class Driver {
	public static void main(String []args) {
		Node linkedList = new Node(2);
		linkedList.appendToTail(1);
		linkedList.appendToTail(1);
		linkedList.appendToTail(1);
		linkedList.appendToTail(3);
		linkedList.appendToTail(4);
		linkedList.appendToTail(4);
		linkedList.appendToTail(111);
		linkedList.appendToTail(111);
		linkedList.appendToTail(10);
		linkedList.appendToTail(10);
		
		linkedList = linkedList.deleteDuplicates(linkedList);
		
		linkedList.showList();
		
	}

}
