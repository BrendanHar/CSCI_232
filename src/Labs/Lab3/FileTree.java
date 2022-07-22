package Labs.Lab3;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author yaw
 */
public class FileTree {

    private Node root;
    private Node current;

    public FileTree() {
        root = new Node("~");
        current = root;
    }

    public String getCurrentLocation() {
        return current.getName();
    }
    
    public boolean moveDown(String directory) {
        ArrayList<Node> children = current.getChildren();
        for (Node child : children) {
            if (directory.equals(child.getName())) {
                current = child;
                return true;
            }
        }
        return false;
    }

    public void moveUp() {
        if (current != root) {
            current = current.getParent();
        }
    }

    public void goHome() {
        current = root;
    }

    public String getChildren() {
        String files = new String();
        ArrayList<Node> children = current.getChildren();
        for (Node c : children) {
            files += c.getName() + " ";
        }
        return files;
    }

    public boolean insert(String directory) {
        if (directory != null && !directory.equals(" ")) {
            Node newFile = new Node(directory);
            newFile.setParent(current);
            current.addChild(newFile);
            return true;
        }
        return false;
    }

    public void getPath(){

    }
    
    public void getSubTree() {
        Node tempCurrent = current;
        ArrayList<Node> children = current.getChildren();
        for (Node c : children){
            int count = 0;
            if (c != children.get(children.size()-1)){
                System.out.print("|");
                if (c.getChildren() !=null){
                    System.out.print(("---"  +  c.getName()).indent(count));
                    current = c;
                    getSubTree(count += 4);
                }
            }
            else{
                System.out.print("`");
                if (c.getChildren() !=null){
                    System.out.print(("---"  +  c.getName()).indent(count));
                    current = c;
                    getSubTree(count += 4);
                }
            }

        }
        current = tempCurrent;
    }
    public void getSubTree(int num) {
        ArrayList<Node> children = current.getChildren();
        for (Node c : children){
            int count = num;
            if (c != children.get(children.size()-1)){
                if (c.getChildren() !=null){
                    System.out.print(("|---" +  c.getName()).indent(count));
                    current = c;
                    getSubTree(count += 4);
                }
            }
            else{
                if (c.getChildren() !=null){
                    System.out.print(("`---" +  c.getName()).indent(count));
                    current = c;
                    getSubTree(count += 4);
                }
            }
        }
    }
}
