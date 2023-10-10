/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnionPathComprassion {
    private int id[];
    private int size[];
    private int large[];

    public WeightedQuickUnionPathComprassion(int N) {
        id = new int[N];
        size = new int[N];
        large = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            size[i] = 1;
            large[i] = i;
        }
    }

    public int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public int find(int p) {
        return large[root(p)];
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        int largestP = large[rootP];
        int largestQ = large[rootQ];

        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];

            if (largestP > largestQ) {
                large[rootQ] = large[rootP];
            }
        }
        else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];

            if (largestQ > largestP) {
                large[rootP] = large[rootQ];
            }
        }
    }

    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public static void main(String[] args) {
        WeightedQuickUnionPathComprassion quickUnion = new WeightedQuickUnionPathComprassion(
                StdIn.readInt());
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (!quickUnion.connected(p, q)) {
                quickUnion.union(p, q);
            }
        }
    }
}
