import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Trie {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("grardo");
		trie.insert("gerad");
		trie.insert("gsraso");
		
		trie.print("gera");
	}
	public class TrieNode {
	    private char c;
	    private HashMap<Character, TrieNode> children = new HashMap<>();
	    public boolean isLeaf;

	    public TrieNode() {}

	    public TrieNode(char c){
	        this.c = c;
	    }

	    public HashMap<Character, TrieNode> getChildren() {
	        return children;
	    }

	    public void setChildren(HashMap<Character, TrieNode> children) {
	        this.children = children;
	    }

	    public boolean isLeaf() {
	        return isLeaf;
	    }

	    public void setLeaf(boolean isLeaf) {
	        this.isLeaf = isLeaf;
	    }
	}
	
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node;
            if(children.containsKey(c)) {
                node = children.get(c);
            } else { 
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.getChildren();

            if(i == word.length() - 1) {
                node.setLeaf(true);
            }
        }
    }

    public boolean search(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode node = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren(); 
            } else { 
                node = null;
                break;
            }
        }

        if(node != null && node.isLeaf()) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public void print(String word) {
    		HashMap<Character, TrieNode> children = root.getChildren();
    		TrieNode node = children.get((word.charAt(0)));

    		for(Character letter: node.children.keySet() ) {
    			System.out.println(word + letter);
    		}
    }
}
	

