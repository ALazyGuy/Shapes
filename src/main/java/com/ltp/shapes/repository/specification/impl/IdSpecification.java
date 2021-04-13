package com.ltp.shapes.repository.specification.impl;

import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.repository.specification.Specification;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IdSpecification implements Specification {

    private int id;

    @Override
    public boolean specified(Triangle triangle) {
        return (id == triangle.getId());
    }
}
