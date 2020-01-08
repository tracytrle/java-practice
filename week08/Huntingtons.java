public class Huntingtons {

  // Returns the maximum number of consecutive repeats of CAG in the DNA string.
  public static int maxRepeats(String dna) {
    int max = 0;
    int count = 0;
    int i = 0;
    while(i + 2 < dna.length()) {
      if (dna.charAt(i) == 'C') {
        if(dna.charAt(i + 1) == 'A' && (dna.charAt(i + 2) == 'G')) {
          count++;
          i = i + 3;
          if (count > max) {
            max = count;
          }
        }
        else {
          count = 0; 
          i++;
        }
      }
      else {
        count = 0;
        i++;
      }
    }
    return max;
  }

  // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
  public static String removeWhitespace(String s) {
    String ret = s.replace(" ","");
    ret = ret.replace("\n", "");
    ret = ret.replace("\t", "");
    return ret;
  }

  // Returns one of these diagnoses corresponding to the maximum number of repeats:
  // "not human", "normal", "high risk", or "Huntington's".
  public static String diagnose(int maxRepeats) {
    if (maxRepeats >= 0 && maxRepeats <= 9){
      return "not human"; 
    }
    if (maxRepeats >= 10 && maxRepeats <= 35) {
      return "normal";
    }
    if (maxRepeats >= 36 && maxRepeats <= 39) {
      return "high risk";
    }
    if (maxRepeats >= 40 && maxRepeats <= 180) {
      return "Huntington's";
    }
    return "not human";
  }

  // Sample client (see below).
  public static void main(String[] args) {
    In in = new In(args[0]);
    StringBuilder sb = new StringBuilder();
    while (!in.isEmpty()) {
      sb.append(in.readLine());
    }
    String input = sb.toString();
    String cleanInput = removeWhitespace(input);
    int max = maxRepeats(cleanInput);
    System.out.println("max repeats = " + max);
    System.out.println(diagnose(max));
  }
}