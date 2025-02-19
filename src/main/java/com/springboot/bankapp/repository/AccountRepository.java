package com.springboot.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bankapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
