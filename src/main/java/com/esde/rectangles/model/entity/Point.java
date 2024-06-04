package com.esde.rectangles.model.entity;

import com.esde.rectangles.util.IdGenerator;

import java.util.Objects;

public class Point {
    private final int id = IdGenerator.increment();
    private double x;
    private double y;


    public Point() {}

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }


    public int getId() {
        return id;
    }
@Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    } //TODO think to add "Point"

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return id == point.id && Double.compare(x, point.x) == 0 && Double.compare(y, point.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, x, y);
    }
}
