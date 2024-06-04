package com.esde.rectangles.service;

import com.esde.rectangles.model.entity.Point;
import com.esde.rectangles.model.entity.Rectangle;

public interface PointService {
    double calculateDistance(Point a, Point b);
    double calculateAngleBetweenLines(Point p1, Point p2, Point p3);
    boolean arePointsCollinear(Point p1, Point p2, Point p3);
    double[] calculateSides(Rectangle rectangle);

}
