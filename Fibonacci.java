/**
 * Created by ainacio on Oct, 2023
 */
public class Fibonacci {

    static int fib(int n){
        int result;
        if(n == 1 || n == 2){
            result = 1;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }
        return result;
    }

    static int fibMemoization(int n, int array[]){
        int result;
        if(array[n] != 0){
            return array[n];
        }
        if(n == 1 || n == 2){
            result = 1;
        } else {
            result = fibMemoization(n - 1, array) + fibMemoization(n - 2, array);
        }
        array[n] = result;
        return result;
    }

    static int fib_bottom_up(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int a = 1;
        int b = 1;
        for(int i = 3; i <= n; i++){
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

    public static void main(String[] args) {
        int n = 8;
        int fibonacci = fib(n);
        System.out.println("Fibonacci: " + fibonacci);

        fibonacci = fibMemoization(n, new int[n + 1]);
        System.out.println("Fibonacci Memoization: " + fibonacci);

        fibonacci = fib_bottom_up(n);
        System.out.println("Fibonacci Bottom Up: " + fibonacci);
    }
}
