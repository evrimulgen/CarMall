package com.loading.carmall.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 马小布 on 2017/5/5.
 */

public class MqlUtils {
    public static List groupListByQuantity(List list, int quantity) {
        if (list == null || list.size() == 0) {
            return list;
        }

        if (quantity <= 0) {
            new IllegalArgumentException("Wrong quantity.");
        }

        List wrapList = new ArrayList();
        int count = 0;
        while (count < list.size()) {
            wrapList.add(new ArrayList(list.subList(count, (count + quantity) > list.size() ? list.size() : count + quantity)));
            count += quantity;
        }

        return wrapList;
    }
}
