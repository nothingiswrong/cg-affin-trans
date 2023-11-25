package tests.scale;

import main.java.cgvsu.affinetransformations.AffineTransformer;
import main.java.cgvsu.math.vector.Vector3f;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScalesTest {
    AffineTransformer affineTransformer = new AffineTransformer();
    final static float EPS = 1e-5F;

    @Test
    void testCase1() {
        var scaleVector = new Vector3f(new float[]{2, 4, 6});
        var testVector = new Vector3f(new float[]{1, 2, 3});
        var expected = new Vector3f(new float[]{2, 8, 18});
        affineTransformer.scale(testVector, scaleVector);
        assertTrue(expected.epsEquals(testVector, EPS));
    }
    @Test
    void testCase2() {
        var scaleVector = new Vector3f(new float[]{-1.85444f, 0, 8998.33f});
        var testVector = new Vector3f(new float[]{1, 2, 3});
        var expected = new Vector3f(new float[]{-1.85444f, 0, 26994,99f});
        affineTransformer.scale(testVector, scaleVector);
        assertTrue(expected.epsEquals(testVector, EPS));
    } @Test
    void testCase3() {
        var scaleVector = new Vector3f(new float[]{2, 4, 6});
        var testVector = new Vector3f(new float[]{1, 2, 3});
        var expected = new Vector3f(new float[]{2, 8, 18});
        affineTransformer.scale(testVector, scaleVector);
        assertTrue(expected.epsEquals(testVector, EPS));
    }
}
