class Solution {
    class Transaction{
        String name;
        int time;
        int amount;
        String place;
        public Transaction(String line){
            String[] arr = line.split(",");
            name = arr[0];
            time = Integer.parseInt(arr[1]);
            amount = Integer.parseInt(arr[2]);
            place = arr[3];
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        HashMap<String, List<Transaction>> map = new HashMap<>();
		
        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }
		// now go through the transaction list again and 
		// compare each transaction to the respective list for that name
        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
			// if transaction is not valid, add to final result
			// (notice we are passing to the function only the list of transactions for that specific name
			// we only care about transactions for the same name)
            if(!isValid(t, map.get(t.name))){
                invalid.add(transaction);
            }
        }
        return invalid;
    }
    public boolean isValid(Transaction t, List<Transaction> list){
        if(t.amount > 1000){
			return false;
		}
		// go through the list for that name
		// see if the time of the transaction is less than or equal to 60
		// and if the transaction is not in the same city
		// we hit the second condition return the transaction as false
        for(Transaction ta : list){
            if(Math.abs(ta.time - t.time) <= 60 && !ta.place.equals(t.place)){
				return false;
			}
        }
		// if we go through the entire list and we don't hit any condition, then the transaction is true
        return true;
    }
}