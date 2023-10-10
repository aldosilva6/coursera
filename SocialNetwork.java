/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SocialNetwork {
    private int[] network;
    private int[] size;
    private int totalMembers;

    public SocialNetwork(int numberOfMembers) {
        network = new int[numberOfMembers];
        size = new int[numberOfMembers];
        totalMembers = numberOfMembers;
        for (int i = 0; i < network.length; i++) {
            network[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (i != network[i]) {
            i = network[i];
        }
        return i;
    }

    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private void addFriendship(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (size[i] < size[j]) {
            network[i] = j;
            size[j] += size[i];
        }
        else {
            network[j] = i;
            size[i] += size[j];
        }
        totalMembers--;
    }

    private boolean fullyConnected() {
        return totalMembers == 1;
    }

    public static void main(String[] args) {
        int numberOfMembers = StdIn.readInt();
        SocialNetwork socialNetwork = new SocialNetwork(numberOfMembers);
        System.out.println("Number of Members: " + numberOfMembers);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            String date = StdIn.readString();
            String time = StdIn.readString();

            if (!socialNetwork.connected(p, q)) {
                socialNetwork.addFriendship(p, q);
            }

            if (socialNetwork.fullyConnected()) {
                StdOut.println("Date :" + date + "and time: " + time + " connection");
                break;
            }
        }
    }
}
