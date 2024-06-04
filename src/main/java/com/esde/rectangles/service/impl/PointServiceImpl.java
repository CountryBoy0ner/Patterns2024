package com.esde.rectangles.service.impl;

import com.esde.rectangles.model.entity.Point;
import com.esde.rectangles.model.entity.Rectangle;
import com.esde.rectangles.service.PointService;

public class PointServiceImpl implements PointService {
    @Override
    public double calculateDistance(Point a, Point b) {
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
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
    public boolean arePointsCollinear(Point p1, Point p2, Point p3) {
        double area = 0.5 * ((p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p3.getX() - p1.getX()) * (p2.getY() - p1.getY()));
        return Math.abs(area) < 1e-10; //EPSILON
    }

    @Override
    public double[] calculateSides(Rectangle rectangle) {
        PointService service = new PointServiceImpl();
        double sideAB = service.calculateDistance(rectangle.getPointA(), rectangle.getPointB());
        double sideBC = service.calculateDistance(rectangle.getPointB(), rectangle.getPointC());
        double sideCD = service.calculateDistance(rectangle.getPointC(), rectangle.getPointD());
        double sideDA = service.calculateDistance(rectangle.getPointD(), rectangle.getPointA());
        return new double[] {sideAB, sideBC, sideCD, sideDA};
    }
}
