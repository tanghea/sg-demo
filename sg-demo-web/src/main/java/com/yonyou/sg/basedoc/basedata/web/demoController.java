package com.yonyou.sg.basedoc.basedata.web;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.cpu.commons.domain.PageBean;
import com.yonyou.sg.basedoc.basedata.api.IDemoService;
import com.yonyou.sg.basedoc.basedata.domain.Demo;
import com.yonyou.sg.basedoc.basedata.web.vo.ResultObjectVo;
import org.cpu.common.utils.json.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ck on 2018\3\13 0013.
 */
@Controller
@RequestMapping("/demo")
public class demoController {
    @Autowired
    private IDemoService iDemoService;
    @RequestMapping(value = "/query/page", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject queryProfessionAll (HttpServletRequest request, HttpServletResponse response,
                                          @RequestParam(value = "pageSize",defaultValue="10") Integer pageSize,
                                          @RequestParam(value = "pageIndex",defaultValue="0") Integer pageIndex,
                                          @RequestParam(value = "businessStatus",defaultValue="") String businessStatus){
        PageBean<Object> pagebean = new PageBean<Object>();
        pagebean.setPageNo(pageIndex);
        pagebean.setPageSize(pageSize);
        Demo vo = new Demo();
        vo.setBusinessStatus(businessStatus);
        JSONObject s = iDemoService.pageQuery(pagebean,vo);
        return s;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResultObjectVo<Demo> save(@RequestBody Map map){
        ResultObjectVo<Demo> result = new  ResultObjectVo<Demo>();
        try {
            Demo vo = JsonUtils.fromJson(map.get("datas").toString(), Demo.class);
            Long pk = iDemoService.savedata(vo);
            vo.setId(pk);
            result.setStatus(1);
            result.setData(vo);
            result.setMsg("保存成功！");
        }
        catch (Exception e){
            result.setStatus(0);
            result.setMsg("保存失败！");
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public ResultObjectVo<Demo> update(Demo vo){
        ResultObjectVo<Demo> result = new  ResultObjectVo<Demo>();
        int count = iDemoService.update(vo);
        if(count>0){
            result.setStatus(1);
            result.setData(vo);
            result.setMsg("保存成功！");
        }
        else{
            result.setStatus(0);
            result.setMsg("保存失败！");
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultObjectVo<Demo> delete(@RequestBody Map map){
        ResultObjectVo<Demo> result = new  ResultObjectVo<Demo>();
        List<Demo> vos = JsonUtils.fromJsonArray(map.get("datas").toString(), Demo.class);
        List<Long> pks = new ArrayList<>();
        if(vos == null || vos.size()==0){
            result.setStatus(0);
            result.setMsg("没有需要保存的数据！");
        }
        for(Demo vo:vos){
            pks.add(vo.getId());
        }
        int count = iDemoService.delete(pks);
        if(count>0){
            result.setStatus(1);
            result.setMsg("删除成功！");
        }
        else{
            result.setStatus(0);
            result.setMsg("删除失败！");
        }
        return result;
    }
}
