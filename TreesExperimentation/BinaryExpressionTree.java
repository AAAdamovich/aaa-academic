// Anton Adamovich
// Advanced Topics in Computer Science Honors
// Mr. Meistering
// 11/7/13
// Trees Experimentation

import java.util.ArrayList;

import adt.Stack;

// As of right now, this tree only takes in preFix and postFix expressions
public class BinaryExpressionTree extends BinaryTree{
	
	public BinaryExpressionTree(){
		super();
	}
	
	// Make "type" true for a preFix expression and false for a postFix expression
	public BinaryExpressionTree(String expression, boolean type){
		super();
		String[] tokens = expression.split(" ");
		Stack values = new Stack();
		// Array needs to be put into a stack backwards for preFix, normal for postFix
		if(type){
			for(int i = ((tokens.length) - 1); i >= 0; i--){
				if(isLegal(tokens[i])) values.push(tokens[i]);
			}
		}
		else{
			for(String token : tokens){
				if(isLegal(token)) values.push(token);
			}
		}
		generate(values);
	} 
	
	private boolean generate(Stack expression){
		if(!(expression.isEmpty())){
			if(root == null) root = new BinaryTreeNode(expression.pop());
			genHelper(expression, root);
			return true;
		}
		return false;
	}

	// PreCondition: beingCompared is never null
	private void genHelper(Stack expression, BinaryTreeNode beingCompared){
		if((!(expression.isEmpty())) && (isOperator((String)(beingCompared.getValue())))){
			if((beingCompared.getLeft()) == null){
				beingCompared.setLeft(new BinaryTreeNode(expression.pop()));
				genHelper(expression, beingCompared.getLeft());
			}
			if((beingCompared.getRight()) == null){
				beingCompared.setRight(new BinaryTreeNode(expression.pop()));
				genHelper(expression, beingCompared.getRight());
			}
		}
	}

	private boolean isOperator(String value){
		if((value.equals("+") || value.equals("-")) || (value.equals("*") || value.equals("/"))) return true;
		else return false;
	}
	
	private boolean isLegal(String value) throws NumberFormatException{
		try{
			if(isOperator(value)) return true;
			else{
				Integer.parseInt(value);
				return true;
			}
		}
		catch(NumberFormatException e){
			return false;
		}
	}

	protected void inOrderHelper(BinaryTreeNode toBeProcessed, ArrayList<Object> output){
		if(toBeProcessed != null){
			if(isOperator((String)(toBeProcessed.getValue()))) output.add("(");
			inOrderHelper(toBeProcessed.getLeft(), output);
			output.add(toBeProcessed.getValue());
			inOrderHelper(toBeProcessed.getRight(), output);
			if(isOperator((String)(toBeProcessed.getValue()))) output.add(")");
		}
	}
}
