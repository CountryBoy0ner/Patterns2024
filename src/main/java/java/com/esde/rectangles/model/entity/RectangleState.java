package java.com.esde.rectangles.model.entity;

import java.com.esde.rectangles.service.PointService;
import java.com.esde.rectangles.service.impl.PointServiceImpl;

public enum RectangleState {
    VALID,
    INVALID;
    public static RectangleState state(Rectangle rectangle) {
        PointService service = new PointServiceImpl();
        Point a = rectangle.getPointA();
        Point b = rectangle.getPointB();
        Point c = rectangle.getPointC();
        Point d = rectangle.getPointD();
        if (service.calculateAngleBetweenLines(a, b, c) == 180.0
                || service.calculateAngleBetweenLines(b, c, d) == 180.0
                || service.calculateAngleBetweenLines(c, d, a) == 180.0
                || service.calculateAngleBetweenLines(d, a, b) == 180.0) {
            return RectangleState.INVALID;
        }
        return RectangleState.VALID;
    }
}
