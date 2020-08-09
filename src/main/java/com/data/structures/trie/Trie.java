package com.data.structures.trie;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.endOfWord;
	}

	public boolean searchWith(String prefix) {
		TrieNode current = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return true;
	}

	public static void main(String[] s) {
		Trie t = new Trie();
		t.insert("This");
		System.out.println(t.search("This"));
		System.out.println(t.searchWith("Th"));
	}
}
