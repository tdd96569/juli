package com.touge.serviceedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.touge.serviceedu.entity.EduTeacher;
import com.touge.serviceedu.entity.vo.TaecherQuery;
import com.touge.serviceedu.mapper.EduTeacherMapper;
import com.touge.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author touge
 * @since 2020-07-31
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void pageQuery(Page<EduTeacher> pageParam, TaecherQuery teacherQuery) {

        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        if (teacherQuery == null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return ;
        }

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if (!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }

        if (level != 0){
            queryWrapper.eq("level",level);
        }

        if (!StringUtils.isEmpty(begin)){
            queryWrapper.ge("gmt_create",begin);
        }

        if (!StringUtils.isEmpty(end)){
            queryWrapper.le("gmt_create",end);
        }

        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
