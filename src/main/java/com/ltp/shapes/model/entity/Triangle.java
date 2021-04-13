package com.ltp.shapes.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Triangle {

    private Point p1, p2, p3;
    @Setter(AccessLevel.NONE)
    private int id;

    @Override
    public String toString(){
        return String.format("%d -> { %s, %s, %s }", id, p1.toString(), p2.toString(), p3.toString());
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != getClass()) return false;
        Triangle shape = (Triangle)o;
        return p1.equals(shape.p1) && p2.equals(shape.p2) && p3.equals(shape.p3) && shape.getId() == id;
    }

    @Override
    public int hashCode(){
        int result = 19 * p1.hashCode() + 13 * p2.hashCode() + 31 * p3.hashCode() - id;
        return result;
    }

}
