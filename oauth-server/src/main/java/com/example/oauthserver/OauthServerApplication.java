package com.example.oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@SpringBootApplication
@EnableAuthorizationServer
public class OauthServerApplication extends AuthorizationServerConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class, args);
	}

	 @Override
	   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	      clients.inMemory()
	            .withClient("candy") // clientId
	            .secret("{noop}123")
	            .authorizedGrantTypes("client_credentials")
	            .accessTokenValiditySeconds(90000)
	            .scopes("read", "write");
	   }

	   @Override
	   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	      endpoints.tokenStore(tokenStore()).accessTokenConverter(jwtAccessTokenConverter());
	   }


	   @Bean
	   public DefaultTokenServices tokenServices() {
	      DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
	      defaultTokenServices.setTokenStore(tokenStore());
	      return defaultTokenServices;
	   }

	   @Bean
	   public TokenStore tokenStore() {
	      return new JwtTokenStore(jwtAccessTokenConverter());
	   }

	   @Bean
	   public JwtAccessTokenConverter jwtAccessTokenConverter() {
	      JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
	      jwtAccessTokenConverter.setSigningKey("123456789012345678901234567890AB");
	      return jwtAccessTokenConverter;
	   }
}
