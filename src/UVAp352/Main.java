package UVAp352;
import java.util.Scanner;

public class Main {
    private static final int MAX = 30;
    private static char[][] image = new char[MAX][MAX];

    private static void DFS(int n, int i, int j) {
        image[i][j] = '0';

        if (i - 1 >= 0 && image[i - 1][j] == '1')
            DFS(n, i - 1, j);
        if (i + 1 < n && image[i + 1][j] == '1')
            DFS(n, i + 1, j);
        if (j - 1 >= 0 && image[i][j - 1] == '1')
            DFS(n, i, j - 1);
        if (j + 1 < n && image[i][j + 1] == '1')
            DFS(n, i, j + 1);

        if (i - 1 >= 0 && j - 1 >= 0 && image[i - 1][j - 1] == '1')
            DFS(n, i - 1, j - 1);
        if (i - 1 >= 0 && j + 1 < n && image[i - 1][j + 1] == '1')
            DFS(n, i - 1, j + 1);
        if (i + 1 < n && j - 1 >= 0 && image[i + 1][j - 1] == '1')
            DFS(n, i + 1, j - 1);
        if (i + 1 < n && j + 1 < n && image[i + 1][j + 1] == '1')
            DFS(n, i + 1, j + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, t = 1, num = 0;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; ++i)
                image[i] = scanner.nextLine().toCharArray();
            num = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (image[i][j] == '1') {
                        DFS(n, i, j);
                        ++num;
                    }
                }
            }
            System.out.printf("Image number %d contains %d war eagles.\n", t++, num);
        }
        scanner.close();
    }
}


