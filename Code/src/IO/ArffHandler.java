package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.core.Instances;

public class ArffHandler {
	private Instances trainingSet, testingSet;

	public Instances getTrainingSet() {
		return trainingSet;
	}

	public void setTrainingSet(Instances trainingSet) {
		this.trainingSet = trainingSet;
	}

	public Instances getTestingSet() {
		return testingSet;
	}

	public void setTestingSet(Instances testingSet) {
		this.testingSet = testingSet;
	}
	
	public Instances readArff(String path) throws FileNotFoundException, IOException {
		Instances dataSet = new Instances(new BufferedReader(
                new FileReader(path)));
		return dataSet;
	}
}
