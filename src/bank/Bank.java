package bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    public Bank(){
        accounts.put(1000, new BasicACC(new AccountData(
                1000, "Test1", "test1@gmail.com", 500
        )));

        accounts.put(2000, new VipACC(new AccountData(
                2000, "Test2", "test2@gmail.com", 500
        )));
    }

    public ActionResult<AccountData> getAccountById(int id){
        Account account = accounts.get(id);

        if(account != null) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("No account with id: " + id);
        }
    }

    public ActionResult<AccountData> deposit(AccountData accountData, int amount) {
        Account account = accounts.get(accountData.getId());
        account.deposit(amount);

        return  ActionResult.success(account.getAccountData());
    }


    public ActionResult<AccountData> withdraw(AccountData accountData, int amount) {
        Account account = accounts.get(accountData.getId());
        boolean ok = account.withdraw(amount);

        if(ok) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("Withdraw failed: " + amount + ". Account has: " + account.getBalance());
        }
    }
}
