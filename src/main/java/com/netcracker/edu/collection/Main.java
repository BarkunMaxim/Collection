package com.netcracker.edu.collection;

import com.netcracker.edu.collection.entity.GeometricFigure;
import com.netcracker.edu.collection.service.list.ArrayListCollectionOperation;
import com.netcracker.edu.collection.service.map.HashMapCollectionOperation;

public class Main {

    public static void main(String[] args) {

        GeometricFigure geometricFigure1 = new GeometricFigure("Квадрат", 4);
        GeometricFigure geometricFigure2 = new GeometricFigure("Треугольник", 3);
        GeometricFigure geometricFigure3 = new GeometricFigure("Пятиугольник", 5);
        ArrayListCollectionOperation list = new ArrayListCollectionOperation();
        HashMapCollectionOperation hashMapCollectionOperation = new HashMapCollectionOperation();

        hashMapCollectionOperation.put("0",geometricFigure1);
        hashMapCollectionOperation.put("1", geometricFigure2);
        hashMapCollectionOperation.put("2", geometricFigure3);

        hashMapCollectionOperation.printItem();
        hashMapCollectionOperation.sortByName();
        System.out.println("===============================");
        hashMapCollectionOperation.printItem();
        hashMapCollectionOperation.sortByColDot();
        System.out.println("===============================");
        hashMapCollectionOperation.printItem();
        hashMapCollectionOperation.addPostfix("_1");


        /*list.add(geometricFigure1);
        list.add(geometricFigure2);
        list.add(geometricFigure3);

        System.out.println(list.toString());
        list.removeByMaxColDot();
        System.out.println(list.toString());

        System.out.println(list.toString());
        list.removeByMinName();
        System.out.println(list.toString());*/


    }

}
