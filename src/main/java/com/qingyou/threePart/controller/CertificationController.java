package com.qingyou.threePart.controller;


import com.github.pagehelper.PageInfo;
import com.qingyou.threePart.model.Student;
import com.qingyou.threePart.service.StuService;
import com.qingyou.threePart.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("certification")
//@Controller
public class CertificationController {

    @Autowired
    private StuService stuService;
  //  @Autowired
   // private UserMapper userMapper;
    @RequestMapping("list")
    public RestResult list (@RequestParam(defaultValue = "1") int pageNum,
                            @RequestParam(defaultValue = "5") int pageSize,
                            @RequestParam(defaultValue = "未完成") String state) {


        PageInfo pageInfo = stuService.getLogInfoPage(pageNum,pageSize,state);

        if(pageInfo==null) {
            return new RestResult(RestResult.STATUS_VALID_FAILED,null,"分页失败");
        }

        return new RestResult(RestResult.STATUS_SUCCESS,pageInfo,"分页成功");
     }


     @RequestMapping("list/getInfo")
     public RestResult getInfo(@RequestParam(defaultValue = "null") String userid, @RequestParam(defaultValue = "1") int pageNum){

         RestResult result = null;
         int pageSize =1;
         if(userid.equals("null")){
             PageInfo pageInfo =stuService.getLogInfoPage(pageNum,pageSize,"未完成");
             result = new RestResult(RestResult.STATUS_SUCCESS,pageInfo,"获取用户信息成功");
         }else {
             try {
                 Student stu = stuService.getByUserId(userid);

                 if (stu != null) {
                     PageInfo pageInfo =stuService.getLogInfoPage(stuService.getPageNum(stu),pageSize,"未完成");
                     result = new RestResult(RestResult.STATUS_SUCCESS, pageInfo, "获取用户信息成功");
                 } else {
                     result = new RestResult(RestResult.STATUS_VALID_FAILED, null, "未找到用户信息");
                 }
             } catch (Exception e) {
                 e.printStackTrace();
                 result = new RestResult(RestResult.STATUS_VALID_FAILED, null, "finduser异常");
             }
         }

         return result;
     }
     @RequestMapping("list/getInfo/rejected")
     public RestResult rejected(@RequestParam String userid){


         RestResult result = null;

         Student st = stuService.getByUserId(userid);

         stuService.setTime(st);


         if(st==null){
            result=new RestResult(RestResult.STATUS_VALID_FAILED,null,"未找到用户信息");

        }
        else {

            try{
                st.setState("未通过");
                stuService.updateStuState(st);
                result = new RestResult(RestResult.STATUS_SUCCESS, null, "更新用户状态成功");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
     }
    @RequestMapping("list/getInfo/approve")
    public RestResult approve(@RequestParam String userid){

        RestResult result = null;

        Student st = stuService.getByUserId(userid);

        stuService.setTime(st);
        if(st==null){
            result=new RestResult(RestResult.STATUS_VALID_FAILED,null,"未找到用户信息");

        }
        else {

           try{
                st.setState("已通过");
                stuService.updateStuState(st);
                result = new RestResult(RestResult.STATUS_SUCCESS, null, "更新用户状态成功");

              }catch (Exception e){
                   e.printStackTrace();
           }
        }
        stuService.pushMsg(userid);
        return result;
    }


    }
