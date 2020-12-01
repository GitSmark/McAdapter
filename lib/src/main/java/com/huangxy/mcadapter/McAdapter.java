package com.huangxy.mcadapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapter extends CommonAdapter {

    private Object l = null;

    private List<Class<? extends IAdapterItem>> classTs = new ArrayList<>();

    public McAdapter(@NonNull Object listener, @NonNull List data, Class<? extends IAdapterItem>... params) {
        this(data, params);
        this.l = listener;
    }

    public McAdapter(@NonNull List data, Class<? extends IAdapterItem>... params) {
        super(data, params.length);
        for (Class<? extends IAdapterItem> classT: params) {
            classTs.add(classT);
        }
    }

    public McAdapter(@NonNull Object listener, @NonNull List data, List<Class<? extends IAdapterItem>> classTs) {
        this(data, classTs);
        this.l = listener;
    }

    public McAdapter(@NonNull List data, List<Class<? extends IAdapterItem>> classTs) {
        super(data, classTs.size());
        for (Class<? extends IAdapterItem> classT: classTs) {
            this.classTs.add(classT);
        }
    }

    @Override
    public Object getItemType(Object obj) {
        if (classTs.size() > 1){
            try {
                return ((McEntity) obj).getItemType();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return 0;
    }

    @NonNull
    @Override
    public IAdapterItem onCreateItem(Object type) {
        final int ItemType = (type!=null)? (int)type: 0;
        try {
            return classTs.get(ItemType).getDeclaredConstructor(Object.class).newInstance((l!=null)? l: new Object());
        }catch (Exception e){
            e.printStackTrace();
        }
        //默认无构造参数
        try {
            return classTs.get(ItemType).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}