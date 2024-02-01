import java.util.ArrayList;
import java.util.Scanner; 
  


class Account{
    private String name;
    private int number;
    private String creationDate;
    private double balance;

    public Account(String name, int number, String creationDate, double balance){
        this.name = name;
        this.number = number;
        this.creationDate = creationDate;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        if(name != null){
            this.name = name;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance > 0){
            this.balance = balance;
        }
    }

    public String toString(){
        return "Account [name=" + name + ", number=" + number + ", creationDate=" + creationDate + ", balance=" + balance + "]";
    }
}

class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    static int accountNumber = 1;


    public void createAccount(){
        System.out.println("Enter name: ");
        
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        
        int number = accountNumber++;
        
        // give creation date to today's date
        String today = java.time.LocalDate.now().toString();
        
        System.out.println("Enter balance: ");
        double balance = scanner.nextDouble();
        
        if(balance < 0){
            System.out.println("Balance cannot be negative");
            accountNumber--;
            return;
        }

        Account account = new Account(name, number, today, balance);
        accounts.add(account);
    }

    public void displayAllAccounts() {
        
        System.out.println("Total number of accounts: " + accounts.size());
        for(Account account: accounts){
            System.out.println(account.toString());
        }
        System.out.println();
    }
    public void updateAccount() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account number: ");
        int number = scanner.nextInt();
        // find the account with the given number from arrayList accounts  
        for(Account account: accounts){
            if(account.getNumber() == number){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter new name: ");
                String name = sc.nextLine();
                account.setName(name);

                System.out.println("Account with number " + number + " updated");
                return;
            }
        }
        System.out.println("Account with number " + number + " not found");
    }

    public void deleteAccount() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account number: ");
        int number = scanner.nextInt();
        // find the account with the given number from arrayList accounts  
        for(Account account: accounts){
            if(account.getNumber() == number){
                accounts.remove(account);
                System.out.println("Account with number " + number + " deleted");
                return;
            }
        }
        System.out.println("Account with number " + number + " not found");
    }

    public void depositAmount() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account number: ");
        int number = scanner.nextInt();
        // find the account with the given number from arrayList accounts  
        for(Account account: accounts){
            if(account.getNumber() == number){
                System.out.println("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                if(amount < 0){
                    System.out.println("Amount cannot be negative");
                    return;
                }
                double balance = account.getBalance();
                balance += amount;
                account.setBalance(balance);
                System.out.println(amount + "$ deposited successfully");
                return;
            }
        }
        System.out.println("Account with number " + number + " not found");
    }
    public void withdrawAmount() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account number: ");
        int number = scanner.nextInt();
        // find the account with the given number from arrayList accounts  
        for(Account account: accounts){
            if(account.getNumber() == number){
                System.out.println("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                if(amount < 0){
                    System.out.println("Amount cannot be negative");
                    return;
                }
                double balance = account.getBalance();
                if(balance < amount){
                    System.out.println("Insufficient balance");
                    return;
                }
                balance -= amount;
                account.setBalance(balance);
                System.out.println(amount + "$ withdrawn successfully");
                return;
            }
        }
        System.out.println("Account with number " + number + " not found");
    }
    public void searchAccount() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account number: ");
        int number = scanner.nextInt();
        // find the account with the given number from arrayList accounts  
        for(Account account: accounts){
            if(account.getNumber() == number){
                System.out.println(account.toString());
                return;
            }
        }
        System.out.println("Account with number " + number + " not found");
    }
}


public class SimpleBankingApp{
    public static void main(String[] args) {
        Bank bank = new Bank();
        
        int choice;
        do{
            System.out.println("1. Create a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Update an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Deposit an amount into your account");
            System.out.println("6. Withdraw an amount from your account");
            System.out.println("7. Search for account");
            System.out.println("8. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    bank.createAccount();
                    break;
                case 2:
                    bank.displayAllAccounts();
                    break;
                case 3:
                    bank.updateAccount();
                    break;
                case 4:
                    bank.deleteAccount();
                    break;
                case 5:
                    bank.depositAmount();
                    break;
                case 6:
                    bank.withdrawAmount();
                    break;
                case 7:
                    bank.searchAccount();
                    break;
                case 8:
                    System.out.println("Thank you for using our banking app");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 8);

    }
}