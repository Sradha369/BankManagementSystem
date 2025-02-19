package com.springboot.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankapp.entity.Account;
import com.springboot.bankapp.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
//create the account
@Autowired public AccountService accountService;	
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) {
		Account crtAcc=accountService.createAccount(account);
		return crtAcc;		
	}
	@GetMapping("/{acntNo}")
	public Account getAcntDtlByAcntNum(@PathVariable Long acntNo) {
		Account accDetails=accountService.getAcntDtlByAcntNum(acntNo);
		return accDetails;
	}
	@GetMapping("/getAllAccountDetails")
	public List<Account> getAllAcntDetails() {
		List<Account>allAccountDetails =accountService.getAllAcntDetails();
		return allAccountDetails;
	}
	@PutMapping("/deposite/{acntNo}/{amount}")
	public Account depositeMoney(@PathVariable Long acntNo,@PathVariable Double amount) {
		Account account= accountService.depositeMoney(acntNo, amount);
		return account;
	}
	@PutMapping("/withdrw/{acntNo}/{amount}")
	public Account withDrawAmount(@PathVariable Long acntNo,@PathVariable Double amount) {
		Account account= accountService.withDrawAmonut(acntNo, amount);
		return account;
	}
	@DeleteMapping("/deleteAccount/{acntNo}")
	public ResponseEntity<String> closeAccount(@PathVariable Long acntNo) {
		accountService.closeAccount(acntNo);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("account closed");
		//return ResponseEntity.ok("account is closed");
	}
}
