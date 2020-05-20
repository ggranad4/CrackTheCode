
public class Driver {
	public static void main(String []args) {
		Node linkedList = new Node(2);
		linkedList.appendToTail(3);
		linkedList.appendToTail(1);
		linkedList.appendToTail(2);
		linkedList.deleteDuplicates(linkedList);
		linkedList.showList();
	}

}
