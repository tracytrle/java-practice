public class RandomWalker {
  public static void main(String[] args) {
    int r = Integer.parseInt(args[0]);
    int a = 0;
    int b = 0;
    int distance = 0;
    int count = 0;

    while (distance != r) {
      double random = Math.random();
      if (random >= 0 && random < 0.25){
        a = a + 1;
      }
      else {
        if (random >= 0.25 && random < 0.5) {
          a = a - 1;
        }
        else {
          if (random >= 0.5 && random < 0.75) {
            b = b + 1;
          }
          else {
            b =  b - 1; 
          }
        }
      }
      distance = Math.abs(a) + Math.abs(b);
      count = count + 1;
      System.out.println("(" + a + ", "  +b + ")");
    }
    System.out.println("Steps" + " = " + count);
  }
}