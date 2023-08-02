package ezen.ams.domain;

/**
 * 메모리(배열)를 통해 은행계좌 목록 저장 및 관리(검색, 수정, 삭제) 구현체
 * 
 * @author 주성민
 * @since 1.0
 */
public class MemoryAccountRepository implements AccountRepository{
	
	private Account[] accounts;
	private int count;
	
	public MemoryAccountRepository() {
		this(100);
	}
	
	public MemoryAccountRepository(int capacity) {
		this.accounts = new Account[capacity];
	}
	
	/**
	 * 전체 계좌 목록 수 반환
	 * @return 목록수
	 */
	public int getCount() {
		return count;
	}

	/**
	 * 
	 * @return 전체계좌 목록
	 */
	public Account[] getAccounts() {
		return accounts;
	}
	
	/**
	 * 신규계좌 등록
	 * @param account 신규계좌
	 * @return 등록 여부
	 */
	public boolean addAccount(Account account){
//		데이터 검증이 필요하지만 편의상 생략
		accounts[count++] = account;
		return true;
	}
	
	/**
	 * 
	 * @param accountNum 검색 계좌번호
	 * @return 검색된 계좌
	 */
	public Account searchAccount(String accountNum) {
		for (int i = 0; i < count; i++) {
			String number = accounts[i].getAccountNum();
			// 동일 계좌번호 여부 확인
			if(number.equals(accountNum)) {
				return accounts[i];
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param accountOwner 검색 예금주명
	 * @return 검색된 계좌목록
	 */
	public Account[] searchAccountByOwner(String accountOwner) {
		Account[] searchList = null;
		
		int searchCount = getCountByOwner(accountOwner);
		if(searchCount == 0) {
			return null;
		}
		
		searchList = new Account[searchCount];
		int listIndex = 0;
		for (int i = 0; i < count; i++) {
			if(accounts[i].getAccountOwner().equals(accountOwner)) {
				searchList[listIndex++] = accounts[i];
			}
		}
		return searchList;
	}
	
//	private 헬퍼메소드
	private int getCountByOwner(String accountOwner) {
		int searchCount = 0;
		for (int i = 0; i < count; i++) {
			String name = accounts[i].getAccountOwner();
			// 동일 예금주 여부 확인
			if(name.equals(accountOwner)) {
				searchCount++;
			}
		}
		return searchCount;
	}
	
	
	public boolean removeAccout(String accountNum) {
		for (int i = 0; i < count; i++) {
			String number = accounts[i].getAccountNum();
			// 동일 계좌번호 여부 확인
			if(number.equals(accountNum)) {
				for(int j=i; j < count-1; j++){
					accounts[j] = accounts[j+1];					
				}
				count--;
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
}

	
























