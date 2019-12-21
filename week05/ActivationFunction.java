public class ActivationFunction {
  public static double heaviside(double x) {
    if (Double.isNaN(x)) {
      return Double.NaN;
    }
    if (x < 0) {
      return 0.0;
    }
    if (x == 0) {
      return 1.0/2;
    }
    else {
      return 1.0;
    }
  }
  public static double sigmoid(double x) {
    return 1.0 / (1.0 + Math.exp(-x));
  }
  public static double tanh(double x) {
    if (x >= 20){
      return 1.0; 
    }
    if (x <= -20) {
      return -1.0;
    } else {
      return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }
  }
  public static double softsign(double x) {
    if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY) {
      return Double.NaN;
    }
    return (x * 1.0 / (1 + Math.abs(x)));
  }
  public static double sqnl(double x) {
    if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY) {
      return Double.NaN;
    }
    if (x <= -2.0) {
      return -1.0;
    }
    if (x > -2.0 && x < 0) {
      return x + (x * x / 4.0);
    }
    if (x >= 0.0 & x < 2.0) {
      return x - (x * x / 4);
    }
    else {
      return 1.0;
    }
  }
  public static void main(String[] args) {
    double x = Double.parseDouble(args[0]);
    System.out.println("heaviside(" + x +") = " + heaviside(x)); 
    System.out.println("sigmoid(" + x +") = " + sigmoid(x));
    System.out.println("tanh(" + x +") = " + tanh(x));
    System.out.println("softsign(" + x +") = " + softsign(x));
    System.out.println("sqnl(" + x +") = " + sqnl(x));
  }
}