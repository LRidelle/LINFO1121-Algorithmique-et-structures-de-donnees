import java.util.Arrays;

public class MinMaxHeap<Key extends Comparable<Key>> {

    // ---------------------------------------------------------------------------------------
    // Instance variables
    // ---------------------------------------------------------------------------------------

    // You are not allowed to add/delete variables, nor modifying their names or visibility.
    public Key[] pq;          // contains the elements starting at position 1
    public int N = 0;         // number of elements in the heap
    public int height = 0;    // should help you to know if you are at a level min or max

    // ---------------------------------------------------------------------------------------------------
    // Functions that you should implement. This is the only part of this class that you should modify ;-)
    // ---------------------------------------------------------------------------------------------------

    /**
     * @pre size() >= 1
     */
    public Key min() {
        //TODO O(1) expected
        if(!isEmpty())
            return pq[1];
        return null;
    }

    /**
     * @pre size() >= 1
     */
    public Key max() {
        //TODO O(1) expected
        if(N == 1)
            return pq[1];
        if (N == 2)
            return pq[2];
        if(N > 2){
            if (less(2, 3))
                return pq[3];
            return pq[2];
        }
        return null;
    }

    /**
     * @pre 1 <= k <= size()
     */
    private void swim(int k) {
        //TODO O(log N) expected
        int i = k;
        int currHeight = height;
        while(i > 1){
            if(currHeight%2 == 0){  //Etage MAX
                if(less(i, i / 2)){  //SI x < son parent MIN ALORS on les echanges
                    exch(i, i/2);
                    i = i/2;
                    currHeight = currHeight - 1;
                }
                else if(i > 4 && !less(i, i/4)){  //SI x > son parent MAX ALORS on les echanges
                    exch(i, i/4);
                    i = i/4;
                    currHeight = currHeight - 2;
                }
                else{
                    break;
                }
            }
            else{  //Etage MIN
                if(!less(i, i / 2)){  //SI x > son parent MAX ALORS on les echanges
                    exch(i, i/2);
                    i = i/2;
                    currHeight = currHeight - 1;
                }
                else if(i >= 4 && less(i, i/4)){  //SI x < son parent MIN ALORS on les echanges
                    exch(i, i/4);
                    i = i/4;
                    currHeight = currHeight - 2;
                }
                else{
                    break;
                }
            }
        }

        /*if(height%2 == 0){           //Etage MAX
            while(i > 1){
                if(less(i, i / 2)){  //SI x < son parent MIN ALORS on les echanges
                    exch(i, i/2);
                    i = i/2;
                }
                else if(i > 4 && !less(i, i/4)){  //SI x > son parent MAX ALORS on les echanges
                    exch(i, i/4);
                    i = i/4;
                }
                else{
                    break;
                }
            }
        }
        else{                        //Etage MIN
            while(i > 1){
                if(!less(i, i / 2)){  //SI x > son parent MAX ALORS on les echanges
                    exch(i, i/2);
                    i = i/2;
                }
                else if(i >= 4 && less(i, i/4)){  //SI x < son parent MIN ALORS on les echanges
                    exch(i, i/4);
                    i = i/4;
                }
                else{
                    break;
                }
            }
        }*/
    }

    // ---------------------------------------------------------------------------------------
    // Constructor and helpers. You should not modify this. However, using them may be useful.
    // ---------------------------------------------------------------------------------------

    public MinMaxHeap(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    /**
     * @return pq[i] < pq[j]
     */
    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * Exchanges positions i and j in pq
     */
    private void exch(int i, int j) {
        Key e = pq[i];
        pq[i] = pq[j];
        pq[j] = e;
    }

    /**
     * @return true if the heap is empty, false else
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * @return the size of the heap
     */
    public int size() {
        return N;
    }

    /**
     * @param v value to insert in the heap. v != null.
     */
    public void insert(Key v) {
        pq[++N] = v;
        if (N >= (1 << height)) height++;
        swim(N);
    }

    @Override
    public String toString() {
        return Arrays.toString(pq);
    }
}