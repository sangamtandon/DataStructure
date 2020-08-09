package com.data.structures.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	Map<Character, TrieNode> children;
	boolean endOfWord;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		endOfWord = false;
	}
}
