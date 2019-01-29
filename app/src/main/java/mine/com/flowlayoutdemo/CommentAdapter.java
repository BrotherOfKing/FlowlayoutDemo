package mine.com.flowlayoutdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class CommentAdapter<T> extends BaseAdapter {
    protected abstract void setItem(View convertView, T item, int position);

    protected List<T> mData;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected int mLayoutRes;

    public CommentAdapter(Context context, List<T> data, int layoutRes) {
        this.mData = data;
        this.mContext = context;
        this.mLayoutRes = layoutRes;

        this.mInflater = LayoutInflater.from(mContext);
    }

    /**
     * 刷新 adapter
     * 考虑到可能会发生数据完全改变的情况，故提供此方法
     * @param data
     */
    public void refresh(List<T> data) {
        try {
            this.mData = data;
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            if (convertView == null) {
                convertView = mInflater.inflate(mLayoutRes, null);
            }

            setItem(convertView, getItem(position), position);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertView;
    }

    public <V extends View> V getChildView(View view, int id) {
        return HelperHolder.get(view, id);
    }
}
