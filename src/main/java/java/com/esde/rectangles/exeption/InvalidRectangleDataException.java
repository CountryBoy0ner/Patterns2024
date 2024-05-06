package java.com.esde.rectangles.exeption;

public class InvalidRectangleDataException extends Exception {
    public InvalidRectangleDataException() {}

    public InvalidRectangleDataException(String message){
        super("Invalid rectangle: " + message);
    }

    public InvalidRectangleDataException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidRectangleDataException(Throwable cause){
        super(cause);
    }
    // todo
}
