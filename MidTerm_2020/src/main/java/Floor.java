public class Floor {
    /**
     * @param node La racine d'un arbre 2-3
     * @param x
     * @return La valeur la plus proche possible de x (y compris x lui-meme) contenue dans l'arbre et plus petite que x.
     *         si une telle valeur n'existe pas, null.
     * @throws Exception
     *
     * @Idee : detecter le premier tourant a droite qui sera le node de retour.
     */
    public static Integer floor(TwoThreeNode node, int x) throws Exception { //Recussive
        if(node == null)
            return null;
        if(node.getFirstValue() > x)
            return floor(node.getLeft(), x);
        if(node.getFirstValue() == x)
            return x;
        if(node.isThreeNode()){
            if(node.getSecondValue() > x) {
                Integer res = floor(node.getCenter(), x);
                return res == null ? node.getFirstValue() : res;
            }
            else if(node.getSecondValue() == x)
                return x;
            else {
                Integer res = floor(node.getRight(), x);
                return res == null ? node.getSecondValue() : res;
            }
        }
        else {
            Integer res = floor(node.getCenter(), x);
            return res == null ? node.getFirstValue() : res;
        }
    }

    public static Integer floorV1(TwoThreeNode node, int x) throws Exception {
        if(node == null){ return null; }
        if(node.getFirstValue() == x){ return node.getFirstValue(); }
        if(node.isThreeNode()){
            if(node.getSecondValue() == x){ return node.getSecondValue(); }
            if(node.getSecondValue() < x){
                return floor(node.getRight(), x);
            }
            if(node.getFirstValue() > x){
                return floor(node.getCenter(), x);
            }
            return floor(node.getLeft(), x);
        }
        if(node.getFirstValue() > x){ return floor(node.getLeft(), x); }
        if(node.getFirstValue() < x){ return floor(node.getCenter(), x); }
        return node.getFirstValue();
    }
}
