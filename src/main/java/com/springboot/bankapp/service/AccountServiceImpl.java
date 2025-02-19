package com.springboot.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankapp.entity.Account;
import com.springboot.bankapp.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired AccountRepository accountRepo;
	@Override
	public Account createAccount(Account account) {
		try {
			Account accCrt;
			if(account.getAcntNo()!=null) {
				accCrt=accountRepo.findById(account.getAcntNo()).get();
			}
			else {
				accCrt=new Account();
			}
			accCrt.setAcntHolderName(account.getAcntHolderName());
			accCrt.setAcntBlnc(account.getAcntBlnc());
			return accountRepo.save(account);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	}

	@Override
	public Account getAcntDtlByAcntNum(Long acntNo) {
		Optional<Account>account=accountRepo.findById(acntNo);
		if(account.isEmpty()) {
			throw new RuntimeException("No account present");
		}
		Account accountGet=account.get();
		return accountGet;
	}

	@Override
	public List<Account> getAllAcntDetails() {
		List<Account>allAcntDetails=accountRepo.findAll();
		return allAcntDetails;
	}

	@Override
	public Account depositeMoney(Long acntNo, Double amount) {
		Optional<Account>account=accountRepo.findById(acntNo);
		if(account.isEmpty()) {
			throw new RuntimeException("account is not present");
		}
		Account acnt= account.get();
		acnt.setAcntBlnc(acnt.getAcntBlnc()+amount);
		return accountRepo.save(acnt);
	}

	@Override
	public Account withDrawAmonut(Long acntNo, Double amount) {
		Optional<Account>account=accountRepo.findById(acntNo);
		if(account.isEmpty()) {
			throw new RuntimeException("account is not present");
		}
		Account acnt= account.get();
		acnt.setAcntBlnc(acnt.getAcntBlnc()-amount);
		return accountRepo.save(acnt);
	}

	@Override
	public void closeAccount(Long acntNo) {
		getAcntDtlByAcntNum(acntNo);
		accountRepo.deleteById(acntNo);
	}

}
