package structures;

/**
 * A node in the 2-3 tree
 * @param <Key>
 * @param <Value>
 */

public class TwoThreeNode<Key extends Comparable<Key>, Value> {
    public Value leftValue;     // The left record
    public Key leftKey;         // The node's left key

    public Value rightValue;    // The right record
    public Key rightKey;        // The node's right key

    public TwoThreeNode<Key, Value> leftChild;   // Pointer to left child.
    public TwoThreeNode<Key, Value> centerChild; // Pointer to middle child. Is actually the right child if right_child == null.
    public TwoThreeNode<Key, Value> rightChild;  // Pointer to right child.


    //
    //
    // Some utility functions to help you, if needed. You probably won't need them.
    //
    //

    /**
     * @return the number of keys in the node
     */
    public int getnKeys() {return ((leftKey != null)? 1: 0) + ((rightKey != null)? 1: 0) ;}

    /**
     * @return the number of children in the node. Should be 0, 1, 2 or 3.
     */
    public int getnChildren() {return ((leftChild != null)? 1: 0) + ((centerChild != null)? 1: 0) + ((rightChild != null)? 1: 0) ;}

    /**
     * @return True if the node is a 2-node (has one key, and two children (which can be null!))
     */
    public boolean is2node() { return rightKey == null; }

    /**
     * @return True if the node is a 3-node (has two keys, and three children (which can be null!))
     */
    public boolean is3node() { return rightKey != null; }

    public String toString() {
        if(leftKey == null && rightKey == null) return "";

        String strnode = "/";

        if ( leftKey != null ) strnode += "(lk:"+ leftKey +":"+ leftValue +")";
        if ( rightKey != null ) strnode += "(rk:"+ rightKey +":"+ rightValue +")";

        strnode += "c="+getnChildren()+"/";

        return strnode;
    }
}
