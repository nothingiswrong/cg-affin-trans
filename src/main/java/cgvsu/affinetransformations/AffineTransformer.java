package main.java.cgvsu.affinetransformations;

import main.java.cgvsu.affinetransformations.enums.AngleMetric;
import main.java.cgvsu.affinetransformations.enums.RotationDirection;
import main.java.cgvsu.math.matrix.Matrix3f;
import main.java.cgvsu.math.matrix.Matrix4f;
import main.java.cgvsu.math.vector.Vector3f;
import main.java.cgvsu.math.vector.Vector4f;

import static main.java.cgvsu.math.MathUtils.PI;
import static main.java.cgvsu.math.matrix.Matrix3f.*;
import static main.java.cgvsu.math.matrix.Matrix4f.*;

public class AffineTransformer {
    public Matrix3f rotationMatrix3f = new Matrix3f(
            new float[]{
                    1, 0, 0,
                    0, 1, 0,
                    0, 0, 1
            }
    );
    public AngleMetric angleMetric;
    public RotationDirection rotationDirection; //TODO: добавить выбор направления вращения
    public Matrix3f scaleMatrix3f = new Matrix3f(
            new float[]{
                    1, 0, 0,
                    0, 1, 0,
                    0, 0, 1
            }
    );
    public Matrix4f scaleMatrix4f;
    public Matrix4f rotationMatrix4f;
    public Matrix4f translationMatrix = new Matrix4f(
            new float[]{
                    1,0,0,0,
                    0,1,0,0,
                    0,0,1,0,
                    1,1,1,1

            }
    );


    public Vector3f rotateXClockwise(Vector3f vec, float radiansAngle) {
        return null;
    }

    public Vector3f rotateZClockwise(Vector3f vec, float radiansAngle) {
        return null;
    }

    public Vector3f rotateYClockwise(Vector3f vec, float radiansAngle) {
        return null;
    }

    public Vector3f rotateXCounterclockwise(Vector3f vec, float radiansAngle) {
        rotationMatrix3f.val[Matrix3f.M11] = 1;
        rotationMatrix3f.val[Matrix3f.M12] = 0;
        rotationMatrix3f.val[Matrix3f.M13] = 0;
        rotationMatrix3f.val[Matrix3f.M21] = 0;
        rotationMatrix3f.val[Matrix3f.M22] = (float) Math.cos(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M23] = (float) -Math.sin(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M31] = 0;
        rotationMatrix3f.val[Matrix3f.M32] = (float) Math.sin(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M33] = (float) Math.cos(radiansAngle);
        rotationMatrix3f.mul(vec);
        return vec;
    }

    public Vector3f rotateYCounterclockwise(Vector3f vec, float radiansAngle) {
        //TODO: вычислять синус и косинус заранее
        rotationMatrix3f.val[Matrix3f.M11] = (float) Math.cos(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M12] = 0;
        rotationMatrix3f.val[Matrix3f.M13] = (float) -Math.sin(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M21] = 0;
        rotationMatrix3f.val[Matrix3f.M22] = 1;
        rotationMatrix3f.val[Matrix3f.M23] = 0;
        rotationMatrix3f.val[Matrix3f.M31] = (float) Math.sin(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M32] = 0;
        rotationMatrix3f.val[Matrix3f.M33] = (float) Math.cos(radiansAngle);
        rotationMatrix3f.mul(vec);
        return vec;
    }

    public Vector3f rotateZCounterclockwise(Vector3f vec, float radiansAngle) {
        rotationMatrix3f.val[Matrix3f.M11] = (float) Math.cos(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M12] = (float) -Math.sin(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M13] = 0;
        rotationMatrix3f.val[Matrix3f.M21] = (float) Math.sin(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M22] = (float) Math.cos(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M23] = 0;
        rotationMatrix3f.val[Matrix3f.M31] = 0;
        rotationMatrix3f.val[Matrix3f.M32] = 0;
        rotationMatrix3f.val[Matrix3f.M33] = 1;
        rotationMatrix3f.mul(vec);
        return vec;
    }

    public Vector3f rotate(Vector3f vec, Vector3f rotationVector) {
        return null;
    }

    public Vector4f rotateX(Vector4f vec, float radiansAngle) {
        return null;
    }

    public Vector4f rotateYCounterClockwise(Vector4f vec, float radiansAngle) {
        return null;
    }

    public Vector4f rotateZ(Vector4f vec, float radiansAngle) {
        return null;
    }

    public Vector4f rotate(Vector4f vec, Vector4f rotationVector) {
        return null;
    }

    public Vector3f scaleX(Vector3f vec, float scaleFactorX) {
        scaleMatrix3f.val[Matrix3f.M11] = scaleFactorX;
        scaleMatrix3f.val[Matrix3f.M22] = scaleMatrix3f.val[Matrix3f.M33] = 1;
        rotationMatrix3f.mul(vec);
        return vec;
    }

    public Vector3f scaleY(Vector3f vec, float scaleFactorY) {
        scaleMatrix3f.val[Matrix3f.M22] = scaleFactorY;
        scaleMatrix3f.val[Matrix3f.M11] = scaleMatrix3f.val[Matrix3f.M33] = 1;
        rotationMatrix3f.mul(vec);
        return vec;
    }

    public Vector3f scaleZ(Vector3f vec, float scaleFactorZ) {
        scaleMatrix3f.val[Matrix3f.M33] = scaleFactorZ;
        scaleMatrix3f.val[Matrix3f.M11] = scaleMatrix3f.val[Matrix3f.M22] = 1;
        rotationMatrix3f.mul(vec);
        return vec;
    }

    public Vector3f scale(Vector3f vec, Vector3f scaleVector) {
        scaleMatrix3f.val[Matrix3f.M11] = scaleVector.x;
        scaleMatrix3f.val[Matrix3f.M22] = scaleVector.y;
        scaleMatrix3f.val[Matrix3f.M33] = scaleVector.z;
        rotationMatrix3f.mul(vec);
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

    public Vector4f translateX(Vector3f vec, float distanceX) {
        translationMatrix.val[M14] = distanceX;
        translationMatrix.val[M24] = 0;
        translationMatrix.val[M34] = 0;
        translationMatrix.val[M44] = 1;
        var vec4f = new Vector4f(vec);
        translationMatrix.mul(vec4f);
        return vec4f;
    }

    public Vector4f translateY(Vector3f vec, float distanceY) {
        translationMatrix.val[Matrix4f.M14] = 0;
        translationMatrix.val[Matrix4f.M24] = distanceY;
        translationMatrix.val[Matrix4f.M34] = 0;
        translationMatrix.val[Matrix4f.M44] = 1;
        var vec4f = new Vector4f(vec);
        translationMatrix.mul(vec4f);
        return vec4f;
    }

    public Vector4f translateZ(Vector3f vec, float distanceZ) {
        translationMatrix.val[Matrix4f.M14] = 0;
        translationMatrix.val[Matrix4f.M24] = 0;
        translationMatrix.val[Matrix4f.M34] = distanceZ;
        translationMatrix.val[Matrix4f.M44] = 1;
        var vec4f = new Vector4f(vec);
        translationMatrix.mul(vec4f);
        return vec4f;
    }

    public Vector4f translate(Vector3f vec, Vector3f translationVector) {
        translationMatrix.val[Matrix4f.M14] = translationVector.x;
        translationMatrix.val[Matrix4f.M24] = translationVector.y;
        translationMatrix.val[Matrix4f.M34] = translationVector.z;
        translationMatrix.val[Matrix4f.M44] = 1;
        var vec4f = new Vector4f(vec);
        translationMatrix.mul(vec4f);
        return vec4f;
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

    public float convertDegreesToRadians(float val) {
        return val / 180 * PI;
    }
}