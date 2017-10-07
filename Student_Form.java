/**HW3
 Question 2 : Student Form
 Implement a form accepting details of student in correct format.
-> this form should be able to include the name,  email, rollnumber, adderess, phone number, marks in HSC and UG base on which
-> calculate whether he/she is eligible for PG admission in National Institute where they give criteria of 60% in HSC and 70% in UG.
-> this form should also be able to handle the mistakes done by students during filling the form. [Throw appropriate exception]
*/
import java.util.InputMismatchException;
import java.util.Scanner;
public class Student_Form 
{
	String name,email,address,RollNo,ph_no;
	boolean value1,value2; ;
	double HsgMarks,Ugmarks;
	final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+com+";
	final static double HSG=100,UG=100;
	
	public static boolean checkblank(String s)
	{
		if(s.length()==0)
			return false;
		else
			return true;
		
	}
	
	static boolean containsNumber(String s)
	{
		int i;
		int l=s.length();
        char[] ch = new char[l];
        ch = s.toCharArray();
        for (i=0; i <l; i++) 
        {
            if ((ch[i] >= 48) && (ch[i] <= 57))
            {
                return true;
            }
        }
        return false;
    }
	public static boolean isfullyNumeric(String s)
	{
		int i;
	int l=s.length();
    char[] ch = new char[l];
    ch = s.toCharArray();
    for (i=0;i<l;i++) 
    {
        if ((ch[i]<48) || (ch[i]>57 ))
        {
            return false;
        }
    }
    return true;
}
	public void getData() throws Exception 
	{
		Scanner sc=new Scanner(System.in);
	System.out.println("Enter your name");	
	try{
		name=sc.nextLine();
	}
	catch(InputMismatchException e)
	{
		System.out.println("Enter the valid name !!");
	}
	value1=containsNumber(name);
	if(!checkblank(name))
	throw new Exception("invalid name: Please Enter a valid name");
	else if(value1==true)
	throw new Exception("invalid name: Numbers are not allowed");
	
	System.out.println("Enter Your email");	
	email=sc.nextLine();	
	if(!checkblank(email))
	throw new Exception("invalid name: Please Enter a valid email");
	else if (!(email.matches(emailPattern)))
	throw new Exception("Please enter a valid email !");
	
	System.out.println("Enter your roll number");	
	RollNo=sc.nextLine();
	if(!checkblank(RollNo))
	throw new Exception("invalid name: Please Enter a valid RollNo");
	value1=isfullyNumeric(RollNo);
	if(!value1)
	throw new Exception("NumberFormatException: Enter a valid  roll number");
	
	System.out.println("Enter your address");	
	address=sc.nextLine();
	if(!checkblank(address))
	throw new Exception("invalid name: Please Enter a valid address");
	
	System.out.println("Enter your phone number");
	ph_no=sc.nextLine();
	if(!checkblank(ph_no))
		throw new Exception("invalid name: Please Enter a valid phone no");		
	value1=isfullyNumeric(ph_no);
	if(ph_no.length()==10)
		value2=true;
		else
			value2=false;
	if(!(value1 && value2))
		throw new Exception("NumberFormatException: Enter a valid number");
	
	System.out.println("Enter your HSG marks");	
	HsgMarks=sc.nextDouble();

	System.out.println("Enter your UG marks");	
	Ugmarks=sc.nextDouble();
	}
	public void check_eligibility()
	{
		if(HsgMarks>=(0.60)*HSG  && Ugmarks>=(0.70)*UG)
			System.out.println(name+" is eligible for National Institute");
		else
			System.out.println(name+" is not eligible for National Institute");
	}
	
public static void main(String args[]) throws Exception
{
	Student_Form sf =new Student_Form();
	sf.getData();
	sf.check_eligibility();
}
}