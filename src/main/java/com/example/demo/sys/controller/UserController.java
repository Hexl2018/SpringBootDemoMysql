package com.example.demo.sys.controller;

import com.example.demo.sys.service.IUserService;
import com.example.demo.sys.service.ProcessEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService service;

    @Resource
    private ProcessEngineService processEngineService;

    @GetMapping("user")
    @ResponseBody
    public Map selectUsers() {
        try{
            return success(service.findUsers());
        }catch (Exception e) {
            logger.error(e.getMessage());
            return error(-1,e.getMessage());
        }
    }

    @GetMapping("user/{id}")
    @ResponseBody
    public Map findUserById(@PathVariable Integer id) {
        try{
            return success(service.findUserById(id));
        }catch (Exception e) {
            logger.error(e.getMessage());
            return error(-1,e.getMessage());
        }
    }

    @GetMapping("start_process")
    @ResponseBody
    public Map startProcess(String processId) {
        try{
            processEngineService.startProcess(processId);
            return success("启动成功！");
        }catch (Exception e) {
            logger.error(e.getMessage());
            return error(-1,e.getMessage());
        }
    }


    @GetMapping("test_process")
    @ResponseBody
    public Map testProcess(String assignee) {
        try{
            return success(processEngineService.getTasks(assignee));
        }catch (Exception e) {
            logger.error(e.getMessage());
            return error(-1,e.getMessage());
        }
    }

    @GetMapping("task/{id}")
    @ResponseBody
    public Map task(@PathVariable String id) {
        try{
            return success(processEngineService.getTasksById(id));
        }catch (Exception e) {
            logger.error(e.getMessage());
            return error(-1,e.getMessage());
        }
    }
}

