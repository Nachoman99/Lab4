/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4;


/**
 * this class has the tests and the recursive methods
 * 
 *@version 21/11/2018
 * @author Jose Ignacio Zamora/Kevin Trejos
 */
public class Laboratorio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
    //1
    /**
     * Declaration: public static int binaryDecimal(int binary)
     * This method calls the private method
     * @param binary the binary number
     * @return the decimal number
     */
    public static int binaryDecimal(int binary){
        return binaryDecimal(binary, 0);
    }
    
    /**
     * Declaration: private static int binaryDecimal(int binary, int exponent)
     * @param binary a binary number
     * @param exponent the exponent to raise the number
     * @return the decimal number
     */
    private static int binaryDecimal(int binary, int exponent){
        int result = 0;
        if (binary < 1) {
            return result;
        } else {
            result = (binary%10) * (int)(Math.pow(2, exponent));
            return result + binaryDecimal(binary / 10, exponent+1);
        }
    }
    /**
     * Declaration: public static void reservedVector(int[] vector)
     * this method calls the private method
     * @param vector the vector to invest
     */
    public static void reversedVector(int[] vector){
        reversedVector(vector, 0);
    }
    /**
     * Declaration: private static void reversedVector(int[] vector, int positions)
     * this method takes a vector and returns the same vector but inverted
     * @param vector the vector to invest
     * @param positions counter
     */
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
    /**
     * Declaration: public static String printVector(int[] vector)
     * This method call the private method
     * @param vector vector to print
     * @return a string with the vector
     */
    public static String printVector(int[] vector){
        return printVector(vector, 0);
    }
    
    /**
     * Declaration: private static String printVector(int[] vector, int positions)
     * this method prints a vector
     * @param vector vector to print
     * @param positions an accountant
     * @return a string with the vector
     */
    private static String printVector(int[] vector, int positions){
        String txt = " ";
        if (vector.length == positions) {
            return "";
        } else {
            txt += vector[positions];
            return txt + printVector(vector, positions +1);
        }
    }
    /**
     * Declaration: public static String cashMachine(int amount)
     * this method calls the private vector
     * @param amount amount to analyze
     * @return  a string with the minimum amount of money needed
     */
    public static String cashMachine(int amount){
        int[] vector ={50000,20000,10000,5000,2000,1000,500,100,50,25,10,5};
        return cashMachine(amount, vector, 0,0);
    }
    /**
     * Declaration: private static String cashMachine(int amount, int[vector], int positions, int count)
     * @param amount amount to analyze 
     * @param vector a vector with money available
     * @param positions an accountant
     * @param count an accountant
     * @return a string with the minimum amount of money needed
     */
    private static String cashMachine(int amount, int[] vector, int positions, int count){
        String result = "";
        if(amount <1){
            result += "\n"+ vector[positions] +":"+count; 
            return result;
        }else{
            if(amount >= vector[positions]){
                amount = amount - vector[positions];
                count += 1;   
            }else{  
                if(count >= 1){
                    result += "\n"+ vector[positions] +":"+count; 
                }
                return result+ cashMachine(amount, vector, positions+1,0);
            }
            return  cashMachine(amount, vector, positions,count);
        }
    } 
    
    /**
     * Declaration: public static int mcd(int a, int b)
     * this method gets the maximum common divisor of two numbers
     * @param a a whole number
     * @param b a whole number
     * @return the maximum common divisor of "a" and "b"
     */
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
