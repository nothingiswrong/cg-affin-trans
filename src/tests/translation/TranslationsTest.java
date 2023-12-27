package tests.translation;

import main.java.cgvsu.math.matrix.Matrix3f;
import main.java.cgvsu.math.vector.Vector3f;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TranslationsTest {
    AffineTransformer affineTransformer = new AffineTransformer();
    final static float EPS = 1e-5F;
    public final static Matrix3f testMatrix1 = new Matrix3f(
            new float[]{
                    1, 0, 0,
                    0, 2, 0,
                    0, 0, 3
            }
    );
    public final static Matrix3f testMatrix2 = new Matrix3f(
            new float[]{
                    -5, 0, 0,
                    0, -10, 0,
                    0, 0, -15
            }
    );
    public final static Matrix3f testMatrix3 = new Matrix3f(
            new float[]{
                    -0.17f, 0, 0,
                    0, 1024f, 0,
                    0, 0, -244.23f
            }
    );

    @Test
    void testCase1() {
        var expected = new Vector3f(new float[]{2, 4, 6});
        var testVector = new Vector3f(new float[]{1, 2, 3});
        var translationVector = new Vector3f(new float[]{1, 2, 3});
        affineTransformer.translate(testVector, translationVector);
        assertEquals(testVector, expected);
    }

    @Test
    void testCase2() {
        var expected = new Vector3f(new float[]{0.83f, 2202, -6.55555f});
        var testVector = new Vector3f(new float[]{1, 2, 6});
        var translationVector = new Vector3f(new float[]{-0.17f, 2200, -12.55555f});
        affineTransformer.translate(testVector, translationVector);
        assertTrue(expected.epsEquals(testVector, EPS));
    }
    @Test
    void testCase3() {
        var expected = new Vector3f(new float[]{-10, -20, -30});
        var testVector = new Vector3f(new float[]{-5, -10, -15});
        var translationVector = new Vector3f(new float[]{-5, -10, -15});
        affineTransformer.translate(testVector, translationVector);
        assertTrue(expected.epsEquals(testVector, EPS));
    }
}
