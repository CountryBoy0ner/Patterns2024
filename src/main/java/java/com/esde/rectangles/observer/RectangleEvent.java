package java.com.esde.rectangles.observer;

import java.com.esde.rectangles.model.entity.Rectangle;
import java.util.EventObject;

public class RectangleEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */


    public RectangleEvent(Object source) {
        super(source);
    }
    @Override
    public Rectangle getSource(){
        return (Rectangle) super.getSource();
    }
}
// todo explore