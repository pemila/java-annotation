package com.pemila.annotationdemo;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 月在未央
 * @date 2019/5/24 11:17
 */
public class AnnotationCheck {
    private static Map<String,Integer> map;

    static {
        map = new HashMap<>();
        map.put("RecordVisit",0);
    }

    public static void check(Annotation annotation){

        String simpleName = annotation.annotationType().getSimpleName();
        switch (map.get(simpleName)){
            case 0:
                System.out.println("服务器访问次数 + 1");
                break;
            default:
                break;
        }
    }
}
