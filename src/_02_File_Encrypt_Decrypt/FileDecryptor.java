package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	
	public void decryptFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_Encrypt_Decrypt/textFile.txt"));
			
			String line = br.readLine();
			
			char[] arr = line.toCharArray();
			for(int i = 0; i < arr.length; i++) {
				arr[i] = (char) (arr[i] - 5);
			}
			
			String strng = new String(arr);
			
			
			while(strng != null){
				System.out.println(strng);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
