package com.example.keycloakserver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
@KeycloakConfiguration
public class KeyCloakConfig extends KeycloakWebSecurityConfigurerAdapter{
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().anyRequest().authenticated();
	    }

	    @Bean
	    @Override
	    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
	        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) {
	        SimpleAuthorityMapper grantedAuthorityMapper = new SimpleAuthorityMapper();
	        grantedAuthorityMapper.setPrefix("ROLE_"); // ROLE_user_role? check?
	        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
	        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(grantedAuthorityMapper);
	        auth.authenticationProvider(keycloakAuthenticationProvider);
	    }

	    @Bean
	    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
	        return new KeycloakSpringBootConfigResolver();
	    }
}
