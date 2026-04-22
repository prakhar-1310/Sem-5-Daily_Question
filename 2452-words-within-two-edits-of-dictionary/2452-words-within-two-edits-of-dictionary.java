class Solution {
    public List<String> twoEditWords(String[] queries, String[] dic) {
        List<String>list = new ArrayList<>();
        int len = queries[0].length();
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<dic.length; j++){
                int c=0;
                for(int k=0;k<len;k++){
                    if(queries[i].charAt(k)!=dic[j].charAt(k)){
                        c++;
                    }

                    if(c>2){
                        break;
                    }
                }

                if(c<=2){
                    list.add(queries[i]);
                    break;
                }
            }
        }

        return list;
    }
}