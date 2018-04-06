package jlib;

import java.util.LinkedList;
import java.util.List;

public class Combinatorics {
    
    public static void main(String[] args) {
        String[] alphabet={"A","B", "C"};
        String regex="^CA+B*";
        
        List<String> codes=generateCodesToMatchRegex(alphabet, regex, 10);
        
        for(String s: codes){
            System.out.println(s);
        }
    }
    
    static List<String> generateCodesToMatchRegex(String[] alfabet, String regex, int maxLength){
       List<String> codes=generateCodesUpTo(alfabet, maxLength);
       List<String> result=new LinkedList<>();
       
       for(String s: codes){
           if(s.matches(regex)){
               result.add(s);
           }
       }
       
       return result;
       
    }
    static List<String> generateCodes(String[] alphabet, int maxCodes){


        List<String> codes=new LinkedList();        
        int m=1;
        while(codes.size() < maxCodes){
            int[] variation=new int[m];
            generateVariations(alphabet, m, 0, variation, true, maxCodes, codes);
            m++;
        }
        return codes;
    }
    
    /***
     * Genera todas las variaciones desde longitud 1 hasta maxLenght
     * @param alphabet
     * @param maxLength
     * @return 
     */
    static List<String> generateCodesUpTo(String[] alphabet, int maxLength){

        List<String> codes=new LinkedList();        
        int m=1;
        while(m <= maxLength){
            int[] variation=new int[m];
            generateVariations(alphabet, m, 0, variation, false, 0, codes);
            m++;
        }
        return codes;
    }
            
    
    /***
     * Genera variaciones con repeticion.
     * @param elements: conjunto sobre el que se generaran las variaciones con repeticion (alfabeto).
     * @param m: numero de elementos a incluir en cada variacion.
     * @param currentPos: parametro especifico de la funcion. Indica que posicion de la variacion se esta generando.
     * @param variation: arreglo para codificar los  indices de los elementos incluidos en la variacion.
     * @param maxVariations: numero maximo de variaciones que se generaran. Se compara con el size de la lista results. 
     * notar que al comienzo results.size() puede ser > 0.
     * @param results: lista donde se colocaran las variaciones
     */
    static void generateVariations(String[] elements, int m, int currentPos, int[] variation, boolean checkMaxVariations, int maxVariations, List<String> results){

        if(!checkMaxVariations || results.size() < maxVariations){
            if(m==0){ /*Imprimir la variacion*/
                StringBuilder sb=new StringBuilder(m);
                
		for(int i=0;i<currentPos;i++){
                    sb.append(elements[variation[i]]) ;
		}
		results.add(sb.toString());
            }
            else{
                    for(int i=0;i<elements.length; i++){
                        variation[currentPos]=i;
                        generateVariations(elements,m-1,currentPos+1,variation, checkMaxVariations, maxVariations, results);
                        variation[currentPos]=-1;
                    }
            }
        }
    }
}
