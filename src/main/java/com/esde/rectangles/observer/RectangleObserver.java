package com.esde.rectangles.observer;

import com.esde.rectangles.model.entity.Rectangle;

public interface RectangleObserver {
    void update(Rectangle rectangle);
}
