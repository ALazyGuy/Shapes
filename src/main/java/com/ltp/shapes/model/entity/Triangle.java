package com.ltp.shapes.model.entity;

import com.ltp.shapes.observer.Observable;
import com.ltp.shapes.observer.Observer;
import lombok.*;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

@Getter
public class Triangle implements Observable {

    private Point p1, p2, p3;
    private int id;
    @Getter(AccessLevel.NONE)
    private List<Observer> observers;

    public Triangle(Point p1, Point p2, Point p3, int id){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.id = id;
        observers = new ArrayList<>();
        notifyObservers();
    }

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

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(new EventObject(this));
        }
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void setP1(Point p1){
        this.p1 = p1;
        notifyObservers();
    }

    public void setP2(Point p2){
        this.p2 = p2;
        notifyObservers();
    }

    public void setP3(Point p3){
        this.p3 = p3;
        notifyObservers();
    }

}
