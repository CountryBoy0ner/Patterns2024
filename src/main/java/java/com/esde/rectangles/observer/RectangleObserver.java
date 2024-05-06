package java.com.esde.rectangles.observer;

import java.com.esde.rectangles.model.entity.Rectangle;

public interface RectangleObserver {
    void update(Rectangle rectangle);
}
