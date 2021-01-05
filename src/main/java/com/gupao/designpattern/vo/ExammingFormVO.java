package com.gupao.designpattern.vo;

import com.alibaba.fastjson.JSONObject;
import com.gupao.designpattern.bean.ExammingForm;

/**
 * @author jacky
 * @description
 * @date 2020/8/9
 */
public class ExammingFormVO extends ExammingForm {
    private String examinationPaperId;//试卷主键
    private String leaveTime;//剩余时间
    private String organizationId;//单位主键

    public void setExammingForm(ExammingForm form,String parameters){
        try {
            JSONObject json = new JSONObject();
            ExammingFormVO vo = JSONObject.parseObject(parameters,ExammingFormVO.class);
            form = vo;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
