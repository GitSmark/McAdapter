package com.huangxy.mcadapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 * McAdapterUtil工具类，将model转换为McEntity
 */
public class McAdapterUtil {

    public static List<McEntity> toMcEntity(Object... orgs) {
        return toMcEntity(Arrays.asList(orgs));
    }

    public static List<McEntity> toMcEntity(List list){
        return toMcEntity(list, 0);
    }

    @Deprecated
    public static List<McEntity> toMcEntity(List data, int itemType){
        List<McEntity> list = new ArrayList<>();
        if(data != null && data.size() > 0) {
            Iterator it = data.iterator();
            while (it.hasNext()) {
                list.add(new McEntity(it.next(), itemType));
            }
        }
        return list;
    }

    public static List<McEntity> toMcEntity(List data, Class<? extends IAdapterItem> adapterItem){
        List<McEntity> list = new ArrayList<>();
        if(data != null && data.size() > 0) {
            Iterator it = data.iterator();
            while (it.hasNext()) {
                list.add(new McEntity(it.next(), adapterItem));
            }
        }
        return list;
    }
}
