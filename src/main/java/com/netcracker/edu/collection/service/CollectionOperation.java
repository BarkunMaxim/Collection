package com.netcracker.edu.collection.service;

import com.netcracker.edu.collection.entity.GeometricFigure;

import java.util.List;

public interface CollectionOperation {

    void removeByMinName();

    void removeByMaxColDot();

    void removeItemsWithColDotLessThan(int value);

    int getSumColDot();

    GeometricFigure get(int index);

    List<GeometricFigure> getTwoItem(int index);

    List<GeometricFigure> getItems(GeometricFigure geometricFigure);

    boolean isAllItemsNameNotNull();

    void addPostfix(String postfix);


}
