package com.wizeline.nflxpipoll.dto.response;

import com.wizeline.nflxpipoll.constant.ResponseCode;
import com.wizeline.nflxpipoll.dto.AccountDto;

public class AccountResponse extends GenericResponse<AccountDto> {

  public AccountResponse(ResponseCode responseCode, AccountDto data) {
    super(responseCode, data);
  }
}
