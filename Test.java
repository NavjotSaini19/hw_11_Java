/*
 * This program implements the concept of
 * serialization. It created an object and allows
 * the used to write to file or read from file 
 * some data including name, dob, phone nmber and email.
 * 
 * Author: Navjot Saini
 * Assignment: Hw 11
 */
package proj_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Person implements Serializable {
	String name;
	String phone_Number;
	String dob;
	String email;

	

	public Person(String name, String phone_Number, String dob, String email) {
		super();
		this.name = name;
		this.phone_Number = phone_Number;
		this.dob = dob;
		this.email = email;
	}



	@Override
	public String toString() {
		return "[name=" + name + ", phone number=" + phone_Number + ", dob=" + dob + ", email=" + email
				+ "]";
	}
	
}


public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("1) Add information into a file");
		System.out.println("2) Retrieve information from a file and display them.");
		System.out.println("3) Delete information. ");
		System.out.println("4) Update information.");
		System.out.println("5) Exit.");
		System.out.print("Enter menu option <1/4>:");
		
		Scanner sc= new Scanner(System.in);
		int option = sc.nextInt();

		if (option ==1 ) {
			try {
				System.out.print("Enter name:");
				sc.nextLine();
				String name = sc.nextLine();
				
				System.out.print("Enter phone number:");
				String num = sc.nextLine();
				
				System.out.print("Enter dob:");
				String dob = sc.nextLine();
				
				System.out.print("Enter email:");
				String email = sc.nextLine();
				
				Person mike = new Person(name, num, dob, email);

				writeToFile(mike);

			} catch (IOException e) {
				System.out.println(e.getMessage());
		    }
		}
		else if (option == 2) {
			try {
				readFile();
				} catch (IOException e) {
					System.out.println(e.getMessage());
			}
		}
		else if(option == 3) {
			try {
				Person mike = new Person("", "", "", "");

				writeToFile(mike);
				} catch (IOException e) {
					System.out.println(e.getMessage());
			}
		}
		if (option == 4) {
			try {
				System.out.print("Enter name:");
				sc.nextLine();
				String name = sc.nextLine();
				
				System.out.print("Enter phone number:");
				String num = sc.nextLine();
				
				System.out.print("Enter dob:");
				String dob = sc.nextLine();
				
				System.out.print("Enter email:");
				String email = sc.nextLine();
				
				Person mike = new Person(name, num, dob, email);

				writeToFile(mike);

			} catch (IOException e) {
				System.out.println(e.getMessage());
		    }
		}
		if (option == 5) {
			System.exit(0);
		}
		
		

	}
	
	private static Person Person(String string, String string2, String string3, String string4) {
		return null;
	}

	public static void writeToFile(Person p) throws FileNotFoundException, IOException{
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Person.bin"));
		objectOutputStream.writeObject(p);
	}
	
	public static void readFile( ) throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.bin"));
		Person name = (Person) objectInputStream.readObject();
		System.out.println(name);
	}

}
