class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if(a.length>b.length){
            int tem[] = a;
            a=b;
            b=tem;
        }
        int tot= a.length + b.length;
        int half = (tot+1)/2; // handling both even and odd
        int low = 0;
        int high = a.length; // al ke left tk ka element lete h, agar al=a.length then all element from array a;

        while(low<=high){
            int al = (low+high)/2;
            int bl = half - al;
           
            int aleft = (al==0)? Integer.MIN_VALUE : a[al-1];
            int bleft = (bl==0)? Integer.MIN_VALUE : b[bl-1];
            int aright = (al == a.length) ? Integer.MAX_VALUE : a[al];
            int bright = (bl==b.length) ? Integer.MAX_VALUE : b[bl];
            if(aleft<=bright && bleft<=aright){
                if(tot%2==0){
                    double ans = Math.max(aleft,bleft) + Math.min(aright,bright);
                    return ans/2.0;
                }
                else{
                    return Math.max(aleft,bleft)/1.0;
                }
            }
            else if (bleft>aright){
                low=al+1;
            }
            else if(bright<aleft){
                high=al-1;
            }
        }

        return 0;

    }
}