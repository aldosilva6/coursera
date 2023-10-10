import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ainacio on Oct, 2023
 */
public class TreeSumAldo {

    private final int[] arr;
    private int count;
    private HashMap<Integer, Integer> map;
    private List<String> resultList;

    public ThreeSum(int[] inputArray) {
        this.arr = inputArray;
        this.count = 0;
        this.map = new HashMap();
        this.resultList = new ArrayList();
    }

    public void computeThreeSum() {
        int n = this.arr.length;
        for (int i = 0; i < n - 2; i++) {
            int val = 0 - this.arr[i];
            for(int j = i + 1; j < n; j++) {
                if (this.map.containsKey(this.arr[j])) {
                    this.count++;
                    this.resultList.add("index: " + i + ", " + this.map.get(this.arr[j]) + ", " + j);
                }
                else {
                    int val2 = val - this.arr[j];
                    this.map.put(val2, j);
                }
            }
            this.map.clear();
        }
    }


    public static int count(int[] array){
        int count = 0;
        int N = array.length;
        for(int i=0; i <N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k = k++)
                    if (array[i] + array[j] + array[k] == 0)
                        count++;
        return count;
    }

    public int getCount() {
        return this.count;
    }

    public List<String> getResultList() {
        return this.resultList;
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        int[] array = {30,-40,10,30,-20,-10,-40,40,0,-10,0,10};
        double time = stopwatch.elapsedTime();
        System.out.println("Total:" + count(array));
        System.out.println("Time:" + time);

        ThreeSum ts = new ThreeSum(array);
        /*ts.computeThreeSum();
        StdOut.println("The number of 3-sum is: " + ts.getCount());
        List<String> resultList = ts.getResultList();
        resultList.forEach((str) -> {
            StdOut.println(str);
        });*/
    }
}
