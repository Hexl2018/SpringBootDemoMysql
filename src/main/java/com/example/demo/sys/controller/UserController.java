package com.example.demo.sys.controller;

import com.example.demo.sys.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 管理员表 前端控制器
 * @author hexl
 * @since 2019-06-10
 */
@RestController
@RequestMapping("/sys/user/")
public class UserController extends BaseController {
    @Resource
    private IUserService service;

    @GetMapping("user")
    @ResponseBody
    public Map selectUsers() {
        try{
            return success(service.findUsers());
        }catch (Exception e) {
            return error(-1,e.getMessage());
        }
    }

    @GetMapping("user/{id}")
    @ResponseBody
    public Map findUserById(@PathVariable Integer id) {
        try{
            return success(service.findUserById(id));
        }catch (Exception e) {
            return error(-1,e.getMessage());
        }
    }
}

