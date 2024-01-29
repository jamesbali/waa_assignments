package edu.miu.WebAppArchLab.auth;

import edu.miu.WebAppArchLab.domain.User;
import edu.miu.WebAppArchLab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import edu.miu.WebAppArchLab.domain.Role;


import java.util.List;


@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), getAuthority(user));
//
//        org.springframework.security.core.userdetails.User.UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
//        builder.password(user.getPassword());
//        builder.roles(user.getRoles().stream().map(Role::getRole).toArray(String[]::new));
//        return builder.build();
   }

    private List<SimpleGrantedAuthority> getAuthority(User user) {
        return List.of(new SimpleGrantedAuthority(/*"ROLE_" +*/ user.getRole().name()));
    }



}
