class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        HashMap<Character,int []>map = new HashMap<>();
        for(String i : votes){
            for(int j=0;j<i.length();j++){
                if(!map.containsKey(i.charAt(j))){
                    map.put(i.charAt(j), new int[n]);
                }
                map.get(i.charAt(j))[j]++;
            }
        }

        List<Character>list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b)->{
            for(int i=0;i<n;i++){
                if(map.get(a)[i]!=map.get(b)[i]){
                    return map.get(b)[i]-map.get(a)[i]; // more vote, higher rank
                }
            }

            return a-b; // if equal votes then alphabetically
        });


        StringBuilder sb= new StringBuilder();
        for(char i : list){
            sb.append(i);
        }

        return sb.toString();

    }
}