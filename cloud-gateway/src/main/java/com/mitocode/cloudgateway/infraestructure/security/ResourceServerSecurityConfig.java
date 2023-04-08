package com.mitocode.cloudgateway.infraestructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.CorsSpec;
import org.springframework.security.config.web.server.ServerHttpSecurity.CsrfSpec;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Configuration
public class ResourceServerSecurityConfig {

	public static final String ADMIN = "admin";
	public static final String USER = "user";
	public static final String LICENCIA_API_PATH_MATCHER="/api/v1/licencia/**";
	public static final String AUDITORIA_API_PATH_MATCHER="/api/v1/auditoria/**";
	private final JwtAuthConverter jwtAuthConverter;

	@Bean
	public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) throws Exception {
		http.authorizeExchange().pathMatchers(HttpMethod.POST, LICENCIA_API_PATH_MATCHER).hasRole(ADMIN)
				.pathMatchers(HttpMethod.PUT, LICENCIA_API_PATH_MATCHER).hasRole(ADMIN)
				.pathMatchers(HttpMethod.DELETE, LICENCIA_API_PATH_MATCHER).hasRole(ADMIN)
				.pathMatchers(HttpMethod.GET, LICENCIA_API_PATH_MATCHER).hasAnyRole(ADMIN, USER)
				.pathMatchers(HttpMethod.GET, AUDITORIA_API_PATH_MATCHER).hasRole(ADMIN).anyExchange()
				.authenticated();
		http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(grantedAuthoritiesExtractor());
		http
		.csrf(CsrfSpec::disable)
		.cors(CorsSpec::disable);

		return http.build();
	}

	Converter<Jwt, Mono<AbstractAuthenticationToken>> grantedAuthoritiesExtractor() {
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();

		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtAuthConverter);

		return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
	}

}
