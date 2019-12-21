public class GreatCircle {
  public static void main(String[] args) {
  double dx1 = Double.parseDouble(args[0]);
  double x1 = Math.toRadians(dx1);
  double dy1 = Double.parseDouble(args[1]);
  double y1 = Math.toRadians(dy1);
  double dx2 = Double.parseDouble(args[2]);
  double x2 = Math.toRadians(dx2);
  double dy2 = Double.parseDouble(args[3]);
  double y2 = Math.toRadians(dy2);
  double r = 6371.0;
  double x = (x2 - x1) / 2.0;
  double y = (y2 - y1) / 2.0;
  double sinpowx = Math.sin(x) * Math.sin(x);
  double sinpowy = Math.sin(y) * Math.sin(y);
  double sqrt = Math.sqrt(sinpowx + Math.cos(x1) * Math.cos(x2) * sinpowy);
  double distance = 2.0 * r * Math.asin(sqrt);
  System.out.println(distance + " kilometers ");
 }
}