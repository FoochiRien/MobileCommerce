package lyadrienne.generalassemb.git.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Admin on 4/8/17.
 */

public class DollRecyclerViewAdapter extends RecyclerView.Adapter<DollViewHolder>{

    private List<Doll> mDolls;

    public DollRecyclerViewAdapter(List<Doll> dolls){
        mDolls = dolls;
    }

    @Override
    public DollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new DollViewHolder(inflater.inflate(R.layout.custom_search_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(final DollViewHolder holder, final int position) {
        final Doll currentDoll = mDolls.get(position);

        holder.mItemNameView.setText(currentDoll.getItemName());
        holder.mCurrentPriceView.setText(String.valueOf(currentDoll.getRetailPrice()));

        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Doll doll = mDolls.get(position);
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.SELECTED_ITEM_ID_KEY, doll.getId());
                v.getContext().startActivity(intent);
            }
        });
        //todo picasso
//        Picasso.with(this).load(Doll.getImageView).resize(200,200).into(holder.mImageView);
        }




    @Override
    public int getItemCount() {
        return mDolls.size();
    }

    public void replaceAllDolls(List<Doll> newDolls){

        mDolls = newDolls;
        notifyDataSetChanged();

    }
}
