package Projects.Project1;


import java.util.Locale;
import java.util.Scanner;

public class TreeManager {

    private Tree tree;

    public TreeManager() {
        tree = new Tree();
    }

    public void run(){
        String command = "";
        Scanner input = new Scanner(System.in);
        boolean check = false;
        tree.treeExplore();
//        while (check != true){
//            System.out.print("Do you have another animal to identify?(Y/N) ");
//            command = input.nextLine();
//            if (command.equals("Y")){
//                System.out.println("Good its working now enter again");
//            }
//            else if (command.equals("y")){
//                System.out.println("Good its working now enter again");
//            }
//            else if (command.equals("N")){
//                check = true;
//            }
//            else if (command.equals("n")){
//                check = true;
//            }
//            else {
//                System.out.println("not a valid command. Try again");
//            }
//        }
    }


}
