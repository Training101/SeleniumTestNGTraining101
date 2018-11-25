package com.utils;

import java.util.ArrayList;
import java.util.List;

class DataTable {

    private String tableName;
    
    private List<Row> rows;
    
    public DataTable(String tableName){
        this.tableName = tableName;
        this.rows = new ArrayList<Row>();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
    
}

class Row {
    
    private List<Object> values;
    
    public Row(){
        values = new ArrayList<Object>();
    }
    
    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }   
}
