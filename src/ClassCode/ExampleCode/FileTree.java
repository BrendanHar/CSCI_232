package ClassCode.ExampleCode;

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
        for (Node c : children) {
            if (directory.equals(c.getName())) {
                current = c;
                return true;
            }
        }
        return false;
    }

//    public void moveUp() {
//        if (current != root) {
//            current = current.getParent();
//        }
//    }

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

//    public boolean insert(String directory) {
//        if (directory != null && !directory.equals(" ")) {
//            Node newFile = new Node(directory);
//            newFile.setParent(current);
//            current.addChild(newFile);
//            return true;
//        }
//        return false;
//    }
}
