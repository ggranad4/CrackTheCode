import java.util.ArrayList;

public class MyTrie {
	private class Node{
		public char c = ' ';
		public ArrayList<Node> children = new ArrayList<>();
		public boolean isLeaf = false;;
		public Node(char letter) {
			this.c = letter;
		}
		public char getLetter() {
			return this.c;
		}
		
		public void setIsLeaf(boolean t) {
			this.isLeaf = t;
		}
		public boolean getIsLieaf() {
			return this.isLeaf;
		}
	}
	public Node root;
	
	public MyTrie(){
		root = new Node(' ');
	}
	public static void main(String[] args) {
		MyTrie trie = new MyTrie();
		trie.insert("cat");
		System.out.println("next");
		trie.insert("car");
		
		System.out.println(trie.search("cat"));	
	
	}
	
	public void insert(String word) {
		Node node = this.root;
		Node checkNode = node;
		for(Character letter: word.toCharArray()) {
			if(node.children.isEmpty()) {
				node.children.add(new Node(letter));
				node = node.children.get(0);
				
			}else {
				checkNode = hasChild(node, letter);
				
				if(checkNode == null) {
					Node newChild = new Node(letter);
					node.children.add(newChild);
					node = node.children.get(node.children.indexOf(newChild));
				}
				else {
					node = checkNode;
					System.out.println("bam " + node.c);
				}
			}
			
			
			
		}
		
		node.children.add(new Node(' '));
		node.children.get(0).setIsLeaf(true);
	}
	
	public void print(String prefix) {
		Node node = root;
		char letter = ' ';
		boolean found = true;
		ArrayList<String> wordsSuggestions = new ArrayList<>();
		
		for(int i = 0; i < prefix.length(); i++) {
			letter = prefix.charAt(i);
			
			node = hasChild(node, letter);
		
			if(node == null) {
				found = false;
				
				break;
			}
		}
		if(found) {
			for(Node child: node.children) {
				wordsSuggestions.add(prefix + child.getLetter());
			}
			for(String strings: wordsSuggestions) {
				System.out.println(strings);
			}
		}
		
			
		}
	
	public boolean search(String word) {
		Node node = this.root;
		for(Character letter: word.toCharArray()) {
			node = hasChild(node, letter);
			if(node == null) {
				return false;
			}
		}
		return true;
	}
	
	public Node hasChild(Node node, char letter) {
		for(Node child: node.children) {
			if(child.getLetter() == letter) {
				return child;
			}
		}
		return null;
	}
		
}
