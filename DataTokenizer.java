import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;


public class DataTokenizer {

	
	private String name;
	

	public DataTokenizer(String name){
		this.name=name;
		
	}
	public DataTokenizer(){
		this("");
		
	}
		
		public ArrayList<Object> DataReader(String path){
			
			ArrayList<Object > returner=new ArrayList<Object >();
			
			int N_of_class_1=0;
			int N_of_class_2=0;
			int N_of_class_3=0;
			int N_of_class_4=0;
			File f=null;
			String line;
			int counter=1;
			BufferedReader reader=null;
			StringTokenizer st;
			String type_of_class="";
			try {
				f = new File(path);
				}
				catch (NullPointerException e) {
				System.err.println("File not found.");
				}
				try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				} catch (FileNotFoundException e) {
				System.err.println("Error opening file!");
				}
				try{
					line = reader.readLine();
					while(line!=null){
						st=new StringTokenizer(line,",");
						for(int i=0;i<6;i++){
							st.nextToken();
						}
						type_of_class=st.nextToken();
						
						
						if(type_of_class.equals("unacc")){
							++N_of_class_1;
						}else if(type_of_class.equals("acc")){
								++N_of_class_2;
							} else if(type_of_class.equals("good")){
								++N_of_class_3;
							}else{
								++N_of_class_4;
							}
						line=reader.readLine();
						++counter;
						if(line.startsWith("END"))break;
						}
						
				}
				catch (IOException e) {
			
			System.out.println("Line " + counter + ": Sudden end.");
		}
		try {
			reader.close();
			} catch (IOException e) {
			System.err.println("Error closing file.");
			}
		/*
		 * We Learned the number of instances of each class
		 * 
		 *  now we are going to add to an array all the data that we need
		 *  | names file (C4.5 format) for car evaluation domain

			| class values

							unacc, acc, good, vgood

			| attributes

				buying:   vhigh, high, med, low.
				maint:    vhigh, high, med, low.
				doors:    2, 3, 4, 5more.
				persons:  2, 4, more.
				lug_boot: small, med, big.
				safety:   low, med, high.

		 * 
		 */
		ArrayList<String []> parts=new ArrayList<String[]>();
		
		try {
			f = new File(path);
			}
			catch (NullPointerException e) {
			System.err.println("File not found.");
			}
			try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			} catch (FileNotFoundException e) {
			System.err.println("Error opening file!");
			}
			try{
				line = reader.readLine();
				while(line!=null){
					
					String[] member=line.split(",");
					parts.add(member);
					
					line=reader.readLine();
					++counter;
					if(line.startsWith("END"))break;
					}
					
			}
			catch (IOException e) {
		
		System.out.println("Line " + counter + ": Sudden end.");
	}
	try {
		reader.close();
		} catch (IOException e) {
		System.err.println("Error closing file.");
		}
	String[][] data=new String[N_of_class_1+N_of_class_2+N_of_class_3+N_of_class_4][7];
	
	for(int i=0;i<data.length;i++){
		for(int j=0;j<data[i].length;j++){
			
			data[i][j]=parts.get(i)[j];
			}
	}
				
			returner.add(data);
			returner.add(N_of_class_1);
			returner.add(N_of_class_2);
			returner.add(N_of_class_3);
			returner.add(N_of_class_4);
			returner.add(N_of_class_1+N_of_class_2+N_of_class_3+N_of_class_4);
			return returner;
			//return data;
			
			
		}
		/**
		 * 
		 * @param path
		 * @return ArrayList of string [] 
		 */
		public  ArrayList<String[]> ReadEvaluateData(String path) {
			ArrayList<String []> parts=new ArrayList<String[]>();
			
			File f = null;
			try {
				f = new File(path);
				}
				catch (NullPointerException e) {
				System.err.println("File not found.");
				}
				BufferedReader reader = null;
				try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				} catch (FileNotFoundException e) {
				System.err.println("Error opening file!");
				}
				int counter = 0;
				try{
					String line = reader.readLine();
					while(line!=null){
						
						String[] member=line.split(",");
						parts.add(member);
						
						line=reader.readLine();
						++counter;
						if(line.startsWith("END"))break;
						}
						
				}
				catch (IOException e) {
			
			System.out.println("Line " + counter + ": Sudden end.");
		}
		try {
			reader.close();
			} catch (IOException e) {
			System.err.println("Error closing file.");
			}
			
			
			return parts;
		}
	}


