package ClassCode.Trees;
import java.util.ArrayList;


public class Node {
    private Node parent;
    private ArrayList<Node> child;
    private String name;

    public Node(String name){
        this.name = name;
    }
    //code needed
    //getchildren()
    //getparent() --- to make these mehtods more secure you could make a copy of the arraylist that is what you then return instead
    //              of returning the orignal arraylist, to prevent someone from editing a private field
    //addChild()


    public ArrayList<Node> getChild() {
        return child;
    }
    public Node getParent() {
        return parent;
    }
    public String getName() {
        return name;
    }

    public void setChild(Node child) {
        this.child.add(child);
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public void setName(String name) {
        this.name = name;
    }
}
