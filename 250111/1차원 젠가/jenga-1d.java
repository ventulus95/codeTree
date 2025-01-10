import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken()) - 1;
        int s2 = Integer.parseInt(st.nextToken())-1;
        arr = moveJenga(s1, s2, arr, n, new int[n]);
        st = new StringTokenizer(br.readLine());
        int s3 = Integer.parseInt(st.nextToken())-1;
        int s4 = Integer.parseInt(st.nextToken())-1;
        arr = moveJenga(s3, s4, arr, n, new int[n]);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i <n; i++) {
            if (arr[i] > 0) {
                count++;
                sb.append(arr[i]);
                sb.append("\n");
            }
        }
        System.out.println(count);
        System.out.print(sb);
    }

    private static int[] moveJenga(int s1, int s2, int[] arr, int n, int[] temp) {
        for (int i = s1; i <= s2; i++) {
            arr[i] = 0;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                temp[cnt] = arr[i];
                cnt++;
            }
        }
        arr = new int[n];
        for (int i = 0; i <cnt; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }
}