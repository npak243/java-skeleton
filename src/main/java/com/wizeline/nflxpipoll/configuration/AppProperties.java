package com.wizeline.nflxpipoll.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

  private final GithubClientService githubClientService = new GithubClientService();

  @Getter
  @Setter
  public static class ConfigClient {

    private int maxTotal;
    private int defaultMaxPerRoute;
    private int connectTimeout;
    private int socketTimeout;
    private int readTimeoutMs;
    private int keepAliveHeader;
    private String endpoint;
  }

  @Getter
  @Setter
  public static class GithubClientService extends ConfigClient {}
}
