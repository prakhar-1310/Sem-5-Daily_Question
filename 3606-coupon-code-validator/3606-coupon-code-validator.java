class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>list = new ArrayList<>();
        List<String>e = new ArrayList<>();
        List<String>g = new ArrayList<>();
        List<String>p = new ArrayList<>();
        List<String>r = new ArrayList<>();
        for(int i=0;i<code.length;i++){
            boolean flag=true;
            for(char ch : code[i].toCharArray()){
                if(Character.isLetterOrDigit(ch) || ch=='_'){

                }else{
                    flag=false;
                    break;
                }
            }
            if(code[i].equals("")){
                flag=false;
            }
            if(flag==false){
                continue;
            }

            if(businessLine[i].equals("grocery")||businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant") || businessLine[i].equals("electronics")){

            }
            else{
                continue;
            }

            if(isActive[i]==true){
                if(businessLine[i].startsWith("e"))e.add(code[i]);
                if(businessLine[i].startsWith("g"))g.add(code[i]);
                if(businessLine[i].startsWith("p"))p.add(code[i]);
                if(businessLine[i].startsWith("r"))r.add(code[i]);
            }
        }
        Collections.sort(e);
        Collections.sort(g);
        Collections.sort(p);
        Collections.sort(r);
        list.addAll(e);
        list.addAll(g);
        list.addAll(p);
        list.addAll(r);

        return list;
    }
}