package com.esde.rectangles.model.entity;

import com.esde.rectangles.service.PointService;
import com.esde.rectangles.service.impl.PointServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public enum RectangleState {


    VALID,
    INVALID;
    private static final Logger logger = LogManager.getLogger();



    private static final double EPSILON = 1e-10; // Задаем значение EPSILON

    public static RectangleState state(Rectangle rectangle) {
        PointService service = new PointServiceImpl();
        Point a = rectangle.getPointA();
        Point b = rectangle.getPointB();
        Point c = rectangle.getPointC();
        Point d = rectangle.getPointD();
        double angle1 = service.calculateAngleBetweenLines(a, b, c);
        double angle2 = service.calculateAngleBetweenLines(b, c, d);
        double angle3 = service.calculateAngleBetweenLines(c, d, a);
        double angle4 = service.calculateAngleBetweenLines(d, a, b);
        double sideAB = service.calculateDistance(a, b);
        double sideBC = service.calculateDistance(b, c);
        double sideCD = service.calculateDistance(c, d);
        double sideDA = service.calculateDistance(d, a);

        if (service.arePointsCollinear(a, b, c)
                || service.arePointsCollinear(b, c, d)
                || service.arePointsCollinear(c,d,a)
                || service.arePointsCollinear(d,a,b)) {
            logger.info("Несколько точек лежат на одной плоскасти");
            return RectangleState.INVALID;
        }
        return RectangleState.VALID;
    }
}
