package com.bit.yourmain.service;

import com.bit.yourmain.domain.Role;
import com.bit.yourmain.domain.Users;
import com.bit.yourmain.domain.UsersRepository;
import com.bit.yourmain.dto.UsersRoleChangeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {
    private final UsersRepository usersRepository;

    public void save(Users users) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setRole(Role.USER);
        usersRepository.save(users);
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        try {
            Users users = getUsers(id);
            if (users == null) {
                return null;
            } else {
                List<GrantedAuthority> authorities = new ArrayList<>();
//                authorities.add(new SimpleGrantedAuthority(users.getRole().getValue()));
                return new User(users.getId(), users.getPassword(), authorities);
            }
        } catch (Exception e) {
            System.out.println("account empty");
        }

        return null;
    }

    public Users getUsers(String id) {
        Users users = usersRepository.findById(id).get();
        return users;
    }

    public void roleChange(UsersRoleChangeDto roleChangeDto) {
        Users users = getUsers(roleChangeDto.getId());
        users.setPhone(roleChangeDto.getPhone());
        users.setAddress(roleChangeDto.getAddress());
        users.setRole(Role.USER);
        usersRepository.save(users);
    }
}
