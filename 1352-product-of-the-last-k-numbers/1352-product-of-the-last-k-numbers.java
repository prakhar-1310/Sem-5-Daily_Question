class ProductOfNumbers {
    List<Integer>list;
    int size;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        size=1;
        list.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            size=1;
            list = new ArrayList<>();
            list.add(1);
        }
        else{
            list.add(num);
            size++;
        }
        
    }
    
    public int getProduct(int k) {
        if(k>size-1)return 0;
        int n = list.size();
        int tot = 1;
        for(int i=1;i<=Math.min(k, size);i++){
            tot*=list.get(n-i);
        }
        return tot;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */