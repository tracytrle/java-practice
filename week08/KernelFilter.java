import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        Picture pic = new Picture(picture.width(), picture.height());
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                // row and column for cell 2
                int r1 = i - 1;
                int c1 = j - 1;
                if (r1 < 0) {
                    r1 = picture.height() - 1;
                }
                if (c1 < 0) {
                    c1 = picture.width() - 1;
                }

                int r2 = i - 1;
                int c2 = j;
                if (r2 < 0) {
                    r2 = picture.height() - 1;
                }

                int r3 = i - 1;
                int c3 = j + 1;
                if (r3 < 0) {
                    r3 = picture.height() - 1;
                }
                if (c3 == picture.width()) {
                    c3 = 0;
                }

                int r4 = i;
                int c4 = j - 1;
                if (c4 < 0) {
                    c4 = picture.width() - 1;
                }

                int r5 = i;
                int c5 = j;

                int r6 = i;
                int c6 = j + 1;
                if (c6 == picture.width()) {
                    c6 = 0;
                }

                int r7 = i + 1;
                int c7 = j - 1;
                if (r7 == picture.height()) {
                    r7 = 0;
                }
                if (c7 < 0) {
                    c7 = picture.width() - 1;
                }

                int r8 = i + 1;
                int c8 = j;
                if (r8 == picture.height()) {
                    r8 = 0;
                }

                int r9 = i + 1;
                int c9 = j + 1;
                if (r9 == picture.height()) {
                    r9 = 0;
                }
                if (c9 == picture.width()) {
                    c9 = 0;                
                }

                int r = (int) Math.round((picture.get(c1, r1).getRed() + 2*picture.get(c2, r2).getRed() + picture.get(c3, r3).getRed() + 
                    2*picture.get(c4, r4).getRed() + 4*picture.get(c5, r5).getRed() + 2*picture.get(c6, r6).getRed() +
                    picture.get(c7, r7).getRed() + 2*picture.get(c8, r8).getRed() + picture.get(c9, r9).getRed()) * 1.0 / 16);

                int g = (int) Math.round((picture.get(c1, r1).getGreen() + 2*picture.get(c2, r2).getGreen() + picture.get(c3, r3).getGreen() + 
                    2*picture.get(c4, r4).getGreen() + 4*picture.get(c5, r5).getGreen() + 2*picture.get(c6, r6).getGreen() +
                    picture.get(c7, r7).getGreen() + 2*picture.get(c8, r8).getGreen() + picture.get(c9, r9).getGreen()) * 1.0 / 16);

                int b = (int) Math.round((picture.get(c1, r1).getBlue() + 2*picture.get(c2, r2).getBlue() + picture.get(c3, r3).getBlue() + 
                    2*picture.get(c4, r4).getBlue() + 4*picture.get(c5, r5).getBlue() + 2*picture.get(c6, r6).getBlue() +
                    picture.get(c7, r7).getBlue() + 2*picture.get(c8, r8).getBlue() + picture.get(c9, r9).getBlue()) * 1.0 / 16);
                if (r < 0) {
                    r = 0;
                }
                if (r > 255) {
                    r = 255;
                }

                if (g < 0) {
                    g = 0;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b < 0) {
                    b = 0;
                }
                if (b > 255) {
                    b = 255;
                }
                pic.set(j, i, new Color(r, g, b));
            }
        }
        return pic; 
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        Picture pic = new Picture(picture.width(), picture.height());
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                // row and column for cell 2
                int r2 = i - 1;
                int c2 = j;
                if (r2 < 0) {
                    r2 = picture.height() - 1;
                }

                int r4 = i;
                int c4 = j - 1;
                if (c4 < 0) {
                    c4 = picture.width() - 1;
                }

                int r5 = i;
                int c5 = j;

                int r6 = i;
                int c6 = j + 1;
                if (c6 == picture.width()) {
                    c6 = 0;
                }

                int r8 = i + 1;
                int c8 = j;
                if (r8 == picture.height()) {
                    r8 = 0;
                }
                
                int r = -picture.get(c2, r2).getRed() - picture.get(c4, r4).getRed()
                    + 5*picture.get(c5, r5).getRed() - picture.get(c6, r6).getRed()
                    - picture.get(c8, r8).getRed();

                int g = -picture.get(c2, r2).getGreen() - picture.get(c4, r4).getGreen()
                    + 5*picture.get(c5, r5).getGreen() - picture.get(c6, r6).getGreen()
                    - picture.get(c8, r8).getGreen();

                int b = -picture.get(c2, r2).getBlue() - picture.get(c4, r4).getBlue()
                    + 5*picture.get(c5, r5).getBlue() - picture.get(c6, r6).getBlue()
                    - picture.get(c8, r8).getBlue();
                if (r < 0) {
                    r = 0;
                }
                if (r > 255) {
                    r = 255;
                }

                if (g < 0) {
                    g = 0;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b < 0) {
                    b = 0;
                }
                if (b > 255) {
                    b = 255;
                }
                pic.set(j, i, new Color(r, g, b));
            }
        }
        return pic; 
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        Picture pic = new Picture(picture.width(), picture.height());
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                // row and column for cell 2
                int r1 = i - 1;
                int c1 = j - 1;
                if (r1 < 0) {
                    r1 = picture.height() - 1;
                }
                if (c1 < 0) {
                    c1 = picture.width() - 1;
                }

                int r2 = i - 1;
                int c2 = j;
                if (r2 < 0) {
                    r2 = picture.height() - 1;
                }

                int r3 = i - 1;
                int c3 = j + 1;
                if (r3 < 0) {
                    r3 = picture.height() - 1;
                }
                if (c3 == picture.width()) {
                    c3 = 0;
                }

                int r4 = i;
                int c4 = j - 1;
                if (c4 < 0) {
                    c4 = picture.width() - 1;
                }

                int r5 = i;
                int c5 = j;

                int r6 = i;
                int c6 = j + 1;
                if (c6 == picture.width()) {
                    c6 = 0;
                }

                int r7 = i + 1;
                int c7 = j - 1;
                if (r7 == picture.height()) {
                    r7 = 0;
                }
                if (c7 < 0) {
                    c7 = picture.width() - 1;
                }

                int r8 = i + 1;
                int c8 = j;
                if (r8 == picture.height()) {
                    r8 = 0;
                }

                int r9 = i + 1;
                int c9 = j + 1;
                if (r9 == picture.height()) {
                    r9 = 0;
                }
                if (c9 == picture.width()) {
                    c9 = 0;                
                }

                int r = -picture.get(c1, r1).getRed() - picture.get(c2, r2).getRed() - picture.get(c3, r3).getRed() - 
                    picture.get(c4, r4).getRed() + 8*picture.get(c5, r5).getRed() - picture.get(c6, r6).getRed() -
                    picture.get(c7, r7).getRed() - picture.get(c8, r8).getRed() - picture.get(c9, r9).getRed();

                int g = -picture.get(c1, r1).getGreen() - picture.get(c2, r2).getGreen() - picture.get(c3, r3).getGreen() - 
                    picture.get(c4, r4).getGreen() + 8*picture.get(c5, r5).getGreen() - picture.get(c6, r6).getGreen() -
                    picture.get(c7, r7).getGreen() - picture.get(c8, r8).getGreen() - picture.get(c9, r9).getGreen();

                int b = -picture.get(c1, r1).getBlue() - picture.get(c2, r2).getBlue() - picture.get(c3, r3).getBlue() - 
                    picture.get(c4, r4).getBlue() + 8*picture.get(c5, r5).getBlue() - picture.get(c6, r6).getBlue() -
                    picture.get(c7, r7).getBlue() - picture.get(c8, r8).getBlue() - picture.get(c9, r9).getBlue();

                if (r < 0) {
                    r = 0;
                }
                if (r > 255) {
                    r = 255;
                }

                if (g < 0) {
                    g = 0;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b < 0) {
                    b = 0;
                }
                if (b > 255) {
                    b = 255;
                }
                pic.set(j, i, new Color(r, g, b));
            }
        }
        return pic; 
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        Picture pic = new Picture(picture.width(), picture.height());
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                // row and column for cell 2
                int r1 = i - 1;
                int c1 = j - 1;
                if (r1 < 0) {
                    r1 = picture.height() - 1;
                }
                if (c1 < 0) {
                    c1 = picture.width() - 1;
                }

                int r2 = i - 1;
                int c2 = j;
                if (r2 < 0) {
                    r2 = picture.height() - 1;
                }

                int r4 = i;
                int c4 = j - 1;
                if (c4 < 0) {
                    c4 = picture.width() - 1;
                }

                int r5 = i;
                int c5 = j;

                int r6 = i;
                int c6 = j + 1;
                if (c6 == picture.width()) {
                    c6 = 0;
                }

                int r8 = i + 1;
                int c8 = j;
                if (r8 == picture.height()) {
                    r8 = 0;
                }

                int r9 = i + 1;
                int c9 = j + 1;
                if (r9 == picture.height()) {
                    r9 = 0;
                }
                if (c9 == picture.width()) {
                    c9 = 0;                
                }

                int r = - 2*picture.get(c1, r1).getRed() - picture.get(c2, r2).getRed() - 
                    picture.get(c4, r4).getRed() + picture.get(c5, r5).getRed() + picture.get(c6, r6).getRed() +
                    picture.get(c8, r8).getRed() + 2*picture.get(c9, r9).getRed();

               int g = - 2*picture.get(c1, r1).getGreen() - picture.get(c2, r2).getGreen() - 
                    picture.get(c4, r4).getGreen() + picture.get(c5, r5).getGreen() + picture.get(c6, r6).getGreen() +
                    picture.get(c8, r8).getGreen() + 2*picture.get(c9, r9).getGreen();

               int b = - 2*picture.get(c1, r1).getBlue() - picture.get(c2, r2).getBlue() - 
                    picture.get(c4, r4).getBlue() + picture.get(c5, r5).getBlue() + picture.get(c6, r6).getBlue() +
                    picture.get(c8, r8).getBlue() + 2*picture.get(c9, r9).getBlue();

                if (r < 0) {
                    r = 0;
                }
                if (r > 255) {
                    r = 255;
                }

                if (g < 0) {
                    g = 0;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b < 0) {
                    b = 0;
                }
                if (b > 255) {
                    b = 255;
                }
                pic.set(j, i, new Color(r, g, b));
            }
        }
        return pic; 
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        Picture pic = new Picture(picture.width(), picture.height());
        for (int i = 0; i < picture.height(); i++) {
            for (int j = 0; j < picture.width(); j++) {
                // row and column for cell 2
                int r1 = i - 4;
                int c1 = j - 4; 
                if (r1 < 0) {
                    r1 = picture.height() - Math.abs(r1);
                }
                if (c1 < 0) {
                    c1 = picture.width() - Math.abs(c1);
                }

                int r2 = i - 3;
                int c2 = j - 3; 
                if (r2 < 0) {
                    r2 = picture.height() - Math.abs(r2);
                }
                if (c2 < 0) {
                    c2 = picture.width() - Math.abs(c2);
                }

                int r3 = i - 2;
                int c3 = j - 2; 
                if (r3 < 0) {
                    r3 = picture.height() - Math.abs(r3);
                }
                if (c3 < 0) {
                    c3 = picture.width() - Math.abs(c3);
                }

                int r4 = i - 1;
                int c4 = j - 1; 
                if (r4 < 0) {
                    r4 = picture.height() - 1;
                }
                if (c4 < 0) {
                    c4 = picture.width() - 1;
                }

                int r5 = i;
                int c5 = j;

                int r6 = i + 1;
                int c6 = j + 1; 
                if (r6 == picture.height()) {
                    r6 = 0;
                }
                if (c6 == picture.width()) {
                    c6 = 0;
                }

                int r7 = i + 2;
                int c7 = j + 2; 
                if (r7 >= picture.height()) {
                    r7 = r7 - picture.height();
                }
                if (c7 >= picture.width()) {
                    c7 = c7 -  picture.width();
                }

                int r8 = i + 3;
                int c8 = j + 3; 
                if (r8 >= picture.height()) {
                    r8 = r8 - picture.height();
                }
                if (c8 >= picture.width()) {
                    c8 = c8 - picture.width();
                }
                int r9 = i + 4;
                int c9 = j + 4; 
                if (r9 >= picture.height()) {
                    r9 = r9 - picture.height();
                }
                if (c9 >= picture.width()) {
                    c9 = c9 - picture.width();
                }

                int r = (int) Math.round((picture.get(c1, r1).getRed() + picture.get(c2, r2).getRed() + picture.get(c3, r3).getRed() + 
                    picture.get(c4, r4).getRed() + picture.get(c5, r5).getRed() + picture.get(c6, r6).getRed() +
                    picture.get(c7, r7).getRed() + picture.get(c8, r8).getRed() + picture.get(c9, r9).getRed()) * 1.0 / 9);

                int g = (int) Math.round((picture.get(c1, r1).getGreen() + picture.get(c2, r2).getGreen() + picture.get(c3, r3).getGreen() + 
                    picture.get(c4, r4).getGreen() + picture.get(c5, r5).getGreen() + picture.get(c6, r6).getGreen() +
                    picture.get(c7, r7).getGreen() + picture.get(c8, r8).getGreen() + picture.get(c9, r9).getGreen()) * 1.0 / 9);

                int b = (int) Math.round((picture.get(c1, r1).getBlue() + picture.get(c2, r2).getBlue() + picture.get(c3, r3).getBlue() + 
                    picture.get(c4, r4).getBlue() + picture.get(c5, r5).getBlue() + picture.get(c6, r6).getBlue() +
                    picture.get(c7, r7).getBlue() + picture.get(c8, r8).getBlue() + picture.get(c9, r9).getBlue()) * 1.0 / 9);

                if (r < 0) {
                    r = 0;
                }
                if (r > 255) {
                    r = 255;
                }

                if (g < 0) {
                    g = 0;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b < 0) {
                    b = 0;
                }
                if (b > 255) {
                    b = 255;
                }
                pic.set(j, i, new Color(r, g, b));
            }
        }
        return pic; 
    }
    // Test client (ungraded).
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        Picture sharpenPic = motionBlur(picture);
        sharpenPic.show();
    }
}