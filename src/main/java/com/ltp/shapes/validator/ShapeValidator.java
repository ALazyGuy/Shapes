package com.ltp.shapes.validator;

import com.ltp.shapes.model.entity.Triangle;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShapeValidator {

    public static boolean validateTriangle(Triangle triangle){
        return triangle != null && triangle.getP1() != null && triangle.getP2() != null && triangle.getP3() != null;
    }

}
