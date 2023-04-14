package com.example.demo.util;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class CommonUtil {
    private CommonUtil() {
    }

    /**
     *
     * @param list1
     * @param list2
     * @return if the list1 is none then return the list2
     *         otherwise return the list1
     */
    public static <T> List<T> addAll(List<T> list1, List<T> list2) {
        if (list1 == null) {
            return list2;
        }
        if (!CollectionUtils.isEmpty(list2)) {
            list1.addAll(list2);
        }
        return list1;
    }
}
