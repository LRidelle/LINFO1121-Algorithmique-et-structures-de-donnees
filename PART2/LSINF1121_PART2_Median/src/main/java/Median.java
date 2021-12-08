
public class Median {
	
    public static int median(Vector a, int lo, int hi) {
        sort(a, lo, hi);
        return a.get(lo + (hi-lo)/2);
    }

    public static void sort(Vector a, int lo, int hi){
        if(hi<=lo) return;
        int j=partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public static int partition(Vector a, int lo, int hi){
        int i=lo;
        int j=hi+1;
        int val=a.get(lo);
        while(true){
            while(a.get(++i)<val) if(i==hi) break;
            while(val<a.get(--j)) if(j==lo) break;
            if(i>=j) break;
            a.swap(i, j);
        }
        a.swap(lo, j);
        return j;
    }
}
