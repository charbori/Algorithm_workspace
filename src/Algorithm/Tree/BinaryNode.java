package Algorithm.Tree;

public class BinaryNode <T> {
    BinaryNode left_node;
    BinaryNode right_node;
    T value;

    public BinaryNode(T value){
        this.value = value;
    }

    void set_left_node(BinaryNode left_node){
        this.left_node = left_node;
    }

    void set_right_node(BinaryNode right_node){
        this.right_node = right_node;
    }

    BinaryNode get_left_node(){
        return this.left_node;
    }

    BinaryNode get_right_node(){
        return this.right_node;
    }

    public T get_value() {
        return this.value;
    }
}

class BinaryNodeMgr <T>{
    BinaryNode head;

    public BinaryNodeMgr(BinaryNode head){
        this.head = head;
    }

    public void insert(BinaryNode node){

    }

    public void delete(T value){

    }

    public BinaryNode search_node(BinaryNode node, T value){

        if(head == null){
            System.out.println("노드가 없습니다.");
            return null;
        }
        if(node == null){
            return null;
        }
        if(node.value.equals(value)){
            return node;
        }

        BinaryNode<String> temp = search_node(node.left_node, value);

        if(temp != null)
            return temp;
        temp = search_node(node.right_node, value);

        if(temp != null)
            return temp;

        return null;
    }

    public void preorder_traversal(BinaryNode node){

        if(head == null){
            System.out.println("노드가 없습니다.");
        }
        if(node != null){
            if(node.value != null)
                System.out.print(node.value);
            if(node.left_node != null){
                preorder_traversal(node.left_node);
            }
            if(node.right_node != null){
                preorder_traversal(node.right_node);
            }
        }

    }

    public void inorder_traversal(BinaryNode node){

        if(head == null){
            System.out.println("노드가 없습니다.");
        }
        if(node != null){
            if(node.left_node != null){
                inorder_traversal(node.left_node);
            }
            if(node.value != null) {
                System.out.print(node.value);
            }
            if(node.right_node != null){
                inorder_traversal(node.right_node);
            }
        }
    }

    public void postorder_traversal(BinaryNode node){
        if(head == null){
            System.out.println("노드가 없습니다.");
        }
        if(node != null){
            if(node.left_node != null){
                postorder_traversal(node.left_node);
            }
            if(node.right_node != null){
                postorder_traversal(node.right_node);
            }
            if(node.value != null) {
                System.out.print(node.value);
            }
        }

    }
}



























