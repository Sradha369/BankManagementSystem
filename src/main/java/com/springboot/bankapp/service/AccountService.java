package com.springboot.bankapp.service;
import java.util.List;

import com.springboot.bankapp.entity.Account;

public interface AccountService {
	public Account createAccount(Account account);
	public Account getAcntDtlByAcntNum(Long acntNo);
	public List<Account> getAllAcntDetails();
	public Account depositeMoney(Long acntNo,Double amount);
	public Account withDrawAmonut(Long acntNo,Double amount);
	public void closeAccount(Long acntNo);
}
