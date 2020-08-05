package com.touge.serviceedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.touge.serviceedu.entity.EduTeacher;
import com.touge.serviceedu.entity.vo.TaecherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author touge
 * @since 2020-07-31
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void pageQuery(Page<EduTeacher> pageParam, TaecherQuery teacherQuery);

}
