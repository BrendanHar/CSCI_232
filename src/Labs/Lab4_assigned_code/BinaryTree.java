package Labs.Lab4_assigned_code;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

/**
 *
 * @author yaw
 */
public class BinaryTree {

    private Node root;
    private Node current;

    public BinaryTree(/*int value*/) {
        root = null;
    }

    public void insert(int newValue) {
        if (root == null) {
            root = new Node(newValue);
        } else {
            Node currentNode = root;
            boolean placed = false;
            while (!placed) {
                if (newValue < currentNode.getValue()) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(new Node(newValue));
                        currentNode.getLeft().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(new Node(newValue));
                        currentNode.getRight().setParent(currentNode);
                        placed = true;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }

    public void modify(int oldValue, int newValue) {
        if (root != null) {
            Node currentNode = root;
            boolean found = false;
            while (!found) {
                if (oldValue < currentNode.getValue()) {
                    if (currentNode.getLeft() != null) {
                        currentNode = currentNode.getLeft();
                    } else {
                        System.out.println("Value not in tree.");
                        found = true;
                    }
                } else if (oldValue > currentNode.getValue()) {
                    if (currentNode.getRight() != null) {
                        currentNode = currentNode.getRight();
                    } else {
                        System.out.println("Value not in tree.");
                        found = true;
                    }
                } else {
                    currentNode.setValue(newValue);
                    found = true;
                }
            }
        }
    }

    public ArrayList<Node> getChildren(){
        ArrayList<Node> children = new ArrayList<Node>(2);
        children.add(current.getLeft() );
        children.add(current.getRight());
        return children;
    }

//    public boolean isBST() {
//        ArrayList<Node> log = new ArrayList<>();
//        treeTraverse(root, log);
//        boolean  check = true;
//       while (!current.getLeft().equals(null)){
//           if (current.getValue() < current.getLeft().getValue()){
//               check = false;
//           }
//           else{
//               System.out.println(current.getValue());
//               current = current.getLeft();
//           }
//
//       }
//       while (!current.getRight().equals(null)){
//           if (current.getValue() > current.getRight().getValue()){
//               check = false;
//           }
//           else {
//               System.out.println(current.getValue());
//               current = current.getRight();
//           }
//       }
//       if (current.getRight().equals(null) && current.getLeft().equals(null)){
//           System.out.println("you're fucked");
//       }

//        System.out.println(root.getValue());
//        System.out.println(current.getValue());

//        return true;
//    }

//    private ArrayList<Node> treeTraverse(Node current, ArrayList<Node> log){
//        boolean check = true;
//        while (!current.getLeft().equals(null)){
//           if (current.getValue() < current.getLeft().getValue()){
//               check = false;
//           }
//           else{
//               System.out.println(current.getValue());
//               current = current.getLeft();
//               treeTraverse(current, log);
//           }
//
//       }
//       while (!current.getRight().equals(null)){
//           if (current.getValue() > current.getRight().getValue()){
//               check = false;
//           }
//           else {
//               System.out.println(current.getValue());
//               current = current.getRight();
//               treeTraverse(current, log);
//           }
//       }
//       if (current.getRight().equals(null) && current.getLeft().equals(null)){
//           System.out.println("you're fucked");
//       }
//       return log;
//    }


    public boolean isBST() {
        ArrayList<Node> log = new ArrayList<>();
        ArrayList<Node> children = getChildren();
        for (Node c : children) {
            if (!c.getLeft().equals(null)) {
                System.out.println(c.getValue());
                current = c.getLeft();
                isBST();
//                if (current.getValue() < current.getLeft().getValue()) {
//                    return false;
//                }
//                else {
//                    current = c.getLeft();
//                    isBST();
//                }

            } else if (!c.getRight().equals(null)) {
                System.out.println(c.getValue());
                current = c.getRight();
                isBST();
//                if (c.getValue() > current.getRight().getValue()) {
//                    return false;
//                }
//                else {
//                    current = c.getRight();
//                    isBST();
//                }
            }
            else if (c.getRight().equals(null) && c.getLeft().equals(null)){
                System.out.println("tree is empty");
                return true;
            }
        }


        System.out.println(root.getValue());
        System.out.println(current.getValue());

        return true;
    }

    public void setCurrent() {
        current = root;
    }
}