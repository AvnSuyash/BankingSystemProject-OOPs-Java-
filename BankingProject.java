import java.util.*;
class BankAccount{
    BankAccount(){

    }
  protected String account_number;
   String account_holder_name;
    double balance;
    BankAccount(String account_number,String name, double balance, double interest_rate){
        this.account_number=account_number;
this.account_holder_name=name;
this.balance=balance;
    }
    private List<String>transaction=new ArrayList<>();
    public void deposit(double amount){
        if(amount>=0){
            balance+=amount;
            System.out.println("Deposited amount:"+ amount);
            transaction.add("Deposited AMOUNT:"+amount);
        }
        else{
            System.out.println("Invalid amount!");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount<balance){
            balance-=amount;
            System.out.println("Withdrawl amount:"+amount);
            transaction.add("Withdrawl: " + amount);
        }else{
            System.out.println("Invalid amount entered.");
        }
    }
    public void printTransactionReport() {
        System.out.println("Transaction Report for Account: " + account_number);
        for (String transaction : transaction) {
            System.out.println(transaction);
        }
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountNumber() {
        return account_number;
    }
    public String getaccountholdersname(){
        return account_holder_name;
    }
    
}
class SavingsAccount extends BankAccount{
    private static final double interest_rate=0.04;
    SavingsAccount(String account_holder_name, String account_number,double balance){
        super.account_holder_name=account_holder_name;
        super.account_number=account_number;
        super.balance=balance;
    }
    void calculate_interest(){
        //Interest counted once every six month
        double interest=balance*interest_rate;
        balance+=interest;
        System.out.println("INTEREST amount:"+interest);
    }
}
class checkingAccount extends BankAccount{
    private static final double min_balance=500;
   public checkingAccount(String accountNumber, String accountHolderName, double balance) {
    super.account_holder_name=accountHolderName;
    super.account_number=accountNumber;
    super.balance=balance;
    }
    public void withdraw(double amount){
        if(amount>0 && (balance-amount)>=min_balance){
            balance-=amount;
            System.out.println("Withdrawn amount:"+amount);
        }else{
            System.out.println("You can't withdraw money because of insufficient balance.");
        }
    }
}
public class Bank{
    public static void main(String[] args) {
        SavingsAccount savings=new SavingsAccount("Suyash","10001",100000);
        System.out.println(savings.getaccountholdersname());
        System.out.println(savings.getAccountNumber());
        savings.deposit(5000);
        savings.calculate_interest();
        savings.withdraw(1000);
        System.out.println(savings.getBalance());
        savings.printTransactionReport();
    }
}
