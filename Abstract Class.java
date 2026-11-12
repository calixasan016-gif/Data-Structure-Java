abstract class BankAccount {
    private String accountNumber;
    protected double balance;

    BankAccount(String accountNumber, double balance) { // abstract class constructors
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract void withdraw(double amount); // no body; each subclass must implement it

    void deposit(double amount) { // concrete: shared implementation
        if (amount <= 0) refuse("deposit must be more than 0");
        else balance += amount;
    }

    void refuse(String why) {
        System.out.println(" " + accountNumber + " refused: " + why);
    }

    void show() {
        System.out.println(" " + accountNumber + " balance: " + balance);
    }
}

// First Supper Class
class SavingsAccount extends BankAccount {
    SavingsAccount(String n, double b) { super(n, b); }

    @Override
    void withdraw(double amount) {
        if (balance - amount < 50) refuse("must keep at least 50");
        else balance -= amount;
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(String n, double b) { super(n, b); }

    @Override
    void withdraw(double amount) {
        if (balance - amount < -200) refuse("overdraft limit is 200");
        else balance -= amount;
    }
}

class StudentAccount extends BankAccount {
    StudentAccount(String n, double b) { super(n, b); }

    @Override
    void withdraw(double amount) {
        if (amount > 100) refuse("max 100 per withdrawal");
        else if (amount > balance) refuse("not enough money");
        else balance -= amount;
    }
}

// Secpond Supper Class
public class AbstractAccountDemo {
    public static void main(String[] args) {
        // BankAccount x = new BankAccount("BAS-1", 100); // cannot be instantiated

        BankAccount acc1 = new SavingsAccount("SAV-1", 200);
        BankAccount acc2 = new CurrentAccount("CUR-1", 200);
        BankAccount acc3 = new StudentAccount("STU-1", 200);

        acc1.deposit(50); acc1.withdraw(300); acc1.show();
        acc2.deposit(50); acc2.withdraw(300); acc2.show();
        acc3.deposit(50); acc3.withdraw(300); acc3.show();
    }
}

// Main Class
public class AbstractAccountDemo {
    public static void main(String[] args) {
        // BankAccount x = new BankAccount("BAS-1", 100); // cannot be instantiated

        BankAccount acc1 = new SavingsAccount("SAV-1", 200);
        BankAccount acc2 = new CurrentAccount("CUR-1", 200);
        BankAccount acc3 = new StudentAccount("STU-1", 200);

        acc1.deposit(50); acc1.withdraw(300); acc1.show();
        acc2.deposit(50); acc2.withdraw(300); acc2.show();
        acc3.deposit(50); acc3.withdraw(300); acc3.show();
    }
}
