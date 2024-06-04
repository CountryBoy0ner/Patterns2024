package com.esde.rectangles.service.impl;

import com.esde.rectangles.model.entity.Rectangle;
import com.esde.rectangles.model.entity.RectangleState;
import com.esde.rectangles.service.PointService;
import com.esde.rectangles.service.RectangleService;

import java.util.Arrays;

public class RectangleServiceImpl implements RectangleService{


    @Override
    public double perimeter(Rectangle rectangle) {
        double perimeter = -1;
        if (RectangleState.VALID == RectangleState.state(rectangle)){
            PointService service = new PointServiceImpl();
            double[] sides = service.calculateSides(rectangle);
            perimeter = (sides[0] + sides[1] + sides[2]+ sides[3]);
        }
        return perimeter;
    }

    @Override
    public double area(Rectangle rectangle) {
        double area = -1;
        if (RectangleState.VALID == RectangleState.state(rectangle)) {
            PointService service = new PointServiceImpl();
            double sideAB = service.calculateDistance(rectangle.getPointA(), rectangle.getPointB());
            double sideBC = service.calculateDistance(rectangle.getPointB(), rectangle.getPointC());
            area =sideAB * sideBC;
        }
        return area;
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
