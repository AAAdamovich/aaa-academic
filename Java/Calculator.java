/* Anton Adamovich
*  HomeNet Application Assesment
*  Created: 7-31-2016 - Last Edited: 8-10-2016
*  Simple Arithmetic Calculator
*  Description: Computes arithmetic operations with simple operands ( * / + - ) and displays a subtotal during operations. Program is user-terminated. 
*/

import java.util.Scanner;

public class Calculator{
   
   public static void main(String[] args){
      
      double subTotal = 0.0;
      String userInput = "";
      char nextOperator = '+';
      double nextOperand = 0.0;
      boolean operatingNext = false;
      Scanner reader = new Scanner(System.in);
      
      System.out.println("Hello and welcome to the simple calculator. ");
      System.out.println("To start, type an number and press Return, then enter an operator ( + - / * ) and press Return.");
      System.out.println("Program can be terminated with \"finish\".");
      
      userInput = reader.nextLine();
      
      while(!(userInput.equalsIgnoreCase("finish"))){
         
         if(!operatingNext){
            nextOperand = Double.parseDouble(userInput);
            switch(nextOperator){
               case '+': 
                  subTotal += nextOperand;
                  break;
               case '-':
                  subTotal -= nextOperand;
                  break;
               case '*': 
                  subTotal *= nextOperand;
                  break;
               case '/': 
                  subTotal /= nextOperand;
                  break;
               default:
                  break;
            }
            System.out.print(subTotal + " ");
            operatingNext = true;
         }
         else{
            nextOperator = userInput.charAt(0);
            if(nextOperator == '+' || nextOperator == '-' || nextOperator == '*' || nextOperator == '/'){
               System.out.print(subTotal + " " + nextOperator + " ");  
            }
            operatingNext = false;
         }

         userInput = reader.nextLine();

      }
      
      System.out.println("Program terminated. ");
      System.out.print("Final total: " + subTotal);
   }
}