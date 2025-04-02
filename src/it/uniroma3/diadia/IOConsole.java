package it.uniroma3.diadia;
import java.util.Scanner;
public class IOConsole {
<<<<<<< HEAD
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
=======
public void mostraMessaggio(String msg) {
System.out.println(msg);
}
public String leggiRiga() {
Scanner scannerDiLinee = new Scanner(System.in);
String riga = scannerDiLinee.nextLine();
//scannerDiLinee.close();
return riga;
}
>>>>>>> 8aa140e92919475658dc28001d98ae5fb5ed849b
}