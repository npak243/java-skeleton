package com.wizeline.nflxpipoll.service;

import com.wizeline.nflxpipoll.dto.AccountDto;
import java.util.List;

public interface AccountService {

  AccountDto save(AccountDto account);

  AccountDto getOne(Long id);

  List<AccountDto> findAll();
}
