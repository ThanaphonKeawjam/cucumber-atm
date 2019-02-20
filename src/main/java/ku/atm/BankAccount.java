package ku.atm;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount {
   private double balance;
   private double overAmount;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount() {
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance) {
      balance = initialBalance;
      overAmount = -1;
   }

   public BankAccount(double initalBalacne, double overAmount){
      this.balance = initalBalacne;
      this.overAmount = overAmount;
   }
 
   /** 
      Deposits money into the account.
      @param amount the amount of money to withdraw
   */
   public void deposit(double amount) {
      balance = balance + amount;
   }

   /** 
      Withdraws money from the account.
      @param amount the amount of money to deposit
   */
   public void withdraw(double amount) throws NotEnoughBalanceException {
         double value = amount - balance;
         double pre_balance = balance - amount;
         if(amount > balance){
            if(overAmount == -1) throw new NotEnoughBalanceException("cannot withdraw more than balance");
            if(value > overAmount){
               throw new NotEnoughBalanceException("cannot withdraw more than balance");
            }else{
               overAmount = overAmount - value;
            }
         }
         if(pre_balance <= 0) {
            balance = 0;
            throw new NotEnoughBalanceException("can withdraw in range of overdraw");
         }
         else balance = balance - amount;
   }

   /** 
      Gets the account balance.
      @return the account balance
   */
   public double getBalance() {
      return balance; 
   }

   public double getOverAmount() {
      return overAmount;
   }
}

