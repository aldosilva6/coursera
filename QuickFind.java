/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFind {

    private static int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        System.out.println("id[p]: " + id[p] + " id[q]: " + id[q]);
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
        StdOut.println("id[" + p + "]:" + id[p] + " id[" + q + "]:" + id[q]);
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind quickFind = new QuickFind(10);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            System.out.println("Valor de p: " + p);
            int q = StdIn.readInt();
            System.out.println("Valor de q: " + q);

            System.out.println(quickFind.connected(p, q));

            if (!quickFind.connected(p, q)) {
                quickFind.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}
