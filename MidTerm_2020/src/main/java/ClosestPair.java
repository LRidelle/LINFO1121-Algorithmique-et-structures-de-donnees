import java.util.Arrays;

public class ClosestPair {

    /**
     *
     * @param input a non empty array
     * @return an array containing two values a,b present in the input array (possibly the same value)
     *         such that |x-(a+b)| is minimum
     *
     */
    public static int[] closestPair(int [] input, int x){
        int l = 0;
        int r = input.length-1;

        Arrays.sort(input);

        int[] pair = new int[]{input[l], input[r]};
        int val = Math.abs(x - input[l] - input[r]);

        while(l!=input.length && r!=-1){
            int m = x - input[l] - input[r];
            if(m == 0){ return new int []{input[l], input[r]}; }
            if(Math.abs(m) < val){
                pair[0] = input[l];
                pair[1] = input[r];
                val = Math.abs(m);
            }
            if (m<0){ r--; }
            if (m>0){ l++; }
        }
        return pair;
    }

    public static int[] closestPairV1(int [] input, int x) {
        int[] pair = {input[0], input[0]};
        int val = pair[0] + pair[1];
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input.length; j++){
                if(x - (input[i] + input[j]) == 0){ return new int[]{input[i], input[j]}; }
                if(Math.abs(x - val) >= Math.abs(x - (input[i] + input[j]))){
                    pair[0] = input[i];
                    pair[1] = input[j];
                    val = pair[0] + pair[1];
                }
            }
        }
        return pair;
    }

    public static int[] closestPairV2(int [] input, int x) {
        Arrays.sort(input);  //n*log(n)
        int n = input.length;
        int[] pair = {input[0], input[0]};
        int res = Math.abs(x - 2 * input[0]);
        for(int i=0; i<input.length; i++){
            if(Math.abs(x - input[i] - input[n-i-1]) == 0){ return new int[]{input[i], input[n-i-1]}; }
            if(Math.abs(x - 2 * input[i]) == 0){ return new int[]{input[i], input[i]}; }
            if(Math.abs(x - 2 * input[n-i-1]) == 0){ return new int[]{input[n-i-1], input[n-i-1]}; }
            if(Math.abs(x - input[i] - input[n-i-1]) <= res){
                res = Math.abs(x - input[i] - input[n-i-1]);
                pair[0] = input[i];
                pair[1] = input[n-i-1];
            }
            if(Math.abs(x - 2 * input[i]) <= res){
                res = Math.abs(x - 2 * input[i]);
                pair[0] = input[i];
                pair[1] = input[i];
            }
            if(Math.abs(x - 2 * input[n-i-1]) <= 0){
                res = Math.abs(x - 2 * input[n-i-1]);
                pair[0] = input[n-i-1];
                pair[1] = input[n-i-1];
            }
            if(i != 0 && Math.abs(x - input[i] - input[n-i]) <= res){
                res = Math.abs(x - input[i] - input[n-i]);
                pair[0] = input[i];
                pair[1] = input[n-i];
            }
            if(i != 0 && Math.abs(x - input[i-1] - input[n-i-1]) <= res){
                res = Math.abs(x - input[i-1] - input[n-i-1]);
                pair[0] = input[i-1];
                pair[1] = input[n-i-1];
            }
        }
        return pair;
    }

}
