package yichang;

import yichang.Account.OverdraftException;

public class CheckingAccount extends Account {
	private double overdraftProtection;
	public CheckingAccount() {
		super();
	}
	public CheckingAccount(double balance) {
		this.balance=balance;
	}
	public CheckingAccount(double balance,double protect) {
		this.balance=balance;
		this.overdraftProtection=protect;
	}
	public void deposit(double amt) {
		if(overdraftProtection<0) {
			overdraftProtection+=amt;
		}
		balance+=amt;
	}
	public void withdraw(double amt) throws OverdraftException{
		if(amt<=balance) {
			balance-=amt;
			System.out.println("卡内余额为："+balance);
		}else if(amt-balance<=overdraftProtection){
			balance-=amt;
			System.out.println("透支余额为："+(balance+overdraftProtection));
		}else {
			throw new OverdraftException("信用额不足",amt-balance-overdraftProtection);
		}
	}
	public static void main(String[] args) {
		CheckingAccount check=new CheckingAccount(0,2000);
		check.deposit(1000);
		try {
			check.withdraw(3000)		;
		} catch (OverdraftException e) {
			System.out.println("异常的具体原因："+e.getMessage());
			e.printStackTrace();
		}
	}
}
