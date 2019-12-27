package com.wizeline.nflxpipoll.util;

import static com.wizeline.nflxpipoll.constant.ResponseCode.NOT_FOUND_HANDLER;
import static com.wizeline.nflxpipoll.constant.ResponseCode.UNEXPECTED_ERROR;

import com.wizeline.nflxpipoll.dto.response.ErrorResponse;

public class ResponseBodyBuilder {

  private ResponseBodyBuilder() {}

  public static ErrorResponse unexpectedError() {
    return new ErrorResponse(UNEXPECTED_ERROR);
  }

  public static ErrorResponse notFoundHandler() {
    return new ErrorResponse(NOT_FOUND_HANDLER);
  }
}
