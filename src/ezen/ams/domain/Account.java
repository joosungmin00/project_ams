package ezen.ams.domain;

import java.io.NotActiveException;

import java.util.Objects;

import ezen.ams.exception.NotBanlanceException;

/*
 * 은행계좌 추상화
 */
public class Account {
//	필드 캡슐화(은닉화)
//	인스턴스 변수들...
private String accountNum;
private String accountOwner;
private int passwd;
private long restMoney;

// public static String bankName = "이젠은행";
// 스태틱(정적,클래스)변수
// 상수
public final static String BANK_NAME= "이젠은행";
//private static int accountId = 1000;
private static int accountId;

//  초기화 블록
//  static 초기화 블록
 static {
		//System.out.println("초기화 블록 실행됨...");
//	주로 애플리케이션 환경설정파이르이 내용을 읽어 오는 코드...
	//--
	//--
	accountId = 1000;
	}




// 	생성자 오버로딩
public Account() {
	
}

// public Account(String accountNum, String accountOwner) {
//	 this(accountNum, accountOwner, 0, 0L);
// }

public Account(String accountOwner, int passwd, long restMoney) {
	//System.out.println("생성자 실행됨");
	this.accountNum = (accountId++) + "";
	this.accountOwner = accountOwner;
	this.passwd = passwd;
	this.restMoney = restMoney;
}


		

/*설정시 private 사용해도 변경 가능
		void setAccountNum(String num) {
			accountNum = num;
		}
		
		String getAccountNum() {
			return accountNum;
		}*/



// setter/getter 메소드
public String getAccountNum() {
	return accountNum;
}

public void setAccountNum(String accountNum) {
	this.accountNum = accountNum;
}

public String getAccountOwner() {
	return accountOwner;
}

 public void setAccountOwner(String accountOwner) {
	this.accountOwner = accountOwner;
}

public int getPasswd() {
	return passwd;
}

public void setPasswd(int passwd) {
	this.passwd = passwd;
}

public void setRestMoney(long restMoney) {
	this.restMoney = restMoney;
}
	

		/*
		 * 입금기능
		 */
		public long deposit(long money) throws NotBanlanceException{
			//데이터검증 및 예외처리
			if(money <= 0) {
				throw new NotBanlanceException("입금금액은 0이거나 음수일 수 없습니다.");
				
			}else if(money >= 100000000) {
				throw new NotBanlanceException("1억이상 입금할 수 없습니다.");
			}
			return restMoney += money;
		}
		
		

		/*
		 * 출금기능
		 */
		public long withdraw(long money) throws NotBanlanceException{
			//데이터검증 및 예외처리
			if(money <= 0) {
				throw new NotBanlanceException("출금금액은 0이거나 음수일 수 없습니다.");
				
			}else if(money >= 100000000) {
				throw new NotBanlanceException("1억이상 출금할 수 없습니다.");
			}else if(money > restMoney) {
				throw new NotBanlanceException("잔액이 부족여 출금할 수 없습니다.");
			}
			return restMoney -= money;
		}
		
		/*
		 * 잔액조회 기능
		 */
		public long getRestMoney() {
			return restMoney;
		}
		
		
		/*
		 * 비밀번호 확인 기능
		 */
		
		public boolean checkPasswd(int pwd) {
			return passwd == pwd;
			
		}
		
		public void  printInfo() {
			System.out.println(accountNum + "\t" + accountOwner + "\t******\t" + restMoney );
		}
		
		
		
		@Override
		public String toString() {
			return accountNum + "\t" + accountOwner + "\t******\t" + restMoney;
//			return "Account [accountNum=" + accountNum + ", accountOwner=" + accountOwner + ", passwd=" + passwd
//					+ ", restMoney=" + restMoney + "]";
		}

		//		스태틱(클래스) 메소드
		public static int getAccountId() {
			return accountId;
		}

		
	

		@Override
		public boolean equals(Object obj) {
			
			return toString().equals(obj.toString());
			
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			Account other = (Account) obj;
//			return Objects.equals(accountNum, other.accountNum) && Objects.equals(accountOwner, other.accountOwner)
//					&& passwd == other.passwd && restMoney == other.restMoney;
		}
		
		
}
