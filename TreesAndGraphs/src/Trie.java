import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class Trie {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("carpet ha");
		trie.insert("catless");
		trie.insert("cape");
		trie.insert("cactus");
		
		trie.suggestions("ca");
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
    
    
    public void suggestions(String word) {
    		HashMap<Character, TrieNode> children = root.getChildren();
    		TrieNode node = null;
    		char letter = ' ';
    		for(int i = 0; i < word.length(); i++) {
    			letter = word.charAt(i);
    			if(children.containsKey(letter)) {
    				node = children.get(letter);
    				children = node.getChildren();
    			}
    			else {
    				node = null;
    				break;
    			}
    		}
    		if(node != null) {
    			String s = traverseThrough(node);
    			s = s.replace(",", " ");
    			ArrayList<String> suggestions = new ArrayList<>();
    			String single = "";
    			for(Character letters: s.toCharArray()) {
    				if(letters != ' ') {
    					single = single + "" + letters;
    				}
    				else if(!single.equals("")) {
    					suggestions.add(single);
    					single = "";
    				}
    			}
    			for(String words: suggestions) {
    				System.out.println(word + words);
    			}
    		}
    }
    
    public String traverseThrough(TrieNode node) {
    		StringBuilder sb = new StringBuilder();
    		HashMap<Character,TrieNode> children = node.children;
    		Iterator<Entry<Character, TrieNode>> it = children.entrySet().iterator();
    			while(it.hasNext()) {
    				node = it.next().getValue();
    				sb.append(node.c);
    				sb.append(traverseThrough(node));
    				sb.append(",");
    				
    			}
    			return sb.toString();
    		}
}
	

