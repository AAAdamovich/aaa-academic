// Anton Adamovich
// Advanced Topics in Computer Science Honors
// Mr. Meistering
// 10/10/13
// Trees Experimentation

// This implementation uses only the Integer class for the add method,
// it was not intended to be used with other objects

import java.util.ArrayList;

public class BinaryTree {

	protected BinaryTreeNode root;
	
	public BinaryTree(){
		root = null;
	}
	
	public BinaryTreeNode getRoot(){
		return root;
	}

	public boolean add(Integer toBeAdded){
		if(toBeAdded != null){
			if(root == null){
				root = new BinaryTreeNode(toBeAdded);
				return true;
			}
			addHelper(toBeAdded, root);
			return true;
		}
		else return false;
	}

	// PreCondition: beingCompared and toBeAdded are never null
	private void addHelper(Integer toBeAdded, BinaryTreeNode beingCompared){
		if((((Integer)beingCompared.getValue()).intValue()) >= (toBeAdded.intValue())){
			// Add left
			if(beingCompared.getLeft() != null){
				beingCompared = beingCompared.getLeft();
				addHelper(toBeAdded, beingCompared);
			}
			else beingCompared.setLeft(new BinaryTreeNode(toBeAdded));
		}
		else{
			// Add right
			if(beingCompared.getRight() != null){
				beingCompared = beingCompared.getRight();
				addHelper(toBeAdded, beingCompared);
			}
			else beingCompared.setRight(new BinaryTreeNode(toBeAdded));
		}
	}
	
	protected void preOrderHelper(BinaryTreeNode toBeProcessed, ArrayList<Object> output){
		if(toBeProcessed != null){
			output.add(toBeProcessed.getValue());
			preOrderHelper(toBeProcessed.getLeft(), output);
			preOrderHelper(toBeProcessed.getRight(), output);
		}
	}

	public ArrayList<Object> preOrder(){
		ArrayList<Object> output = new ArrayList<Object>(); 
		preOrderHelper(root, output);
		return output;
	}

	protected void inOrderHelper(BinaryTreeNode toBeProcessed, ArrayList<Object> output){
		if(toBeProcessed != null){
			inOrderHelper(toBeProcessed.getLeft(), output);
			output.add(toBeProcessed.getValue());
			inOrderHelper(toBeProcessed.getRight(), output);
		}
	}

	public ArrayList<Object> inOrder(){
		ArrayList<Object> output = new ArrayList<Object>(); 
		inOrderHelper(root, output);
		return output;
	}
	
	protected void postOrderHelper(BinaryTreeNode toBeProcessed, ArrayList<Object> output){
		if(toBeProcessed != null){
			postOrderHelper(toBeProcessed.getLeft(), output);
			postOrderHelper(toBeProcessed.getRight(), output);
			output.add(toBeProcessed.getValue());
		}
	}

	public ArrayList<Object> postOrder(){
		ArrayList<Object> output = new ArrayList<Object>(); 
		postOrderHelper(root, output);
		return output;
	}
}
