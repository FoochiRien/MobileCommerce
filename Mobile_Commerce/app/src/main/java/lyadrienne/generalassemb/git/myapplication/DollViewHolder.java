package lyadrienne.generalassemb.git.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Admin on 4/8/17.
 */

public class DollViewHolder extends RecyclerView.ViewHolder {
    View mRootView;
    TextView mItemNameView, mCurrentPriceView;


    public DollViewHolder(View itemView) {
        super(itemView);

        //----Recyclerview
        mRootView = itemView;
        mItemNameView = (TextView) itemView.findViewById(R.id.itemname_view);
        mCurrentPriceView = (TextView) itemView.findViewById(R.id.currentprice_view);

    }



}
