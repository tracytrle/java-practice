public class Ramanujan {
// Is n a Ramanujan number?
  public static boolean isRamanujan(long n) {
    long a = Math.round(Math.pow(n, 1.0/3));
    boolean ret;
    int count = 0; 
    for (int i = 1; i <= a; i++) {
      long j = Math.round(n - Math.pow(i, 3));
      double k = Math.pow(j, 1.0/3);
      long m = Math.round(k);
      if (Math.pow(m, 3) == j) {
        count++;
      }
    }
    ret = count > 2; 
    return ret;
  }

  // Takes a long integer command-line arguments n and prints true if
  // n is a Ramanujan number, and false otherwise.
  public static void main(String[] args) {
    long n = Long.parseLong(args[0]);
    System.out.println(isRamanujan(n));
  }
}