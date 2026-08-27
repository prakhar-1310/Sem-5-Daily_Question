class Solution {
    public String lexGreaterPermutation(String s, String target) {
        HashMap<Character, Integer>map = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch))map.put(ch,0);

            map.put(ch, map.get(ch)+1);
        }
        List<Character>list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int idx=-1;
        for(int i=0;i<target.length();i++){
            char ch = target.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>0){
                ///System.out.println(sb);
                sb.append(ch);
                map.put(ch, map.get(ch)-1);
            }
            else{
                //System.out.println(sb);
                idx=i;
                break;
            }
        }
        int flag=0;
        if(idx==-1){
            System.out.println("hii");
            
            
                for(int i=target.length()-1;i>=0;i--){
                    char chi = target.charAt(i);
                    for(char c: list){
                        if(c>chi && map.get(c)>0){
                            String n = sb.substring(0,i)+c;
                            sb = new StringBuilder(n);
                            map.put(chi, map.get(chi)+1);
                            map.put(c, map.get(c)-1);
                            for(char ch : list){
                                while(map.get(ch)>0){
                                    sb.append(ch);
                                    map.put(ch, map.get(ch)-1);
                                }
                            }
                            return sb.toString();
                        }
                    }
                    map.put(chi, map.get(chi)+1);
                }
            
            
        }
        else{
            //System.out.println("hii");
            for(char c : list){
                if(map.get(c)>0 && target.charAt(idx)<c){
                    sb.append(c);
                    map.put(c, map.get(c)-1);

                    for(char ch : list){
                        while(map.get(ch)>0){
                            sb.append(ch);
                            map.put(ch, map.get(ch)-1);
                        }
                    }

                    return sb.toString();
                }
            }

            for(int i=idx-1;i>=0;i--){
                char chi = target.charAt(i);
                for(char c: list){
                    if(c>chi && map.get(c)>0){
                        String n = sb.substring(0,i)+c;
                        sb = new StringBuilder(n);
                        map.put(chi, map.get(chi)+1);
                        map.put(c, map.get(c)-1);
                        for(char ch : list){
                            while(map.get(ch)>0){
                                sb.append(ch);
                                map.put(ch, map.get(ch)-1);
                            }
                        }
                        return sb.toString();
                    }
                }
                map.put(chi, map.get(chi)+1);
            }

        }

        return "";

    }
}