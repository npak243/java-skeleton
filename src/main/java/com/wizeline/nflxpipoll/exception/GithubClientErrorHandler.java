package com.wizeline.nflxpipoll.exception;

import static com.wizeline.nflxpipoll.constant.ResponseCode.REQUEST_TIMEOUT;
import static com.wizeline.nflxpipoll.constant.ResponseCode.SERVICE_UNAVAILABLE;
import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

import com.wizeline.nflxpipoll.constant.Namespace;
import com.wizeline.nflxpipoll.dto.response.ErrorResponse;
import com.wizeline.nflxpipoll.util.JsonUtil;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class GithubClientErrorHandler implements ResponseErrorHandler {

  @Override
  public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
    return (httpResponse.getStatusCode().series() == CLIENT_ERROR
        || httpResponse.getStatusCode().series() == SERVER_ERROR);
  }

  @Override
  public void handleError(ClientHttpResponse httpResponse) throws IOException {
    HttpStatus status = httpResponse.getStatusCode();

    if (status.series() == SERVER_ERROR || status.series() == CLIENT_ERROR) {
      if (HttpStatus.REQUEST_TIMEOUT.equals(status)) {
        throw new BusinessException(REQUEST_TIMEOUT, HttpStatus.REQUEST_TIMEOUT);
      }

      String responseString =
          StreamUtils.copyToString(httpResponse.getBody(), StandardCharsets.UTF_8);
      ErrorResponse errorResponse = JsonUtil.parse(responseString, ErrorResponse.class);

      if (Objects.isNull(errorResponse)) {
        throw new BusinessException(SERVICE_UNAVAILABLE, HttpStatus.OK);
      }

      throw new BusinessException(Namespace.GITHUB, errorResponse, HttpStatus.OK);
    }
  }
}
