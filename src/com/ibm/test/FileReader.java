package com.ibm.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//List<String> lines = Files.readAllLines(Paths.get("E:/temp/data/all.cars"), Charset.defaultCharset());
			
			//System.out.println(lines.toString());
			//for (String line : lines) {
			//System.out.println("line read: " + line);
			//}		
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream("E:/tmp/inv/Sample_100000.csv")));
			int total=getLineCount("E:/tmp/inv/Sample_100000.csv");
			long batchsize=40;
            long count=0;
            long diff=0;
            long i=0;
            String line=null;
            ArrayList list=new ArrayList();
            System.out.println("Total Line Count:: " +total +" Batch Size:: " +batchsize);
          while((line=br.readLine())!=null){
            	System.out.println("READ LINE:: " +line);
            	list.add(line);
            	count++;
            	System.out.println("LOOP START (count):: " +count);
            if(i<total){
            	 System.out.println("Value of i :: " +i + "(i<total):: " +(i<total));
            	if(count==batchsize){
            		diff=total-i-1;
            		System.out.println("(count==batchsize) diff:: " +diff); 
            		System.out.println("Ingested "+count+ " lines");
            		//System.out.println("Total left:: " +diff);
            		//proxy.InjestData(list);//Ingest 40 count of data
            		System.out.println("INGEST DATA HERE  " +list.toString());
            		list=new ArrayList();
            		if(diff<batchsize){
            			batchsize=diff;
            			System.out.println("(diff<batchsize) count=0 && batchsize=:: " +diff); 
            		}
            		count=0;
            		System.out.println("Count Reset to 0:: " +count);
            	}
            	i++;
              }         	           	
            }
            System.out.println("Exiting Loop");
            
		   // System.out.println("Number1:: " +num + "Quotient:: " +q1 + " Reminder:: " +r1);
		}catch(Exception t){t.printStackTrace();}

	}
	
	  private static int getLineCount(String ftpPath){
		  int count=0;
		  String line=null;
		  try{
	        	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ftpPath)));
	        	ArrayList list = new ArrayList();
	        	while((line=br.readLine())!=null){
                       ++count;
	        	}				  
		  }catch(Exception t){t.printStackTrace();}
		  return count;
	  }

}
