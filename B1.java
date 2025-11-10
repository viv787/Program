import java.util.Scanner;
class B1 {
 
static {
System.loadLibrary("B1");
}
// Native method declarations
private native int add(int a, int b);
private native int sub(int a, int b);
private native int mult(int a, int b);
private native int div(int a, int b);
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int a, b, ch;
B1 obj = new B1();
System.out.print("\nEnter value of a : ");
a = sc.nextInt();
System.out.print("Enter value of b : ");
b = sc.nextInt();
do {
System.out.println("\n--- MENU ---");
System.out.println("1. Add");
System.out.println("2. Subtract");
System.out.println("3. Multiply");
System.out.println("4. Divide");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");
ch = sc.nextInt();
switch(ch) {
case 1: obj.add(a, b); break;
case 2: obj.sub(a, b); break;
case 3: obj.mult(a, b); break;
case 4: obj.div(a, b); break;
case 5: System.out.println("Exiting..."); break;
default: System.out.println("Invalid choice.");
}
} while(ch != 5);
}
}