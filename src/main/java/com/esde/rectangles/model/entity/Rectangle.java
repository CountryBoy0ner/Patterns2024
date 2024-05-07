package com.esde.rectangles.model.entity;

import com.esde.rectangles.model.Shape;
import com.esde.rectangles.observer.Observable;
import com.esde.rectangles.observer.RectangleObserver;
import com.esde.rectangles.observer.impl.RectangleObserverImpl;

import java.util.Objects;

public class Rectangle extends Shape implements Observable {


    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private RectangleType type = RectangleType.UNKNOWN;
    private RectangleState state = RectangleState.INVALID;
    private RectangleObserver observer = new RectangleObserverImpl();

    public Rectangle() {}
    public Rectangle(Point pointA,
                     Point pointB,
                     Point pointC,
                     Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
        this.type = RectangleType.type(this);
        this.state =RectangleState.state(this);
    }


    public Rectangle(Double[] param) {
        this.pointA = new Point(param[0], param[1]);
        this.pointB = new Point(param[2], param[3]);
        this.pointC = new Point(param[4], param[5]);
        this.pointD = new Point(param[6], param[7]);
        this.type = RectangleType.type(this);
        this.state =RectangleState.state(this);
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public RectangleType getType() {
        return type;
    }
    public RectangleState getState() {
        return state;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
        notifyObservers();
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        notifyObservers();
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
        notifyObservers();
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
        notifyObservers();
    }
    //todo





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return Objects.equals(pointA, rectangle.pointA) && Objects.equals(pointB, rectangle.pointB) && Objects.equals(pointC, rectangle.pointC) && Objects.equals(pointD, rectangle.pointD) && type == rectangle.type && state == rectangle.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, pointC, pointD, type, state);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "PointA=" + pointA +
                ", PointB=" + pointB +
                ", PointC=" + pointC +
                ", PointD=" + pointD +
                ", type=" + type +
                ", state=" + state +
                '}';
    }


    @Override
    public void attach() {
        observer = new RectangleObserverImpl();
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }

    //todo refactor object methods
  }
