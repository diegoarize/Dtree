package machineLeaningModule;

import java.util.Random;

import io.ArffHandler;
import machineLeaningModule.dataset.DataSets;
import machineLeaningModule.dtree.DTree;
import weka.classifiers.Evaluation;
import weka.core.Instance;

public class Main {

	public static void main(String[] args) throws Exception {
		DataSets dataset = new DataSets();
		
		
		DTree tree = new DTree();
		
		tree.printTree();
		tree.evaluate(DataSets.test);
		tree.printEvaluationSummary();
		
		
		//loop through the new dataset and make predictions
				System.out.println("===================");
				System.out.println("Actual Class, DTree Predicted");
				
				DataSets.test = ArffHandler.readArff("weather.numeric-test2.arff");	
				DataSets.test.setClassIndex(DataSets.test.numAttributes()-1);
				
				int numberOfInstances = DataSets.test.numInstances();
				for (int i = 0; i < numberOfInstances; i++) {
					//get class double value for current instance
					double actualClass = DataSets.test.instance(i).classValue();
					//get class string value using the class index using the class's int value
					String actual = DataSets.test.classAttribute().value((int) actualClass);
					//get Instance object of current instance
					Instance newInst = DataSets.test.instance(i);
					//call classifyInstance, which returns a double value for the class
					
					//use this value to get string value of the predicted class
					String predString = tree.predictClassFromModel(newInst);
					System.out.println(actual+", "+predString);
				}

	}

}
