package com.ltp.shapes.repository;

import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.repository.specification.Specification;

import java.util.List;

public interface TriangleRepository {
    void save(Triangle triangle);
    void remove(Triangle triangle);
    List<Triangle> query(Specification specification);
    List<Triangle> getAll();
}
