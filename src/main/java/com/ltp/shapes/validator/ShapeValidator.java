package com.ltp.shapes.validator;

import com.ltp.shapes.model.entity.Triangle;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShapeValidator {

    public static boolean validateTriangle(Triangle triangle){
        boolean notNull = triangle != null && triangle.getP1() != null && triangle.getP2() != null && triangle.getP3() != null;
        if(notNull){
            notNull = notNull && !(triangle.getP1().getX() == triangle.getP2().getX() && triangle.getP1().getX() == triangle.getP3().getX());
            notNull = notNull && !(triangle.getP1().getY() == triangle.getP2().getY() && triangle.getP1().getY() == triangle.getP3().getY());
        }
        return notNull;
    }

}
