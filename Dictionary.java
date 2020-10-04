/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Dictionary {
    private HashMap<String,Integer>dictionary= new HashMap<>();
    
    public Dictionary(String s)
    {
        String line;
        String[] splitedLine;
        try
        {
            File f= new File(s);
            Scanner sc= new Scanner(f);
            while(sc.hasNextLine())
            {
                line=sc.nextLine();
                splitedLine=line.split(" ");
                dictionary.put(splitedLine[0],Integer.parseInt(splitedLine[1]));
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
            return;
        }
    }
    public boolean inDictionary(String s)
    {
        return dictionary.containsKey(s);
    }
    public int getSize()
    {
        return dictionary.size();
    }
    public void addToDictionary(String s,int n)
    {
        dictionary.put(s, n);
    }
    public String getLetter(int n)
    {
        for(String s : dictionary.keySet())
        {
            if(dictionary.get(s)== n)
            {
                return s;
            }
        }
        return null;
    }
    
    public int getCode(String s)
    {
        return dictionary.get(s);
    }
    @Override
    public String toString()
    {
        return dictionary.toString();
    }
}



