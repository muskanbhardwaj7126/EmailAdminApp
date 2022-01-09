package emailApp;

import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to the company! \nPlease enter your first name");
        String fname = s.next();
        System.out.println("Please enter your last name");
        String lname = s.next();

        Email email = new Email(fname, lname);

        int choice;

        do{
            System.out.println("Enter your choice : \n1. Show information \n2. Change password \n3. Set alternate email");
            System.out.println("4. Set mailbox capacity \n5. Store information in the file ");
            System.out.println("6. Display information from the file \n7. Exit the application");
            choice = s.nextInt();
            switch(choice){
                case 1 : {
                    email.getInfo();
                    break;
                }
                case 2 : {
                    email.changePassword();
                    break;
                }
                case 3 : {
                    email.setAlternateEmail();
                    break;
                }
                case 4 : {
                    email.setMailboxCapacity();
                    break;
                }
                case 5 : {
                    email.storeInFile();
                    break;
                }
                case 6 : {
                    email.readFromFile();
                    break;
                }
                case 7 : {
                    System.out.println("Thank for using the application! \nHoping you had a good experience!");
                    break;
                }
                default : {
                    System.out.println("Invalid choice! Please try again");
                    break;
                }
            }
            System.out.println("----------------------------------------------------");
        }while(choice != 7);

    }
}
