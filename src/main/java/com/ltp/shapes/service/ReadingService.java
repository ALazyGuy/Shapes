package com.ltp.shapes.service;

import com.ltp.shapes.exception.ShapeException;

public interface ReadingService {
    String read(String filename) throws ShapeException;
}
