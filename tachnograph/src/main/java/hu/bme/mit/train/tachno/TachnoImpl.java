package main.java.hu.bme.mit.train.tachno;


import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.sql.Time;

public class TachnoImpl {
    private Table<Time,Double, Integer> container;
    public TachnoImpl(){
        container = HashBasedTable.create();
    }
    public void add(Time t, Double p, Integer s){
        container.put(t,p,s);
    }
    public int size(){
        return  container.size();
    }
}
