package com.devbridge.academy;

import java.util.Scanner;

/*
Write a program to check if a number is a magic or not.

A magic number is an integer in which permutations of the digits are successive multiples of the number (number of digits and order does not change, but can start from different position).

The most widely known is 142857:
142857 × 1 = 142857
142857 × 2 = 285714
142857 × 3 = 428571
142857 × 4 = 571428
142857 × 5 = 714285
142857 × 6 = 857142

Input Data:
> Input a number: 142857
Expected Output
> It's magic!
*/

public class Main {

    /**
     * Main class main method. Uses java.util.Scanner class to receive an integer from the console input.
     * Then calls the isMagicNumber method to determine is the number "magic".
     */
    public static void main(String[] args) {
        System.out.print("Please enter an integer: ");

        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        scanner.close();

        if (isMagicNumber(inputNumber)) {
            System.out.println("The number " + inputNumber + " is Magic!");
        } else {
            System.out.println("The number " + inputNumber + " has no magic :(");
        }
    }

    /**
     * Method that checks the @param number for "magic".
     * NOTE: If the @param number multiplied by 2 contains all of the same digits in the correct order,
     * there is no need to spin the loop further. However, in case the @param number needs to be multiplied several times
     * and only then it could be announced as "magic", I have left the primary loop and would only need to create a local variable
     * (and tweak the code just a little) to determine how many times the primary loop completed successfully in a row.
     * @param number input number as int type parameter.
     * @return boolean type. True if the @param number multiplied by 2 contains all of the same digits in the correct order.
     */
    private static boolean isMagicNumber(int number) {
        String baseNumber = String.valueOf(number);
        int length = baseNumber.length();

        for (int i = 2; i <= 9; i++) {
            String currentNumber = String.valueOf(number * i);
            System.out.println(number + " * " + i + " = " + currentNumber);

            if (length == currentNumber.length()) {
                int matchAt = -1;

                for (int j = 0; j < length - 1; j++) {
                    if (currentNumber.contains(baseNumber.substring(j, j + 1))) {
                        matchAt = currentNumber.indexOf(baseNumber.substring(j, j + 1));
                        System.out.println("Partial match at " + matchAt + ". Continuing...");
                        break;
                    }
                }

                if (matchAt >= 0) {
                    for (int j = 0; j < length; j++) {

                        if(matchAt+j==length){
                            matchAt=0-j;
                        }

                        if(currentNumber.charAt(matchAt+j)!=baseNumber.charAt(j)){
                            return false;
                        }
                    }
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
