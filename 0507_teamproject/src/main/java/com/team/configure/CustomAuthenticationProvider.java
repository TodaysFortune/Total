package com.team.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.team.vo.UserinfoVO;

@Component("CustomAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
    private UserDetailsService userDeSer;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        
        UserinfoVO user = (UserinfoVO) userDeSer.loadUserByUsername(username);
        
        if(!matchPassword(password, user.getPassword())) {
            throw new BadCredentialsException(username);
        }
        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	private boolean matchPassword(String loginPwd, String password) {
        return loginPwd.equals(password);
    }
}
