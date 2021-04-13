package com.ltp.shapes.repository.specification;

import com.ltp.shapes.model.entity.Triangle;

public interface Specification {
    boolean specified(Triangle triangle);
}
