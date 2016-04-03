package machineLeaningModule.dataset;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.ArffHandler;
import weka.core.Instances;

public class DataSets {
	public static Instances training, test;
	
	public DataSets() throws Exception, IOException {
		training = ArffHandler.readArff("weather.numeric.arff");
		training.setClassIndex(training.numAttributes() - 1);
		
		test = ArffHandler.readArff("weather.numeric-test.arff");
		test.setClassIndex(test.numAttributes() - 1);
		
	}
}
