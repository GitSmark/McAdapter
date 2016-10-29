package huangxy.com.mcadapter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 */
public class McRcvAdapter extends CommonRcvAdapter {

    private List<Class<? extends AdapterItem>> classTs = new ArrayList<>();

    public McRcvAdapter(@NonNull List data, Class<? extends AdapterItem>... params) {
        super(data);
        for (Class<? extends AdapterItem> classT: params) {
            classTs.add(classT);
        }
    }

    public McRcvAdapter(@NonNull List data, List<Class<? extends AdapterItem>> classTs) {
        super(data);
        for (Class<? extends AdapterItem> classT: classTs) {
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
    public AdapterItem onCreateItem(Object type) {
        try {
            int ItemType = (type != null)?(int)type: 0;
            return classTs.get(ItemType).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
