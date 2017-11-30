import java.util.Hashtable;


public class NaiveBayes {
private static final int Laplace_1=4,Laplace_2=4;
private static final int Laplace_3=4,Laplace_4=3;
private static final int Laplace_5=3,Laplace_6=3;
	private String name;
	private double p_c1,p_c2,p_c3,p_c4;
	private int class1,class2,class3,class4;
	private String[][] data;
	
	public NaiveBayes(String name){
		this.name=name;
	}
	public NaiveBayes(){
		this("");
	}

	public void train(String[][] data,int class1,int class2,int class3,int class4){
		
		this.data=data;
		this.class1=class1;
		this.class2=class2;
		this.class3=class3;
		this.class4=class4;
		
		int number_of_instances=class1+class2+class3+class4;
		
		if(class1+class2+class3+class4!=0){
			
		
		
		if(class1!=0){
			
			this.p_c1=(double)class1/number_of_instances;
			
		}
		
		if(class2!=0){
			this.p_c2=(double)class2/number_of_instances;
			
		}
		
		if(class3!=0){
			this.p_c3=(double)class3/number_of_instances;
		}
		if(class4!=0){
			this.p_c4=(double)class4/number_of_instances;
		}
		
		
		}
		
		
	}
	
	/*
	 * 
		| class values

						unacc, acc, good, vgood

		| attributes

			buying:   vhigh, high, med, low. count[0]
			maint:    vhigh, high, med, low. count[1]
			doors:    2, 3, 4, 5more.		 count[2]
			persons:  2, 4, more.			 count[3]
			lug_boot: small, med, big.		 count[4]
			safety:   low, med, high.		 count[5]

	 * 
	 */
	public boolean predict(String[] object_to_predict){
		
		
		
		int[] counttable_c1=new int[6];
		int[] counttable_c2=new int[6];
		int[] counttable_c3=new int[6];
		int[] counttable_c4=new int[6];
		
		
		
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[i].length-1;j++){
				if(data[i][j].equals(object_to_predict[j])){
					//class of training set instance//
					if(data[i][6].equals("unacc")){
						++counttable_c1[j];
					}else if(data[i][6].equals("acc")){
						
						++counttable_c2[j];
						
					}else if(data[i][6].equals("good")){
						
						++counttable_c3[j];
						
					}else if(data[i][6].equals("vgood")){
						
						++counttable_c4[j];
						
					}
				}
				
			}
		}
		
		//UPOLOGISMOS GIA KA8E CLASS //
		double[] results=new double[4]; 
		
		//Gia C=unnac
		
		double P_c_unnac=Math.log(p_c1);
		
		
		double P_c_acc=Math.log(p_c2);
		double P_c_good=Math.log(p_c3);
		double P_c_vgood=Math.log(p_c4);
		
		//LAPLACE +1 Arithmiti,+n oses einai oi diaforetikes times tou C ston Paranomasti//
		
			for(int i=0;i<counttable_c1.length;i++){
				if(i==3||i==4||i==5){
					P_c_unnac=P_c_unnac+Math.log((double)(1+counttable_c1[i])/(class1+3));
					
				}else{
				P_c_unnac=P_c_unnac+Math.log(((1+counttable_c1[i])/((double) class1+4)));
				}
			
			}
			results[0]=P_c_unnac;
			for(int i=0;i<counttable_c2.length;i++){
				if(i==3||i==4||i==5){
					P_c_acc=P_c_acc+Math.log((double)(1+counttable_c2[i])/(class2+3));
					
				}else{
				P_c_acc=P_c_acc+Math.log((double)(1+counttable_c2[i])/(class2+4));}
			
			}
			results[1]=P_c_acc;
			
			for(int i=0;i<counttable_c3.length;i++){
				if(i==3||i==4||i==5){
					P_c_good=P_c_good+Math.log((double)(1+counttable_c3[i])/(class3+3));
					
				} else{
				P_c_good=P_c_good+Math.log((double)(1+counttable_c3[i])/(class3+4));}
			
			}
			results[2]=P_c_good;
			for(int i=0;i<counttable_c4.length;i++){
				if(i==3||i==4||i==5){
					P_c_vgood=P_c_vgood+Math.log((double)(1+counttable_c4[i])/(class4+3));
					
				}else{
				P_c_vgood=P_c_vgood+Math.log((double)(1+counttable_c4[i])/(class4+4));}
			
			}
			results[3]=P_c_vgood;
			//finding the result//
			double result=results[0];
			for(int i=1;i<results.length;i++){
				
				if(results[i]>result){
					
					
					result=results[i];
				}
			}
			//find the category//
			String Category;
			if(result==P_c_unnac){
				Category="unnac";
			}else if(result==P_c_acc){
				Category="acc";
			}else if(result==P_c_good){
				Category="good";
				}else{Category="vgood";
						
				}
			
			//System.out.print("Naive Bayes Says "+Category);
			
			return Category.equals(object_to_predict[object_to_predict.length-1]);
			
		
		
		
	}
	
}
