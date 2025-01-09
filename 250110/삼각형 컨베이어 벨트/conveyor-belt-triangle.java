import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] arr = new int[3][n];
        int[] temp = new int [3];
        for(int i =0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(t-->0) {
            for(int i =0; i<3; i++) {
                temp[i] = arr[i][n-1];
                for(int j =n-1; j>0; j--) {
                    arr[i][j] = arr[i][j-1];    
                }
            }
            arr[0][0] = temp[2];
            arr[1][0] = temp[0];
            arr[2][0] = temp[1];
        }
        for(int i =0; i<3; i++) {
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
}