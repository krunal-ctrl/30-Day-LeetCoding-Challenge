/*
Implement a trie with insert, search, and startsWith methods.

Example:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:
You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/
class Trie {
    static final int SIZE=26;
    static class TrieNode{
        TrieNode[] children=new TrieNode[SIZE];
        boolean isEndOfWord; 
    }
    
    static TrieNode root;
    
    /** Initialize your data structure here. */
    
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    
    public void insert(String word) {
        TrieNode curr=root; 
        int index=0;
        for(char c:word.toCharArray()){
            index=c-'a';   
            if(curr.children[index]==null){ 
               curr.children[index]=new TrieNode();
            }
            curr=curr.children[index];
        }
        curr.isEndOfWord=true;       
    }
    
    /** Returns if the word is in the trie. */
    
    public boolean search(String word) {
        
        TrieNode curr=root;
        int index=0;
        
        for(char c:word.toCharArray()){
            index=c-'a';
            
            if(curr.children[index]==null){
               return false;
            }
            
            curr=curr.children[index];
        }
        
        return curr!=null && curr.isEndOfWord; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    
    public boolean startsWith(String prefix) {
        
        TrieNode curr=root;
        int index=0;
        
        for(char c:prefix.toCharArray()){
            index=c-'a';
            if(curr.children[index]==null){
               return false;
            }
            curr=curr.children[index];
        }
        return curr!=null; 
    }
}
