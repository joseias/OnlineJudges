package pool;

import java.util.Scanner;

public class P_0004{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int i;
	int edad;
	int posMejorEdad=1;
	int mejorEdad=10000;
	int puntaje;
	for(i=0;i<n;i++){
	    puntaje = sc.nextInt();
	    edad = sc.nextInt();
	    if(puntaje>100 && edad<mejorEdad){
		mejorEdad = edad;
		posMejorEdad = i+1;
	    }
	}
	System.out.println(posMejorEdad);
    }
}
