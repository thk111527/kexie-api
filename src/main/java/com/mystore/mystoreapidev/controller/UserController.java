package com.mystore.mystoreapidev.controller.front;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;
import com.mystore.mystoreapidev.common.CommonResponse;
import com.mystore.mystoreapidev.domain.User;
import com.mystore.mystoreapidev.persistence.UserMapper;
import com.mystore.mystoreapidev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import static com.mystore.mystoreapidev.common.CONSTANT.LOGIN_USER;

@RestController
@Validated
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;//这个对象是被我们的容器new出来并且注入到类里面的

    //看文档，显然我们需要一个通用响应 public sth
    //登录
    //路径映射
    @PostMapping("login")
    public CommonResponse<User> login(
            @RequestParam @NotBlank(message = "用户名不能为空") String username,
            @RequestParam @NotBlank(message = "密码不能为空") String password,
            HttpSession session
    ){
       CommonResponse<User> result =userService.login(username,password);//调业务逻辑，但是我们没办法知道业务逻辑那边到底是成功还是失败，所以再建立一个通用响应
        if(result.isScuess()){
            session.setAttribute(LOGIN_USER,result.getData());//不希望出现常量，在CONSTANT里加
        }
        return result;//return从业务逻辑返回来的结果
    }

    @PostMapping("check_field")
    public CommonResponse<Object> checkField(
            @RequestParam @NotBlank(message = "字段名不能为空") String fieldName,
            @RequestParam @NotBlank(message = "字段值不能为空") String fieldValue){
        return userService.checkField(fieldName, fieldValue);
    }

//    @PostMapping("register")
//    public CommonResponse<Object> register(
//            @RequestBody @Valid User user
//    ){
//        return userService.register(user);
//    }
@PostMapping("register")
public CommonResponse<Object> register(
        @RequestBody @Valid User user){
    return userService.register(user);
}
}
