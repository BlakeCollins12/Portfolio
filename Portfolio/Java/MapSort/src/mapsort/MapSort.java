/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapsort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blakecollins
 */
public class MapSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String testScores = "/Users/blakecollins/NetBeansProjects/"
                + "mapsort/src/resources/testResults.csv";
        TreeMap<Integer, String> topScores = new TreeMap<>();
        LinkedHashMap<Integer, String> sortedScores = new LinkedHashMap<Integer, String>();
     

        System.out.println("Java version: " + getVersion());

        try {
            BufferedReader br = new BufferedReader(new FileReader(testScores));
            String line;
            while ((line = br.readLine()) != null) {

                String[] columns = line.split(",");
                Integer testScore = Integer.valueOf(columns[1].trim());

                if (isTopScore(testScore).equals(true)) {
                    topScores.put(testScore, columns[0]);
                }
            }

            System.out.println(topScores);

            // Calling the method sortByvalues
            sortedScores = reverseTreeMap(topScores);
            
            
            //sortedTopScores = sortByValues(topScores);
            System.out.println(sortedScores);

            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MapSort.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MapSort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static LinkedHashMap<Integer, String> reverseTreeMap(TreeMap<Integer, String> scores) {
        Stack<Entry<Integer, String>> reverse = new Stack<Entry<Integer, String>>();

        for (Map.Entry<Integer,String> entry : scores.entrySet()) {
            reverse.push(entry);
        }
        
        LinkedHashMap<Integer, String> sortedScores = new LinkedHashMap<Integer, String>();
        
        while(!reverse.isEmpty()){
            Entry<Integer, String> item = reverse.pop();
            sortedScores.put(item.getKey(), item.getValue());
        }
        
        return sortedScores;
    }

    private static Boolean isTopScore(Integer score) {
        Boolean isTopScore = false;
        if (score >= 90) {
            isTopScore = true;
        }

        return isTopScore;
    }


    static double getVersion() {
        String version = System.getProperty("java.version");
        int pos = version.indexOf('.');
        pos = version.indexOf('.', pos + 1);
        return Double.parseDouble(version.substring(0, pos));
    }
}
