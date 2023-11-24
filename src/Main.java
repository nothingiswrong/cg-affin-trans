import main.java.cgvsu.affinetransformations.AffineTransformer;
import main.java.cgvsu.math.matrix.Matrix3f;
import main.java.cgvsu.math.vector.Vector3f;

public class Main {
    public static void main(String[] args) {
        var vec = new Vector3f();
        vec.x = 1;
        vec.y = 2;
        vec.z = 3;
        var scvec = new Vector3f();
        scvec.x = 2;
        scvec.y = 5;
        scvec.z = 3;
        var aff = new AffineTransformer();
        aff.translateZ(vec, 5f);
    }
}