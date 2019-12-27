package com.wizeline.nflxpipoll.service;

import com.wizeline.nflxpipoll.dto.AccountDto;
import com.wizeline.nflxpipoll.mapper.AccountMapper;
import com.wizeline.nflxpipoll.persistence.entity.AccountEntity;
import com.wizeline.nflxpipoll.persistence.repository.AccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired private AccountRepository accountRepository;

  @Autowired private AccountMapper accountMapper;

  public AccountServiceImpl() {}

  @Override
  public AccountDto save(AccountDto account) {
    AccountEntity entity = accountRepository.save(accountMapper.toEntity(account));
    return accountMapper.toDto(entity);
  }

  public AccountDto getOne(Long accountId) {
    AccountDto account = new AccountDto();
    account.setId(accountId);
    return account;
  }

  @Override
  public List<AccountDto> findAll() {
    return accountMapper.fromEntityToDtoList(accountRepository.findAll());
  }
}
