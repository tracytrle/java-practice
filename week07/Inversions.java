public class Inversions {

  // Return the number of inversions in the permutation a[].
  public static long count(int[] a) {
    int n = a.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (a[i] > a[j]) {
          count++;
        }
      }
    }
    return count;
  }

  // Return a permutation of length n with exactly k inversions.
  public static int[] generate(int n, long k) {
    int[] a = new int[n];
    int i = 0;
    int number = n - 1;
    while (k > n - 1 - i) {
      a[i] = number;
      k = k - (n - 1 - i);
      number--;
      i++;
    }
    if (k > 0) {
      a[(int)(n - 1 - k)] = number--;
    }
    for (i = n - 1; number > 0 && i >= 0; i--) {
      if (a[i] == 0) {
        a[i] = number--; 
      }
    }
    return a;
  }

  // Takes an integer n and a long k as command-line arguments,
  // and prints a permutation of length n with exactly k inversions.
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int k = Integer.parseInt(args[1]);
    int[] arr = generate(n, k);
    for (int i = 0; i < n; i++) {
      System.out.printf("%d ", arr[i]);
    }
    System.out.println();
  }
}