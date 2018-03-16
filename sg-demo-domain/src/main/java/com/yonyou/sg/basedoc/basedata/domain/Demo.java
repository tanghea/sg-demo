package com.yonyou.sg.basedoc.basedata.domain;


import com.yonyou.cpu.commons.domain.criteria.Criteria;

import java.io.Serializable;

/**
 * Created by ck on 2018\3\13 0013.
 */
public class Demo  extends Criteria {
    private Long id;
    private String name;
    private String code;
    private Integer dr;
    private String businessStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }
}
