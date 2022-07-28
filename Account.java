package BankMangment;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class Account {
    private int id;
    private String name;
    private double balance;

    public Account( int id, String name, double balance){
        if(id==0 || name==null || name.isBlank())
            throw new IllegalArgumentException("Invalid Parameters");
        this.id=id;
        this.name = name;
        this.balance = balance;
    }
    public Account (Account source){
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public Account() {

    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getBalance(){
        return this.balance;
    }

    public void setId(int id){
        if(id==0){throw new IllegalArgumentException("Invalid Id");}
        this.id = id;

    }
    public void setName(String name){
        if(name ==null || name.isBlank()){
            throw new IllegalArgumentException("Invalid Name");
        }
        this.name = name;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

    public abstract void deposit(double shuma);
    public abstract boolean withdraw(double shuma);
    public abstract Account clone();

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        return Double.parseDouble(formatter.format(amount));
    }
    @Override
    public String toString() {
        return (this.getClass().getSimpleName()) + "  " +
                "\t" + this.getId() + " " +
                "\t" + this.getName() + " " +
                "\t$" + this.getBalance() + " ";
    }


}
