package io.blog.helper;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {

    public static Map<String, Object> getSuccessMap(String msg, Object data) {
        Map<String, Object> successResult = new HashMap<>();
        successResult.put("message", msg);
        successResult.put("data", data);
        return getMapTemplate("Request was succeed", successResult, 200);

    }

    public static Map<String, Object> getRequestFailureMap(String msg) {
        Map<String, Object> failureResult = new HashMap<>();
        failureResult.put("message", msg);
        return getMapTemplate("Request was failed.", failureResult, 401);

    }

    public static Map<String, Object> getBadRequestMap(String msg) {
        Map<String, Object> badRequestResult = new HashMap<>();
        badRequestResult.put("message", msg);
        return getMapTemplate("Bad Request", badRequestResult, 404);

    }

    public static Map<String,Object> getUnauthorizedMap(String msg){
        Map<String, Object> unauthorizedResult = new HashMap<>();
        unauthorizedResult.put("message", msg);
        return getMapTemplate("Unauthorized", unauthorizedResult, 401);
    }
    public static Map<String, Object> getMapTemplate(String msg1, Map<String, Object> data, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", msg1);
        map.put("result", data);
        map.put("status", status);
        return map;
    }

}
