package org.bibhas.embilabs;

import java.util.*;

public class MaxAmountFromARowOfCheeseBlock {
    /**
     * @param args
     * staring point of program.
     * Step1: Get Validated input/testcase from the user
     * Step2: run the logic to calculate maximum amount of Cheese mouse can ear from each input/testcase
     */
    public static void main(String[] args){
        Map<Integer,Integer[]> inputs = getValidatedTestCases();
        maxAmountOfCheeseMouseCanEat(inputs);
    }

    /**
     * @param inputs  is Map<Integer,Integer[]> containing Testcase number and Array of value Integer
     *         representing weight of cheese block kept in row
     */
    public static void maxAmountOfCheeseMouseCanEat(Map<Integer,Integer[]> inputs){
        inputs.forEach((k,v)->{
            System.out.println("\nMax Amount of cheese mouse can eat from a row of block of cheese for TestCase "+k
                    + "\nArray=>" + Arrays.toString(v)
                    + "\nMax Amount of Cheese=" + maxSumOfNonAdjacentNumberInArray(v));
        });

    }

    /**
     *
     * @param input is Integer[] representing each testcase
     * @return int - representing  maximum sum of non-adjacent integer in integer array
     * This method represent core logic to get the maximum sum of non-adjacent Integer in the Integer Array.
     * Solution is DP (dynamic programming) approach wherein instead to iterating through the array recursively
     * multiple times to get different combination of non-adjacent element in array we iterate through only once
     * by identifying initial criteria (max possible sum at an index of array)
     * we take 2 pointers representing Sum including current value at the index (currentInclude) and
     * Sum excluding current value at index (currentExclude).
     * As we move to next index Sum including current element will be previous sum excluding previous
     * element (currentExclude) and sum of current element a[i]  and currentExclude will be Max between
     * previous currentExclude and currentInclude.
     * Final result will be Max of final currentExclude and final currentInclude.
     */
    public static int maxSumOfNonAdjacentNumberInArray(Integer[] input){
        int currentInclude = input[0];
        int currentExclude = 0;

        for(int i= 1; i < input.length; i++){
            int nextInclude = currentExclude + input[i];
            currentExclude = Math.max(currentExclude,currentInclude);
            currentInclude = nextInclude;
        }

        return Math.max(currentExclude,currentInclude);
    }

    /**
     * @return  is Map<Integer,Integer[]> representing testcases with validated input for each testcase
     * User inputs are validated with following Constraints
     * 1<=T<=200
     * 1<=n<=1000
     * 1<=a[i]<=10000
     * where T is total number of testcases
     * n is number of elements in the array
     * a[i] represents element value in array
     */
    private static Map<Integer,Integer[]> getValidatedTestCases() {
        Scanner reader = new Scanner(System.in);
        Map<Integer,Integer[]> inputs = new HashMap<>();

        System.out.println("Enter Total Number of TestCases to run\n");
        int totalTestCases = 0;
        try {
            totalTestCases = Integer.parseInt(reader.nextLine().trim());
        } catch (InputMismatchException e){
            System.out.println("Input is not a valid number. ");
        }
        if(totalTestCases < 1 || totalTestCases > 200 ){
            System.out.println("Total testcases should be between 1 to 200. Program will terminate.");
            System.exit(0);
        }


        for(int i =1; i <= totalTestCases; i++){
            try {
                System.out.println("\nEnter Total Number of Integer in Test Case " + i);
                Integer arrayLength = Integer.parseInt(reader.nextLine().trim());

                System.out.println("Enter space separated array values");
                String arrayValues = reader.nextLine();
                String[] values = arrayValues.replaceAll("\\s+"," ").split(" ");

                /* Validate if Array Length  matches expected length */
                if(values.length != arrayLength){
                    System.out.println("Number of Input and Array Length don't match");
                    throw new Exception();
                }

                Integer[] intArray = new Integer[arrayLength];

                for(int j=0; j<values.length;j++){
                    int intValue = Integer.parseInt(values[j]);
                    if(intValue < 1 || intValue > 10000){
                        System.out.println("Individual value in an Array should be between 1 and 10000");
                        throw new Exception();
                    }
                    intArray[j] = intValue;
                }
                inputs.put(i,intArray);
            } catch (Exception e){
                System.out.println("Please re-enter values for TestCase Number " + i--);
            }
        }
        return inputs;
    }
}
