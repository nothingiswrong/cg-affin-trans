package main.java.cgvsu.affinetransformations;

import main.java.cgvsu.affinetransformations.enums.AngleMetric;
import main.java.cgvsu.affinetransformations.enums.RotationDirection;
import main.java.cgvsu.math.matrix.Matrix3f;
import main.java.cgvsu.math.matrix.Matrix4f;
import main.java.cgvsu.math.vector.Vector3f;
import main.java.cgvsu.math.vector.Vector4f;

import static main.java.cgvsu.math.MathUtils.PI;
import static main.java.cgvsu.math.matrix.Matrix4f.*;

public class AffineTransformer {
    private final Vector3f templateVector3f = new Vector3f();
    private final Vector4f templateVector4f = new Vector4f(new Vector3f());
    
    public Matrix3f rotationMatrix3f = new Matrix3f(
            new float[]{
                    1, 0, 0,
                    0, 1, 0,
                    0, 0, 1
            }
    );
    private AngleMetric angleMetric;
    private RotationDirection rotationDirection;
    private final Matrix3f scaleMatrix3f = new Matrix3f(
            new float[]{
                    1, 0, 0,
                    0, 1, 0,
                    0, 0, 1
            }
    );
    private final Matrix4f scaleMatrix4f = new Matrix4f(
            new float[] {
                    1, 0, 0, 0,
                    0, 1, 0, 0,
                    0, 0, 1, 0,
                    0, 0, 0, 1
            }
    );
    private final Matrix4f rotationMatrix4f = new Matrix4f(
            new float[] {
                    1, 0, 0, 0, 
                    0, 1, 0, 0,
                    0, 0, 1, 0,
                    0, 0, 0, 1
            }
    );
    private final Matrix4f translationMatrix = new Matrix4f(
            new float[]{
                    1, 0, 0, 0, // расположение элементов именно  такое в угоду библиотечной реализации Matrix4f
                    0, 1, 0, 0,
                    0, 0, 1, 0,
                    1, 1, 1, 1

            }
    );

    public Vector3f rotateX(Vector3f vec, float angle) {
        if (angleMetric == AngleMetric.DEGREES) { //TODO: переписать это убожество под switch
           if (rotationDirection == RotationDirection.COUNTERCLOCKWISE) {
               return rotateXCounterclockwise(vec, angle);
           } else {
               return rotateXCounterclockwise(vec, -angle);
           }
        } else if (rotationDirection == RotationDirection.COUNTERCLOCKWISE) {
            return rotateXCounterclockwise(vec, (float)Math.toRadians(angle));
        }
        return rotateXCounterclockwise(vec, (float) Math.toRadians(-angle));
    }

    public Vector3f rotateY(Vector3f vec, float angle) {
        if (angleMetric == AngleMetric.DEGREES) {
            if (rotationDirection == RotationDirection.COUNTERCLOCKWISE) {
                return rotateYCounterclockwise(vec, angle);
            } else {
                return rotateYCounterclockwise(vec, -angle);
            }
        } else if (rotationDirection == RotationDirection.COUNTERCLOCKWISE) {
            return rotateYCounterclockwise(vec, (float)Math.toRadians(angle));
        }
        return rotateYCounterclockwise(vec, (float) Math.toRadians(-angle));
    }

    public Vector3f rotateZ (Vector3f vec, float angle) {
        if (angleMetric == AngleMetric.DEGREES) {
            if (rotationDirection == RotationDirection.COUNTERCLOCKWISE) {
                return rotateZCounterclockwise(vec, angle);
            } else {
                return rotateZCounterclockwise(vec, -angle);
            }
        } else if (rotationDirection == RotationDirection.COUNTERCLOCKWISE) {
            return rotateZCounterclockwise(vec, (float)Math.toRadians(angle));
        }
        return rotateZCounterclockwise(vec, (float) Math.toRadians(-angle));
    }


    public Vector3f rotateXCounterclockwise(Vector3f vec, float radiansAngle) {
        var cos = (float) Math.cos(radiansAngle);
        var sin = (float) Math.sin(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M11] = 1;
        rotationMatrix3f.val[Matrix3f.M12] = 0;
        rotationMatrix3f.val[Matrix3f.M13] = 0;
        rotationMatrix3f.val[Matrix3f.M21] = 0;
        rotationMatrix3f.val[Matrix3f.M22] = cos;
        rotationMatrix3f.val[Matrix3f.M23] = -sin;
        rotationMatrix3f.val[Matrix3f.M31] = 0;
        rotationMatrix3f.val[Matrix3f.M32] = sin;
        rotationMatrix3f.val[Matrix3f.M33] = cos;
        rotationMatrix3f.mul(vec);
        return vec;
    }

    public Vector3f rotateYCounterclockwise(Vector3f vec, float radiansAngle) {
        var cos = (float) Math.cos(radiansAngle);
        var sin = (float) Math.sin(radiansAngle);
        rotationMatrix3f.val[Matrix3f.M11] = cos;
        rotationMatrix3f.val[Matrix3f.M12] = 0;
        rotationMatrix3f.val[Matrix3f.M13] = -sin;
        rotationMatrix3f.val[Matrix3f.M21] = 0;
        rotationMatrix3f.val[Matrix3f.M22] = 1;
        rotationMatrix3f.val[Matrix3f.M23] = 0;
        rotationMatrix3f.val[Matrix3f.M31] = sin;
        rotationMatrix3f.val[Matrix3f.M32] = 0;
        rotationMatrix3f.val[Matrix3f.M33] = cos;
        rotationMatrix3f.mul(vec);
        return vec;
    }

    public Vector3f rotateZCounterclockwise(Vector3f vec, float radiansAngle) {
        var cos = (float) Math.cos(radiansAngle);
        var sin = (float) Math.sin(radiansAngle);

        rotationMatrix3f.val[Matrix3f.M11] = cos;
        rotationMatrix3f.val[Matrix3f.M12] = -sin;
        rotationMatrix3f.val[Matrix3f.M13] = 0;
        rotationMatrix3f.val[Matrix3f.M21] = sin;
        rotationMatrix3f.val[Matrix3f.M22] = cos;
        rotationMatrix3f.val[Matrix3f.M23] = 0;
        rotationMatrix3f.val[Matrix3f.M31] = 0;
        rotationMatrix3f.val[Matrix3f.M32] = 0;
        rotationMatrix3f.val[Matrix3f.M33] = 1;

        rotationMatrix3f.mul(vec);
        return vec;
    }
    
    
    public Vector4f rotateXCounterclockwise(Vector4f vec, float radiansAngle) {
        var cos = (float) Math.cos(radiansAngle);
        var sin = (float) Math.sin(radiansAngle);
        rotationMatrix4f.val[Matrix4f.M11] = 1;
        rotationMatrix4f.val[Matrix4f.M12] = 0;
        rotationMatrix4f.val[Matrix4f.M13] = 0;
        rotationMatrix4f.val[Matrix4f.M21] = 0;
        rotationMatrix4f.val[Matrix4f.M22] = cos;
        rotationMatrix4f.val[Matrix4f.M23] = -sin;
        rotationMatrix4f.val[Matrix4f.M31] = 0;
        rotationMatrix4f.val[Matrix4f.M32] = sin;
        rotationMatrix4f.val[Matrix4f.M33] = cos;
        rotationMatrix4f.mul(vec);
        return vec;
    }


    public Vector4f rotateX(Vector4f vec, float radiansAngle) {
        return null;
    }
    
    public Vector4f rotateYCounterclockwise(Vector4f vec, float radiansAngle) {
        var cos = (float) Math.cos(radiansAngle);
        var sin = (float) Math.sin(radiansAngle);
        rotationMatrix4f.val[Matrix4f.M11] = cos;
        rotationMatrix4f.val[Matrix4f.M12] = 0;
        rotationMatrix4f.val[Matrix4f.M13] = -sin;
        rotationMatrix4f.val[Matrix4f.M21] = 0;
        rotationMatrix4f.val[Matrix4f.M22] = 1;
        rotationMatrix4f.val[Matrix4f.M23] = 0;
        rotationMatrix4f.val[Matrix4f.M31] = sin;
        rotationMatrix4f.val[Matrix4f.M32] = 0;
        rotationMatrix4f.val[Matrix4f.M33] = cos;
        rotationMatrix4f.mul(vec);
        return vec;
    }


    public Vector4f rotateZCounterclockwise(Vector4f vec, float radiansAngle) {
        var cos = (float) Math.cos(radiansAngle);
        var sin = (float) Math.sin(radiansAngle);

        rotationMatrix4f.val[Matrix4f.M11] = cos;
        rotationMatrix4f.val[Matrix4f.M12] = -sin;
        rotationMatrix4f.val[Matrix4f.M13] = 0;
        rotationMatrix4f.val[Matrix4f.M21] = sin;
        rotationMatrix4f.val[Matrix4f.M22] = cos;
        rotationMatrix4f.val[Matrix4f.M23] = 0;
        rotationMatrix4f.val[Matrix4f.M31] = 0;
        rotationMatrix4f.val[Matrix4f.M32] = 0;
        rotationMatrix4f.val[Matrix4f.M33] = 1;
        
        rotationMatrix4f.mul(vec);
        return vec;
    }

    public Vector4f rotateZ(Vector4f vec, float radiansAngle) {
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
        scaleMatrix3f.mul(vec);
        return vec;
    }


    public Vector4f scaleX(Vector4f vec, float scaleFactorX) {
        scaleMatrix4f.val[Matrix4f.M11] = scaleFactorX;
        scaleMatrix4f.val[Matrix4f.M22] = scaleMatrix4f.val[Matrix4f.M33] = scaleMatrix4f.val[Matrix4f.M44]  = 1;
        scaleMatrix4f.mul(vec);
        return vec;
    }

    public Vector4f scaleY(Vector4f vec, float scaleFactorY) {
        scaleMatrix4f.val[Matrix4f.M22] = scaleFactorY;
        scaleMatrix4f.val[Matrix4f.M11] = scaleMatrix4f.val[Matrix4f.M33] = scaleMatrix4f.val[Matrix4f.M44]  = 1;
        scaleMatrix4f.mul(vec);
        return null;
    }

    public Vector4f scaleZ(Vector4f vec, float scaleFactorZ) {
        scaleMatrix4f.val[Matrix4f.M33] = scaleFactorZ;
        scaleMatrix4f.val[Matrix4f.M11] = scaleMatrix4f.val[Matrix4f.M22] = scaleMatrix4f.val[Matrix4f.M44] = 1;
        scaleMatrix4f.mul(vec);
        return vec;
    }

    public Vector4f scale(Vector4f vec, Vector4f scaleVector) {
        scaleMatrix4f.val[Matrix4f.M11] = scaleVector.x;
        scaleMatrix4f.val[Matrix4f.M22] = scaleVector.y;
        scaleMatrix4f.val[Matrix4f.M33] = scaleVector.z;
        scaleMatrix4f.mul(vec);
        return vec;
    }

    public Vector4f translateX(Vector3f vec, float distanceX) {
        translationMatrix.val[M14] = distanceX;
        translationMatrix.val[M24] = 0;
        translationMatrix.val[M34] = 0;
        translationMatrix.val[M44] = 1;

        templateVector4f.x = vec.x;
        templateVector4f.y = vec.y;
        templateVector4f.z = vec.z;

        translationMatrix.mul(templateVector4f);

        vec.x = templateVector4f.x;
        vec.y = templateVector4f.y;
        vec.z = templateVector4f.z;

        return templateVector4f;
    }

    public Vector4f translateY(Vector3f vec, float distanceY) {
        translationMatrix.val[Matrix4f.M14] = 0;
        translationMatrix.val[Matrix4f.M24] = distanceY;
        translationMatrix.val[Matrix4f.M34] = 0;
        translationMatrix.val[Matrix4f.M44] = 1;

        templateVector4f.x = vec.x;
        templateVector4f.y = vec.y;
        templateVector4f.z = vec.z;

        translationMatrix.mul(templateVector4f);

        vec.x = templateVector4f.x;
        vec.y = templateVector4f.y;
        vec.z = templateVector4f.z;

        return templateVector4f;
    }

    public Vector4f translateZ(Vector3f vec, float distanceZ) {
        translationMatrix.val[Matrix4f.M14] = 0;
        translationMatrix.val[Matrix4f.M24] = 0;
        translationMatrix.val[Matrix4f.M34] = distanceZ;
        translationMatrix.val[Matrix4f.M44] = 1;

        templateVector4f.x = vec.x;
        templateVector4f.y = vec.y;
        templateVector4f.z = vec.z;

        translationMatrix.mul(templateVector4f);

        vec.x = templateVector4f.x;
        vec.y = templateVector4f.y;
        vec.z = templateVector4f.z;

        return templateVector4f;
    }

    public Vector4f translate(Vector3f vec, Vector3f translationVector) {
        translationMatrix.val[Matrix4f.M14] = translationVector.x;
        translationMatrix.val[Matrix4f.M24] = translationVector.y;
        translationMatrix.val[Matrix4f.M34] = translationVector.z;
        translationMatrix.val[Matrix4f.M44] = 1;

        templateVector4f.x = vec.x;
        templateVector4f.y = vec.y;
        templateVector4f.z = vec.z;

        translationMatrix.mul(templateVector4f);

        vec.x = templateVector4f.x;
        vec.y = templateVector4f.y;
        vec.z = templateVector4f.z;

        return templateVector4f;
    }

    public Vector4f translateX(Vector4f vec, float distanceX) {
        translationMatrix.val[M14] = distanceX;
        translationMatrix.val[M24] = 0;
        translationMatrix.val[M34] = 0;
        translationMatrix.val[M44] = 1;
        translationMatrix.mul(vec);
        return vec;
    }

    public Vector4f translateY(Vector4f vec, float distanceY) {
        translationMatrix.val[Matrix4f.M14] = 0;
        translationMatrix.val[Matrix4f.M24] = distanceY;
        translationMatrix.val[Matrix4f.M34] = 0;
        translationMatrix.val[Matrix4f.M44] = 1;
        translationMatrix.mul(vec);
        return vec;
    }

    public Vector4f translateZ(Vector4f vec, float distanceZ) {
        translationMatrix.val[Matrix4f.M14] = 0;
        translationMatrix.val[Matrix4f.M24] = 0;
        translationMatrix.val[Matrix4f.M34] = distanceZ;
        translationMatrix.val[Matrix4f.M44] = 1;
        translationMatrix.mul(vec);
        return vec;
    }

    public Vector4f translate(Vector4f vec, Vector4f translationVector) {
        translationMatrix.val[Matrix4f.M14] = translationVector.x;
        translationMatrix.val[Matrix4f.M24] = translationVector.y;
        translationMatrix.val[Matrix4f.M34] = translationVector.z;
        translationMatrix.val[Matrix4f.M44] = 1;
        translationMatrix.mul(vec);
        return vec;
    }

    private float convertDegreesToRadians(float val) {
        return val / 180.0f * PI;
    }

    public AngleMetric getAngleMetric() {
        return angleMetric;
    }

    public void setAngleMetric(AngleMetric angleMetric) {
        this.angleMetric = angleMetric;
    }

    public RotationDirection getRotationDirection() {
        return rotationDirection;
    }

    public void setRotationDirection(RotationDirection rotationDirection) {
        this.rotationDirection = rotationDirection;
    }
}