import main.java.cgvsu.affinetransformations.AffineTransformer;
import main.java.cgvsu.math.matrix.Matrix3f;
import main.java.cgvsu.math.vector.Vector3f;
import main.java.cgvsu.reader.ObjReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.rmi.MarshalException;

public class Main {
    public static void main(String[] args) throws IOException {
      var s = Files.readString(Path.of("/home/fyodor/IdeaProjects/cg-affin-trans/src/3DModels/Faceform/WrapSkull.obj"));
        var model =  ObjReader.read(s);
        System.out.println();
   }
}