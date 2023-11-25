package main.java.cgvsu.affinetransformations;

import main.java.cgvsu.affinetransformations.enums.AngleMetric;
import main.java.cgvsu.affinetransformations.enums.RotationDirection;
import main.java.cgvsu.model.Model;

public class ModelTransformer {
    public AffineTransformer affineTransformer;

    private RotationDirection rotationDirection;
    private AngleMetric angleMetric;

    public RotationDirection getRotationDirection() {
        return rotationDirection;
    }

    public void setRotationDirection(RotationDirection rotationDirection) {
        this.rotationDirection = rotationDirection;
        affineTransformer.setRotationDirection(rotationDirection);
    }

    public AngleMetric getAngleMetric() {
        return angleMetric;
    }

    public void setAngleMetric(AngleMetric angleMetric) {
        this.angleMetric = angleMetric;
        affineTransformer.setAngleMetric(angleMetric);
    }
    public void rotateX(Model model, float angle) {
        for (var v : model.vertices) {
            affineTransformer.rotateX(v, angle);
        }
    }
    public void rotateZ(Model model, float angle) {
        for (var v : model.vertices) {
            affineTransformer.rotateZ(v, angle);
        }
    }
    public void rotateY(Model model, float angle) {
        for (var v : model.vertices) {
            affineTransformer.rotateY(v, angle);
        }
    }
    public void scaleX(Model model, float scaleFactor) {
        for (var v : model.vertices) {
            affineTransformer.scaleX(v, scaleFactor);
        }
    }

    public void scaleY(Model model, float scaleFactor) {
        for (var v : model.vertices) {
            affineTransformer.scaleY(v, scaleFactor);
        }
    }

    public void scaleZ(Model model, float scaleFactor) {
        for (var v : model.vertices) {
            affineTransformer.scaleZ(v, scaleFactor);
        }
    }

    public void translateX(Model model, float distance) {
        for (var v : model.vertices) {
            affineTransformer.translateX(v, distance);
        }
    }

    public void translateZ(Model model, float distance) {
        for (var v : model.vertices) {
            affineTransformer.translateZ(v, distance);
        }
    }

    public void translateY(Model model, float distance) {
        for (var v : model.vertices) {
            affineTransformer.translateY(v, distance);
        }
    }


}
