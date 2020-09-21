package Algorithm.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TreeCirculation {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int data_size = Integer.parseInt(st.nextToken());

        int idx = 0;

        BinaryNode<String> head_node = new BinaryNode<>("A");
        BinaryNodeMgr<String> node_mgr = new BinaryNodeMgr<>(head_node);

        while(idx < data_size)
        {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens())
            {
                String str = st.nextToken();
                BinaryNode<String> node = node_mgr.search_node(head_node, str);

                str = st.nextToken();
                if(!str.equals("."))
                    node.left_node = new BinaryNode<String>(str);

                str = st.nextToken();
                if(!str.equals("."))
                    node.right_node = new BinaryNode<String>(str);
            }

            idx++;
        }

        node_mgr.preorder_traversal(head_node);
        System.out.println();
        node_mgr.inorder_traversal(head_node);
        System.out.println();
        node_mgr.postorder_traversal(head_node);
    }
}
