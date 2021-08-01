package org.bibhas.embilabs;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxAmountFromARowOfCheeseBlockTest {

    @Test
    public void maxSumOfNonAdjacentNumberInArray_testInput1(){
        Integer[] input1 = new Integer[]{8, 5, 10, 100, 10, 5};
        System.out.println("Testing for input " + Arrays.toString(input1));
        int result = MaxAmountFromARowOfCheeseBlock.maxSumOfNonAdjacentNumberInArray(input1);
        Assert.assertEquals(result,113);
        System.out.println("Result:" + result + "\n");
    }

    @Test
    public void maxSumOfNonAdjacentNumberInArray_testInput2(){
        Integer[] input2 = new Integer[]{1, 2, 3};
        System.out.println("Testing for input " + Arrays.toString(input2));
        int result = MaxAmountFromARowOfCheeseBlock.maxSumOfNonAdjacentNumberInArray(input2);
        Assert.assertEquals(result,4);
        System.out.println("Result:" + result + "\n");
    }
}
