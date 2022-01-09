package emailApp;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Email {
    public Scanner s = new Scanner(System.in);   // global - can be used all over the project

    // attributes using which we would be creating an email for the user
    private String fName;               // first name given by user
    private String lName;               // last name given by user
    private String dept;                // department in which he/she is working
    private String email;               // final email address
    private String company;             // company name
    private String password;            // password of the email
    private int mailCapacity = 500;     // initially mail capacity is set to be 500mb
    private String alterEmail;          // alternate mail address

    //constructor
    public Email(String fName, String lName){
        this.company = "company";       // dummy initialization for the project
        this.fName = fName;
        this.lName = lName;

        System.out.println("New Employee - " + this.fName + " " + this.lName);
        System.out.println("----------------------------------------------------");

        this.dept = this.setDept();
        this.password = this.genPassword(6); //initially a random password is generated of length 6
        this.email = this.generateEmail();

    }

    // method to generate final email address
    private String generateEmail(){
        return this.fName.toLowerCase() + "." + this.lName.toLowerCase() + "@" + this.dept + "." + this.company + ".in";
    }

    // method to select department
    private String setDept(){
        System.out.println("Choose from department codes : \n1. Sales \n2. Development \n3. Accounting \n4. Other");

        int code = s.nextInt();

        if(code == 1){
            return "Sales";
        }else if(code == 2){
            return "Development";
        }else if(code == 3){
            return "Accounting";
        }else if(code == 4){
            return "Other";
        }else{
            System.out.println("Error : Invalid code!");
            return null;
        }
    }

    /*
    method to generate random password
    arguments - length for the password
    returns generated password
     */
    private String genPassword(int length){

        String capitalChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChar = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChar = "!@#$%^&*?/";

        // password can be combination (of length given in argument) of any character from values
        String values = capitalChar + smallChar + numbers + specialChar;

        String password = "";
        Random r = new Random();

        //password would be generated from random characters in the values
        // r.nextInt(int bound) generates random number from 0 to bound-1
        for(int i = 0; i < length; i++){
            password += values.charAt(r.nextInt(values.length()));
        }

        return password;
    }

    // method to change password
    protected void changePassword(){

        System.out.println("Do you want to update your password? (Y/N) ");
        char choice = s.next().charAt(0);

        if(choice == 'y' || choice == 'Y'){
            System.out.println("Enter the current password");
            String curPassword = s.next();
            if(curPassword.equals(this.getPassword())){
                System.out.println("Enter new password");
                String newPassword = s.next();
                this.setPassword(newPassword);
                System.out.println("Password changed successfully!");
            }
        }else if(choice == 'n' || choice == 'N'){
            System.out.println("Password not changed!");
        }else{
            System.out.println("Not a valid choice! \nPassword not changed!");
        }
    }

    private void setPassword(String password){
        this.password = password;
    }

    private String getPassword(){
        return this.password;
    }

    // method to set mailbox capacity by user
    public void setMailboxCapacity(){
        System.out.println("Current Mailbox capacity : " + this.mailCapacity + "mb");
        System.out.println("Enter new Mailbox capacity.");
        int cap = s.nextInt();
        this.mailCapacity = cap;
        System.out.println("Mailbox capacity changed successfully!");
    }

    //method to set alternate email

    public void setAlternateEmail(){
        System.out.println("Enter the alternate email address");
        String altEmail = s.next();
        this.alterEmail = altEmail;
        System.out.println("Alternate email set successfully!");
    }

    // method to display user information
    public void getInfo(){
        System.out.println("Name : " + this.fName + " " + this.lName);
        System.out.println("Department : " + this.dept);
        System.out.println("Email : " + this.email);
        System.out.println("Password : " + this.password);  //for testing purpose only (else remove this password)
        System.out.println("Alternate email : " + this.alterEmail);
        System.out.println("Mailbox capacity : " + this.mailCapacity + "mb");
    }

    // storing in file
    //this is acting as a database
    public void storeInFile(){
        try{
            FileWriter in = new FileWriter("file.txt"); //if in project just the name works, else mention the path in the computer
            in.write("First Name : " + this.fName);
            in.append("\nLast Name : " + this.lName);
            in.append("\nDepartment : " + this.dept);
            in.append("\nEmail : " + this.email);
            in.append("\nPassword : " + this.password);
            in.append("\nMailbox capacity : " + this.mailCapacity);
            in.append("\nAlternate Email : " + this.alterEmail);
            in.close();
            System.out.println("Data stored successfully in file!");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //reading data from file

    public void readFromFile(){
        try{
            FileReader out = new FileReader("file.txt");
            int i;
            while((i=out.read()) != -1){
                System.out.print((char)i);   //printing the char value of i
            }
            out.close();

            System.out.println("\n----------------------------------------------------");
        }catch(Exception e){
            System.out.println(e);
        }
    }



}
