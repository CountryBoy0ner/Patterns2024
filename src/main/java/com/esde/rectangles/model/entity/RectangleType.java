package com.esde.rectangles.model.entity;

import com.esde.rectangles.service.PointService;
import com.esde.rectangles.service.RectangleService;
import com.esde.rectangles.service.impl.PointServiceImpl;
import com.esde.rectangles.service.impl.RectangleServiceImpl;

public enum RectangleType {
    CONVEX,
    SQUARE,
    RHOMBUS,
    TRAPEZOID,
    UNKNOWN;
    public static  RectangleType type(Rectangle rectangle) {
        PointService pointService = new PointServiceImpl();
        RectangleService rectangleService = new RectangleServiceImpl();
        double angleABC = pointService.calculateAngleBetweenLines(rectangle.getPointA(),
                rectangle.getPointB(), rectangle.getPointC());
        if (rectangleService.isAllSidesEqual(rectangle) && angleABC == 90.0) {
            return RectangleType.SQUARE;
        } else if (rectangleService.isAllSidesEqual(rectangle)) {
            return RectangleType.RHOMBUS;
        } else if (RectangleState.VALID ==   RectangleState.state(rectangle)) {
            return RectangleType.CONVEX;
        } else {
            return RectangleType.TRAPEZOID; // TODO FIX
        }
    }
}
