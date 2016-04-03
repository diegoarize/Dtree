package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.core.Instances;

public class ArffHandler {
	
	public static Instances readArff(String path) throws FileNotFoundException, IOException {
		Instances dataSet = new Instances(new BufferedReader(
                new FileReader(path)));
		return dataSet;
	}
}
