class Solution {
    public boolean isAnagram(String s, String t) {
        // if (s.length()!=t.length()){
        //     return false;
        // }
        // char a[] = new char[s.length()];
        // a = s.toCharArray();
        // Arrays.sort(a);
        // char b[] = t.toCharArray();
        // Arrays.sort(b);
        // for (int i=0;i<s.length();i++){
        //     if (a[i]!=b[i]){
        //         return false;
        //     }
        // }
        // return true;


        // Method 2

        HashMap<Character,Integer>map = new HashMap<>();
        for (char i : s.toCharArray()){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for (char i : t.toCharArray()){
            map.put(i, map.getOrDefault(i,0)-1);
        }

        for(int i : map.values()){
            if(i!=0){
                return false;
            }
        }

        return true;

        
        
    }
}