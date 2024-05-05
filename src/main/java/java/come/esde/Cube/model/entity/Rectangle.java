package java.come.esde.Cube.model.entity;

import java.come.esde.Cube.model.Shape;
import java.come.esde.Cube.service.impl.RectangleServiceImpl;
import java.lang.reflect.Type;

public class Rectangle extends Shape {

    private Point PointA;
    private Point PointB;
    private Point PointC;
    private Point PointD;;
    private RectangleType type = RectangleType.UNKNOWN;

    private RectangleState state = RectangleState.INVALID; // TODO

    public Rectangle(Point pointA,
                     Point pointB,
                     Point pointC,
                     Point pointD) {
        PointA = pointA;
        PointB = pointB;
        PointC = pointC;
        PointD = pointD;
        type = new RectangleServiceImpl().type(new Rectangle(pointA, pointB, pointC, pointD));
        state = new RectangleServiceImpl().state(new Rectangle(pointA, pointB, pointC, pointD));
    }


    public Point getPointA() {
        return PointA;
    }

    public Point getPointB() {
        return PointB;
    }

    public Point getPointC() {
        return PointC;
    }

    public Point getPointD() {
        return PointD;
    }

    public RectangleType getType() {
        return type;
    }
    public RectangleState getState() {
        return state;
    }

    public void setPointA(Point pointA) {
        PointA = pointA;
    }

    public void setPointB(Point pointB) {
        PointB = pointB;
    }

    public void setPointC(Point pointC) {
        PointC = pointC;
    }

    public void setPointD(Point pointD) {
        PointD = pointD;
    }

    public void setType(RectangleType type) {this.type = type;}

    public void setState(RectangleState state) {
        this.state = state;
    }


//todo object methods
  }
