package hu.bme.mit.train.tachno;


import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Date;

public class TachnographImpl{
    Table<Date,Integer,Integer> data;
    public TachnographImpl(){
        data = HashBasedTable.create();
    }
    public Table<Date,Integer,Integer> getTable(){
        return data;
    }
    public void add(Date date, int pos, int speed){
        data.put(date,pos,speed);
    }
}
