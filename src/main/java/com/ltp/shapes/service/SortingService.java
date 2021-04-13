package com.ltp.shapes.service;

import com.ltp.shapes.model.entity.Triangle;

import java.util.Comparator;
import java.util.List;

public interface SortingService {
    List<Triangle> sort(List<Triangle> triangles, Comparator<Triangle> method);
}
