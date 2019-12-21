public class DiscreteDistribution {
  private static void printArray(int[] arr) {
    for (int item : arr) {
      System.out.printf("%d ", item);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int m = Integer.parseInt(args[0]);
    int[] a = new int[args.length - 1];
    int[] s = new int[args.length - 1]; 
    for (int i = 0; i < args.length - 1; i++) {
      a[i] = Integer.parseInt(args[i + 1]); 
    }
    for (int i = 1; i < args.length - 1; i++) {
      a[i] = a[i] + a[i - 1];
    }

    printArray(a);
  }  
}