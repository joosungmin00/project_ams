

package ezen.ams.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 메모리(리스트)를 통해  은행계좌목록 저장 및 관리(검색, 수정, 삭제) 구현체
 * 
 * @author 주성민
 * @since 1.0
 */
public class ListAccountRepository /*implements AccountRepository*/ {
	
	private List<Account> accounts;
	
	

		
	public ListAccountRepository() {
		this.accounts = new LinkedList<>();
		
	}
	/**
	 * 전체 계좌 목록수 반환
	 * @return 목록수
	 */
	
	public int getCount() {
		return accounts.size();
	}
	
	
	/**
	 * 
	 * @return 전체계좌 목록
	 */
	public List<Account> getAccounts() {
		return accounts;
	}
	
	/**
	 * 신규계좌등록
	 * @param account
	 * @return 등록여부
	 */
	public boolean addAccount(Account account){
//		데이터 검증이 필요하지만편의상 생략
		accounts.add(account);
		return true;
	}
	
	/**
	 * 
	 * @param accountNum 검색 계좌 번호
	 * @return 검색된 계좌
	 */
	public Account searchAccount(String accountNum) {
		for (Account account : accounts) {
			if(account.getAccountNum().equals(accountNum)) {
			
			return account;
				}
		}
				return null;
	}

	/**
	 * 
	 * @param accountOwner 검색 예금주명
	 * @return 검색된 계좌목록
	 */
	public List<Account> searchAccountByOwner(String accountOwner) {
		List<Account> searchAccounts = new ArrayList<>();
		
		for (Account account : accounts) {
			if(account.getAccountOwner().equals(accountOwner)) {
				searchAccounts.add(account);
				}
		}
				return searchAccounts;
	}

	
	
			
			
	
	
	public boolean removeAccout(String accountNum) {
		for (int i=0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if(account.getAccountNum().equals(accountNum)) {
				accounts.remove(i);
				return true;
				}
		}
		return false;
	}
	
}
