/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando2;

import java.util.ArrayList;


public class Process {
    private ArrayList<Integer>encoded=new ArrayList<>();
    private String decoded="";
    private Dictionary d;
    
    public Process(String s,String s2)
    {
        d= new Dictionary(s);
        String helper="";
        for(int i=0;i<s2.length();i++)
        {
            helper+=s2.charAt(i);
            if(!d.inDictionary(helper) && i+1!=s2.length())
            {
                d.addToDictionary(helper, d.getSize()+1);
                encoded.add(d.getCode(helper.substring(0, helper.length()-1)));
                helper="";
                i--;
            }
            if(i+1==s2.length())
            {
                encoded.add(d.getCode(helper));
            }
        }
        System.out.println(encoded.toString());
    }
    public void decode()
    {
        for(int n : encoded)
        {
             decoded+=d.getLetter(n);
        }
        System.out.println(decoded);
    }
}


