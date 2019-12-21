public class BandMatrix {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int width = Integer.parseInt(args[1]);
  
    for (int i = 0; i < n; i++){
      String pattern = ""; 
      for (int j = 0; j < n; j++){
        if ((Math.abs(i - j)) <= width)
          pattern = pattern + " *";
        else
          pattern = pattern + " 0"; 
      }
      System.out.println(pattern);
    }
  }
}