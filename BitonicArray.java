/**
 * Created by ainacio on Oct, 2023
 */
public class BitonicArray {

    public static void main(String[] args) {
        long start = System.nanoTime();
        int array[] = {1,2,3,5,10,15,9,8,7,6};
        System.out.println(findMaximNumber(array));
        long end = System.nanoTime();
        System.out.println(end - start);

        start = System.nanoTime();
        int binary[] = {1,2,3,5,10,15,9,8,7,6};
        System.out.println(findMaximNumberBinary(binary, 0, binary.length - 1));
        end = System.nanoTime();
        System.out.println(end - start);


        start = System.nanoTime();
        int binary2[] = {1,2,3,15,18,20,7,6};
        System.out.println(findMaximNumberIterative(binary2, 0, binary2.length - 1));
        end = System.nanoTime();
        System.out.println(end - start);
    }

    private static int findMaximNumberIterative(int []array, int left, int right){
        while (left <= right){
            int mid = left + (right - left) / 2;

            if(left == right){
                return array[left];
            }

            if((right == left + 1) && array[left] >= array[right]){
                return array[left];
            }

            if((right == left + 1) && array[left] < array[right]){
                return array[right];
            }

            if(array[mid] > array[mid + 1] && array[mid] > array[mid - 1]){
                return array[mid];
            }

            if(array[mid] > array[mid + 1] && array[mid] < array[mid - 1]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private static int findMaximNumberBinary(int []array, int low, int high){
        int max = 0;

        if(low == high){
            return array[low];
        }

        if((high == low + 1) && array[low] >= array[high]){
            return array[low];
        }

        if((high == low + 1) && array[low] < array[high]){
            return array[high];
        }

        int mid = (low + high)/2;

        if(array[mid] > array[mid + 1] && array[mid] > array[mid - 1]){
            return array[mid];
        }

        if(array[mid] > array[mid + 1] && array[mid] < array[mid - 1]){
            return findMaximNumberBinary(array, low, mid - 1);
        } else {
            return findMaximNumberBinary(array, mid + 1, high);
        }
    }

    private static int findMaximNumber(int[] array) {
        int low = 0;
        int max = 0;
        int high = array.length;
        for(int i = low;i < high;i++){
            if(array[i]>max){
                max = array[i];
            }
        }

        return max;
    }
}
