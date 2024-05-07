package com.esde.rectangles.model.entity;

import com.esde.rectangles.model.Shape;
import com.esde.rectangles.service.impl.PointServiceImpl;
import java.util.Objects;

public class Rectangle extends Shape {

    private Point PointA;
    private Point PointB;
    private Point PointC;
    private Point PointD;
    private RectangleType type = RectangleType.UNKNOWN;// todo
    private RectangleState state = RectangleState.INVALID; // TODO
    private  double side = 0.0;
    private  double weight = 0.0;

    public Rectangle(Point pointA,
                     Point pointB,
                     Point pointC,
                     Point pointD) {
        this.PointA = pointA;
        this.PointB = pointB;
        this.PointC = pointC;
        this.PointD = pointD;
        this.type = RectangleType.type(new Rectangle(pointA, pointB, pointC, pointD));
        this.state =RectangleState.state(new Rectangle(pointA, pointB, pointC, pointD));
        this.side = new PointServiceImpl().calculateDistance(pointA, pointB);
        this.weight = new PointServiceImpl().calculateDistance(pointB, pointC);
    }

    public Rectangle() {}
    public Rectangle(Double[] param) {
        this.PointA = new Point(param[0], param[1]);
        this.PointB = new Point(param[2], param[3]);
        this.PointC = new Point(param[4], param[5]);
        this.PointD = new Point(param[6], param[7]);
        this.type = RectangleType.type(new Rectangle(PointA, PointB, PointC, PointD));
        this.state =RectangleState.state(new Rectangle(PointA, PointB, PointC, PointD));
        this.side = new PointServiceImpl().calculateDistance(PointA, PointB);
        this.weight = new PointServiceImpl().calculateDistance(PointB, PointC);
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

//    public void setType(RectangleType type) {this.type = type;}
//
//    public void setState(RectangleState state) {
//        this.state = state;
//    }
//todo


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return Objects.equals(PointA, rectangle.PointA) && Objects.equals(PointB, rectangle.PointB) && Objects.equals(PointC, rectangle.PointC) && Objects.equals(PointD, rectangle.PointD) && type == rectangle.type && state == rectangle.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PointA, PointB, PointC, PointD, type, state);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "PointA=" + PointA +
                ", PointB=" + PointB +
                ", PointC=" + PointC +
                ", PointD=" + PointD +
                ", type=" + type +
                ", state=" + state +
                '}';
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    //todo refactor object methods
  }
