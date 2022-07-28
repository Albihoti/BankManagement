package BankMangment;

public class SavingAccount extends Account{

    public SavingAccount(int id, String name, double balance){
        super(id,name,balance);
    }

    public SavingAccount(SavingAccount savingAccount) {
        super();
    }

    @Override
    public void deposit(double shuma) {
        super.setBalance(super.round(super.getBalance()+shuma));

    }

    @Override
    public boolean withdraw(double shuma) {
        super.setBalance(super.getBalance()-shuma-5);
        return true;
    }

    @Override
    public Account clone() {
        return new SavingAccount(this);
    }
}
