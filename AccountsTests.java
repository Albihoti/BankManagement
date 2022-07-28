package BankMangment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountsTests {
    Account[] accounts;

    @Before
    public void  setup(){
        accounts = new Account[]{
                new ChequingAccount(111111111,"Enar Kastrati", 1000),
                new LoanAccount(22222222,"Albi Hoti",1200),
                new SavingAccount(33333333, "Noar Kastrati",12400)
        };
    }
    @Test
    public void withdraw(){
        accounts[0].withdraw(144);
//      assertEquals(84.51, accounts[0].getBalance());
    }

    @Test
    public void overdraft(){
        accounts[0].withdraw(1534.43);
        assertEquals(-15.42,accounts[0].getBalance());
    }
}
