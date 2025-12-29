class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // bfs
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        int ans = Integer.MAX_VALUE;

        HashSet<String>visited = new HashSet<>();

        while(!q.isEmpty()){
            Pair rm = q.poll();

            if(visited.contains(rm.word)){
                continue;
            }

            visited.add(rm.word);

            if(rm.word.equals(endWord)){
                ans = Math.min(ans,rm.step);
                continue;
            }

            for(int i=0;i<rm.word.length();i++){    
                for(int j=0;j<26;j++){
                    char ch = (char)('a'+j);
                    if(ch==rm.word.charAt(i)) continue;
                    String newWord = rm.word.substring(0,i)+ch+rm.word.substring(i+1,rm.word.length());
                    if(dict.contains(newWord) && !visited.contains(newWord)){
                        q.add(new Pair(newWord,rm.step+1));
                    }
                        
                }
            }
        }

        return ans==Integer.MAX_VALUE ? 0 : ans;
    }

    class Pair{
        String word;
        int step;

        public Pair(String word, int step){
            this.word = word;
            this.step = step;
        }
    }
}