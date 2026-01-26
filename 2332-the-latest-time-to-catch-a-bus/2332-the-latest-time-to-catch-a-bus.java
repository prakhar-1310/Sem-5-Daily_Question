class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
//         sort both the arrays 
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        int last = 0; // keep track of the last passenger boarded on the bus;
        int j = 0; // a pointer to iterate on the passenger array
        HashSet<Integer> set = new HashSet<>(); // to keep track of all passengers boarded till on the bus
        
        for(int i = 0 ; i < buses.length ; i++){
            int count = 0; // keep a count of passengers on each bus, so that (count > capacity) never happen
            
            // keep boarding passengers on the current bus till there is capacity left on the bus and arrival time of passenger <= departure time of the bus
            while(j < passengers.length && count < capacity && passengers[j] <= buses[i]){
                last = passengers[j]; // update the last passenger
                set.add(passengers[j++]); // add the passenger in the set and increment the pointer
                    count++; // increment the count
            }
            
            // if we are on the last bus and the arrival time of last passenger boarded is less than the departure time of the last bus and still there is some space left so simply return the departure time of that bus as we can afford to reach at the bus station at that time and still able to get the bus because there is still some space and no valid passengers left to on board.
            if(i == buses.length - 1 && count < capacity && last < buses[i]){
                return buses[buses.length - 1];
            }
        }
        // another corner case, if there is no passenger then also we can  afford to reach the station by buses[buses.length - 1] time;
        if(set.size() == 0) return buses[buses.length - 1];
        
        // now the last variable tells us the arrival time of the last passenger who boarded so we must have to reach before him/her so that we can catch the bus, but also our arrival time must be unique so we will perform this operation.
        while(set.contains(last)) last--;
        
        return last; // return answer :)
    }
}