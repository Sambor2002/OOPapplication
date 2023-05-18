package bank;

public class VipACC extends Account{

    public static final int OVERDRAFT_LIMIT = 100;

    public VipACC(AccountData accountData) {
        super(accountData);
    }

    @Override
    protected boolean canwithdraw(int amount) {
        return getBalance() + OVERDRAFT_LIMIT >= amount;
    }
}
