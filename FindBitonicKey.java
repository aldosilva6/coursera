/**
 * Created by ainacio on Oct, 2023
 */
public class FindBitonicKey {

    public static void main(String[] args) {
        int array[] = {1, 10, 9, 8, 7, 6, 5, 4};
        int key = 4;
        int n, left, right;
        left = 0;
        n = array.length;
        right = n - 1;
        int index;
        index = findBitonicPoint(array, n, left, right);
        int indexKey = searchBitonic(array, n, key, index);
        if(indexKey == -1){
            System.out.println("Element not found!");
        } else {
            System.out.println("Element found at index: " + indexKey);
        }
    }

    private static int searchBitonic(int[] array, int size, int key, int index) {
        if(key > array[index]){
            return -1;
        } else if(key == array[index]){
            return index;
        } else {
            int temp = ascendingBinarySearch(array, 0, index - 1, key);
            if(temp != -1){
                return temp;
            }

            return descendingBinarySearch(array, index + 1, size - 1, key);
        }
    }

    private static int descendingBinarySearch(int[] array, int low, int high, int key) {
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(array[mid] == key){
                return mid;
            }
            if(array[mid] < key){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    private static int ascendingBinarySearch(int[] array, int low, int high, int key) {
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(array[mid] == key){
                return mid;
            }
            if(array[mid] > key){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    private static int findBitonicPoint(int[] array, int size, int left, int right) {
        int mid;
        int bitonicPoint = 0;
        mid = (right + left) / 2;
        if(array[mid] > array[mid-1] && array[mid] > array[mid + 1]){
            return mid;
        } else {
            if(array[mid] > array[mid - 1] && array[mid] < array[mid + 1]){
                bitonicPoint = findBitonicPoint(array, size, mid, right);
            } else {
                if(array[mid] < array[mid -1] && array[mid] > array[mid +1]){
                    bitonicPoint = findBitonicPoint(array, size, left, mid);
                }
            }
        }

        return bitonicPoint;
    }
}
