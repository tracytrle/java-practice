public class TrinomialDP {
  // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
      long[][] t = new long[n + 1][n + 1];
      t[0][0] = 1;
      if (Math.abs(k) > n) {
        return 0;
      }
      for (int i = 1; i < n + 1; i++) {
        for (int j = 0; j <= i; j++) {
          if (j == 0) {
            t[i][0] = t[i - 1][0] + 2 * t[i - 1][1];
          } else {
            long a = 0;
            if ( j + 1 <=  i) {
              a = t[i - 1][j + 1];
            }
            t[i][j] = t[i - 1][j - 1] + t[i - 1][j] + a;
          }
        }
      }
      if (k < 0 && k >= - n) {
        k = -k;
      }
      return t[n][k]; 
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
      int n = Integer.parseInt(args[0]);
      int k = Integer.parseInt(args[1]);
      System.out.println(trinomial(n, k));
    }
}