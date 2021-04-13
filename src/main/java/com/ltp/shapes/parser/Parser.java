package com.ltp.shapes.parser;

import com.ltp.shapes.exception.ShapeException;
import com.ltp.shapes.factory.ShapeFactory;
import com.ltp.shapes.model.entity.Triangle;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Parser {

    public static Triangle parse(String line) throws ShapeException {
        String[] points = line.split("(,|\\s)");
        int[] coords = Arrays.stream(points).mapToInt(Integer::parseInt).toArray();
        return ShapeFactory.getInstance().createShape("triangle", coords);
    }

}
