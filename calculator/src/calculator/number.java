package calculator;
import java.util.Scanner;
public class number {
public static void main (String[]args){
	Scanner Input= new Scanner(System.in);
System.out.println("welcome to the calculator");
System.out.println("enter your first number");
int num1 =Input.nextInt();
System.out.println("enter an operation");
String oper =Input.next();
System.out.println("enter your second number");
int num2 =Input.nextInt();
if(oper.equals("+"))
{
	System.out.println(num1 + num2);
}
}
}

