package com.bit.yourmain.controller;

import com.bit.yourmain.domain.Users;
import com.bit.yourmain.dto.UsersRoleChangeDto;
import com.bit.yourmain.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/signup")
    public void save(@RequestBody Users users) {
        usersService.save(users);
    }

    @PostMapping("/idCheck")
    public Object idCheck(@RequestBody Users users) {
        Users checkUser = null;
        try {
            checkUser = usersService.getUsers(users.getId());
        } catch (NoSuchElementException e) {
            System.out.println("계정 없음");
        }

        boolean check;
        check = checkUser == null;

        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        map.put("data", check);
        return map;
    }

    @PostMapping("/roleChange")
    public void roleChange(@RequestBody UsersRoleChangeDto roleChangeDto) {
        usersService.roleChange(roleChangeDto);
    }
}
