package com.netcracker.edu.collection.service.map;

import com.netcracker.edu.collection.entity.GeometricFigure;
import com.netcracker.edu.collection.service.CollectionOperation;

import java.util.*;

public class HashMapCollectionOperation implements CollectionOperation {

    private HashMap<String, GeometricFigure> map;
    private Iterator<String> mapIterator;

    public HashMapCollectionOperation() {
        this.map = new HashMap<>();
    }

    public void put(String key, GeometricFigure geometricFigure) {
        this.map.put(key, geometricFigure);
    }

    @Override
    public void removeByMinName() {

        String minName = Collections.min(map.values(), Comparator.comparing(GeometricFigure::getName)).getName();

        mapIterator = map.keySet().iterator();

        while (mapIterator.hasNext()) {
            String key = mapIterator.next();

            if (minName.equals(map.get(key).getName())) {
                mapIterator.remove();
            }
        }

    }

    @Override
    public void removeByMaxColDot() {
        int minValue = Collections.max(map.values(), Comparator.comparing(GeometricFigure::getColDot)).getColDot();

        mapIterator = map.keySet().iterator();

        while (mapIterator.hasNext()) {

            String key = mapIterator.next();

            if (map.get(key).getColDot() == minValue) {
                mapIterator.remove();
            }
        }
    }

    @Override
    public void removeItemsWithColDotLessThan(int value) {

        mapIterator = map.keySet().iterator();

        while (mapIterator.hasNext()) {
            String key = mapIterator.next();
            if (map.get(key).getColDot() < value) {
                mapIterator.remove();
            }
        }
    }


    @Override
    public int getSumColDot() {
        int tempSum = 0;

        for (Map.Entry<String, GeometricFigure> entry : map.entrySet()) {
            tempSum += entry.getValue().getColDot();
        }
        return tempSum;
    }

    @Override
    public GeometricFigure get(int index) {
        return map.get(map.keySet().toArray()[index]);
    }

    @Override
    public List<GeometricFigure> getTwoItem(int index) {
        List<GeometricFigure> templist = new ArrayList<GeometricFigure>();

        int size = map.keySet().toArray().length;
        if (size - index >= 2) {
            templist.add(map.get(map.keySet().toArray()[index]));
            templist.add(map.get(map.keySet().toArray()[index + 1]));
        }
        return templist;
    }

    @Override
    public List<GeometricFigure> getItems(GeometricFigure geometricFigure) {
        List<GeometricFigure> templist = new ArrayList<GeometricFigure>();

        for (Map.Entry<String, GeometricFigure> entry : map.entrySet()) {
            if (geometricFigure.equals(entry.getValue())) {
                templist.add(entry.getValue());
            }
        }

        return templist;
    }

    @Override
    public boolean isAllItemsNameNotNull() {

        for (Map.Entry<String, GeometricFigure> entry : map.entrySet()) {
            if (entry.getValue().getName() == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addPostfix(String postfix) {

        for (String key : map.keySet()) {
            map.get(key).setName(map.get(key).getName().concat(postfix));
        }
    }


    public void sortByName() {
        List<Map.Entry<String, GeometricFigure>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue().getName().equals(o2.getValue().getName())) {
                return o1.getValue().getName().compareTo(o2.getValue().getName());
            }
            return o1.getValue().getName().compareTo(o2.getValue().getName());
        });


        LinkedHashMap<String, GeometricFigure> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, GeometricFigure> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        this.map = sortedMap;
    }


    public void sortByColDot() {

        List<Map.Entry<String, GeometricFigure>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue().getColDot() == o2.getValue().getColDot()) {
                return o1.getValue().getColDot() - o2.getValue().getColDot();
            }
            return o1.getValue().getColDot() - o2.getValue().getColDot();
        });


        LinkedHashMap<String, GeometricFigure> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, GeometricFigure> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        this.map = sortedMap;
    }

    public void printItem() {
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
