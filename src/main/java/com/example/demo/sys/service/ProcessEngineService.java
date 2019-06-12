package com.example.demo.sys.service;

import org.flowable.task.api.Task;

import java.util.List;

/**
 * flowable 服务类
 * @author hexl
 * @since 2019-06-10
 */
public interface ProcessEngineService {
    /**
     * 查询所有用户
     * @param processId 流程id
     */
    void startProcess(String processId);

    /**
     * 获取任务
     * @param assignee 委托人
     * @return list
     */
    List<Task> getTasks(String assignee);


    List<Task> getTasksById(String id);
}
