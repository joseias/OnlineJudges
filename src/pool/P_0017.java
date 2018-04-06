/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class P_0017 {
    public static void main(String[] args){
        
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        
        Equipo[] ti=new Equipo[n];
        Equipo[] tf=new Equipo[n];
        
        for(int i=0;i<n;i++){
            String no=s.next();
            int p1=s.nextInt();
            int p2=s.nextInt();
            int d1=s.nextInt();
            int d2=s.nextInt();
            
            Equipo e=new Equipo(no, p1, p2, d1, d2);
            
            ti[i]=e;
            tf[i]=e;
        }
        
        Arrays.sort(ti,new EquipoComparatorInicio());
        Arrays.sort(tf,new EquipoComparatorFinal());
        
        for(int i=0;i<n;i++){
            if(ti[i].equals(tf[i])){
                System.out.print(ti[i].nombre+" ");
            }
        }
    }
}

class Equipo{
    String nombre;
    int p1;
    int p2;
    int d1;
    int d2;
    
    public Equipo(String n, int ap1, int ap2, int ad1, int ad2){
        nombre=n;
        p1=ap1;
        p2=ap2;
        d1=ad1;
        d2=ad2;
    }
}

class EquipoComparatorInicio implements Comparator<Equipo>{

    @Override
    public int compare(Equipo o1, Equipo o2) {
	if(o1.p1==o2.p1){
		if(o1.d1==o2.d1){
                    return o1.nombre.compareTo(o2.nombre);
		}
		else{
                    return -1*Integer.compare(o1.d1,o2.d1);
		}
	}
	else{
            return -1*Integer.compare(o1.p1,o2.p1);
	}
    }  
}

class EquipoComparatorFinal implements Comparator<Equipo>{

    @Override
    public int compare(Equipo o1, Equipo o2) {
	if(o1.p2==o2.p2){
		if(o1.d2==o2.d2){
                    return o1.nombre.compareTo(o2.nombre);
		}
		else{
			return -1*Integer.compare(o1.d2,o2.d2);
		}
	}
	else{
            return -1*Integer.compare(o1.p2,o2.p2);
	}
    }  
}