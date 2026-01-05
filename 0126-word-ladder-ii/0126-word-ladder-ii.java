class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>dict = new HashSet<>(wordList);
        HashMap<String,List<String>>map = bfs(beginWord,dict);
        
        List<List<String>>list = new ArrayList<>();
        List<String>ans = new ArrayList<>();
        ans.add(beginWord);
        dfs(beginWord, endWord,list,ans,map);
        return list;
    }

    public void dfs(String w, String end, List<List<String>>list, List<String>ans, HashMap<String,List<String>>map){
        if(w.equals(end)){
            list.add(new ArrayList<>(ans));
            return;
        }
        if(!map.containsKey(w))return;
        for(String ngbr : map.get(w)){
            ans.add(ngbr);
            dfs(ngbr,end,list,ans,map);
            ans.remove(ans.size()-1);
        }
    }

    public HashMap<String,List<String>> bfs(String w, HashSet<String>dict){
        HashMap<String,List<String>>map = new HashMap<>();
        HashMap<String,Integer>visited = new HashMap<>();
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(w,0));
        visited.put(w, 0);
        while(!q.isEmpty()){
            Pair rm = q.poll();

            // if(visited.containsKey(rm.vtx)){
            //     continue;
            // }
            // visited.put(rm.vtx,rm.dist);

            for(int i=0;i<rm.vtx.length();i++){
                for(int j=0;j<26;j++){
                    char ch = (char)('a'+j);
                    String str = rm.vtx.substring(0,i)+ch+rm.vtx.substring(i+1,rm.vtx.length());
                    if(dict.contains(str)){
                        if (!visited.containsKey(str)) {
                            visited.put(str, rm.dist + 1);
                            q.add(new Pair(str, rm.dist + 1));

                            map.putIfAbsent(rm.vtx, new ArrayList<>());
                            map.get(rm.vtx).add(str);
                        }
                        else if(visited.get(str)==rm.dist+1){
                            map.putIfAbsent(rm.vtx, new ArrayList<>());
                            map.get(rm.vtx).add(str);
                        }
                    }
                }
            } 
        }
        return map;
    }

    class Pair{
        String vtx;
        int dist;
        public Pair(String vtx, int dist){
            this.vtx = vtx;
            this.dist = dist;
        }
    }
}