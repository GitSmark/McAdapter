package com.huangxy.mcadapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterUtil {

    public static List<McEntity> toMcEntity(Object... orgs) {
        return toMcEntity(Arrays.asList(orgs));
    }

    public static List<McEntity> toMcEntity(List list){
        return toMcEntity(list, 0);
    }

    public static List<McEntity> toMcEntity(List data, int itemType){
        List<McEntity> list = new ArrayList<>();
        if(data != null && data.size() > 0) {
            Iterator it = data.iterator();
            while (it.hasNext()) {
                list.add(new McEntity(itemType, it.next()));
            }
        }
        return list;
    }
}
