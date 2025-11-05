import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		TreeMap<String, Node> children = new TreeMap<>();
	}
	
	static class Trie {
		Node root = new Node();

        void insert(String[] foods) {
            Node current = root;
            for (String food : foods) {
                current.children.putIfAbsent(food, new Node());
                current = current.children.get(food);
            }
        }

        void print(Node node, int depth) {
            for (String key : node.children.keySet()) {
                for (int i = 0; i < depth; i++) System.out.print("--");
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] foods = new String[K];
            for (int j = 0; j < K; j++) foods[j] = st.nextToken();
            trie.insert(foods);
        }

        trie.print(trie.root, 0);
	}
	
}
