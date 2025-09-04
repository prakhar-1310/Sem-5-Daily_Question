class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> map = new HashMap<>();
        for (String str : strs){
            int freq[] = new int[26];
            for (int i=0;i<str.length();i++){
                freq[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder ();
            for (int i=0;i<26;i++){
                sb.append(freq[i]);
                sb.append("#");
            }

            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);

        }
        List<List<String>> list = new ArrayList<>();
        for(String key : map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
}