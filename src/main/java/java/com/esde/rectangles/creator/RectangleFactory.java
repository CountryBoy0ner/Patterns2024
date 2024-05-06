package java.com.esde.rectangles.creator;

import java.com.esde.rectangles.model.entity.Point;
import java.com.esde.rectangles.model.entity.Rectangle;
import java.util.List;

public interface RectangleFactory {

    Rectangle createRectangle(Point a, Point b, Point c, Point d);
    List<Rectangle> createRectangles(String file);
}
