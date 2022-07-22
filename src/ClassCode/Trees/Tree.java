package ClassCode.Trees;
import java.util.ArrayList;

public class Tree {
    private Node root;
    private Node location;

    public Tree(){
        root = new Node("~");
        location = root;
    }

    public Node getLocation() {
        return location;
    }
    public Node getRoot() {
        return root;
    }

    public void setLocation(Node location) {
        this.location = location;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    public String getCurrentLocation(){
        return location.getName();
    }

    public void moveUp(){
        if (location != root) {
            location = location.getParent();
        }
        else{
            System.out.println("You are at the root of the tree");
        }
    }

    public boolean moveDown(String directory){
        ArrayList<Node> children = location.getChild();
        boolean check = false;
        for (Node child: children){
            if (directory.equals(child.getName())){
                location = child;
                return true;
            }
        }
        return false;
    }

    public void goHome(){
        location = root;
    }

    public String getChildren(){
        String files = "";
        ArrayList<Node> children = location.getChild();
        for (Node child :children){
            files += child.getName() + " ";
        }
        return files;
    }

    public boolean insert(String name){
        if (!name.equals(null) && !name.equals("")) {
            Node newNode = new Node(name);
            newNode.setParent(location);
            location.setChild(newNode);
            return true;
        }
        return false;
    }

    public void listFilePath(){
        String locationName;
        while(location.getParent()!= null){
            location = location.getParent();
        }
    }

}
