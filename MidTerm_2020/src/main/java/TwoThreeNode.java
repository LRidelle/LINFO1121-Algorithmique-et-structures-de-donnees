/**
 * Interface vers des noeuds d'un arbre 2-3 *valide*. Les cles dans l'arbre sont *uniques*.
 */
public interface TwoThreeNode {
    /**
     * @return true si le noeud est un noeud 3 (s'il contient 2 valeurs et 3 enfants).
     */
    boolean isThreeNode();

    /**
     * @return le noeud a gauche, contenant les valeurs plus petites que getFirstValue()
     */
    TwoThreeNode getLeft();

    /**
     * @return La premiere cle. Elle est toujours presente, meme dans un 2-noeud.
     */
    int getFirstValue();

    /**
     * @return le noeud au centre, contenant les valeurs plus grandes que getFirstValue() et plus petite que getSecondValue().
     * existe toujours, meme dans un 2-noeud (il contient alors les noeuds plus grand que getFirstValue()).
     */
    TwoThreeNode getCenter();

    /**
     * @return La seconde cle. Presente uniquement si c'est un 3-noeud.
     * Si cette fonction est appelee alors que isThreeNode est faux, lance une Exception.
     */
    int getSecondValue() throws Exception;

    /**
     * @return le noeud parent des valeurs plus grandes que la seconde cle.
     * Si cette fonction est appelee alors que isThreeNode est faux, lance une Exception.
     */
    TwoThreeNode getRight() throws Exception;
}
