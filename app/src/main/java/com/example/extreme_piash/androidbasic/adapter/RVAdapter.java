package com.example.extreme_piash.androidbasic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.extreme_piash.androidbasic.Model.BaseModel;
import com.example.extreme_piash.androidbasic.Model.Category;
import com.example.extreme_piash.androidbasic.R;
import com.example.extreme_piash.androidbasic.RClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by piash on 7/29/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private Context context;
    private List<Category> categories;
    private RClickListener rClickListener;

    public RVAdapter(Context context) {
        this.context = context;
        this.categories = new ArrayList<>();
    }

    public void setData(List<Category> categories){
        this.categories.clear();
        this.categories.addAll(categories);
        this.notifyDataSetChanged();

    }
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.row_one, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder holder, int position) {

        holder.textViewCategoryName.setText(categories.get(position).getCategoryName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setOnclickListener(RClickListener rClickListener){
      this.rClickListener =  rClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        @BindView(R.id.categoryName)
        TextView textViewCategoryName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            rClickListener.onItemClick(getAdapterPosition(), view);
        }
    }
}
