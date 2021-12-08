import java.util.*;

   public class GlobalWarmingImpl extends GlobalWarming {

       int N=0;
       int[] union;

       public GlobalWarmingImpl(int[][] altitude, int waterLevel) {
           super(altitude,waterLevel);
           // expected pre-processing time in the constructror : O(n^2 log(n^2))
           int l=altitude.length;
           int c=altitude[0].length;
           int tot=l * c;
           union=new int[tot];
           for(int i=0; i<tot; i++)
               union[i]=i;

           for(int i=0; i<l; i++){
               for(int j=0; j<c; j++){
                   if(altitude[i][j] > waterLevel){
                       N++;
                       if(j!=0 && altitude[i][j-1]>waterLevel){
                           int a=allPoints(i*c+j);
                           int b=allPoints(i*c+j-1);
                           if(a!=b) {
                               union[a] = b;
                               N--;
                           }
                       }
                       if(i!=0 && altitude[i-1][j]>waterLevel){
                           int a=allPoints(i*c+j);
                           int b=allPoints((i-1)*c+j);
                           if(a!=b) {
                               union[a] = b;
                               N--;
                           }
                       }
                   }
               }
           }
       }

       public int nbIslands() {
           // TODO
           // expected time complexity O(1)
           return N;
       }


       public boolean onSameIsland(Point p1, Point p2) {
           // TODO
           // expected time complexity O(1)
           return allPoints(p1.x*altitude.length+p1.y) == allPoints(p2.x*altitude.length+p2.y) && !p1.equals(p2);
       }

       public int allPoints(int i){
           if(union[i] != i)
               union[i]=allPoints(union[i]);
           return union[i];
       }
   }