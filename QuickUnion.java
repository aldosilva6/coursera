/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class QuickUnion {

    private int id[];

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
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
        id[i] = j;
    }

    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(StdIn.readInt());
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (!quickUnion.connected(p, q)) {
                quickUnion.union(p, q);
                System.out.println(p + " " + q);
            }
        }

    }
}
