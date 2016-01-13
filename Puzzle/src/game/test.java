package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = getInput();
	}

	private static int getInput() {
		System.out.println("Please enter int:");
		Scanner scanner = new Scanner(System.in);
		int n=0;
		try{
			n=scanner.nextInt();
			while(!(n>=3 && n<=100)){
				System.out.println("Pls skriv her:");
				n=scanner.nextInt();
			}
		}catch(InputMismatchException ime){
			System.out.println("Det sakl være et tal smarte");
			n=getInput();
		}
		return n;
	}

}
