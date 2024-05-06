package java.com.esde.rectangles.service.impl;

import java.com.esde.rectangles.model.entity.Point;
import java.com.esde.rectangles.service.PointService;

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
}
