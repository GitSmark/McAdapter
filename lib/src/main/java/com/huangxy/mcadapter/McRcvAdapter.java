package com.huangxy.mcadapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 */
public class McRcvAdapter extends CommonRcvAdapter {

    private Object l = null;

    private List<Class<? extends IAdapterItem>> classTs = new ArrayList<>();

    public McRcvAdapter(@NonNull List<? extends McAdapterModel> data) {
        super(data);
    }

    public McRcvAdapter(@NonNull List data, @NonNull Class<? extends IAdapterItem> classTs) {
        super(data);
        this.classTs.add(classTs);
    }

    @Deprecated
    public McRcvAdapter(@NonNull List<? extends IAdapterModel> data, Class<? extends IAdapterItem>... classTs) {
        super(data);
        for (Class<? extends IAdapterItem> classT: classTs) {
            this.classTs.add(classT);
        }
    }

    @Deprecated
    public McRcvAdapter(@NonNull List<? extends IAdapterModel> data, List<Class<? extends IAdapterItem>> classTs) {
        super(data);
        for (Class<? extends IAdapterItem> classT: classTs) {
            this.classTs.add(classT);
        }
    }

    public McRcvAdapter(@NonNull Object listener, @NonNull List<? extends McAdapterModel> data) {
        this(data);
        this.l = listener;
    }

    public McRcvAdapter(@NonNull Object listener, @NonNull List data, @NonNull Class<? extends IAdapterItem> classTs) {
        this(data, classTs);
        this.l = listener;
    }

    @Deprecated
    public McRcvAdapter(@NonNull Object listener, @NonNull List<? extends IAdapterModel> data, Class<? extends IAdapterItem>... classTs) {
        this(data, classTs);
        this.l = listener;
    }

    @Deprecated
    public McRcvAdapter(@NonNull Object listener, @NonNull List<? extends IAdapterModel> data, List<Class<? extends IAdapterItem>> classTs) {
        this(data, classTs);
        this.l = listener;
    }

    @Override
    public Object getItemType(Object model) {
        Class<? extends IAdapterItem> adapterItem = null;
        try {
            adapterItem = ((McAdapterModel) model).getAdapterItem();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (adapterItem != null) return adapterItem;
        try {
            return classTs.get(((IAdapterModel) model).getItemType()); //itemType，实际上是classTs的下标
        }catch (Exception e){
            e.printStackTrace();
        }
        if (classTs.size() > 0) return classTs.get(0); //List<?>如果没有实现IAdapterModel接口，默认取第一个
        return adapterItem;
    }

    @NonNull
    @Override
    public IAdapterItem onCreateItem(Object obj) {
        final Class<? extends IAdapterItem> adapterItem = (Class<? extends IAdapterItem>) obj;
        try {
            //带参构造函数
            return adapterItem.getDeclaredConstructor(Object.class).newInstance((l!=null)? l: new Object());
        }catch (Exception e){
            e.printStackTrace();
        }
        //默认无构造参数
        try {
            return adapterItem.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
