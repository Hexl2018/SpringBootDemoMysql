package com.example.demo.sys.service.impl;

import com.example.demo.sys.service.ProcessEngineService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hexl
 */
@Service
public class ProcessEngineServiceImpl implements ProcessEngineService {
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private TaskService taskService;

    /**
     * 开启流程
     * @param processId processId
     */
    @Override
    public void startProcess(String processId) {
        runtimeService.startProcessInstanceByKey(processId);
        System.out.println("流程启动了！");
    }

    @Override
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    @Override
    public List<Task> getTasksById(String id) {
        return taskService.createTaskQuery().excludeSubtasks().list();
    }
}
