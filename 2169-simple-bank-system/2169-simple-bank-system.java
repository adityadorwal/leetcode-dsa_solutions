class Bank {
    long acc[];
    int total_account;
    public Bank(long[] balance) {
        total_account = balance.length;
        acc = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        account1 --;
        account2 --;
        if(account1 > total_account || account2 > total_account || acc[account1] < money )return false;
        acc[account1] -= money;
        acc[account2] += money; 
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account > total_account)return false;
        account--;
        acc[account] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account > total_account)return false;
        account--;
        if(acc[account] < money)return false;
        acc[account] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */