package coders.self.materialdesigntemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Carlos Bedoy on 8/6/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 * <p/>
 * Pademobile
 */
public abstract class AbstractAdapter<T> extends BaseAdapter {

    private List<T> mDataModel;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public List<T> getDataModel() {
        return mDataModel;
    }

    public LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }

    public Context getContext() {
        return mContext;
    }

    public AbstractAdapter(Context context, LayoutInflater layoutInflater, List<T> dataModel){
        mContext = context;
        mLayoutInflater = layoutInflater;
        mDataModel = dataModel;
    }

    @Override
    public int getCount() {
        return mDataModel.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataModel.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
