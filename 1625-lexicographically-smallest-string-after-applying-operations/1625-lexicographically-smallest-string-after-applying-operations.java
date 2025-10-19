class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String>q = new LinkedList<>();
        HashSet<String>visited = new HashSet<>();

        q.add(s);
        String smallest = s; 
        while(!q.isEmpty()){
            String r = q.poll();

            if(visited.contains(r)){
                continue;
            }

            visited.add(r);

            if(r.compareTo(smallest)<0){
                smallest=r;
            }

            q.add(add(r,a));
            q.add(rotate(r,b));
        }

        return smallest;
    }

    public String add(String str, int a){
        char arr[] = str.toCharArray();
        for(int i=1;i<str.length();i+=2){
            int temp = ((arr[i]-'0')+a)%10;
            arr[i] = (char)(temp+'0');
        }

        return new String(arr);
    }

    public String rotate(String str, int k){
        StringBuilder sb = new StringBuilder(str);
        rot(sb,0,k-1);
        rot(sb,k,str.length()-1);
        rot(sb,0,str.length()-1);
        return sb.toString();
    }

    public void rot(StringBuilder sb, int a, int b){
        while(a<b){
            char temp = sb.charAt(a);
            sb.setCharAt(a,sb.charAt(b));
            sb.setCharAt(b,temp);
            a++;
            b--;
        }
    }
}