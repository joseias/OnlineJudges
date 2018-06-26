import java.util.*;

public class Main {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    while(sc.hasNext()) 
        {
        int n = sc.nextInt();

        if (n == 0) {
            break;
        }
        PriorityQueue<Integer> cola = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                cola.add(sc.nextInt());
            }
            int suma = 0;
            while(cola.size()>1){
                int temp=cola.poll() + cola.poll();//quita elemento de la cola
                cola.add(temp);//adiere elemento a la cola
                suma=temp+suma;
            }
            System.out.println(suma);
    }
    }
}