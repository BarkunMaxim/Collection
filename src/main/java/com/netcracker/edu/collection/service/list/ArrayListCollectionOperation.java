package com.netcracker.edu.collection.service.list;

import com.netcracker.edu.collection.entity.GeometricFigure;
import com.netcracker.edu.collection.service.CollectionOperation;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Setter
@ToString
public class ArrayListCollectionOperation implements CollectionOperation {

    private List<GeometricFigure> list;
    private ListIterator<GeometricFigure> listIterator;

    public ArrayListCollectionOperation() {
        this.list = new ArrayList<>();
    }

    public void add(GeometricFigure geometricFigure) {
        this.list.add(geometricFigure);
    }

    public void removeByMinName() {

        String minItemName = Collections.min(list, new Comparator<GeometricFigure>() {
            public int compare(GeometricFigure o1, GeometricFigure o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).getName();

        listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (minItemName.equals(listIterator.next().getName())) {
                listIterator.remove();
            }
        }
    }

    public void removeByMaxColDot() {
        int maxItemColDot = 0;
        for (GeometricFigure iterator : this.list) {
            if (iterator.getColDot() > maxItemColDot) {
                maxItemColDot = iterator.getColDot();
            }
        }
        listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            if (maxItemColDot == listIterator.next().getColDot()) {
                listIterator.remove();
            }
        }
    }

    public void removeItemsWithColDotLessThan(int value) {
        listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            if (listIterator.next().getColDot() < value) {
                listIterator.remove();
            }
        }
    }

    public int getSumColDot() {
        int sum = 0;
        for (GeometricFigure iterator : list) {
            sum += iterator.getColDot();
        }
        return sum;
    }

    public GeometricFigure get(int index) {
        return list.get(index);
    }

    public List<GeometricFigure> getTwoItem(int index) {
        List<GeometricFigure> templist = new ArrayList<GeometricFigure>();

        templist.add(list.get(index));
        templist.add(list.get(index + 1));

        return templist;
    }

    public List<GeometricFigure> getItems(GeometricFigure geometricFigure) {
        List<GeometricFigure> templist = new ArrayList<GeometricFigure>();

        while (listIterator.hasNext()) {
            if (listIterator.next().equals(geometricFigure)) {
                templist.add(listIterator.next());
            }
        }
        return templist;
    }

    public boolean isAllItemsNameNotNull() {
        for (GeometricFigure iterator : list) {
            if (iterator.getName() == null) {
                return false;
            }
        }
        return true;
    }

    public void addPostfix(String postfix) {
        listIterator = list.listIterator();
        String tempString;

        while (listIterator.hasNext()) {
            tempString = listIterator.next().getName() + postfix;

            listIterator.next().setName(tempString);
        }
    }

    public void sortByName(List<GeometricFigure> geometricFigureList) {
        geometricFigureList.sort(Comparator.comparing(GeometricFigure::getName));
    }

    public void sortByColDot(List<GeometricFigure> geometricFigureList) {
        geometricFigureList.sort(Comparator.comparing(GeometricFigure::getColDot));
    }
}
