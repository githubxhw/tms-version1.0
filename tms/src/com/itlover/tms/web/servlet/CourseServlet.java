package com.itlover.tms.web.servlet;

import com.itlover.tms.mapper.ICourseMapper;
import com.itlover.tms.mapper.impl.CourseMapperImpl;
import com.itlover.tms.pojo.Course;
import com.itlover.tms.utils.JSONUtil;
import com.itlover.tms.utils.PageInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * 说明：
 * 常见的媒体格式类型如下：
 *         text/html ： HTML格式
 *         text/plain ：纯文本格式
 *         text/xml ：  XML格式
 *         image/gif ：gif图片格式
 *         image/jpeg ：jpg图片格式
 *         image/png：png图片格式
 *
 *    以application开头的媒体格式类型：
 *        application/xhtml+xml ：XHTML格式
 *        application/xml     ： XML数据格式
 *        application/atom+xml  ：Atom XML聚合格式
 *        application/json    ： JSON数据格式
 *        application/pdf       ：pdf格式
 *        application/msword  ： Word文档格式
 *        application/octet-stream ： 二进制流数据（如常见的文件下载）
 *        application/x-www-form-urlencoded ： <form encType=””>中默认的encType，form表单数据被编码为key/value格式发送到服务器（表单默认的提交数据的格式）
 *
 *    另外一种常见的媒体格式是上传文件之时使用的：
 *         multipart/form-data ： 需要在表单中进行文件上传时，就需要使用该格式
 *      经常会用到的若干content-type的内容格式
 */
@WebServlet("/api/courseServlet")
public class CourseServlet extends BaseServlet {

    //查询所有的course信息
    public String findAllByPage(HttpServletRequest request, HttpServletResponse response){
        try {
            String pageNumStr = request.getParameter("pageNum");
            String pageSizeStr = request.getParameter("pageSize");
            int pageNum = 1;//默认
            int pageSize = 10;//默认
            if(pageNumStr != null){
                pageNum = Integer.parseInt(pageNumStr);
            }
            if(pageSizeStr != null){
                pageSize = Integer.parseInt(pageSizeStr);
            }

            ICourseMapper courseMapper = new CourseMapperImpl();
            List<Course> courses = courseMapper.findAllByPage(pageNum,pageSize);
            /*for (Course course:courses){
                System.out.println(course);
            }*/
            Long count = courseMapper.findCount();

            PageInfo<Course> pageInfo = new PageInfo();
            pageInfo.setTotalCount(count);//设置总数
            pageInfo.setPageNum(pageNum);//设置当前页面
            pageInfo.setPageSize(pageSize);//设置当前页面数据量
            pageInfo.setObjects(courses);//设置courses数据
            pageInfo.setPages((int)((count%pageSize) == 0 ? (count/pageSize) : (count/pageSize+1)));

            request.setAttribute("pageInfo", pageInfo);//存值
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/jsp/course/course-list.jsp";
    }

    //根据courseId查询信息服务接口
    public void findByCourseId(HttpServletRequest request, HttpServletResponse response){
        try {
            ICourseMapper courseMapper = new CourseMapperImpl();
            String courseId = request.getParameter("courseId");
            if(courseId == null){
                throw new RuntimeException("courseId为空");
            }
            Course course = courseMapper.findById(Integer.parseInt(courseId));
            String objectToJson = JSONUtil.objectToJson(course);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectToJson);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //根据courseId更新数据
    public void updateByCourseId(HttpServletRequest request, HttpServletResponse response){
            try {
                Course course = new Course();
                course.setCourseId(Integer.parseInt(request.getParameter("courseId")));
                course.setCourseName(request.getParameter("courseName"));
                course.setType(Integer.parseInt(request.getParameter("type")));
                course.setCredit(Float.parseFloat(request.getParameter("credit")));
                course.setGrade(Integer.parseInt(request.getParameter("grade")));
                course.setMajor(Integer.parseInt(request.getParameter("major")));
                course.setDetail(request.getParameter("detail"));
                //System.out.println(course);

                ICourseMapper courseMapper = new CourseMapperImpl();
                Integer res = courseMapper.updateById(course);
                response.setContentType("text/plain;charset=utf-8");
                PrintWriter writer = response.getWriter();
                if(res == 1) {
                    writer.print(1);//成功
                }else {
                    writer.print(0);//失败
                }
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    //根据id删除信息
    public void deleteByCourseId(HttpServletRequest request, HttpServletResponse response){
        try {
            ICourseMapper courseMapper = new CourseMapperImpl();
            String courseId = request.getParameter("courseId");
            Integer res = courseMapper.deleteByCourseId(Integer.parseInt(courseId));
            response.setContentType("text/plain;charset=utf-8");
            PrintWriter writer = response.getWriter();
            if(res == 1) {
                writer.print(1);//成功
            }else {
                writer.print(0);//失败
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //保存一条course信息
    public void saveOne(HttpServletRequest request, HttpServletResponse response){
        try {
            Course course = new Course();
            course.setCourseName(request.getParameter("courseName"));
            course.setType(Integer.parseInt(request.getParameter("type")));
            course.setCredit(Float.parseFloat(request.getParameter("credit")));
            course.setGrade(Integer.parseInt(request.getParameter("grade")));
            course.setMajor(Integer.parseInt(request.getParameter("major")));
            course.setDetail(request.getParameter("detail"));

            ICourseMapper courseMapper = new CourseMapperImpl();
            Integer res = courseMapper.saveNotHasId(course);
            response.setContentType("text/plain;charset=utf-8");
            PrintWriter writer = response.getWriter();
            if(res == 1) {
                writer.print(1);//成功
            }else {
                writer.print(0);//失败
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
