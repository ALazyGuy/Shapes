package com.ltp.shapes.service.impl;

import com.ltp.shapes.model.entity.Triangle;
import com.ltp.shapes.service.SortingService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SortingServiceImpl implements SortingService {

    private static SortingServiceImpl instance;

    public static SortingServiceImpl getInstance(){
        if(instance == null){
            instance = new SortingServiceImpl();
        }

        return instance;
    }

    @Override
    public List<Triangle> sort(List<Triangle> triangles, Comparator<Triangle> method) {
        List<Triangle> result = triangles.stream().sorted(method).collect(Collectors.toList());
        return result;
    }
}
