package com.we.sdk.memsap.base.util;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * 数据校验工具
 */
public class BindingResultHandler {

    public static RestResult bindingMessageHandle(BindingResult bindingResult){
        String errorMessage = "";
        if (bindingResult.hasErrors()){
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for(ObjectError error : errorList){
                errorMessage+=error.getDefaultMessage()+";";
            }
            return RestResultGenerator.createFailResult(errorMessage);
        }
        return RestResultGenerator.createOkResult();
    }
}
