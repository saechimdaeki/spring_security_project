package me.saechimdaeki.security.security.provider;

import lombok.RequiredArgsConstructor;
import me.saechimdaeki.security.security.common.FormWebAuthenticationDetails;
import me.saechimdaeki.security.security.service.AccountContext;
import me.saechimdaeki.security.security.service.CustomUserDetails;
import me.saechimdaeki.security.security.token.AjaxAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AjaxAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetails userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String)authentication.getCredentials();

        AccountContext accountContext = (AccountContext) userDetailsService.loadUserByUsername(username);

        if(!passwordEncoder.matches(password, accountContext.getAccount().getPassword())){
            throw new BadCredentialsException("BadCredentials Exception!!!");
        }
        Object details = authentication.getDetails();//

        String secretKey = ( (FormWebAuthenticationDetails) authentication.getDetails() ).getSecretKey();
//        FormWebAuthenticationDetails formWebAuthenticationDetails = (FormWebAuthenticationDetails)authentication.getDetails();
//        String secretKey = formWebAuthenticationDetails.getSecretKey();
        if(!"secret".equals(secretKey)){
            throw new IllegalArgumentException("Invalid Secret");
        }

        return new AjaxAuthenticationToken(accountContext.getAccount(), null , accountContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(AjaxAuthenticationToken.class);
    }
}
