package com.xiaoluo.easymovie.adapter;

import android.widget.TextView;

import com.xiaoluo.easymovie.R;
import com.xiaoluo.easymovie.base.BaseAdapter;
import com.xiaoluo.easymovie.base.BaseViewHolder;
import com.xiaoluo.easymovie.model.MovieList;

import java.util.List;

/**
 * top250
 *
 * author: xiaoluo
 * date: 2017/8/18 17:01
 */
public class TopMovieAdapter extends BaseAdapter<MovieList.SubjectsBean> {
    private List<MovieList.SubjectsBean> mList;

    public TopMovieAdapter(List<MovieList.SubjectsBean> list) {
        super(list);
        mList = list;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_top_movie;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        TextView title = holder.getView(R.id.title_tv);
        TextView num = holder.getView(R.id.num_tv);

        MovieList.SubjectsBean data = mList.get(position);
        title.setText(data.getTitle());
        num.setText(data.getRating().getAverage() + "");
    }

    public void setList(List<MovieList.SubjectsBean> list){
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }
}
