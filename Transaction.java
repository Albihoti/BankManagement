package BankMangment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Comparable<Transaction>{


    public enum Type{
        WITHDRAW, DEPOSIT
    }
    private Type type;
    private long timestamp;
    private int id;
    private double amount;

    public Transaction(Type type, long timestamp, int id, double amount) {
        if(id==0 || amount<0){
            throw new IllegalArgumentException("Invalid Params");
        }
        this.type = type;
        this.timestamp = timestamp;
        this.id = id;
        this.amount = amount;
    }
    public Transaction(Transaction source){
        this.amount = source.amount;
        this.id = source.id;
        this.timestamp = source.timestamp;
        this.type = source.type;
    }
    public int getId(){
        return this.id;
    }
    public long getTimestamp(){
        return this.timestamp;
    }
    public Type getType(){
        return this.type;
    }
    public double getAmount(){
        return this.amount;
    }
    public void setId(int id){
        if(id==0){
            throw new IllegalArgumentException("Invalid ID");
        }
        this.id = id;
    }
    public void setType(Type type){
        this.type = type;
    }
    public void setTimestamp(long timestamp){
        this.timestamp = timestamp;

    }
    public void setAmount(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Amount can't be negative");
        }
        this.amount = amount;
    }

    public String returnDate(){
        Date date = new Date(this.timestamp * 1000);
        return  new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.timestamp, o.timestamp);
    }

    @Override
    public String toString() {
        return (type)+ "    "+
                "\t"+ returnDate()+" "+
                "\t" +id +" "+
                "\t$" +amount+"";
    }
}
