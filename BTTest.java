import java.security.Key;
import java.util.Scanner;

public class BTTest {

    static Scanner scnr = new Scanner(System.in) ;

    public static void main(String[] args) {
        
        BST<Integer , String> cities = new BST<>();
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
                height();
                break;
            case 3: // preorder
                BST.preOrderPrint(cities.getNode());
                break;
            case 4: //inorder
                BST.inOrderPrint(cities.getNode());
                break;
            case 5: //post order
                BST.postOrderPrint(cities.getNode());
                break;
            case 6: //total population
                total();
                break;
            case 7: //city with biggest population
                BSTNode<Integer , String> biggestPop = cities.getMax(cities.getNode());
                System.out.println(biggestPop.toString());
                break;
            case 8: //cities w/ less than 50k
                lessThan50k();
                break;
            case 9: // cities between 50k and 80k population
                between50k80k();
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

        System.out.println("Ending program");

    }


    static void printMenu(){
        System.out.println("1. print number of cities\n2. print out the height of the treen\n" +
            "3. preOrder printout\n4. inorder printout\n5. postorderTraaversal\n6. total population between all cities\n" + 
            "7. City with biggest populaton\n8. cities with less than 50,000\n9. cities with population between 50,000 - 80,000\n" + 
            "10. Update Pasadena and view change"); 
    }
    
    public static void numOfCities(){

    }

    public static void height(){

    }

    public static void preorder(){

    }

    public static void inorder(){

    }

    public static void postorder(){

    }

    public static void total(){

    }

    public static void biggestPop(){

    }

    public static void lessThan50k(){

    }

    public static void between50k80k(){

    }

    public static void updatePas(){

    }
}
