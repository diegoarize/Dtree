package machineLeaningModule.dtree;

import java.util.Random;

import machineLeaningModule.dataset.DataSets;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;

public class DTree {
	private J48 tree;
	private Evaluation eval;
	
	public DTree() throws Exception {
		tree = new J48();
		tree.buildClassifier(DataSets.training);
	}
	
	public void evaluate(Instances dataset) throws Exception {
		eval = new Evaluation(dataset);
		Random rand = new Random(1);
		int folds = 10;
		
		eval.crossValidateModel(tree, DataSets.training, folds, rand);
	}
	
	public void printEvaluationSummary() throws Exception {
		System.out.println(eval.toSummaryString("Evaluation results:\n", false));
		System.out.println(eval.toMatrixString("=== Overall Confusion Matrix ===\n"));
	}
	
	public String predictClassFromModel(Instance newInstance) throws Exception {
		double predTree = tree.classifyInstance(newInstance);
		return newInstance.dataset().classAttribute().value((int) predTree);
	}
	
	public void printTree() throws Exception {
		System.out.println(tree.graph());
	}
	
	public J48 getTree() {
		return tree;
	}
	public void setTree(J48 tree) {
		this.tree = tree;
	}
	public Evaluation getEval() {
		return eval;
	}
	public void setEval(Evaluation eval) {
		this.eval = eval;
	}
}
