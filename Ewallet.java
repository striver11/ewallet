import java.util.Scanner;
import java.util.Random;        
public class Ewallet

{
        static int count=1;
        private String userName="1";
        private String password="1";
        private static double amount=0.0;
    static
    {
        System.out.println("----------------Welcome to Ewallet------------------");
        System.out.println("---------Best money management appilication---------");
    }

    public static void main(String[] args) {
        login();
    }
    public static void addAmount()
    {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter amount to add into your account : ");
        double enterdAmount=scan.nextDouble();
        amount+=enterdAmount;
        System.out.println("Press '1' for purchase \n Press '2' for recharge \n Press '3' for balance");
        
        int enteredNumber=scan.nextInt();
        switch (enteredNumber){
            case 1:purchase();
            break;
            case 2:recharge();
            break;
            case 3:balance();
            break;
            default: System.out.println("invalid input please try again");
             }
             
        
    }

        


    
      public static void purchase()
    {   
        int otpCount=0;
         Scanner scan=new Scanner(System.in);
        System.out.print("Enter the amount to purchase : ");
        double enterdAmount=scan.nextDouble();
        Random random = new Random();
         int randomNumber = random.nextInt(10000) + 1;
         System.out.println(" OTP : " + randomNumber);
        while(otpCount<=2)
        {
          System.out.print("Enter OTP : ");
          int otpEnteredByUser=scan.nextInt();

         if(otpEnteredByUser==randomNumber)
         {
            if(enterdAmount<=amount)
                 {
                    amount=amount-enterdAmount;
                    System.out.println("Purchase done successfully");
                     System.out.println("Press 'y' Purchase again 'n' to exit :");
                      char purchaseAgainYesNo=scan.next().charAt(0);
                if(purchaseAgainYesNo=='y')
                {
                    purchase();
                }
                else if(purchaseAgainYesNo=='n')
                {
                    login();
                }
                else
                {
                    System.out.println("Invalid Input");
                }
                    
                 }
            else if(enterdAmount>amount)
            {
                System.out.println("Insufficiant Balance");
                System.out.print("Press 'y' Recharge 'n' to exit :");
                char rechargeYesNo=scan.next().charAt(0);
                if(rechargeYesNo=='y')
                {
                    recharge();
                }
                else if(rechargeYesNo=='n')
                {
                    login();
                }
                else
                {
                    System.out.println("Invalid Input");
                }
                
            }
            break;
         }
         else
         {
            System.out.println("Invalid OTP, Please try again.");

         }
         otpCount++;
        }


        if(otpCount==3)
        {
            System.out.println("TOO MANY ATTEMPTS ACCOUNT BLOCKED");
             System.out.println("You have entered OTP wrong too many times, So your account is blocked please contact our help desk ");
            System.out.println("Phone Number: 9456538451");
            System.out.println("Email id   : Ewallet@gmai.com");
            login();
        }

          System.out.print("Do you want to check the balance press '1' for 'yes' and '0' for 'no' ");
         int enteredNum=scan.nextInt();

         if(enteredNum==1)
         {
            balance();

         }
         else if(enteredNum==0)
         {
            login();
         }
         else
         {
             System.out.println("Invlaid input please try again");
         }
         

    }
      public static void recharge()
    {
          Scanner scan=new Scanner(System.in);
        System.out.print("Enter the amount to recharge : ");
        double amtToRechage = scan.nextDouble();
        amount=amount+amtToRechage;
        System.out.println("Recharge Done Successfully");
         System.out.println("if you want to continue any on going purchase press 'y' else 'n' ");
         char purchaseYesNo=scan.next().charAt(0);
                if(purchaseYesNo=='y')
                {
                    purchase();
                }
                else if(purchaseYesNo=='n')
                {
                    login();
                }
                else
                {
                    System.out.println("Invalid Input");
                }
         System.out.print("Do you want to check the balance press '1' for 'yes' and '0' for 'no' ");
         int enteredNum=scan.nextInt();

         if(enteredNum==1)
         {
            balance();

         }
         else if(enteredNum==0)
         {
            login();
         }
         else
         {
             System.out.println("Invlaid input please try again");
         }
    }
      public static void balance()
    {
        System.out.println(amount);
    }
    public static void login()
    {    
        Ewallet ob=new Ewallet();
        Scanner sc= new Scanner (System.in);
        System.out.print("Please Enter your User Name: ");
        String enterdUserName=sc.nextLine();
        System.out.print("Please Enter your Password :");
        String enterdPassword=sc.next();
        if((enterdUserName).equals(ob.userName) && ((enterdPassword).equals(ob.password)))
        {
            System.out.println("Press '1' for Add Amount ");
            
            int enteredNumber=sc.nextInt();
           

            switch (enteredNumber) {
                case 1:addAmount();
                break;
                default:System.out.println("Invalid input please try again");
                    
            }
        
        }
        else if(count<=2)
        {
            System.out.println("Invalid User Name or Password please enter again");
            count++;
            System.out.println("You have "+(4-count)+" more left");
            login();
        }
        else
        {
            System.out.println("You have entered your password or User Name wrong too many times, So your account is blocked please contact our help desk ");
            System.out.println("Phone Number: 9456538451");
            System.out.println("Email id   : Ewallet@gmai.com");
            
           
        }
        
        

        
    }
}
