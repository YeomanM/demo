package com.example.demo.controller;


import com.example.demo.entity.BaseResponse;
import com.example.demo.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yeoman123
 * @since 2019-01-20
 */
@RestController
@RequestMapping("/right")
public class RightController {

    @Autowired
    private RightService rightService;

    @GetMapping
    public BaseResponse get(@RequestParam Integer userId){
        return rightService.getRightTree(userId);
    }

    @GetMapping("/all")
    public BaseResponse getAll(){
        return rightService.getAllRight();
    }

    @GetMapping("/group")
    public Object getByGroupId(@RequestParam(required = false)Integer groupId ){
        return rightService.getRightTreeByGroup(groupId);
    }

}

