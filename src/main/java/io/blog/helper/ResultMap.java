package io.blog.helper;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {

    public static Map<String, Object> getSuccessMap(String msg, Object data) {
        Map<String, Object> successMap = new HashMap<>();
        Map<String, Object> successResult = new HashMap<>();
        successResult.put("message", msg);
        successResult.put("data", data);
        successMap.put("message", "Request was succeed.");
        successMap.put("result", successResult);
        return successMap;

    }

    public static Map<String, Object> getFailureMap(String msg) {
        Map<String, Object> failureMap = new HashMap<>();
        Map<String, Object> failureResult = new HashMap<>();
        failureResult.put("message", msg);
        failureMap.put("message", "Request was failed.");
        failureMap.put("result", failureResult);
        return failureMap;

    }

}
