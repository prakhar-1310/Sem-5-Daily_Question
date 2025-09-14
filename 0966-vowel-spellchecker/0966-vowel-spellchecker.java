class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String>set = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String,String>cap = new HashMap<>();
        HashMap<String,String>vow = new HashMap<>();
        for(String i : wordlist){
            String lower = tolower(i);
            String vows = vowel(lower);
            cap.putIfAbsent(lower,i);
            vow.putIfAbsent(vows,i);
        }
        
        String arr[] = new String[queries.length];
        for(int i=0;i<queries.length;i++){
            String q = queries[i];
            String lower = tolower(q);
            String vows = vowel(lower);
            if(set.contains(q)){
                arr[i]=q;
            }
            else if(cap.containsKey(lower)){
                arr[i] = cap.get(lower);
            }
            else if (vow.containsKey(vows)){
                arr[i] = vow.get(vows);
            }
            else{
                arr[i]="";
            }
            
        }
        return arr;
    }

    public String tolower(String q){
        return q.toLowerCase();
    }


    public String vowel(String q){
        StringBuilder sb = new StringBuilder();
        for(char i : q.toCharArray()){
            if(i=='a'||i=='e'||i=='i'||i=='o'||i=='u'){
                sb.append('*');
            }
            else{
                sb.append(i);
            }
        }
        return sb.toString();
    }
}