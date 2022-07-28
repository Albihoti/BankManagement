package BankMangment;

public class ChequingAccount extends Account implements TaxAble {
    private static  final double OVERDRAFT = 5.50;
    private static final double OVERDRAFTLIMIT = -200;



    public ChequingAccount(int id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void deposit(double shuma) {
        super.setBalance(super.round(super.getBalance()+shuma));

    }

    @Override
    public boolean withdraw(double shuma) {
        if (super.getBalance() - shuma < OVERDRAFT) {
            return false;

        } else if (super.getBalance() - shuma < 0) {
            super.setBalance(super.round(super.getBalance() - shuma - OVERDRAFT));

        } else {
            super.setBalance(super.round(super.getBalance() - shuma));

        }
        return true;
    }

    @Override
    public Account clone() {
        return new ChequingAccount(this);
    }

    public ChequingAccount(ChequingAccount source){
        super(source);
    }


    @Override
    public void tax(double income) {
            double tax = Math.max(0, income - 3000)* 0.15;
            super.setBalance(super.round(super.getBalance()-tax));
    }
}
