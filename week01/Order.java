public class Order {
  public static void main(String[] args){
   int a = Integer.parseInt(args[0]);
   int b = Integer.parseInt(args[1]);
   int c = Integer.parseInt(args[2]);

  // find max and min value
   int max1 = Math.max(a, b);
   int max = Math.max(max1, c);

   int min1 = Math.min(a, b);
   int min = Math.min(min1, c);

   // find medium number

    int medium = 

   //prints
   System.out.println(min + " " + medium + " " + max);
 
  }
  
}