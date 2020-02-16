package yichang;

public class Account {
	protected double balance;
	public Account() {
		balance=0;
	}
	public Account(double init) {
		balance=init;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amt) {
		balance+=amt;
	}
	public void withdraw(double amt) throws OverdraftException{
		if(amt>=balance) {
			throw new OverdraftException("余额不足",amt-balance);
		}else {
			balance-=amt;
		}
	}
	class OverdraftException extends Exception{
		private double deficit;
		public OverdraftException(String message,double deficit) {
			super(message);
			this.deficit=deficit;
		}
		public double getDeficit() {
			return deficit;
		}
	}
	public static void main(String[] args) {
		Account acc=new Account();
		acc.deposit(100);
		try{
            acc.withdraw(200);
        } catch(OverdraftException e){
            System.out.println("异常的具体原因："+e.getMessage());
            e.printStackTrace();
        }
	}
}
