
public class Ceil {
	/**
	 * Find in the tree the smallest element greater than or equal to value
	 * (so either the element itself or the element located directly after it
	 * in order of magnitude). If such an element does not exist,
	 * it must return null.
	 *
	 * Inserez votre reponse ici
	 */
	public static Integer ceil(Node root, int value) {
		if(root == null)
			return null;
		if(value == root.getValue())
			return root.getValue();
		if(value < root.getValue()) {
			if(ceil(root.getLeft(), value) != null)
				return ceil(root.getLeft(), value);
			else
				return root.getValue();
		}
		else
			return ceil(root.getRight(), value);
    }
}
