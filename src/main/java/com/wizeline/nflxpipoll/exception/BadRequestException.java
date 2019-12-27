package com.wizeline.nflxpipoll.exception;

import com.wizeline.nflxpipoll.constant.ResponseCode;
import org.springframework.http.HttpStatus;

public class BadRequestException extends BusinessException {

  public BadRequestException(ResponseCode responseCode) {
    super(responseCode.getCode(), responseCode.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
