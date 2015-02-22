import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;

public class KaratsubaTest {

    @Test
    public void test_multiplication() {
        Random generator = new Random();
        int randomDigit = Math.abs((generator.nextInt() % 9) + 1);
        int randomNumber1 = Math.abs((generator.nextInt() % 1000) + 1);
        int randomNumber2 = Math.abs((generator.nextInt() % 1000) + 1);
        String randomDigitString = Integer.toString(randomDigit);
        String randomNumber1String = Integer.toString(randomNumber1);
        String randomNumber2String = Integer.toString(randomNumber2);

        Assert.assertEquals("trivial test: multiplying a single digit by anything", Karatsuba.multiply(randomDigitString, randomNumber1String), Integer.toString(randomDigit*randomNumber1));
        Assert.assertEquals("mutiplying 0 and anything", Karatsuba.multiply("0", randomNumber2String), Integer.toString(0));
        Assert.assertEquals("multiplying 1234 and 4567", Karatsuba.multiply("1234", "4567"), Integer.toString(1234*4567));

        for (int trial = 0; trial < 100000; trial++) {
            randomNumber1 = Math.abs((generator.nextInt() % 100000) + 1);
            randomNumber2 = Math.abs((generator.nextInt() % 10000) + 1);
            randomNumber1String = Integer.toString(randomNumber1);
            randomNumber2String = Integer.toString(randomNumber2);

            Assert.assertEquals("multiplying two random numbers", Karatsuba.multiply(randomNumber1String, randomNumber2String), Integer.toString(randomNumber1*randomNumber2));
        }
    }
}
