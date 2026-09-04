class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String>set = new HashSet<>();
        int taken[] = new int[tiles.length()];

        helper(taken, tiles, "", set);

        return set.size();
    }

    public void helper(int taken[], String tiles, String ans, HashSet<String>set){
        if(ans.length()!=0)set.add(ans);

        if(ans.length()==tiles.length())return;

        for(int i=0;i<tiles.length();i++){
            if(taken[i]==1)continue;

            taken[i]=1;
            helper(taken, tiles, ans+tiles.charAt(i), set);
            taken[i]=0;
        }
    }
}