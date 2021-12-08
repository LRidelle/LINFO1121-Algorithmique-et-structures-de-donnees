import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Union {

    public static Interval [] union(Interval [] intervals) {
        // TODO
        int n=intervals.length;
        if(n==0)
            return new Interval[]{};
        Arrays.sort(intervals);
        List<Interval> list=new ArrayList<>();
        int lo=intervals[0].min;
        int hi=intervals[0].max;
        for(int i=1; i<n; i++){
            if(hi<intervals[i].min){
                list.add(new Interval(lo,hi));
                lo=intervals[i].min;
                hi=intervals[i].max;
            }
            else if(hi<intervals[i].max){
                hi=intervals[i].max;
            }
        }
        list.add(new Interval(lo,hi));
        return list.toArray(new Interval[]{});
    }

}
