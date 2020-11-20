package com.hoanganh.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.hoanganh.DTO.MyStudent;

public class SecurityUtil {
	public static MyStudent getPrincipal() {
		MyStudent myStudent = (MyStudent) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		return myStudent;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> results = new ArrayList<>();

		List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities());
		for (GrantedAuthority authority : authorities) {
			results.add(authority.getAuthority());
		}
		return results;
	}
}
