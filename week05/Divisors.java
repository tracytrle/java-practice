public class Divisors {
  public static int gcd(int a, int b) {
    if (a == 0 && b == 0) {
      return 0;
    }
    if (a == 0 && b != 0) {
      return Math.abs(b);
    }
    if (a != 0 && b == 0) {
      return Math.abs(a);
    }
    int t = Math.abs(a) % Math.abs(b);
    while (t != 0) {
      a = Math.abs(b);
      b = t;
      t = Math.abs(a) % Math.abs(b);
    }
    return Math.abs(b);
  }

  public static int lcm(int a, int b) {
    if (a == 0 && b == 0) {
      return 0;
    }
    return (Math.abs(a) / gcd(a, b)) * Math.abs(b);
  }

  // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
      if (gcd(a, b) == 1) {
        return true; 
      }
      return false;   
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
      int count = 0;
      for (int i = 1; i <= n; i++) {
        if (areRelativelyPrime(n, i)) {
          count++; 
        }
      }
      return count; 
    }


  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    System.out.println("gcd(" + a +", " + b +") = " + gcd(a, b));
    System.out.println("lcm(" + a +", " + b +") = " + lcm(a, b));
    System.out.println("areRelativelyPrime(" + a +", " + b +") = " + areRelativelyPrime(a, b));
    System.out.println("totient(" + a +") = " + totient(a));
    System.out.println("totient(" + b +") = " + totient(b));
  }
}