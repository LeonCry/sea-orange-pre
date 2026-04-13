package com.voidis.sea_orange_pre.service;

import com.voidis.sea_orange_pre.common.Result;
import com.voidis.sea_orange_pre.entity.User;
import com.voidis.sea_orange_pre.exception.CustomException;
import com.voidis.sea_orange_pre.repository.UserRepository;
import com.voidis.sea_orange_pre.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;

    //    注册
    public User register(User user) {
        return this.userRepository.save(user);
    }

    //    登录
    public String login(User loginUser) {
        User dbUser = this.userRepository.findUserByUsername(loginUser.getUsername());
        if (dbUser == null || !dbUser.getPassword().equals(loginUser.getPassword())) {
            throw new CustomException(401,"账号或密码错误");
        }
        return JwtUtils.generateToken(dbUser.getId(), dbUser.getUsername());
    }
}
