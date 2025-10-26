class Bank {
    private final long[] balance;

    public Bank(long[] balance) {
        this.balance = balance.clone(); 
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) return false;
        
        if (withdraw(account1, money)) {
            return deposit(account2, money);
        }

        return false;
    }
    
    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) return false;
        
        balance[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (!isValidAccount(account) || balance[account - 1] < money) return false;
       
        balance[account - 1] -= money;
        return true;
    }

    private boolean isValidAccount(int account) {
        return account >= 1 && account <= balance.length;
    }
}