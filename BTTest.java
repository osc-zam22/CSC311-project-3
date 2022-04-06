
import java.util.Scanner;

public class BTTest {

    static Scanner scnr = new Scanner(System.in) ;

    public static void main(String[] args) {
        
        BST<Integer , String> cities = new BST<Integer , String>(); 

        cities.insert(15000 , "Carson"); 
        cities.insert(50000 , "Long Beach");
        cities.insert(38000, "Inglewood");
        cities.insert(50000 , "Torrence" ) ; 
        cities.insert(28000 , "Pasadena");
        cities.insert(78000 , "Lakewood");    

        System.out.println(cities.toString());

        int mainMenuChoice;
        do{

        System.out.println("\n\n---------------------------\n\n");
            printMenu();
            System.out.println("Please enter a choice");
            mainMenuChoice = scnr.nextInt();
            switch(mainMenuChoice)
            {
                case 1: //number of cities
                    System.out.printf("Number of Cities : %d" , cities.nodecount);
                    break;
                case 2: //height of tree
                    System.out.print(cities.treeHeight(cities.getNode()));
                    break;
                case 3: // preorder
                    cities.preOrderPrint(cities.getNode());
                    break;
                case 4: //inorder
                    cities.inOrderPrint(cities.getNode());
                    break;
                case 5: //post order
                cities.postOrderPrint(cities.getNode());
                    break;
                case 6: //total population
                    System.out.println(cities.addBT(cities.getNode()));
                    break;
                case 7: //city with biggest population
                    BSTNode<Integer , String> biggestPop = cities.getMax(cities.getNode());
                    System.out.println(biggestPop.toString());
                    break;
                case 8: //cities w/ less than 50k
                    cities.binarySearchBelowThreshold(cities.getNode(), 50000);
                    break;
                case 9: // cities between 50k and 80k population
                    cities.betweenThreshold(cities.getNode(), 50000, 80000);
                    break;
                case 10: //update pasdena
                    updatePas();
                    break;
                case 11:
                    break;
                default :
                    System.out.println("invalid input");
            }


        }while(mainMenuChoice != 11);

        System.out.println("Ending program\n------------\n--------------\n\nBonus in class problem, manually recreate tree from the example given,"
                + " will print in preorder");

        //bonus extra credit to make tree look like the one in the paper manually
        // it is printed in preorder
        BST<Integer , String> bonusCities = new BST<>();
        bonusCities.insert(15000, "Carson");
        bonusCities.getNode().setLeft(new BSTNode<Integer , String>(50000 , "Long Beach"));
        bonusCities.getNode().left().setLeft(new BSTNode<Integer , String>(38000 , "Inglewood"));
        bonusCities.getNode().left().setRight(new BSTNode<Integer , String>(50000 , "Torrance"));
        bonusCities.getNode().left().right().setLeft(new BSTNode<Integer , String>(28000 , "Pasadena"));
        bonusCities.getNode().setRight(new BSTNode<Integer , String>(78000 , "Lakewood" ));

        bonusCities.preOrderPrint(bonusCities.getNode());

    }


    static void printMenu(){
        System.out.println("1. print number of cities\n2. print out the height of the treen\n" +
            "3. preOrder printout\n4. inorder printout\n5. postorderTraaversal\n6. total population between all cities\n" + 
            "7. City with biggest populaton\n8. cities with less than 50,000\n9. cities with population between 50,000 - 80,000\n" + 
            "10. Update Pasadena and view change"); 
    }
    
    public static void lessThan50k(){

    }

    public static void between50k80k(){

    }

    public static void updatePas(){

    }
}
