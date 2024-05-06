package java.com.esde.rectangles.service;

import java.com.esde.rectangles.model.entity.Point;

public interface PointService {
    double calculateDistance(Point a, Point b);
    double calculateAngleBetweenLines(Point p1, Point p2, Point p3);
}
