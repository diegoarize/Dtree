package MachineLeaningModule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import IO.ArffHandler;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class Main {

	public static void main(String[] args) throws Exception {
		ArffHandler dataSets = new ArffHandler();
		Instances testSet = null, trainingSet = null;
		
		trainingSet = dataSets.readArff("weather.numeric.arff");
		testSet = dataSets.readArff("weather.numeric-test.arff");
		
		trainingSet.setClassIndex(trainingSet.numAttributes() - 1);
		testSet.setClassIndex(testSet.numAttributes()-1);
		
		dataSets.setTrainingSet(trainingSet);
		dataSets.setTestingSet(testSet);
		
		
		J48 tree = new J48();
		
		tree.buildClassifier(trainingSet);
		System.out.println(tree.getCapabilities().toString());
		System.out.println(tree.graph());
		
		
		Evaluation eval = new Evaluation(trainingSet);
		Random rand = new Random(1);
		int folds = 10;
		
		eval.crossValidateModel(tree, testSet, folds, rand);
		System.out.println(eval.toSummaryString("Evaluation results:\n", false));
		
		
	    //the confusion matrix
		System.out.println(eval.toMatrixString("=== Overall Confusion Matrix ===\n"));

	}

}
