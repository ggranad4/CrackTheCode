import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	public static void main(String[] args) throws Exception {
		Tree tree = new Tree();
		Node root = null;
		root = tree.insert(root, 3);
		tree.insert(root, 2);
		tree.insert(root, 22);
		tree.insert(root, 33);
		tree.insert(root, 21);
		tree.insert(root, 222);
		tree.insert(root, 44);
		tree.insert(root, 108);
		tree.insert(root, 110);

		tree.breadthFirstSearch();
		System.out.println();
		
		tree.depthFirstSearch();
		
	
	}
	public class Node{
		
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
		
	}
	public Node root;
	public int size = 0;
	
	public int getSize() {
		return this.size;
	}
	public Node insert(Node node, int data) {
		if(this.root == null) {
			this.root = new Node(data);
			this.size +=1;
			return root;
		}
		
		if(node == null) {
			size +=1;
			return new Node(data);
		}
		
		if(node.data > data) {
			node.left = insert(node.left, data);
		}
		
		else if(node.data < data) {
			node.right = insert(node.right, data);	
		}
		
		return node;
	}
	
	public boolean contains(int data) throws Exception {
		if(root == null) throw new Exception("root empty");
		Node curr = root;
		
		while(curr != null) {
			
		if(curr.data == data) {
				return true;
		}
		
		if(curr.data > data) {
			
			curr = curr.left;
		}
		else if(curr.data < data){
			curr = curr.right;
			}
		}
		return false;
		
	}

	public void breadthFirstSearch() {
	    if (root == null) return;
	    
	 
	    Queue<Node> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) {
	        Node node = nodes.remove();
	        System.out.print(" " + node.data);
	        
	        if (node.left != null) {
	            nodes.add(node.left);
	        }
	 
	        if (node.right != null) {
	            nodes.add(node.right);
	        }
	    }
	}
	
	public void depthFirstSearch() {
		if(root == null) return;
		
		Node node = this.root;
		Boolean leftNull = false;
		
		Stack<Integer> nodeWithNoLeftRight = new Stack<>();
		Queue<Integer> queueOfVisted = new LinkedList<>();
		queueOfVisted.add(node.data);
		
		while(node != null) {
			
			if(node.left != null && !nodeWithNoLeftRight.contains(node.left.data)) {
				queueOfVisted.add(node.data);
				node = node.left;
				leftNull = true;
			
			}
			
			else if (node.right != null && !nodeWithNoLeftRight.contains(node.right.data) && !leftNull) {
				queueOfVisted.add(node.data);
				node = node.right;
				leftNull = false;
				
			}
			
			else if(node.right == null && node.left == null) {
				if(queueOfVisted.size() + nodeWithNoLeftRight.size() == this.size) {
					node = null;
				}
				else {
					leftNull = false;
					nodeWithNoLeftRight.push(node.data);
					queueOfVisted.clear();
					node = this.root;
					queueOfVisted.add(node.data);
				}
				
			}
			
			
		}
		
		
		while(!queueOfVisted.isEmpty()) {
			System.out.print(queueOfVisted.remove() + " ");
		}
		while(!nodeWithNoLeftRight.isEmpty()) {
			System.out.print(nodeWithNoLeftRight.pop() + " ");
		}
		
		
	}
	
}
