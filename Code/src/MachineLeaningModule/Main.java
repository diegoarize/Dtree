package MachineLeaningModule;

import java.io.FileNotFoundException;
import java.io.IOException;

import IO.ArffHandler;

public class Main {

	public static void main(String[] args) {
		ArffHandler dataSets = new ArffHandler();
		try {
			dataSets.setTrainingSet(dataSets.readArff("weather.numeric.arff"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dataSets.getTrainingSet().toString());

	}

}
