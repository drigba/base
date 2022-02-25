package hu.bme.mit.train.tachno;

import com.google.*;
import com.google.common.collect.Table;

import java.util.Date;

public class TachnographImpl{
    Table<Date,Integer,Integer> data;
    public Table<Date,Integer,Integer> getTable(){
        return data;
    }
    public void add(Date date, int pos, int speed){
        data.put(date,pos,speed);
    }
}
