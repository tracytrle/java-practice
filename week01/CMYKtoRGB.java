public class CMYKtoRGB {
  public static void main(String[] args) {
    double cyan = Double.parseDouble(args[0]);
    double magenta = Double.parseDouble(args[1]);
    double yellow = Double.parseDouble(args[2]);
    double black = Double.parseDouble(args[3]);

    double white = 1.0 - black;
    double red = 255 * white * (1.0 - cyan);
    double green = 255 * white * (1.0 - magenta);
    double blue = 255 * white * (1.0 - yellow);

    long red1 = Math.round(red);
    long green1 = Math.round(green);
    long blue1 = Math.round(blue);

    System.out.println("red" + " = " + red1);
    System.out.println("green" + " = " + green1);
    System.out.println("blue" + " = " + blue1);
  }
}