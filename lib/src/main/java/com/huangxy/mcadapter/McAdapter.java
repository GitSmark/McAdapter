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

    private static final int SINGLE_VIEW_TYPE = 1;

    private static final int MAX_VIEW_TYPE_COUNT = 32;

    private List<Class<? extends IAdapterItem>> classTs = new ArrayList<>();

    public McAdapter(@NonNull List<? extends McAdapterModel> data) {
        super(data, MAX_VIEW_TYPE_COUNT);
    }

    public McAdapter(@NonNull List data, @NonNull Class<? extends IAdapterItem> classTs) {
        super(data, SINGLE_VIEW_TYPE);
        this.classTs.add(classTs);
    }

    @Deprecated
    public McAdapter(@NonNull List<? extends IAdapterModel> data, Class<? extends IAdapterItem>... classTs) {
        super(data, (classTs != null && classTs.length > 0)? classTs.length: MAX_VIEW_TYPE_COUNT);
        for (Class<? extends IAdapterItem> classT: classTs) {
            this.classTs.add(classT);
        }
    }

    @Deprecated
    public McAdapter(@NonNull List<? extends IAdapterModel> data, List<Class<? extends IAdapterItem>> classTs) {
        super(data, (classTs != null && classTs.size() > 0)? classTs.size(): MAX_VIEW_TYPE_COUNT);
        for (Class<? extends IAdapterItem> classT: classTs) {
            this.classTs.add(classT);
        }
    }

    public McAdapter(@NonNull Object listener, @NonNull List<? extends McAdapterModel> data) {
        this(data);
        this.l = listener;
    }

    public McAdapter(@NonNull Object listener, @NonNull List data, @NonNull Class<? extends IAdapterItem> classTs) {
        this(data, classTs);
        this.l = listener;
    }

    @Deprecated
    public McAdapter(@NonNull Object listener, @NonNull List<? extends IAdapterModel> data, Class<? extends IAdapterItem>... classTs) {
        this(data, classTs);
        this.l = listener;
    }

    @Deprecated
    public McAdapter(@NonNull Object listener, @NonNull List<? extends IAdapterModel> data, List<Class<? extends IAdapterItem>> classTs) {
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
