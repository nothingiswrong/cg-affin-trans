package main.java.cgvsu.affinetransformations;

import main.java.cgvsu.math.matrix.Matrix3f;
import main.java.cgvsu.math.matrix.Matrix4f;
import main.java.cgvsu.math.vector.Vector3f;
import main.java.cgvsu.math.vector.Vector4f;

import static main.java.cgvsu.math.matrix.Matrix3f.*;

public class AffineTransformer {
    public static Matrix3f rotationMatrix3f;
    public static Matrix3f scaleMatrix3f = new Matrix3f(
            new float[]{
                    1, 0, 0,
                    0, 1, 0,
                    0, 0, 1
            }
    );
    public static Matrix4f scaleMatrix4f;
    public static Matrix4f rotationMatrix4f;
    public static Matrix4f translationMatrix;

    public Vector3f rotateX(Vector3f vec, float degreesAngle) {
        return null;
    }

    public Vector3f rotateY(Vector3f vec, float degreesAngle) {
        return null;
    }

    public Vector3f rotateZ(Vector3f vec, float degreesAngle) {
        return null;
    }

    public Vector3f rotate(Vector3f vec, Vector3f rotationVector) {
        return null;
    }

    public Vector4f rotateX(Vector4f vec, float degreesAngle) {
        return null;
    }

    public Vector4f rotateY(Vector4f vec, float degreesAngle) {
        return null;
    }

    public Vector4f rotateZ(Vector4f vec, float degreesAngle) {
        return null;
    }

    public Vector4f rotate(Vector4f vec, Vector4f rotationVector) {
        return null;
    }

    public Vector3f scaleX(Vector3f vec, float scaleFactorX) {
        scaleMatrix3f.val[M11] = scaleFactorX;
        scaleMatrix3f.val[M22] = scaleMatrix3f.val[M33] = 1;
        Matrix3f.mul(vec, scaleMatrix3f);
        return vec;
    }

    public Vector3f scaleY(Vector3f vec, float scaleFactorY) {
        scaleMatrix3f.val[M22] = scaleFactorY;
        scaleMatrix3f.val[M11] = scaleMatrix3f.val[M33] = 1;
        Matrix3f.mul(vec, scaleMatrix3f);
        return vec;
    }

    public Vector3f scaleZ(Vector3f vec, float scaleFactorZ) {
        scaleMatrix3f.val[M33] = scaleFactorZ;
        scaleMatrix3f.val[M11] = scaleMatrix3f.val[M22] = 1;
        Matrix3f.mul(vec, scaleMatrix3f);
        return vec;
    }

    public Vector3f scale(Vector3f vec, Vector3f scaleVector) {
        scaleMatrix3f.val[M11] = scaleVector.x;
        scaleMatrix3f.val[M22] = scaleVector.y;
        scaleMatrix3f.val[M33] = scaleVector.z;
        Matrix3f.mul(vec, scaleMatrix3f);
        return vec;
    }


    public Vector4f scaleX(Vector4f vec, float scaleFactorX) {
        return null;
    }

    public Vector4f scaleY(Vector4f vec, float scaleFactorY) {
        return null;
    }

    public Vector4f scaleZ(Vector4f vec, float scaleFactorZ) {
        return null;
    }

    public Vector4f scale(Vector4f vec, Vector4f scaleVector) {
        return null;
    }

    public Vector3f translateX(Vector3f vec, float distanceX) {
        return null;
    }

    public Vector3f translateY(Vector3f vec, float distanceY) {
        return null;
    }

    public Vector3f translateZ(Vector3f vec, float distanceZ) {
        return null;
    }

    public Vector3f translate(Vector3f vec, Vector3f translateVector) {
        return null;
    }

    public Vector4f translateX(Vector4f vec, float distanceX) {
        return null;
    }

    public Vector4f translateY(Vector4f vec, float distanceY) {
        return null;
    }

    public Vector4f translateZ(Vector4f vec, float distanceZ) {
        return null;
    }

    public Vector4f translate(Vector4f vec, Vector4f translateVector) {
        return null;
    }
}