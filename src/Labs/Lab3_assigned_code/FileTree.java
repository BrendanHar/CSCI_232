package Labs.Lab3_assigned_code;

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
        if (directory != null || !directory.equals(" ")) {
            Node newFile = new Node(directory);
            newFile.setParent(current);
            current.addChild(newFile);
            return true;
        }
        return false;
    }

    public boolean parentEndCheck(){
        Node tempParent = current.getParent();
        Node grandParent = tempParent.getParent();
        ArrayList<Node> children = grandParent.getChildren();
        if (tempParent == children.get(children.size()-1)){
            return true;
        }
        return false;
    }

    public void getSubTree() {
        Node tempCurrent = current;
        ArrayList<Node> children = current.getChildren();
        boolean endCheck;
        for (Node c : children){
            if (c != children.get(children.size()-1)){
                String count = "|";
                if (c.getChildren() !=null){
                    System.out.println((count + "---"  +  c.getName()));
                    current = c;
                    endCheck = false;
                    getSubTree(count += "   |");
                }
            }
            else{
                String count = "";
                System.out.print("`");
                if (c.getChildren() !=null){
                    System.out.println((count + "---"  +  c.getName()));
                    current = c;
                    endCheck = true;
                    getSubTree(count += "   ");
                }
            }

        }
        current = tempCurrent;
    }
    public void getSubTree(String num) {
        ArrayList<Node> children = current.getChildren();
        for (Node c : children){
            String count = num;
            if (c != children.get(children.size()-1)){
                if (c.getChildren() !=null){
                    System.out.println((count + "---" +  c.getName()));
                    current = c;
                    getSubTree(count += "  |");
                }
            }
            else{
                if (c.getChildren() !=null){
                    System.out.println((count + "---" +  c.getName()));
                    current = c;
                    getSubTree(count += "   |");
                }
            }
        }
    }
}
