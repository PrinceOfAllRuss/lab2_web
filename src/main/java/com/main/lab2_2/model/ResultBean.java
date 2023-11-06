package com.main.lab2_2.model;

import java.io.Serializable;
import java.util.LinkedList;

public class ResultBean implements Serializable {
    private LinkedList<ElementForTable> listOfResults = new LinkedList<>();
    public LinkedList<ElementForTable> getListOfResults() {
        return listOfResults;
    }
    public void setListOfResults(LinkedList<ElementForTable> list) {
        this.listOfResults = list;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (ElementForTable el : listOfResults) {
            if (el != null) {
                str.append(el.toString());
                str.append("\n");
            }
        }
        return str.toString();
    }
    
    public AllDots toAllDots() {
        AllDots list = new AllDots();
        for (ElementForTable el : listOfResults) {
            Dot dot = el.toDot();
            list.list.add(dot);
        }
        
        return list;
    }
}
