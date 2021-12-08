import structures.RBNode;
import structures.TwoThreeNode;

public class Converter {

    /**
     * Converts a given 2-3 tree to a red-black tree.
     *
     *
     * Build here the Red-Black tree
     * To do so traverse (left most deep first) the 2-3 tree and for each 2-3 node
     * depending on if it is 2-node or 3-node make the right transformation to a Red-Black tree.
     * @return The Red-Black Tree from the 2-3 tree.
     */
    public static <Key extends Comparable<Key>, Value> RBNode<Key, Value> convert(TwoThreeNode<Key, Value> tttNode) {
        if (tttNode == null) return null;
        //TODO Student
        if(tttNode.is2node()){
            int size=tttNode.getnChildren()+1; //FAUX à modifier
            RBNode<Key, Value> rbNode = new RBNode<>(tttNode.leftKey, tttNode.leftValue, RBNode.BLACK, 0);
            if(tttNode.leftChild!=null) {
                //size += tttNode.leftChild.getnChildren();
                rbNode.left = convert(tttNode.leftChild);
            }
            if(tttNode.centerChild!=null) {
                //size += tttNode.centerChild.getnChildren();
                rbNode.right = convert(tttNode.centerChild);
            }
            size=size(tttNode, 1);
            rbNode.size = size;
            return rbNode;
        }
        if(tttNode.is3node()){
            int sizeBlack = 2;
            int sizeRed = 1;
            if(tttNode.rightChild!=null)
                sizeBlack++;
            if(tttNode.leftChild!=null)
                sizeRed++;
            if(tttNode.centerChild!=null)
                sizeRed++;
            RBNode<Key, Value> rbNodeBlack = new RBNode<>(tttNode.rightKey, tttNode.rightValue, RBNode.BLACK, 0);
            RBNode<Key, Value> rbNodeRed = new RBNode<>(tttNode.leftKey, tttNode.leftValue, RBNode.RED, 0);
            rbNodeBlack.left = rbNodeRed;
            if(tttNode.rightChild!=null) {
                sizeBlack += tttNode.leftChild.getnChildren();
                rbNodeBlack.right = convert(tttNode.rightChild);
            }
            if(tttNode.leftChild!=null) {
                sizeRed += tttNode.leftChild.getnChildren();
                rbNodeRed.left = convert(tttNode.leftChild);
            }
            if(tttNode.centerChild!=null) {
                sizeRed += tttNode.centerChild.getnChildren();
                rbNodeRed.right = convert(tttNode.centerChild);
            }

            rbNodeBlack.size=sizeBlack;
            rbNodeRed.size=sizeRed;
            return rbNodeBlack;
        }
        return null;
    }

    // A small utility function that may help you (or not)
    private static <Key extends Comparable<Key>, Value> int sizeEvenIfNull(RBNode<Key, Value> node) {
        return node == null ? 0 : node.size;
    }

    private static <Key extends Comparable<Key>, Value> int size(TwoThreeNode<Key, Value> node, int size){
        //TwoThreeNode<Key, Value> runner=node;
        if(node==null)
            return size;
        if(node.is2node()){
            return size(node.leftChild, size) + size(node.centerChild, size);
        }
        if(node.is3node()){
            return size(node.rightChild, size) +size(node.leftChild, size) + size(node.centerChild, size);
        }
        return 0;
    }

}