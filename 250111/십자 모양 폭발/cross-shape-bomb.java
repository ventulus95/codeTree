import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;
        //폭탄 터트리기 로직
        arr = makeBomb(y, x, arr, n);
        //중력에 의해 만들어지는 로직
        arr = fallBlock(arr, n);
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] fallBlock(int[][] arr, int n) {
        for (int j = 0; j <n; j++) {
            int[] temp = new int[n];
            int count = 0;
            for (int i = n-1; i>=0 ; i--) {
                if (arr[i][j] > 0) {
                    temp[count] = arr[i][j];
                    count++;
                }
            }
            for (int i = n-1; i>=0 ; i--) {
                arr[i][j] = temp[n-1-i];
            }
        }
        return arr;
    }

    private static int[][] makeBomb(int y, int x, int[][] arr, int n) {
        int[] dx = {-1, 1};
        int[] dy = {-1, 1};

        int size = arr[y][x];
        arr[y][x] =0;
        for (int j = 0; j <2; j++) {
            int cy = y;
            int cx = x;
            for (int i = 0; i <size-1 ; i++) {
                if (cy+dy[j]<0 || cy+dy[j]>=n) {
                    break;
                }
                cy = cy + dy[j];
                arr[cy][x] = 0;
            }
            for (int i = 0; i <size-1 ; i++) {
                if (cx+dx[j]<0 || cx+dx[j]>=n) {
                    break;
                }
                cx = cx + dx[j];
                arr[y][cx] = 0;
            }
        }


        return arr;
    }
}