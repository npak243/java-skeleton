package com.wizeline.nflxpipoll.dto.response;

import com.wizeline.nflxpipoll.constant.ResponseCode;

public class ErrorResponse extends GenericResponse<String> {

  public ErrorResponse() {}

  public ErrorResponse(String namespace, String responseCode, String responseMessage) {
    super(namespace, responseCode, responseMessage, null);
  }

  public ErrorResponse(String responseCode, String responseMessage) {
    super(responseCode, responseMessage, null);
  }

  public ErrorResponse(ResponseCode responseCode) {
    super(responseCode.getCode(), responseCode.getMessage(), null);
  }
}
