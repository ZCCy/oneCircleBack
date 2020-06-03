package com.qingyou.threePart.controller;


import com.github.pagehelper.PageInfo;
import com.qingyou.threePart.model.FeedBackMsg;
import com.qingyou.threePart.service.FeedBackService;
import com.qingyou.threePart.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feedback")
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping("/list")
    public RestResult list (@RequestParam(defaultValue = "1") int pageNum,
                            @RequestParam(defaultValue = "5") int pageSize,
                            @RequestParam(defaultValue = "未处理") String state) {


        PageInfo pageInfo = feedBackService.getList(pageNum,pageSize,state);

        if(pageInfo==null) {
            return new RestResult(RestResult.STATUS_VALID_FAILED, null, "分页失败");
        }
        return new RestResult(RestResult.STATUS_SUCCESS,pageInfo,"分页成功");
    }
    @RequestMapping("/list/getInfo")
    public RestResult getInfo(@RequestParam(defaultValue = "null") String userid, @RequestParam(defaultValue = "1") int pageNum){

        RestResult result = null;
        int pageSize =1;
        if(userid.equals("null")){
            PageInfo pageInfo =feedBackService.getList(pageNum,pageSize,"未处理");
            result = new RestResult(RestResult.STATUS_SUCCESS,pageInfo,"获取用户信息成功");
        }else {
            try {
                FeedBackMsg fd = feedBackService.getFeedBack(userid);

                if (fd != null) {
                    PageInfo pageInfo =feedBackService.getList(feedBackService.getPageNum(fd),pageSize,"未处理");
                    result = new RestResult(RestResult.STATUS_SUCCESS, pageInfo, "获取用户信息成功");
                } else {
                    result = new RestResult(RestResult.STATUS_VALID_FAILED, null, "未找到用户信息");
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = new RestResult(RestResult.STATUS_VALID_FAILED, null, "find消息异常");
            }
        }

        return result;
    }
    @RequestMapping("/list/getInfo/flag")
    public RestResult flag(@RequestParam String userid){


        RestResult result = null;

        FeedBackMsg fd = feedBackService.getFeedBack(userid);

        feedBackService.setTime(fd);


        if(fd==null){
            result=new RestResult(RestResult.STATUS_VALID_FAILED,null,"未找到用户信息");

        }
        else {

            try{
                fd.setState("标记");
                feedBackService.updateState(fd);
                result = new RestResult(RestResult.STATUS_SUCCESS, null, "更新用户状态成功");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    @RequestMapping("/list/getInfo/neglect")
    public RestResult neglect(@RequestParam String userid){


        RestResult result = null;

        FeedBackMsg fd = feedBackService.getFeedBack(userid);

        feedBackService.setTime(fd);


        if(fd==null){
            result=new RestResult(RestResult.STATUS_VALID_FAILED,null,"未找到用户信息");

        }
        else {

            try{
                fd.setState("忽略");
                feedBackService.updateState(fd);
                result = new RestResult(RestResult.STATUS_SUCCESS, null, "更新用户状态成功");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    @RequestMapping("/list/getInfo/certain")
    public RestResult certain(@RequestParam String userid, @RequestParam String msg){


        RestResult result = null;

        FeedBackMsg fd = feedBackService.getFeedBack(userid);
        feedBackService.setTime(fd);


        if(fd==null){
            result=new RestResult(RestResult.STATUS_VALID_FAILED,null,"未找到用户信息");

        }
        else {

            try{
                fd.setState("确定");
                fd.setMsg(msg);
                feedBackService.updateMsg(fd);
                feedBackService.updateState(fd);
                result = new RestResult(RestResult.STATUS_SUCCESS, null, "更新用户状态成功");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }


}
