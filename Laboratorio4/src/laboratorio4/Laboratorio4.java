/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4;


/**
 *
 * @author usuario
 */
public class Laboratorio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // PONER DOS PRUEBAS PARA CADA METODO
        System.out.println("Binario a decimal" +binaryDecimal(101101));
        int[] vector = {8,4,3,6,1};
        System.out.print("El inverso es=");
        reversedVector(vector);
       
        
    }
    //Problema 1
    public static int binaryDecimal(int binary){
        return binaryDecimal(binary, 0);
    }
    
    private static int binaryDecimal(int binary, int exponent){
        int result = 0;
        if (binary < 1) {
            return result;
        } else {
            result = (binary%10) * (int)(Math.pow(2, exponent));
            return result + binaryDecimal(binary / 10, exponent+1);
        }
    }
    
    //Problema 2
    public static void reversedVector(int[] vector){
        reversedVector(vector, 0);
    }
    
    private static void reversedVector(int[] vector, int positions){
        int mid = 0;
        if (vector.length % 2 == 0) {
            mid = (vector.length / 2) - 1;
        }else{
            mid = (vector.length / 2);//impar
        }
        if (positions > mid) {
            System.out.println(printVector(vector));
        }else{
            int intermedio = vector[positions];
            vector[positions] = vector[(vector.length -1)-positions];
            vector[(vector.length-1)-positions] = intermedio;
            reversedVector(vector, positions+1);
        }       
    }
    
    //Problema 3
    private static String printVector(int[] vector){
        return printVector(vector, 0);
    }
    
    public static String printVector(int[] vector, int positions){
        String txt = " ";
        if (vector.length == positions) {
            return "";
        } else {
            txt += vector[positions];
            return txt + printVector(vector, positions +1);
        }
    }
    
    //Problema 4
    
    
}
