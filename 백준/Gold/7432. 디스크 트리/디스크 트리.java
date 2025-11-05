import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		TreeMap<String, Node> children = new TreeMap<>();
	}
	
	static class Trie {
		Node root = new Node();

        void insert(String[] disks) {
            Node current = root;
            for (String disk : disks) {
                current.children.putIfAbsent(disk, new Node());
                current = current.children.get(disk);
            }
        }

        void print(Node node, int depth) {
            for (String key : node.children.keySet()) {
                for (int i = 0; i < depth; i++) System.out.print(" ");
                System.out.println(key);
                print(node.children.get(key), depth + 1);
            }
        }
	}
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
        	String[] st = br.readLine().split("\\\\");
            trie.insert(st);
        }
        trie.print(trie.root, 0);
	}
}
