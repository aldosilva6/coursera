/**
 * Created by ainacio on Oct, 2023
 */
public class TreesumGeek {

    static void findTriplets(int[] arr, int n)
    {
        boolean found = false;
        for (int i=0; i<n-2; i++)
        {
            for (int j=i+1; j<n-1; j++)
            {
                for (int k=j+1; k<n; k++)
                {
                    if (arr[i]+arr[j]+arr[k] == 0)
                    {
                        System.out.println("array[" + i + "]:" + arr[i] + " array[" + j + "]:" + arr[j] + " array[" + k + "]:" + arr[k]);
                        found = true;
                    }
                }
            }
        }

        // If no triplet with 0 sum found in array
        if (found == false)
            System.out.println(" not exist ");

    }
    // Driver code
    public static void main(String[] args)
    {
        int arr[] = {0, -1, 2, -3, 1};
        int n =arr.length;
        findTriplets(arr, n);
    }
}
