package com.qingyou.threePart.controller;

import com.github.pagehelper.PageInfo;
import com.qingyou.threePart.model.Msg;
import com.qingyou.threePart.service.MsgService;
import com.qingyou.threePart.service.StuService;
import com.qingyou.threePart.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dirmsg")
public class DirMsgController {

    @Autowired
    private MsgService msgService;

    @Autowired
    private StuService stuService;

    @RequestMapping("/push")
    public RestResult msgPush(@RequestParam("userid" ) String userid,
                              @RequestParam("title") String title,
                              @RequestParam("msg") String msg) {

        RestResult result = null;
        Msg m = new Msg();
        m.setUserId(userid);
        m.setTitle(title);
        m.setMsg(msg);
        m.setState("未读");
        m.setTime(stuService.getTime());
        m.setHistory("y");


        try {
            msgService.insertMsg(m);
        }catch (Exception e) {
            e.printStackTrace();
            result = new RestResult(RestResult.STATUS_VALID_FAILED, null, "制作学生信息失败");
        }
            result = new RestResult(RestResult.STATUS_SUCCESS, null, "定向推送成功");
        return result;
    }



    @RequestMapping("")
    public RestResult hisList(@RequestParam(defaultValue = "1") int pageNum,
                              @RequestParam(defaultValue = "5") int pageSize){
        RestResult result =null;
        PageInfo pageInfo = msgService.getHistoryPage(pageNum,pageSize);
        if(pageInfo==null) {
            return new RestResult(RestResult.STATUS_VALID_FAILED,null,"分页失败");
        }

        return new RestResult(RestResult.STATUS_SUCCESS,pageInfo,"分页成功");
    }

    @RequestMapping("/delete")
    public RestResult delete(@RequestParam String userid){

        RestResult result =null;
        Msg msg =msgService.getMsg(userid);
        if(msg!=null){
            msg.setHistory("n");
            msgService.updateHistory(msg);
            result=new RestResult(RestResult.STATUS_SUCCESS,null,"删除历史记录");
        }
        else {
            result=new RestResult(RestResult.STATUS_VALID_FAILED,null,"未找到此人");
        }
        return result;

    }
    @RequestMapping("/detail")
    public RestResult detail(@RequestParam String userid){

        RestResult result =null;
        Msg msg =msgService.getMsg(userid);
        if(msg!=null){

            result=new RestResult(RestResult.STATUS_SUCCESS,msg,"获取用户详情成功");
        }
        else {
            result=new RestResult(RestResult.STATUS_VALID_FAILED,null,"未找到此人");
        }
        return result;
    }
}

