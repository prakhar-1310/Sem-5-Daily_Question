class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        List<Long>list = new ArrayList<>();

        for(int i[] : points){
            int x = i[0];
            int y = i[1];

            if(y==0)list.add(x*1L);
            else if(x==side)list.add(1L*side+y);
            else if(y==side)list.add(3*1L*side-x);
            else list.add(4*1L*side-y);
        }

        Collections.sort(list);
        System.out.println(list);

        long left=1;
        long right = 2L*side;

        long ans=0;

        while(left<=right){
            long mid = left + (right-left)/2;

            if(poss(list,k,mid,side)){
                ans = mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return (int)ans;
    }

    public boolean poss(List<Long>list, int k, long mid, int side){
        for(int st=0;st<list.size();st++){
            
            int i=st+1;
            int cp=1;
            long last=list.get(st);
        
            while(cp < k){
                int idx = Collections.binarySearch(list, last + mid);
                if(idx < 0)
                    idx = -idx - 1;
                if(idx>=list.size() || idx >= st + list.size())
                    break;
                last = list.get(idx);
                cp++;
            }

            if(cp==k && 4L*side - (last - list.get(st)) >= mid){
                return true;
            }
        }

        return false;
    }
}