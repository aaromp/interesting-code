import java.util.Arrays;

public class Karatsuba {
    // input is expected to be two integers
    public static void main(String[] args) {
        String x = args[0];
        String y = args[1];
        if (x.length() != 0 && y.length() != 0) System.out.println("Karatsuba product: " + multiply(x, y));
    }

    public static String multiply(String x, String y) {
        x = format(x);
        y = format(y);

        System.out.println(x + " " + y);
        // base case: both inputs are one character long so we return the product
        if (x.length() == 1 || y.length() == 1) return Integer.toString(Integer.parseInt(x) * Integer.parseInt(y));

        int n = Math.max(x.length(), y.length());
        int m = (n + 1) / 2;

        // input x gets split, the first half becomes a
        // and the second half becomes b
        int splitX = x.length() - Math.min(x.length(), m);
        String a = x.substring(0, splitX);
        String b = x.substring(splitX);

        // likewise y gets split. c is the first half
        // and d is the second half
        int splitY = y.length() - Math.min(y.length(), m);
        String c = y.substring(0, splitY);
        String d = y.substring(splitY);


        String z0 = multiply(b, d);
        String z1 = multiply(add(a, b), add(c,d));
        String z2 = multiply(a, c);

        System.out.println("n: " + n + " m: " + m);
        System.out.println("a: " + a + " b: " + b + " c: " + c + " d: " + d);
        System.out.println("a+b: " + add(a, b) + " c+d: " + add(c, d));
        System.out.println("(a+b)*(c+d): " + z1);
        System.out.println("b*d: " + z0);
        System.out.println("a*c: " + z2);

        String middle = subtract(subtract(z1, z2), z0);
        System.out.println("middle: " + middle);
        z2 += getPadding(2*m);
        System.out.println("   a*c with " + n + " zeros of padding is: " + z2);
        middle += getPadding(m);
        System.out.println("middle with " + m + " zeros of padding is: " + middle);

        System.out.println("expected: " + (Integer.parseInt(x) * Integer.parseInt(y)));
        return add(add(z2, middle), z0);
    }

    private static String format(String x) {
        return x.length() == 0 ? "0" : x;
    }

    // TODO: Implement string arithmetic operations to handle big integers
    private  static String add(String x, String y) {
        x = format(x);
        y = format(y);
        return Integer.toString(Integer.parseInt(x) + Integer.parseInt(y));
    }

    private static String subtract(String x , String y) {
        x = format(x);
        y = format(y);
        return Integer.toString(Integer.parseInt(x) - Integer.parseInt(y));
    }

    private static String getPadding(int n) {
        char[] zeros = new char[n];
        Arrays.fill(zeros, '0');
        String word =  new String(zeros);
        return word;
    }
}

