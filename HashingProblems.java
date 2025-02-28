/*
 * *** Nathan Hogg / Section 002 ***
 *
 * This HashingProblems object contains three methods / problems that you must
 * complete utilize the HashMap object within the Java's Collection Framework Library.
 *
 * The three methods / problems you need to solve are:
 *  - getAverage
 *  - odd
 *  - twoSums
 */

import java.util.*;

class HashingProblems {

    /**
     * Method getAverage()
     *
     * This method accepts two parameters. The first is a HashMap object, while the second
     * is an array of integers. This method must compute the average of the values for each
     * 'key' that is found in BOTH the HashMap and the array.
     *
     * For example, if only the keys 1 and 2 from the array are present in the HashMap, and
     * lets say their values were 10 and 20, respectively, then the average is calculated
     * as (10+20)/2 = 15. Lets also say the keys ‘7’ and ‘8’ are in the array, but those keys
     * are not present in the HashMap. That means their corresponding values in the HashMap
     * are not included in the average calculation.
     *
     * To calculate the average, we first declare doubles for sum and commonCnt. Sum is a
     * running total of the values that are present in both the array and the HashMap.
     * commonCnt is a running total of the values that are common to both, since we need
     * to take the average of values found in both structures.
     * We use an enhanced for loop to iterate over the HashMap, and another for loop
     * to iterate over the array. This allows us to check each value in the array
     * against each element in the map. We then check if the values are equal, and
     * add to sum and increment commonCnt. Finally, we return sum / commonCnt.
     *
     * @param map the map to check against array
     * @param array the array to check against map
     * @return sum / commonCnt the average of the common values
     */

    public double getAverage(HashMap<Integer, Integer> map, int[] array) {

        double sum = 0;
        double commonCnt = 0;

        for (Integer key : map.keySet()) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == key) {
                    sum += map.get(i);
                    commonCnt++;
                }
            }
        }

         return sum / commonCnt;
  }

    /**
     * Method odd()
     *
     * This method accepts a HashMap object, and returns an ArrayList object with the
     * values of the corresponding keys that are odd.
     *
     * To determine what elements keys correspond to odd values, we first need to
     * create a new array list to hold these values. Then, we obtain the key set
     * of the Hash Map so that we can iterate over it.
     * We then use an enhanced for loop to iterate over each key in the keyset.
     * We perform a check to see if the current value is odd. If it is, we add
     * it to the result Array List.
     * Finally, we return result.
     *
     * @param map the map to extract odd values from
     * @return result an ArrayList object containing odd values
     **/

  public ArrayList<String> odd(HashMap<Integer, String> map) {
    
      ArrayList<String> result = new ArrayList<>();
      Set<Integer> keySet = map.keySet();

      for (Integer key : keySet) {
          if (key % 2 != 0) {
              result.add(map.get(key));
          }
      }
      return result;
  }


  /**
   * Method twoSums()
   *
   * You ARE to solve this problem in time complexity O(n). The submittals will be spot checked.
   *
   * Problem statement:
   * Suppose you are given an integer array containing the values [1,4,5,7,8,9] along with the
   * value k=4, where k is the difference between two array elements. How many times does k appear
   * in that list?
   *
   * With the above numbers, it will be three times:
   *    k = 4
   *    (5 - 1) = k
   *    (8 - 4) = k
   *    (9 - 5) = k
   *    k appears 3 times.
   *
   * All combinations must be considered. But, any other combination of the numbers in the array
   * results in a difference value that is not equal to k (k=4 in this case).
   *
   * This can be solved using nested for-loops, checking all combinations of the values in the array.
   * But the time complexity would be O(n^2).
   *
   * In order to solve this problem in O(n) complexity, utilize a HashMap (or a HashSet).
   *
   * You are two solve this using a HashMap (or you can use a HashSet, which is implemented
   * using HashMap). To solve this, you should populate the HashMap (or HashSet) based on
   * the array (this will be complexity time on the order of 'n'). After populating the HashMap,
   * consider a for-loop that does a lookup (probe) of the HashMap (or HashSet) on each iteration
   * of the loop. This will also have a complexity on the order of 'n', as the hashing probes are a
   * constant time complexity (after removing any constant based on collisions).
   *
   * This will result in a time complexity of O(n) for the overall method.
   *
   * NOTE: Solving using a HashMap or HashSet is fine (either is okay). HashSet may be easier to code?
   *
   * Rather than approaching this problem with a double for loop approach, we need to use a HashSet to ensure
   * that our solution operates in constant time. To do this, we first declare a new HashSet and
   * iterate over each element in the numbers array and add it to the HashSet.
   * Next, we create a count variable to keep a running count of correct sums.
   * Using an enhanced for loop, we can iterate over each element in the set and check if the set
   * contains i - k, which signifies that we have found a sum. We increment cnt and return.
   *
   * @param numbers the array containing possible sums
   * @param k the difference we are searching for
   * @return cnt the number of correct two-sums found in the array
   **/

  public int twoSums(int[] numbers, int k) {

      HashSet<Integer> set = new HashSet<>();
      for (int number : numbers) {
          set.add(number);
      }
      int cnt = 0;
      for (int i : set) {
          if (set.contains(i - k)) {
              cnt++;
          }
      }
      return cnt;
  }

} /* end class HashingProblems */
