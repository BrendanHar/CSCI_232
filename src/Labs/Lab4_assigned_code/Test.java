package Labs.Lab4_assigned_code;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yaw
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(44);
        tree.insert(23);
        tree.insert(74);
        tree.insert(63);
        tree.insert(28);
        tree.insert(55);
        tree.insert(41);
        tree.insert(42);
        tree.insert(90);
        tree.insert(91);
        tree.insert(12);
        tree.insert(10);
        tree.insert(15);
        tree.insert(33);
        tree.setCurrent();
        tree.isBST();
    }
}
