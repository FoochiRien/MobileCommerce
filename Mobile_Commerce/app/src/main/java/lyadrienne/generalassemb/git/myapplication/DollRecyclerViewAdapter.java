package lyadrienne.generalassemb.git.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

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
    public void onBindViewHolder(DollViewHolder holder, int position) {
        final Doll currentDoll = mDolls.get(position);

        //TODO holder for textview boxes and activity_search buttson
        holder.mItemNameView.setText(currentDoll.getItemName());
//        holder.mDescriptionView.setText(currentDoll.getDescription());
//        holder.mCurrentPriceView.setText(currentDoll.getCurrentPrice());


        //TODO holder for mRootView for setOnLongClickListner

    }

    @Override
    public int getItemCount() {
        return mDolls.size();
    }
}
