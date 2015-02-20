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

        // base case: both inputs are one character long so we return the product
        if (x.length() == 1 || y.length() == 1) return Integer.toString(Integer.parseInt(x) * Integer.parseInt(y));

        int n = Math.max(x.length(), y.length());
        int m = n / 2; // ceil of n/2

        // input x gets split, the first half becomes a
        // and the second half becomes b
        String a = x.substring(0, x.length()-n+m);
        String b = x.substring(x.length()-n+m);

        // likewise y gets split. c is the first half
        // and d is the second half
        String c = y.substring(0, y.length()-n+m);
        String d = y.substring(y.length()-n+m);


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
        middle += getPadding((n+1)/2);
        String padding = getPadding(n);

        System.out.println("expected: " + (Integer.parseInt(x) * Integer.parseInt(y)));
        return add(add(z2 + padding, middle), z0);
    }

    private static String format(String x) {
        return x.length() == 0 ? "0" : x;
    }

    // TODO: implement as a string operation
    private  static String add(String x, String y) {
        x = format(x);
        y = format(y);
        return Integer.toString(Integer.parseInt(x) + Integer.parseInt(y));
    }

    // TODO: implement as a string operation
    private static String subtract(String x , String y) {
        x = format(x);
        y = format(y);
        return Integer.toString(Integer.parseInt(x) - Integer.parseInt(y));
    }

    private static String getPadding(int n) {
        char[] zeros = new char[n];
        Arrays.fill(zeros, '0');
        String word =  new String(zeros);
        System.out.println("the padding is: " + word);
        return word;
    }
}

