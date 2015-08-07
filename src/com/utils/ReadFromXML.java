package com.utils;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadFromXML extends DefaultHandler {

    SAXParser saxParser = null;
    DataTable tempDataTable = null;
    Row tempRow = null;
    
    StringBuilder elementValue = new StringBuilder();
    Map<String, DataTable> dataTables;

    boolean isColumnTag = false;
    
    public ReadFromXML(String xmlFileName) {
        
        dataTables = new HashMap<String, DataTable>();
        
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            saxParser = factory.newSAXParser();
            saxParser.parse(xmlFileName, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object[][] getTableData(String tableName) {
        
        DataTable table = dataTables.get(tableName);
        int rowCount = table.getRows().size();
        int colCount = table.getRows().get(0).getValues().size();
        Object[][] tabArray = new Object[rowCount][colCount];
       
        for(int row = 0; row < rowCount; row++){
            Row currRow = table.getRows().get(row);
            for(int col = 0; col<colCount; col++){
                
                StringBuilder val = (StringBuilder) currRow.getValues().get(col);
                tabArray[row][col] = val.toString().trim();
            }
        }
        
        return tabArray;
    }

    public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
        
        if (qName.equalsIgnoreCase("table")) {
            
            String dtName = attributes.getValue("name");
            tempDataTable = new DataTable(dtName);
            dataTables.put(dtName, tempDataTable);
            
        } else if (qName.equalsIgnoreCase("row")) {
            
            tempRow = new Row();
            tempDataTable.getRows().add(tempRow);
            
        } else if (qName.equalsIgnoreCase("column")) {
            isColumnTag = true;
            elementValue = new StringBuilder();
            tempRow.getValues().add(elementValue);
            
        }
    }
    
    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        if(isColumnTag){
            elementValue.append(new String(chars, i, i1));
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
        if ("column".equals(localName)) {
            isColumnTag = false;
        }
    }
    
}
