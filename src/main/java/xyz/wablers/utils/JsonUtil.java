package xyz.wablers.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Wablers
 * @version 1.0
 * @description: Json格式化工具
 * @date 2021/8/13 15:00
 */
public class JsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        //设置json格式（自动换行），一般仅调试使用，影响性能
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
