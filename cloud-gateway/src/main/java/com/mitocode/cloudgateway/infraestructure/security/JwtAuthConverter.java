package com.mitocode.cloudgateway.infraestructure.security;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	private final JwtAuthConverterProperties properties;

	public JwtAuthConverter(JwtAuthConverterProperties properties) {
		this.properties = properties;
	}

	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
		Map<String, Object> resource;
		Collection<String> resourceRoles;
		if (resourceAccess == null
				|| (resource = (Map<String, Object>) resourceAccess.get(properties.getResourceId())) == null
				|| (resourceRoles = (Collection<String>) resource.get("roles")) == null) {
			return Set.of();
		}
		return resourceRoles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role))
				.collect(Collectors.toSet());
	}

}