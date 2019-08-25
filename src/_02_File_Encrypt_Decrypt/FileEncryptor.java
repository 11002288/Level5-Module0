package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String a = JOptionPane.showInputDialog("Write a Message");
		if(a.contains("a")) {
			
				a = a.replaceAll("a", "@");
			}
		try

	{
		FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/messager");

		fw.write(a);
		fw.close();
	}catch(
	IOException e)
	{
		e.printStackTrace();
	}
}}
