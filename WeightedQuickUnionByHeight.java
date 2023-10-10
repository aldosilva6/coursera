/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnionByHeight {
    private int id[];

    private int size[];

    public WeightedQuickUnionByHeight(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        /*System.out.println("Value i: " + i);
        System.out.println("Value j: " + j);
        System.out.println("Size [" + i + "] Before: " + size[i]);
        System.out.println("Size [" + j + "] Before: " + size[j]);*/
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        }
        else {
            id[j] = i;
            size[i] += size[j];
        }
        // System.out.println("Size [" + i + "] After: " + size[i]);
        // System.out.println("Size [" + j + "] After: " + size[j]);

        // System.out.println("id [" + i + "] after: " + id[i]);
        // System.out.println("id [" + j + "] after: " + id[j]);
    }

    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public static void main(String[] args) {
        WeightedQuickUnionByHeight quickUnion = new WeightedQuickUnionByHeight(StdIn.readInt());
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            // System.out.println("p: " + p);
            // System.out.println("q: " + q);

            if (!quickUnion.connected(p, q)) {
                quickUnion.union(p, q);
                System.out.println("Result: " + p + " " + q);
            }
        }

    }
}
