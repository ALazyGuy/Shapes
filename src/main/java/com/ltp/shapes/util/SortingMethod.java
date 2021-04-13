package com.ltp.shapes.util;

import com.ltp.shapes.model.entity.Triangle;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SortingMethod {

    public static final Comparator<Triangle> X_COORDINATE = Comparator.comparingInt(o -> o.getP1().getX());
    public static final Comparator<Triangle> Y_COORDINATE = Comparator.comparingInt(o -> o.getP1().getY());
    public static final Comparator<Triangle> ID = Comparator.comparingInt(o -> o.getId());

}
