package java.come.esde.Cube.util;

public class IdGenerator {
    private static int currentId;
    public static int increment(){
        return ++currentId;
    }
}
