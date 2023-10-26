/**
 * Created by ainacio on Oct, 2023
 */
public class EggDrop {

    static int max(int a, int b){
        return (a > b)? a : b;
    }

    static int eggDrop(int numberOfEggs, int floors){
        int eggFloors[][] = new int[numberOfEggs + 1][floors + 1];
        int res;
        int i,j,x;

        for(i = 1; i <= numberOfEggs; i++){
            eggFloors[i][1] = 1;
            eggFloors[i][0] = 0;
        }

        for(j = 1;j <= floors; j++)
            eggFloors[1][j] = j;

        for(i = 2; i <= numberOfEggs; i++){
            for(j = 2; j <= floors; j++){
                eggFloors[i][j] = Integer.MAX_VALUE;
                for(x = 1; x <= j; x++){
                    res = 1 + max(eggFloors[i-1][x -1], eggFloors[i][j - x]);
                    if(res < eggFloors[i][j]){
                        eggFloors[i][j] = res;
                    }
                }
            }
        }

        return eggFloors[numberOfEggs][floors];
    }

    static int eggDropAldo(int totalFloors, int totalEggs){
        if(totalFloors == 1 || totalFloors == 0){
            return totalFloors;
        }

        if(totalEggs == 1){
            return totalFloors;
        }

        int min = Integer.MAX_VALUE;
        int floor, res;

        for(floor = 1;floor <= totalFloors; floor++){
            res = max(eggDropAldo(totalFloors - floor, totalEggs), eggDropAldo(floor -1, totalEggs - 1));
            if(res < min){
                min = res;
            }
        }

        return min + 1;
    }

    public static void main(String[] args) {
        int numberOfEggs = 1, numberOfFloors = 4;

        /*System.out.println("Minimum number of trials in "+
                "worst case with "
                + numberOfEggs + "  eggs and " + numberOfFloors + " floors is " + eggDrop(numberOfEggs, numberOfFloors));*/
        System.out.println("Egg drop:" + eggDropAldo(numberOfFloors, numberOfEggs));
    }
}
