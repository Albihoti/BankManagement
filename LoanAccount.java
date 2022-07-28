package BankMangment;

public class LoanAccount extends Account{

    public LoanAccount(int id, String name, double balance){
        super(id,name,balance);
    }

    public LoanAccount(LoanAccount loanAccount) {
    }

    @Override
    public void deposit(double shuma) {
        super.setBalance(super.round(super.getBalance()-shuma));

    }

    @Override
    public boolean withdraw(double shuma) {
        if(super.getBalance()+shuma > 10000){
            return  false;
        }
        super.setBalance(super.round(super.getBalance()+shuma+(shuma * 0.02)));
        return false;
    }

    @Override
    public Account clone() {
        return new LoanAccount(this);
    }


}
