package com.ltp.shapes.validator;

import com.ltp.shapes.model.entity.Triangle;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShapeValidator {

    private static final String VALID_EXP = "((\\d+\\s+\\d)(,|$)){3}";

    public static boolean validateTriangle(Triangle triangle){
        boolean notNull = triangle != null && triangle.getP1() != null && triangle.getP2() != null && triangle.getP3() != null;
        if(notNull){
            notNull = notNull && !(triangle.getP1().getX() == triangle.getP2().getX() && triangle.getP1().getX() == triangle.getP3().getX());
            notNull = notNull && !(triangle.getP1().getY() == triangle.getP2().getY() && triangle.getP1().getY() == triangle.getP3().getY());
        }
        return notNull;
    }

    public static boolean validateLine(String line){
        boolean isValid = Pattern.matches(VALID_EXP, line);
        return isValid;
    }

    public static boolean validateFile(String filename){
        return (filename != null) && (Files.exists(Paths.get(filename)));
    }

}
