import java.util.*;
import java.io.*;
import java.io.*;

public class Main {
	
	static class Node {
		Map<Character, Node> children = new HashMap<>();
		List<Integer> wordIndices = new ArrayList<>();
	}

	static class Trie {
		Node root = new Node();
		
		public void insert(String word, int idx) {
			Node node = root;
			for (char c : word.toCharArray()) {
				node.wordIndices.add(idx);
				node = node.children.computeIfAbsent(c,  k -> new Node());
			}
			node.wordIndices.add(idx);
		}
		
		public void find (Node node, int depth, String path) {
			
			if (node.wordIndices.size() >= 2) {
				int idx1 = node.wordIndices.get(0);
				int idx2 = node.wordIndices.get(1);
				if (depth > maxDepth) {
					maxDepth = depth;
					pair = new int[] {idx1, idx2};
				} else if (depth == maxDepth) {
					int cur1 = pair[0];
					int cur2 = pair[1];
					if (idx1 < idx2 || (cur1 == idx1 && idx2 < cur2)) {
						pair = new int[] {idx1, idx2};
					}
				}
			}
			
			for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
				find(entry.getValue(), depth + 1, path + entry.getKey());
			}
		}
		
	}
	
	static int maxDepth = 0;
	static int[] pair = new int[2];
	static int N;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		Trie trie = new Trie();
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
			trie.insert(words[i], i);
		}
		
		trie.find(trie.root, 0, "");
		
		System.out.println(words[pair[0]]);
		System.out.println(words[pair[1]]);
		
	}
}
