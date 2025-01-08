import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int[] up = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            up[i] = Integer.parseInt(st.nextToken());
        }
        int[] down = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            down[i] = Integer.parseInt(st.nextToken());
        }

        //움직이자
        for (int a = 0; a <t; a++) {
            int upTemp = up[n-1];
            int downTemp = down[n-1];
            for (int i = n-1; i>0; i--) {
                up[i] = up[i-1];
            }
            for (int i = n-1; i>0; i--) {
                down[i] = down[i-1];
            }
            down[0] = upTemp;
            up[0] = downTemp;
        }

        for (int i = 0; i <n; i++) {
            System.out.printf("%d ", up[i]);
        }
        System.out.println();
        for (int i = 0; i <n; i++) {
            System.out.printf("%d ", down[i]);
        }
        System.out.println();

     }
}