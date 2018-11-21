/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4;


/**
 *@version 21/11/2018
 * @author Jose Ignacio Zamora/Kevin Trejos
 */
public class Laboratorio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // PONER DOS PRUEBAS PARA CADA METODO
        System.out.println("Binario a decimal= " +binaryDecimal(101101));
        System.out.println("Binario a decimal= " +binaryDecimal(1001010));
        
        int[] vector = {8,4,3,6,1};
        System.out.print("El inverso es=");
        reversedVector(vector);
        
        int[] vector2 = {1,2,3,4,5};
        System.out.print("El inverso es=");
        reversedVector(vector2);
        
        System.out.println("Cajero Automatico= " + cashMachine(46725));
        System.out.println("Cajero Automatico= " + cashMachine(123200));
        
        System.out.println("MCD= "+ mcd(228, 184));
        System.out.println("MCD= "+ mcd(23, 13));
        
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
    
    public static String cashMachine(int amount){
        int[] vector ={50000,20000,10000,5000,2000,1000,500,100,50,25,10,5};
        return cashMachine(amount, vector, 0);
    }
    
    private static String cashMachine(int amount, int[] vector, int positions){
        String result = "";
        if(amount <1){
            return result;
        }else{
            int sizeMoney = amountMoney(amount,vector[positions]);
            int updateAmount = remainingAmount(amount, vector[positions]);
            if(sizeMoney>0){
               return "\n"+ vector[positions] +":"+ sizeMoney + cashMachine(updateAmount, vector, (positions+1)); 
            }
            return cashMachine(updateAmount, vector, (positions+1));
        }
    } 
    
    private static int amountMoney(int amount, int positionVector){
        int contador = 0;
        if(amount<positionVector){
            return contador;
        }else{
            return (contador+1)+ amountMoney(amount-positionVector, positionVector);
        }   
    }
    
    private static int remainingAmount(int amount, int positionVector){
        if(amount<positionVector){
            return amount;
        }else{
            return  remainingAmount(amount-positionVector, positionVector);
        }   
    }
    
    //5
    public static int mcd(int a, int b){
        if (a == b) {
            return a;
        } else {
            if (a > b) {
                return mcd(a - b, b);
            } else {
                return mcd(a, b - a);
            }
        }
    }
    
}
