package java.come.esde.Cube.service.impl;

import java.come.esde.Cube.model.entity.Point;
import java.come.esde.Cube.model.entity.Rectangle;
import java.come.esde.Cube.model.entity.RectangleState;
import java.come.esde.Cube.model.entity.RectangleType;
import java.come.esde.Cube.service.RectangleService;

public class RectangleServiceImpl implements RectangleService{

    @Override
    public double perimeter(Rectangle rectangle) {
        double sideAB = calculateDistance(rectangle.getPointA(), rectangle.getPointB());
        double sideBC = calculateDistance(rectangle.getPointB(), rectangle.getPointC());
        return (sideAB + sideBC) * 2;
    }


    @Override
    public double area(Rectangle rectangle) {
        double sideAB = calculateDistance(rectangle.getPointA(), rectangle.getPointB());
        double sideBC = calculateDistance(rectangle.getPointB(), rectangle.getPointC());
        return sideAB * sideBC;
    }

    @Override
    public double calculateAngleBetweenLines(Point p1, Point p2, Point p3) {
        double dx1 = p1.getX() - p2.getX();
        double dy1 = p1.getY() - p2.getY();
        double dx2 = p3.getX() - p2.getX();
        double dy2 = p3.getY() - p2.getY();
        double dotProduct = dx1 * dx2 + dy1 * dy2;
        double magnitude1 = Math.sqrt(dx1 * dx1 + dy1 * dy1);
        double magnitude2 = Math.sqrt(dx2 * dx2 + dy2 * dy2);
        return Math.toDegrees(Math.acos(dotProduct / (magnitude1 * magnitude2)));
    }

    @Override
    public double calculateDistance(Point a, Point b) {
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public  RectangleState state(Rectangle rectangle) {
        Point a = rectangle.getPointA();
        Point b = rectangle.getPointB();
        Point c = rectangle.getPointC();
        Point d = rectangle.getPointD();
        if (this.calculateAngleBetweenLines(a, b, c) == 180.0
                || this.calculateAngleBetweenLines(b, c, d) == 180.0
                || this.calculateAngleBetweenLines(c, d, a) == 180.0
                || this.calculateAngleBetweenLines(d, a, b) == 180.0) {
            return RectangleState.INVALID;
        }
        return RectangleState.VALID;
    }

    @Override
    public boolean isAllSidesEqual(Rectangle rectangle) {
        double sideAB = calculateDistance(rectangle.getPointA(), rectangle.getPointB());
        double sideBC = calculateDistance(rectangle.getPointB(), rectangle.getPointC());
        double sideCD = calculateDistance(rectangle.getPointC(), rectangle.getPointD());
        double sideDA = calculateDistance(rectangle.getPointD(), rectangle.getPointA());

        return sideAB == sideBC && sideBC == sideCD && sideCD == sideDA;
    }

    @Override
    public RectangleType type(Rectangle rectangle) {
        double angleABC = this.calculateAngleBetweenLines(rectangle.getPointA(),
                rectangle.getPointB(), rectangle.getPointC());
        if (isAllSidesEqual(rectangle) && angleABC == 90.0) {
            return RectangleType.SQUARE;
        } else if (isAllSidesEqual(rectangle)) {
            return RectangleType.RHOMBUS;
        } else if (RectangleState.VALID == state(rectangle)) {
            return RectangleType.CONVEX;
        } else {
            return RectangleType.TRAPEZOID;
        }
    }
}
