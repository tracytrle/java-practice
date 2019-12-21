public class Checkerboard {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    StdDraw.setScale(0.0, n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        double x = 0.5 + j;
        double y = 0.5 + i;
        if ((i + j) % 2 == 0) {
          StdDraw.setPenColor(StdDraw.BLUE);
          StdDraw.filledSquare(x, y, 0.5);
        } else {
          StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
          StdDraw.filledSquare(x, y, 0.5);
        }
      }
    }
  }
}