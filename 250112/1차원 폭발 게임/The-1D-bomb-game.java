import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = n-1; i >=0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        while(isBombingArray(n, arr, m)) {
            arr = fallingBombs(n, explodeBomb(n, arr, m));
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >=0; i--) {
            if (arr[i]>0) {
                count++;
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.println(count);
        System.out.println(sb);

    }

    private static int[] explodeBomb(int n, int[] arr, int m) {
        int index = 0;
        while(index< n) {
            int start = index;
            int count = 0;
            while(index< n && arr[start] == arr[index] ) {
                index++;
                count++;
            }
            if (count>= m) {
                for (int i = start; i <index; i++) {
                    arr[i] = 0;
                }
            }
        }
//        System.out.println("explode BOMB");
//        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static int[] fallingBombs(int n, int[] arr) {
        int[] temp = new int[n];
        int count = 0;
        for (int i = 0; i<n; i++) {
            if (arr[i] > 0) {
                temp[count] = arr[i];
                count++;
            }
        }
//        System.out.println("falling BOMB");
//        System.out.println(Arrays.toString(temp));
        return temp;
    }

    private static boolean isBombingArray(int n, int[] arr, int m) {
        int index = 0;
        while(index< n) {
            int start = index;
            int count2 = 0;
            while(index< n && arr[start] == arr[index] ) {
                index++;
                count2++;
            }
            if (arr[start] != 0 && count2>= m) {
                return true;
            }
        }
        return false;
    }
}