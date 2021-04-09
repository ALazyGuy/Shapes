package com.ltp.shapes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {

    private int x;
    private int y;

    @Override
    public String toString(){
        return String.format("[%d, %d]", x, y);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != getClass()) return false;
        Point current = (Point)o;
        return current.getX() == x && current.getY() == y;
    }

    @Override
    public int hashCode(){
        int result = 17 * 11 * x + y * 101;
        return result;
    }

}
