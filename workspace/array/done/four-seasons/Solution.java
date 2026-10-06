/**
 * TASK: Four Seasons
 * Source image: exercise/arrays-basics - special/e-55-FourSeasonsxxx.png
 *
 * Strugacarro is a planet whose year is divided into four seasons: winter,
 * spring, summer and autumn in that order. A year has N days and every
 * season lasts for exactly N/4 days. The year starts on the first day of
 * winter and ends on the last day of autumn.
 *
 * Given the history of temperatures from the previous year, find the
 * season with the highest amplitude of temperatures. The amplitude is the
 * difference between the highest and lowest temperatures over the given
 * period. Assume that all seasons within one year have different
 * temperature amplitudes.
 *
 * Write a function:
 *     class Solution { public String solution(int[] T); }
 * that, given an array T of N integers denoting the temperatures on all
 * days of the year, returns a string with the name of the season with the
 * highest temperature amplitude (one of the following: "WINTER", "SPRING",
 * "SUMMER", "AUTUMN").
 *
 * For example, given T = [-3, -14, -5, 7, 8, 42, 8, 3]:
 *     -3 -14 | -5 7 | 8 42 | 8 3
 *   WINTER   SPRING   SUMMER   AUTUMN
 * the function should return "SUMMER", since the highest amplitude (34)
 * occurs in summer.
 *
 * Given T = [2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18]:
 *    2 -3 3 | 1 10 8 | 2 5 13 | -5 3 -18
 *   WINTER     SPRING    SUMMER    AUTUMN
 * the correct answer is "AUTUMN" (amplitude equals 21).
 *
 * Assume that:
 * - The number of elements in the array is divisible by 4;
 * - each element of array T is an integer within the range
 *   [-1,000..1,000];
 * - N is an integer within the range [8..200];
 * - Amplitudes of all seasons are distinct.
 *
 * In your solution, focus on correctness. The performance of your solution
 * will not be the focus of the assessment.
 */
public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public String solution(int[] T) {

        // we have four season: "WINTER" | "SPRING" | "SUMMER" | "AUTUMN" 
        // two pointer 
        // start of the season 
        //end of the season 
        //gap between
        //max gap
        if (T.length <= 3) return "WINTER";
        int evenGap = T.length /4;
        int start = 0; 
        int end = evenGap -1;
        int[] max = new int[4];
        int result = 0;
        int pointer = 0;
        while (pointer <4 ) {
            int minSub = T[start];
            int maxSub = T[start];

            for (int i = start ; i <= end; i++ )  {
                minSub = Math.min(minSub, T[i]);
                maxSub = Math.max(T[i], maxSub);
            }
            int res =  maxSub - minSub;
            max[pointer] = res;
            start = end + 1;
            end = end + evenGap;
            pointer++;
        }

        for (int i = 0; i < max.length; i++) {
            result =max[result] > max[i] ? result : i;
            System.out.println("result of index" + i + " is : " + " " + max[i]);
           
        }
        return result == 0 ? "WINTER" : result == 1 ? "SPRING" : result == 2 ? "SUMMER" : "AUTUMN"; 


    }
}
