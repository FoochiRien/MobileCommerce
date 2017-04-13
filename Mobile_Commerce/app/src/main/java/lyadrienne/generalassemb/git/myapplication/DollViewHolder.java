package lyadrienne.generalassemb.git.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 4/8/17.
 */

public class DollViewHolder extends RecyclerView.ViewHolder {
    View mRootView;
    TextView mItemNameView, mItemNameView2, mCurrentPriceView, mCurrentPriceView2;
    ImageView mImageView, mImageView2;


    public DollViewHolder(View itemView) {
        super(itemView);

        //----Recyclerview
        // 1 references the searchrecycler
        // 2 references the shoppingcartrecycler
        mRootView = itemView;
        mItemNameView = (TextView) itemView.findViewById(R.id.itemname_view);
        mItemNameView2 = (TextView) itemView.findViewById(R.id.itemname_view2);

        mCurrentPriceView = (TextView) itemView.findViewById(R.id.currentprice_view);
        mCurrentPriceView2 = (TextView) itemView.findViewById(R.id.currentprice_view2);

        mImageView = (ImageView) itemView.findViewById(R.id.product_imageview);
        mImageView2 = (ImageView) itemView.findViewById(R.id.product_imageview2);
    }



}
