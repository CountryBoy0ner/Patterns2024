package com.esde.rectangles.model;

import com.esde.rectangles.util.IdGenerator;

public abstract class Shape {
    private final int id = IdGenerator.increment();
    public int getId() {
        return id;
    }

}
