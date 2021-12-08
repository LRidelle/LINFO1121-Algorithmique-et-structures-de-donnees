package dontreadthis;/*
 * 2-3 tree implementation
 */

import structures.TwoThreeNode;

public class TreeTwoThree<Key extends Comparable<Key>, Value>{

	// a Node has 1 (2-Node) or 2 (3-Node) values
	// and 2 or 3 children.  Values and children are stored
	// in ArrayLists.  If there are children, that ArrayList
	// has a null element at the end, so as to make easier the
	// method which adds a new child.
	public class Node extends TwoThreeNode<Key, Value> {
		public Node() { centerChild = leftChild = rightChild = null; }

		public Node(Key leftkey, Value leftvalue, Key rightkey, Value rightvalue,
					Node leftChildNode, Node centerChildNode, Node rightChildNode) {
			leftKey = leftkey; rightKey = rightkey;
			leftValue = leftvalue; rightValue = rightvalue;
			leftChild = leftChildNode; centerChild = centerChildNode; rightChild = rightChildNode;
		}

		public boolean isLeaf() { return leftChild == null; }

		public int getnKeys() {return ((leftKey != null)? 1: 0) + ((rightKey != null)? 1: 0) ;}
		public int getnChildren() {return ((leftChild != null)? 1: 0) + ((centerChild != null)? 1: 0) + ((rightChild != null)? 1: 0) ;}

		public Node leftChild() { return (Node)leftChild; }
		public Node rightChild() { return (Node)rightChild; }
		public Node centerChild() { return (Node)centerChild; }

		public Key leftKey() { return leftKey; }  // Left key
		public Value leftValue() { return leftValue; }  // Left value

		public Key rightKey() { return rightKey; }  // Right key
		public Value rightValue() { return rightValue; }  // Right value

		public void setLeftKV(Key k, Value e) { leftKey = k; leftValue = e; }
		public void setRightKV(Key k, Value e) { rightKey = k; rightValue = e; }

		public void setLeftChild(Node it) { leftChild = it; }
		public void setCenterChild(Node it) { centerChild = it; }
		public void setRightChild(Node it) { rightChild = it; }

		public Node add(Node it) {
			if (rightKey == null) { // Only one key, add here

				if (leftKey.compareTo(it.leftKey()) < 0) {
					rightKey = it.leftKey();
					rightValue = it.leftValue();
					centerChild = it.leftChild();
					rightChild = it.centerChild();
				} else {

					rightKey = leftKey;
					rightValue = leftValue;

					rightChild = centerChild;

					leftKey = it.leftKey();
					leftValue = it.leftValue();

					centerChild = it.centerChild();

					leftChild = it.leftChild();
				}

				return this;
			}
			else if (leftKey.compareTo(it.leftKey()) >= 0) { // Add left

				Node N1 = new Node(leftKey, leftValue, null, null, it, this, null);

				leftChild = centerChild;
				centerChild = rightChild;
				rightChild = null;

				leftKey = rightKey;
				leftValue = rightValue;

				rightKey = null;
				rightValue = null;

				return N1;

			} else if (rightKey.compareTo(it.leftKey()) >= 0) { // Add center

				it.setCenterChild(new Node(rightKey, rightValue, null, null, it.centerChild(), (Node)rightChild, null));

				centerChild = it.leftChild;

				it.setLeftChild(this);
				rightKey = null; rightValue = null; rightChild = null;

				return it;
			}
			else { // Add right

				Node N1 = new Node(rightKey, rightValue, null, null, this, it, null);

				rightChild = null;
				rightKey = null;
				rightValue = null;

				return N1;
			}
		}

		public String toString() {
			if(leftKey == null && rightKey == null) return "";

			String strnode = "/";

			if ( leftKey != null ) strnode += "(lk:"+leftKey+":"+leftValue+")";
			if ( rightKey != null ) strnode += "(rk:"+rightKey+":"+rightValue+")";

			strnode += "c="+getnChildren()+"/";

			return strnode;
		}

	}

	private Node root;

	public Node getRoot() {
		return root;
	}

	/**
	 * Initializes an empty symbol table.
	 */
	public TreeTwoThree() { }

	public Value find(Key key) { return find(root, key); }
	private Value find(Node treenode, Key key) {
		if (treenode == null) return null;          // val not found
		if (key.compareTo(treenode.leftKey()) == 0) return treenode.leftValue();
		if ((treenode.rightKey() != null) && (key.compareTo(treenode.rightKey()) == 0))
			return treenode.rightValue();

		if (key.compareTo(treenode.leftKey()) < 0)       // Search left
			return find(treenode.leftChild(), key);

		else if (treenode.rightKey() == null)           // Search center
			return find(treenode.centerChild(), key);
		else if (key.compareTo(treenode.rightKey()) < 0)  // Search center
			return find(treenode.centerChild(), key);

		else return find(treenode.rightChild(), key); // Search right
	}

	public void insert(Key newKey, Value newValue) { root = insert(root, newKey, newValue); }
	private Node insert(Node treenode, Key newKey, Value newValue) {
		Node retval;
		if (treenode == null) // Empty tree: create a leaf node for root
			return new Node(newKey, newValue, null, null, null, null, null);
		if (treenode.isLeaf()) // At leaf node: insert here
			return treenode.add(new Node(newKey, newValue, null, null, null, null, null));
		// Add to internal node
		if (newKey.compareTo(treenode.leftKey()) < 0) { // Insert left
			retval = insert(treenode.leftChild(), newKey, newValue);
			if (retval == treenode.leftChild()) return treenode;
			else return treenode.add(retval);
		} else if((treenode.rightKey() == null) || (newKey.compareTo(treenode.rightKey()) < 0)) {
			retval = insert(treenode.centerChild(), newKey, newValue);
			if (retval == treenode.centerChild()) return treenode;
			else return treenode.add(retval);
		} else  { // Insert right
			retval = insert(treenode.rightChild(), newKey, newValue);
			if (retval == treenode.rightChild()) return treenode;
			else return treenode.add(retval);
		}
	}

	public void displayTree() {displayTree(root, 1);}
	private void displayTree(Node thisNode, int level) {

		System.out.println(level+"-"+thisNode);

		if (thisNode.leftChild != null){
			System.out.print("lc:");
			displayTree((Node)thisNode.leftChild, level + 1);
		}
		if (thisNode.centerChild != null){
			System.out.print("cc:");
			displayTree((Node)thisNode.centerChild, level + 1);
		}
		if (thisNode.rightChild != null){
			System.out.print("rc:");
			displayTree((Node)thisNode.rightChild, level + 1);
		}
	}
}
