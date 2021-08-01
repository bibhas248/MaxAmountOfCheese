
# Mouse and cheese problem

## Problem statement

There are blocks of cheese of different weights placed in a line. A mouse would like to eat the cheese, but with some rules. The mouse can’t eat two consecutive cheese blocks. The mouse would like to eat maximum cheese from the line of cheese blocks. Weight of each cheese block in Kg is given as a[i] in an integer array.

Constraints:

1. 1<=T<=200 
2. 1<=n<=1000
3. 1<=a[i]<=10000

where T is total number of testcases.
n is number of elements in the array. 
a[i] represents element value in array

-----

## Acceptance criteria

1. The code should accept validated input from the user.
2. The code should print the output appropriately.
3. The code should be commented
4. Error conditions should be considered.

-----

## Solution approach

Core logic to get the maximum sum of non-adjacent Integer in the Integer Array.
Solution is DP (dynamic programming) approach wherein instead to iterating through the array recursively
multiple times to get different combination of non-adjacent element in array we iterate through only once
by identifying initial criteria (max possible sum at an index of array)
we take 2 pointers representing Sum including current value at the index (currentInclude) and
Sum excluding current value at index (currentExclude).
As we move to next index Sum including current element will be previous sum excluding previous
element (currentExclude) and sum of current element a[i]  and currentExclude will be Max between
previous currentExclude and currentInclude.
Final result will be Max of final currentExclude and final currentInclude.

Logic is implemented in the `MaxAmountFromARowOfCheeseBlock.maxSumOfNonAdjacentNumberInArray`

```java
public class MaxAmountFromARowOfCheeseBlock {
  public static int maxSumOfNonAdjacentNumberInArray(Integer[] input){
    ...
  }
}
```

-----

## Installation

* Clone the repository from [GitHub](https://github.com/bibhas248/bibhas-embilabs.git).
* Install dependencies using this command -
    * `mvn clean test install`
* One can also run the program  after compiling class 
   org.bibhas.embilabs.MaxAmountFromARowOfCheeseBlock
  using `javac` command and running as
    `java org.bibhas.embilabs.MaxAmountFromARowOfCheeseBlock`

## Usage

* To run the app use this command - `java -jar target/max-cheese-amount-1.jar`
* One can also run the program  after compiling class
  org.bibhas.embilabs.MaxAmountFromARowOfCheeseBlock
  using `javac` command and running as
  `java org.bibhas.embilabs.MaxAmountFromARowOfCheeseBlock`