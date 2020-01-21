// Anton Adamovich
// Advanced Topics in Computer Science Honors
// Mr. Meistering
// 10/10/13
// Binary Trees Experimentation

public class BinaryTreeNode{

	private Object value;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode(Object value, BinaryTreeNode left, BinaryTreeNode right){
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public BinaryTreeNode(Object value){
		this(value, null, null);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
}

