public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha){
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = alpha * a[i];
        }
        return b;
    }

    // Returns a new array that is the reverse of a[].
    // 0 1 2 3
    // 1 2 3 4
    // 4 3 2 1
    /*
    3 - 0 = 3 - 3
    2 - 1 = 3 - 2
    1 - 2 = 3 - 1
    0 - 3 = 3 - 0
    */ 
    public static double[] reverse(double[] a) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[a.length - 1 - i];
        }
        return c;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    /*
    0 1 2 3 4
    1 2 3 
    4 5 
    1 2 3 4 5
    */
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double [a.length + b.length];
        for (int i = 0; i < a.length; i ++) {
            c[i] = a[i];
        }
        for (int i = a.length; i < c.length; i++) {
            c[i] = b[i - a.length];
        } 
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    /*
    0 1 2 3 4
    1 2 3 4 6
    5 6 
    6 8 
    */
    public static double[] mix(double[] a, double[] b) {
        double[] c;
        if (a.length >= b.length) {
            c = new double[a.length];
            for (int i = 0; i < b.length; i++) {
                c[i] = a[i] + b[i];
            }
            for (int i = b.length; i < c.length; i++) {
                c[i] = a[i];
            }

        } else {
            c = new double[b.length]; 
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] + b[i];
            }
            for (int i = a.length; i < c.length; i++) {
                c[i] = b[i];
            }
        }
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    /* 
    0 1 2 3 4 5 6 7 8
    3 5 7 2 6 1 5 3 2 
    3 7 6 5 

    */
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] c = new double[(int)(a.length/alpha)];
        for (int i = 0; i < c.length; i++) {
            c[i] = a[(int)(alpha * i)]; 
        }
        return c;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        String[] filenames = {"beatbox.wav", "buzzer.wav", "chimes.wav", "cow.wav", "dialup.wav"};
        double[] beatbox = StdAudio.read(filenames[0]);
        double[] buzzer = StdAudio.read(filenames[1]);
        double[] chimes = StdAudio.read(filenames[2]);
        double[] cow = StdAudio.read(filenames[3]);
        double[] dialup = StdAudio.read(filenames[4]);
        
        double[] ret = merge(beatbox, amplify(buzzer, 0.35));
        ret = merge(ret, reverse(amplify(chimes, 0.35)));
        ret = mix(ret, cow);
        ret = mix(ret, amplify(dialup, 0.35));

        StdAudio.play(ret);
    }
}