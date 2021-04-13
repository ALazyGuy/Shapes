package com.ltp.shapes.repository.impl;

import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.repository.TriangleRepository;
import com.ltp.shapes.repository.specification.Specification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TriangleRepositoryImpl implements TriangleRepository {

    private static final Logger LOGGER = LogManager.getLogger(TriangleRepositoryImpl.class);
    private static TriangleRepositoryImpl instance;
    private static List<Triangle> objects = new ArrayList();

    public static TriangleRepositoryImpl getInstance(){
        if(instance == null){
            instance = new TriangleRepositoryImpl();
        }

        return instance;
    }

    @Override
    public void save(Triangle triangle) {
        int index = objectIndexById(triangle.getId());
        if(index == -1){
            objects.add(triangle);
        }else{
            objects.set(index, triangle);
        }
        LOGGER.log(Level.INFO, String.format("%s saved to repository", triangle.toString()));
    }

    @Override
    public void remove(Triangle triangle) {
        objects.remove(triangle);
        LOGGER.log(Level.INFO, String.format("%s removed from repository", triangle.toString()));
    }

    @Override
    public List<Triangle> query(Specification specification) {
        List<Triangle> result = objects.stream().filter(a -> specification.specified(a)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Triangle> getAll() {
        return new ArrayList(objects);
    }

    private int objectIndexById(int id){
        int counter = 0;
        while(counter < objects.size()){
            if(objects.get(counter).getId() == id){
                break;
            }
            counter++;
        }

        return (counter == objects.size() ? -1 : counter);
    }
}
