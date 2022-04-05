import java.util.Scanner;

public class BTTest {

    static Scanner scnr = new Scanner(System.in) ;

    public static void main(String[] args) {
        
        int mainMenuChoice;
        do{

        System.out.println("\n\n---------------------------\n\n");
            printMenu();
            System.out.println("Please enter a choice");
            mainMenuChoice = scnr.nextInt();


        }while(mainMenuChoice != 11);

        System.out.println("Ending program");

    }


    static void printMenu(){
        System.out.println("1. print number of cities\n2. print out the height of the treen\n" +
            "3. preOrder printout\n4. inorder printout\n5. postorderTraaversal\n6. total population between all cities\n" + 
            "7. City with biggerst populaton\n8. cities with less than 50,000\n9. cities with population between 50,000 - 80,000\n" + 
            "10. Update Pasadena and view change"); 
    }
    
}


