public class RandomNumber {
  public static void main(String[] args) {
  
    double r1 = Math.random();
    double r2 = Math.random();
    double r3 = Math.random();
    double r4 = Math.random();
    double r5 = Math.random();

    // prints five randoms from 0 to 1
    System.out.println(r1 + " " + r2 + " " + r3 + " " + r4 + " " + r5);

    // calculate Avarage, max
    double avg = (r1 + r2 + r3 + r4 + r5) / 5;

    System.out.println("avg" + " = " + avg);

    double max1 = Math.max(r1, r2);
    double max2 = Math.max(r3, r4);
    double max3 = Math.max(max1, max2); 
    double max = Math.max(max3, r5);

    // prints max value

    System.out.println("max " + " = " + max);
    // calculate min 

    double min1 = Math.min(r1, r2);
    double min2 = Math.min(r3, r4);
    double min3 = Math.min(min1, min2);
    double min = Math.min(min3, r5);

    
    System.out.println("min" + " = " + min);
  }
}