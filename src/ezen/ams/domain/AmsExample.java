package ezen.ams.domain;

import ezen.ams.exception.NotBanlanceException;

public class AmsExample {

	public static void main(String[] args) {
		Account account = new Account("주성민",1111,10000);
		try {
			long restMoney = account.deposit(1000);
			System.out.println("정상처리 : " + account.getRestMoney());
			
			restMoney = account.withdraw(20000);
			System.out.println("출금 후 잔액: " + restMoney);
		} catch (NotBanlanceException e) {
			System.out.println(e.getMessage());
			
		}

	}

}
