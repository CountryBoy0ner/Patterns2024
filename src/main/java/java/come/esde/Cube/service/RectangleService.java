package java.come.esde.Cube.service;

import java.come.esde.Cube.model.entity.Point;
import java.come.esde.Cube.model.entity.Rectangle;
import java.come.esde.Cube.model.entity.RectangleState;
import java.come.esde.Cube.model.entity.RectangleType;

public interface RectangleService {
    double perimeter(Rectangle rectangle);
    double area(Rectangle rectangle);

   double calculateAngleBetweenLines(Point p1, Point p2, Point p3);
   RectangleState state(Rectangle rectangle);

    double calculateDistance(Point a, Point b);

    boolean isAllSidesEqual(Rectangle rectangle);

    RectangleType type(Rectangle rectangle);
}
