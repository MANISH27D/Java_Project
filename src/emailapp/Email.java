package emailapp;


import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int passwordDefaultLength=16;
    private String department;
    private String companyName = "manishEnterprise";
    private int mailboxCapacity=500;
    private String alternateEmail;
    private String email;

    //constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email created: " + this.firstName + " " + this.lastName);

        //call a method asking for the department - return the department
        this.department = setDepartment();
       //System.out.println("Department: "+this.department);

        //call a method generating random password
        this.password =randomPassword(passwordDefaultLength);
        //System.out.println("Your default password is: "+this.password);

        //combine elements to generate email address
        email = firstName.toLowerCase()+lastName.toLowerCase()+"@"+department+"."+companyName+".com";
        System.out.println("Your auto generated email is: "+email);
    }

    //ask for the department
    private String setDepartment(){
        System.out.println("DEPARTMENT CODES\n1. for sales\n2. for Development\n3. for accounts \n0. none ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice==1) { return "sales"; }
        else if (depChoice==2) { return "dev"; }
        else if (depChoice==3) {return "accounts"; }
        else { return null;}


    }

    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIKJLMNOPQRSTUVWXYZ123456789!@#$%^&*abcdefghijklmnopqrstuvwxyz";
        char[] password = new char[length];
        for (int i=0; i<length;i++){
            int rand = (int) (Math.random()*passwordSet.length());
            password[i] = ((String) passwordSet).charAt(rand);
        }
        return new String(password);
    }

    //set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }


    //set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }


    //change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {return mailboxCapacity;}
    public String getAlternateEmail() {return alternateEmail;}
    public String getPassword(){return password;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  String showInfo(){
        return "DISPLAY NAME: "+firstName+" "+lastName+
                "\nDEPARTMENT IS: "+department+
                "\nEMAIL ADDRESS IS: "+email+
                "\nMAILBOX CAPACITY: "+mailboxCapacity+"mb"
                +"\nDEFAULT PASSWORD IS: "+password;





    }

}
