package java.come.esde.Cube.creator;

import java.come.esde.Cube.model.entity.Point;
import java.come.esde.Cube.model.entity.Rectangle;
import java.util.List;

public interface RectangleFactory {
    Rectangle createRectangle(Point a, Point b, Point c, Point d);

    List<Rectangle> createRectangles(String file);
}
