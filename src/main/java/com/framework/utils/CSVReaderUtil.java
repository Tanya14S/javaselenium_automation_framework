package com.framework.utils;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil {

    public static Object[][] getCSVData(String filePath) {

        List<Object[]> data = new ArrayList<>();

        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            String[] line;

            reader.readNext(); // skip header

            while ((line = reader.readNext()) != null) {
                data.add(new Object[]{line[0], line[1]});
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Rows read: " + data.size());
        return data.size() > 0 ? data.toArray(new Object[0][]) : new Object[][]{};  
        }
}