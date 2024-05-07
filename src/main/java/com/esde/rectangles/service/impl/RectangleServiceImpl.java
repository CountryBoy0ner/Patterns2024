package com.esde.rectangles.service.impl;

import com.esde.rectangles.model.entity.Rectangle;
import com.esde.rectangles.service.PointService;
import com.esde.rectangles.service.RectangleService;

public class RectangleServiceImpl implements RectangleService{

    @Override
    public double perimeter(Rectangle rectangle) {
        PointService service = new PointServiceImpl();
        double sideAB = service.calculateDistance(rectangle.getPointA(), rectangle.getPointB());
        double sideBC = service.calculateDistance(rectangle.getPointB(), rectangle.getPointC());
        return (sideAB + sideBC) * 2;
    }

    @Override
    public double area(Rectangle rectangle) {
        PointService service = new PointServiceImpl();
        double sideAB = service.calculateDistance(rectangle.getPointA(), rectangle.getPointB());
        double sideBC = service.calculateDistance(rectangle.getPointB(), rectangle.getPointC());
        return sideAB * sideBC;
    }

    @Override
    public boolean isAllSidesEqual(Rectangle rectangle) {
        PointService service = new PointServiceImpl();
        double sideAB = service.calculateDistance(rectangle.getPointA(), rectangle.getPointB());
        double sideBC = service.calculateDistance(rectangle.getPointB(), rectangle.getPointC());
        double sideCD = service.calculateDistance(rectangle.getPointC(), rectangle.getPointD());
        double sideDA = service.calculateDistance(rectangle.getPointD(), rectangle.getPointA());

        return sideAB == sideBC && sideBC == sideCD && sideCD == sideDA;
    }
}
