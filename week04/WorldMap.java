public class WorldMap {
  public static void main(String[] args) {
    int x = StdIn.readInt();
    int y = StdIn.readInt();
    StdDraw.setCanvasSize(x, y);
    StdDraw.setXscale(0.0, x);
    StdDraw.setYscale(0.0, y); 
    while (!StdIn.isEmpty()) {
      String region = StdIn.readString();
      int vertices = StdIn.readInt();
      double[] xi = new double[vertices];
      double[] yi = new double[vertices];
      for (int i = 0; i < vertices; i++) {
        xi[i] = StdIn.readDouble();
        yi[i] = StdIn.readDouble(); 
      }
      StdDraw.polygon(xi, yi);
    }
  } 
}