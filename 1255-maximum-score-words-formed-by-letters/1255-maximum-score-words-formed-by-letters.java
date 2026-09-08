class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character, Integer>map = new HashMap<>();
        for(char ch : letters){
            if(!map.containsKey(ch))map.put(ch, 0);

            map.put(ch, map.get(ch)+1);
        }

        return helper(0, words, map, score);


    }

    public int helper(int ind, String words[], HashMap<Character, Integer>map, int score[]){
        if(ind>=words.length)return 0;

        HashMap<Character, Integer>tem = new HashMap<>(map);

        int ans=0;

        //take

        for(char ch : words[ind].toCharArray()){
            if(map.containsKey(ch) && map.get(ch)>0){
                ans+=score[ch-'a'];
                map.put(ch, map.get(ch)-1);
            }
            else{
                ans=0;
                break;
            }
        }

        ans+=helper(ind+1, words, map, score);

        // skip

        int opt2 = helper(ind+1, words, tem, score);

        return Math.max(ans, opt2);
    }
}