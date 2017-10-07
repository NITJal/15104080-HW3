/**
 * HW3
 	Question 1 : ATM MACHINE
  Implement an ATM machine including all kind of exceptions (Ex. Insufficient balance).
-> for this purpose make the robust program which handles all kind of data which has been given as input and the exceptions genereated
-> in the backend processing.
 */
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Atm_Machine 
{
private double current_balance=0.0;
private double withdrawl_amount,deposite_amount;
private String Acc_no;
private int Pin;
int c=0,ch;
static double daywithdrawlamt=0.0;
Scanner sc=new Scanner(System.in);
public void getdetail()
{
	try {
		System.out.println("Welcome To Canara Bank ATM !!");
		System.out.println("Enter Account number");
	      Acc_no=sc.nextLine();
	      System.out.println("Enter PIN ");
	      Pin=sc.nextInt();
	      }
	catch(InputMismatchException e)
	{
		System.out.print("\nEnter the valid input");
	}
}
public void showbalance()
{
	System.out.println("Your Current balace is : " +current_balance);
}
public void deposite()
{
	System.out.println("Enter the amount for Deposition");
	try{
		deposite_amount=sc.nextDouble();	
	}
	catch(InputMismatchException e)
	{
		System.out.print("\nEnter the valid input");
	}
	current_balance=current_balance+deposite_amount;
}
public void Withdrawl() throws Exception
{
	System.out.println("Enter the amount you want to withdraw");	
	withdrawl_amount=sc.nextDouble();
	
	if(daywithdrawlamt>25000)
	{
		throw new Exception("\nLimit Over : You can not withdrawl more than 25000 in a day");
	}
	else if(withdrawl_amount>10000)
		throw new Exception("only less than Rupees 10,000 at one transaction");
	else if((current_balance-withdrawl_amount)<0)
		throw new Exception(" \n Sorry !! Not Enough balance");
	else
	{
		current_balance=current_balance-withdrawl_amount;
	daywithdrawlamt=daywithdrawlamt+withdrawl_amount;
}
}
public int getchoice()
{
	System.out.println("1.Balance check");
	System.out.println("2.Deposite ");
	System.out.println("3.Withdrawal");
	System.out.println("4.Exit");
	System.out.println("Enter your choice");
	ch=sc.nextInt();
	return ch;
	
}

public static void main(String args[])throws Exception{
	Scanner sc=new Scanner(System.in);
Map<String,Integer> hmap =new HashMap<String,Integer>(); 
hmap.put("123456789",1234);
hmap.put("234567891",5678);
hmap.put("345678912",9123);
hmap.put("456789123",4567);
hmap.put("567891234",8912);
hmap.put("678912345",3456);
hmap.put("789123456",7891);
Atm_Machine am=new Atm_Machine();
am.getdetail();

try{
	for(Map.Entry<String,Integer> val : hmap.entrySet())
	{
	if(( am.Acc_no.equals(val.getKey())) && (am.Pin==val.getValue()))
	{
		am.c=1;
	}
	}
	 if(am.c==1)
	{
		int choice=0;
	while(true){
		
		choice= am.getchoice();
	switch(choice)
	{
	case 1:
		am.showbalance();
		break;
	case 2:
		am.deposite();
		break;
	case 3:
		am.Withdrawl();
		break;
	default :
		System.out.println("Thank You For Visiting Canara Bank !");
		System.exit(1);
		break;
	}
	}
	}
	 }
	catch(NullPointerException e)
	{
		System.out.print("\n No operation is performed with null string");
	}
	catch(InputMismatchException e)
	{
		System.out.print("\nEnter the valid input");
	}
	catch(NoSuchElementException e)
	{
		System.out.print("\nElement not found");
	}
	if(am.c==0)
		throw new Exception ("SORRY !! INVALID PIN NUMBER ");


}}
