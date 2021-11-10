package io.blog.helper;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {

    public static Map<String, Object> getSuccessMap(String msg) {
        Map<String, Object> successMap = new HashMap<>();
        Map<String, Object> successResult = new HashMap<>();
        successResult.put("message", msg);
        successMap.put("success", true);
        successMap.put("message", "Request was succeed.");
        successMap.put("result", successResult);
        return successMap;

    }

    public static Map<String, Object> getFailureMap(String msg) {
        Map<String, Object> failureMap = new HashMap<>();
        Map<String, Object> failureresult = new HashMap<>();
        failureresult.put("message", msg);
        failureMap.put("success", false);
        failureMap.put("message", "Request was failed.");
        failureMap.put("result", failureresult);
        return failureMap;

    }
//    public static Map<String,Object> getFailureMap(){
//        Map<String,Object> map=new HashMap<>();
//
//    }

}
