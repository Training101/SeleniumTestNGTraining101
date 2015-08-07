package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	private String propertyFileName;
	
	public PropertyFileReader(String fileName){
		propertyFileName = fileName;
	}
	
	public String getPropertyValue(String key){
        String value = "";
        
        FileInputStream fis = null;
        Properties props = null;
        try {
            fis = new FileInputStream(new File(propertyFileName));
            props = new Properties();
            props.load(fis);
            value = props.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

}
