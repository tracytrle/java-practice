public class ShannonEntropy {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int[] a = new int[n];
    int sum = 0;
    while (!StdIn.isEmpty()){
      int i = StdIn.readInt();
      a[i - 1]++;
      sum = sum + 1;
    }
    double h = 0.0;
    for (int i = 0; i < n; i++) {
      if (a[i] != 0) {
        double pi = a[i] * 1.0 / sum;
        double plogpi = pi * (Math.log(pi) / (Math.log(2)));
        h = h - plogpi;
      }
    }
    System.out.printf("%.4f\n",h); 
  }
}