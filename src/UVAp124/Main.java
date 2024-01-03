package UVAp124;
import java.util.Scanner;

public class Main {
    static int[] can = new int[26];
    static int[][] map = new int[26][26];
    static int[] used = new int[26];
    static char[] str = new char[26];

    public static void DFS(int idx, int n) {
        if (idx == n) {
            str[idx] = '\0';
            System.out.println(new String(str));
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (can[i] == 1 && used[i] == 0) {
                for (int j = 0; j < 26; j++) {
                    if (map[i][j] == 1 && used[j] == 1) {
                        return;
                    }
                }
                used[i] = 1;
                str[idx] = (char) (i + 'a');
                DFS(idx + 1, n);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        char ch1, ch2;
        boolean first = true;
        while (scanner.hasNextLine()) {
            if (!first) {
                System.out.println();
            }
            first = false;
            line = scanner.nextLine();
            for (int i = 0; i < 26; i++) {
                can[i] = 0;
            }
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    map[i][j] = 0;
                }
            }
            for (int i = 0; i < 26; i++) {
                used[i] = 0;
            }
            Scanner sin = new Scanner(line);
            while (sin.hasNext()) {
                ch1 = sin.next().charAt(0);
                can[ch1 - 'a'] = 1;
            }
            int n = 0;
            for (int i = 0; i < 26; i++) {
                n += can[i];
            }
            line = scanner.nextLine();
            sin = new Scanner(line);
            while (sin.hasNext()) {
                ch1 = sin.next().charAt(0);
                ch2 = sin.next().charAt(0);
                map[ch1 - 'a'][ch2 - 'a'] = 1;
            }
            DFS(0, n);
        }
    }
}

