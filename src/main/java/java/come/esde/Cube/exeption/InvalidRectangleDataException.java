package java.come.esde.Cube.exeption;

public class InvalidRectangleDataException extends Exception {
    public InvalidRectangleDataException() {

    }

    public InvalidRectangleDataException(String message){
        super("Invalid cube: " + message);
    }

    public InvalidRectangleDataException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidRectangleDataException(Throwable cause){
        super(cause);
    }
    // todo
}
