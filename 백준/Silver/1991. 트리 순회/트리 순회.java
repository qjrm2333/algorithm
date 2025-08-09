import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        char value;
        Node left = null;
        Node right = null;

        Node(char value){
            this.value = value;
        }

        void setLeft(Node left){
            this.left = left;
        }

        void setRight(Node right){
            this.right = right;
        }
    }

    static int N, M;
    static Node[] tree;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new Node[26];
        for(int i = 0; i<N; i++){
            tree[i] = new Node((char) ('A'+i));
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            Character val = st.nextToken().charAt(0);
            Character left = st.nextToken().charAt(0);
            Character right = st.nextToken().charAt(0);

            if(left != '.') {
                tree[val - 'A'].setLeft(tree[left-'A']);
            }
            if(right != '.'){
                tree[val - 'A'].setRight(tree[right-'A']);
            }
        }

        pre(tree[0]);
        bw.write("\n");

        mid(tree[0]);
        bw.write("\n");

        post(tree[0]);
        bw.write("\n");

        bw.flush();
    }

    static void pre(Node node) throws IOException{
        bw.write(node.value+"");

        if(node.left != null) {
            pre(node.left);
        }
        if(node.right != null) {
            pre(node.right);
        }
    }

    static void mid(Node node) throws IOException{
        if(node.left != null) {
            mid(node.left);
        }

        bw.write(node.value+"");

        if(node.right != null) {
            mid(node.right);
        }
    }

    static void post(Node node) throws IOException{
        if(node.left != null) {
            post(node.left);
        }
        if(node.right != null) {
            post(node.right);
        }

        bw.write(node.value+"");
    }
}
