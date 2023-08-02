package ezen.ams.app;

import java.util.List;
import java.util.Scanner;

import ezen.ams.domain.Account;
import ezen.ams.domain.ListAccountRepository;
import ezen.ams.exception.NotBanlanceException;


public class AMS2 {
	
	//private static AccountRepository repository = new MemoryAccountRepository();
	private static ListAccountRepository repository = new ListAccountRepository();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws NotBanlanceException {
		System.out.println("*****************************************");
		System.out.println("** "+Account.BANK_NAME+"은행 계좌 관리 애플리케이션 **");
		System.out.println("*****************************************");
		
		// 가상데이터 임시 등록
		
		repository.addAccount(new Account("주주주", 1234, 100000000));
		repository.addAccount(new Account("성성성", 1234, 100000000));
		repository.addAccount(new Account("민민민", 1111, 1000));
		repository.addAccount(new Account("민성주", 1331, 100000));
		
		
		boolean run = true;
		
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.입금|4.출금|5.대출|6.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			if (selectNo == 1) {
				// 계좌 생성 및 등록
				createAccount();
			} else if (selectNo == 2) {
				// 계좌목록
				list();
			} else if (selectNo == 3) {
				//입금
				deposit();
			} else if (selectNo == 4) {
				// 출금
				withdraw();
			} else if (selectNo == 5) {
				// 대출
				
			} else if (selectNo == 6) {
				run = false;
			}
		}
		scanner.close();
		System.out.println("계좌관리 애플리케이션을 종료합니다.");
	}
	
	/**
	 * 키보드(표준입력)로부터 계좌정보 입력 받아 계좌생성하기
	 */
	private static void createAccount() {
		System.out.print("예금주명: ");
		String owner = scanner.nextLine();

		System.out.print("비밀번호: ");
		int passwd = Integer.parseInt(scanner.nextLine());
		
		System.out.print("입금액: ");
		long inputMoney = Long.parseLong(scanner.nextLine());
		
		Account account =new Account(owner, passwd, inputMoney);
		
		// AccountRepository에 계좌등록
		repository.addAccount(account);
		System.out.println("※ 계좌 정상 등록 처리되었습니다.");
	}
	/**
	 * 계좌목록 확인
	 */
	private static void list() {
		System.out.println("----------------------------------------------");
		System.out.println("번호    이름  비밀번호    잔액");
		System.out.println("----------------------------------------------");
		List<Account> list =  repository.getAccounts();
		for (Account account : list) {
			account.printInfo();
		}
	}
	/**
	 * 입금
	 * @throws NotBalanceException 
	 */
	
	private static void deposit() throws NotBanlanceException {
		System.out.print("계좌번호 : ");
	      String accountNum = scanner.nextLine();
	      Account searchAccount = repository.searchAccount(accountNum);
	      if(searchAccount != null) {
	         System.out.print("입금액: ");
	         long inputMoney = Long.parseLong(scanner.nextLine());
	         long restMoney = searchAccount.deposit(inputMoney);
	          System.out.println("입금 후 잔액: "+restMoney);
	      }else {
	         System.out.println("계좌번호에 해당하는 계좌가 존재하지 않습니다.");
	      }	        
	      
	   }
		
	/**
	 * 출금	
	 * @throws NotBalanceException 
	 */
	
	private static void withdraw() throws NotBanlanceException{
		System.out.print("계좌번호 : ");
		 String accountNum = scanner.nextLine();
		 Account searAccount = repository.searchAccount(accountNum);
		 if(searAccount != null) {
			 System.out.print("출금액 : ");
			 long outputMoney = Long.parseLong(scanner.nextLine());
			 long restMoney = searAccount.withdraw(outputMoney);
			 System.out.println("출금 후 잔액 : " + restMoney);
		 }else {
			 System.out.println("계좌번호에 해당하는 계좌가 존재하지 않습니다.");
		 }
		 
	 }
	


}	