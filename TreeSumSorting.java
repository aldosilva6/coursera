import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * Created by ainacio on Oct, 2023
 */
public class TreeSumSorting {

    static int count(int arr[])
    {
        int count = 0;
        // sort array elements
        Arrays.sort(arr);
        int n = arr.length;

        for (int i=0; i<n-1; i++)
        {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r)
            {
                if (x + arr[l] + arr[r] == 0)
                {
                    // print elements if it's sum is zero
                    System.out.print(x + " ");
                    System.out.print(arr[l]+ " ");
                    System.out.println(arr[r]+ " ");

                    l++;
                    r--;
                    count++;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;

                    // if sum is greater than zero than
                    // decrement in right side
                else
                    r--;
            }
        }
        return count;
    }

    // Driven source
    public static void main (String[] args) {
        int arr[] = StdIn.readAllInts();
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(TreeSumSorting.count(arr));
        double time = stopwatch.elapsedTime();
        System.out.println("Time: " + time);
    }
}
