
import array15.Array15;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author PM051
 */
public class Array15Test {

    public Array15Test() {
    }

    @Test
    public void checkShouldThrowExceptionWhenLessThan16() {
        try {
            Array15.check(new int[]{21, 61, 53, 63, 64, 38, 36, 31, 68, 24, 55, 41, 54, 15, 44});
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Числа массиве должны быть больше 15", e.getMessage());
        }
    }

    @Test
    public void checkShouldThrowExceptionWhenRepetitiveNumber() {
        try {
            Array15.check(new int[]{21, 61, 53, 63, 64, 38, 36, 31, 68, 24, 55, 41, 54, 19, 61});
            Assert.fail();
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Число 61 повторяется", e.getMessage());
        }
    }

    @Test
    public void zapolnitShouldThrowExceptionWhenLoops() {
        try {
            Array15.zapolnit(new int[]{23, 61, 53, 63, 64, 38, 36, 31, 68, 24, 55, 41, 54, 19, 44});
            Assert.fail();
        } catch (RuntimeException e) {
            Assert.assertEquals("Произошло зацикливание", e.getMessage());
        }
    }

    @Test
    public void zapolnitShouldWorkFine() {
        Assert.assertArrayEquals(new int[]{33, 46, 32, 18, 43, 62, 63, 22, 38, 54, 40, 53, 48, 43, 41},
                Array15.zapolnit(new int[]{18, 54, 38, 43, 46, 43, 63, 32, 62, 48, 53, 40, 33, 22, 41}));
    }
}
