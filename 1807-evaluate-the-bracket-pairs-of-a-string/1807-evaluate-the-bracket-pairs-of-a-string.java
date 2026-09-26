class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();

        HashMap<String, String> map = new HashMap<>();
        for(List<String> i : knowledge){
            map.put(i.get(0), i.get(1));
        }

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                StringBuilder temp = new StringBuilder();
                i++;
                while(s.charAt(i)!=')'){
                    temp.append(s.charAt(i));
                    i++;
                }
                if(map.containsKey(temp.toString())){
                    sb.append(map.get(temp.toString()));
                }
                else{
                    sb.append('?');
                }
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}