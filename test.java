import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] tester=new int[2];
		
		DataTokenizer hey=new DataTokenizer("Bayes");
		/*
		 * size-1=N_all
		 * size-2=N_class_4
		 * size-3=N_class_3
		 * size-4=N_class_2
		 * size-5=N_class_1
		 get(0)=data
		 */
		ArrayList<Object> hello =hey.DataReader("D:\\eclipse\\NaiveBayesClassifier\\src\\Files\\DATASET.txt");
		int n=(int)hello.get(hello.size()-1);
		ArrayList<String[]> evaluate=hey.ReadEvaluateData("D:\\eclipse\\NaiveBayesClassifier\\src\\Files\\DATASET.txt");
		ArrayList<String[]> evaluate_data=hey.ReadEvaluateData("D:\\eclipse\\NaiveBayesClassifier\\src\\Files\\EvaluateData");
		NaiveBayes bayes=new NaiveBayes();
		
		bayes.train((String[][]) hello.get(0),(int)hello.get(hello.size()-5),(int)hello.get( hello.size()-4),(int)hello.get( hello.size()-3),(int)hello.get( hello.size()-2));				
		
		double sum_dataset=0;
		for(int i=0;i<evaluate.size();i++){
				if(bayes.predict(evaluate.get(i))){
			 ++sum_dataset;}
		 System.out.println();
		 
		}
		double sum_eva=0;
		for(int i=0;i<evaluate_data.size();i++){
			if(bayes.predict(evaluate_data.get(i))){
		 ++sum_eva;}
	 System.out.println();
	 
	}
		
		//MESOS OROS THETIKWN APOKRISEWN sta dedomena a3iologhshs//
		double Mean=sum_eva/(evaluate_data.size());
		System.out.println("********************************\n\n"+"Mean of positive answers\n\n"+"************************************+\n\n");
		System.out.println(Mean)	;
				
				
				
				
				
		//MESOS OROS THETIKWN APOKRISEWN sta dedomena ekpaideushs//
				double Mean_d=sum_dataset/(evaluate.size());
				System.out.println("********************************\n\n"+"Mean of positive answers (train) and error\n\n"+"************************************+\n\n");
				System.out.println("positive rate: "+Mean_d)	;
				System.out.println("error rate : "+(1-Mean_d));
				
				
				
			}
		
	}


