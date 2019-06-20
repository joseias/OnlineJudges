
package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class UVA_12086_T {
 
    static int[] tree;
    static int[] array;
 
    public static void initialize(int i, int j, int node) {
        if (i == j) {
            tree[node] = array[i];
            return;
        }
        int mid = (i + j) / 2;
        initialize(i, mid, 2 * node);
        initialize(mid + 1, j, 2 * node + 1);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
 
    public static int query(int i, int j, int x, int y, int node) {
        if (i >= x && j <= y)
            return tree[node];
        if (j < x || i > y)
            return 0;
        int mid = (i + j) / 2;
        int left = query(i, mid, x, y, 2 * node);
        int right = query(mid + 1, j, x, y, 2 * node + 1);
        return left + right;
    }
 
    public static void update(int i, int j, int index, int value, int node) {
        if (i == j) {
            array[index] = value;
            tree[node] = value;
            return;
        }
        int mid = (i + j) / 2;
        if (index <= mid) {
            update(i, mid, index, value, 2 * node);
        } else {
            update(mid + 1, j, index, value, 2 * node + 1);
        }
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
 
    public static void main(String[] args) throws NumberFormatException,
            IOException {
 
        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder("");
        int t = 1;
        while (true) {
            int n = Integer.parseInt(buf.readLine());
            if (n == 0)
                break;
            ans.append("Case " + (t++) + ":\n");
            array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = Integer.parseInt(buf.readLine());
            int h = (int) (Math.log(n) / Math.log(2));
            h += 2;
            tree = new int[1 << h];
            initialize(0, n - 1, 1);
            StringTokenizer str;
            while (true) {
                str = new StringTokenizer(buf.readLine());
                String s = str.nextToken();
                if (s.equals("END"))
                    break;
                else if (s.equals("S")) {
                    int index = Integer.parseInt(str.nextToken()) - 1;
                    int value = Integer.parseInt(str.nextToken());
                    update(0, n - 1, index, value, 1);
                } else {
                    int x = Integer.parseInt(str.nextToken())-1;
                    int y = Integer.parseInt(str.nextToken())-1;
                    int sum = query(0, n - 1, x, y, 1);
                    ans.append(sum + "\n");
                }
            }
            ans.append("\n");
        }
        System.out.print(ans.substring(0, ans.length() - 1));
    }
}