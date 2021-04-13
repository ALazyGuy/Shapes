package com.ltp.shapes.observer;

import com.ltp.shapes.exception.ShapeException;

import java.util.EventObject;

public interface Observer {
    void update(EventObject object);
}
