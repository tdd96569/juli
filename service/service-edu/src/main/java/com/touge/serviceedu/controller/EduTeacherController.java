package com.touge.serviceedu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.touge.common.utils.R;
import com.touge.serviceedu.entity.EduTeacher;
import com.touge.serviceedu.entity.vo.TaecherQuery;
import com.touge.serviceedu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author touge
 * @since 2020-07-31
 */
@Api(description = "讲师管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/edu/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping
    public R list(){

        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items",list);

    }

    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping("/del/{id}")
    public R removeById(
            @ApiParam(name = "id",value = "讲师id",required = true)
            @PathVariable String id){
        teacherService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            TaecherQuery teacherQuery){

        Page<EduTeacher> pageParam = new Page<>(page,limit);

        teacherService.pageQuery(pageParam,teacherQuery);
        //teacherService.page(pageParam,null);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("/save")
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher teacher){
        this.teacherService.save(teacher);
        return R.ok();
    }

    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("/get/{id}")
    public R getTeacherById(
            @ApiParam(name = "id",value = "讲师id",required = true)
            @PathVariable String id){
        EduTeacher teacher = teacherService.getById(id);

        return R.ok().data("item", teacher);

    }

    public R updateTeacherById(
            @ApiParam(name = "id",value = "讲师id", required = true)
            @PathVariable String id,

            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher teacher){

        teacher.setId(id);
        this.teacherService.updateById(teacher);
        return R.ok();
    }
}

