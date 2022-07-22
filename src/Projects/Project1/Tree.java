package Projects.Project1;

import java.util.Scanner;

public class Tree {

    private Node root;
    private Node current;

    public  Tree() {
        root = new Node("dog", "furry");
        root.addRightChild("Snake", "Scaly");
        current = root;
    }

    public String getCurrentLocation() {
        return current.getAnimal();
    }

    public void treeExplore(){
        String command = "";
        String animal;
        String characteristic;d
        Scanner input = new Scanner(System.in);
        boolean check = false;

        while (check != true){
            System.out.print("Is this Animal " + current.getCharacteristic() +"? ");
            command = input.nextLine();
            //Answered yes to get the next characteristic or the last animal with that characteristic
            if(command.equals("Y") || command.equals("y")){
                //if you are at leaf node- check what animal has characteristics
                if (current.getLeftChild().equals(null)){
                    System.out.println("Is this animal a " + current.getAnimal() + "? ");
                    //Guessed the correct animal
                    if(command.equals("Y") || command.equals("y")){
                        System.out.println("Good.");
                        check = true;
                    }
                    //adding unknown animal to the tree after failing to find
                    else if (command.equals("N") || command.equals("n")){
                        System.out.println("I don't know any " + current.getCharacteristic() + " that aren't a " + current.getAnimal() + ".");
                        System.out.print("What is the new animal? > ");
                        animal = input.nextLine();
                        System.out.print("What characteristic does a" + animal + " have that a " + current.getAnimal() + " does not? > ");
                        characteristic = input.nextLine();
                        current.addLeftChild(animal, characteristic);
                        System.out.println();
                        check = true;
                    }
                    else {
                        System.out.println("Invalid Command. please try again.");
                    }
                }
            }
            //if the animal does not have the characteristic
            else if (command.equals("N") || command.equals("n")){
                //if you are at the leaf node
                if (current.getRightChild().equals(null)){
                    //check the current animal
                    System.out.println("Is the animal a " + current.getAnimal() + "? ");
                    command = input.nextLine();
                    //found the animal that user was looking for
                    if(command == "Y" || command == "y"){
                        System.out.println("Good.");
                        check = true;
                    }
                    //wasn't able to find the animal in the tree
                    else if (command == "N" || command == "n"){
                        System.out.println("I don't know any non-" + current.getCharacteristic() + " animals.");
                        System.out.print("What is the new animal? > ");
                        animal = input.nextLine();
                        System.out.print("What characteristic does a" + animal + " have that a " + current.getAnimal() + " does not? > ");
                        characteristic = input.nextLine();
                        current.addRightChild(animal, characteristic);
                        System.out.println();
                        check = true;
                    }
                    else {
                        System.out.println("Invalid Command. please try again.");
                    }
                }

            }
            else {
                System.out.println("Invalid Command. please try again.");
            }
        }

    }

}
