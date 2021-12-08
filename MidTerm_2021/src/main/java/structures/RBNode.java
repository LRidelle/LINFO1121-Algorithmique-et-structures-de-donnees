package structures;

/**
 * A node in the red-black tree
 * @param <Key>
 * @param <Value>
 */
public class RBNode<Key extends Comparable<Key>, Value> {
    public static final boolean RED   = true;
    public static final boolean BLACK = false;

    public Key key;           // key
    public Value val;         // associated data
    public RBNode<Key, Value> left, right;  // links to left and right subtrees
    public boolean color;     // color of parent link. See RED/BLACK for value.
    public int size;          // subtree count

    public RBNode(Key key, Value val, boolean color, int size) {
        this.key = key;
        this.val = val;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "("+this.key+":"+this.val+"> c="+(color? "RED": "BLACK")+"> s="+size+")";
    }
}