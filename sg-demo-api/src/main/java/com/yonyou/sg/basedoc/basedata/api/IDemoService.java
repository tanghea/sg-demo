package com.yonyou.sg.basedoc.basedata.api;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.cpu.commons.domain.PageBean;
import com.yonyou.sg.basedoc.basedata.domain.Demo;

import java.util.List;

/**
 * Created by ck on 2018\3\13 0013.
 */
public interface IDemoService {
     JSONObject pageQuery(PageBean pagebean, Demo criteria);
     Long savedata(Demo vo);
     int delete(List<Long> pks);
     int update(Demo vo);
}
