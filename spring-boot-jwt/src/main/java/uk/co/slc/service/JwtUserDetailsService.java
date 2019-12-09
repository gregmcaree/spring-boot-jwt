package uk.co.slc.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private static HashMap<String, String> passwordStore = new HashMap<>();

    static {
        passwordStore.put("hello_user", "hello_password");
        passwordStore.put("hola_user", "hola_password");
    }

    private Set<GrantedAuthority> getRoleForUser(String username) throws UsernameNotFoundException {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean userFound = false;
        if ("hello_user".equals(username)) {
            userFound = true;
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_HELLO"));
        }
        if ("hola_user".equals(username)) {
            userFound = true;
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_HOLA"));
        }
        if (!userFound) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return grantedAuthorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = passwordStore.get(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = bCryptPasswordEncoder.encode(password);

        return new User(username, hashedPassword, getRoleForUser(username));

    }
}