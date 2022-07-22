package Labs.Lab2_Solution;

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
    
    public String getPath() {
        Node nodePointer = current;
        String path = "";
        while (nodePointer != root) {
            path = "/" + nodePointer.getName() + path;
            nodePointer = nodePointer.getParent();
        }
        path = nodePointer.getName() + path;
        
        return path;
    }
    
    public boolean moveDown(String path) {
        Node oldCurrent = current;

        String[] files = path.split("/");
        for (String f : files) {
            boolean moved = false;
            ArrayList<Node> children = current.getChildren();
            for (Node c : children) {
                if (f.equals(c.getName())) {
                    current = c;
                    moved = true;
                }
            }
            if (!moved) {
                current = oldCurrent;
                return false;
            }
        }

        return true;
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

    public boolean remove(String directory) {
        if (directory != null) {
            ArrayList<Node> children = current.getChildren();
            for (Node c : children) {
                if (c.getName().equals(directory)) {
                    children.remove(c);
                    return true;
                }
            }
        }
        return false;
    }
}
