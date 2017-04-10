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
    TextView mItemNameView, mDescriptionView, mRetailPriceView, mCurrentPriceView;
    Button mSaleView, mDiscountView, mClearanceView, mBarbieView, mEthnicDollsView;


    public DollViewHolder(View itemView) {
        super(itemView);

        mRootView = itemView;
        mItemNameView = (TextView) itemView.findViewById(R.id.itemname_view);
//        mDescriptionView = (TextView) itemView.findViewById(R.id.description_view);
//        mRetailPriceView = itemView.findViewById(R.id.);
//        mCurrentPriceView = ;

        //---------Home screen buttons
        mSaleView = (Button) itemView.findViewById(R.id.thirtypercentoff_view);
        mDiscountView = (Button) itemView.findViewById(R.id.twelvepercentoff_view);
        mClearanceView = (Button) itemView.findViewById(R.id.clearance_view);
        mBarbieView = (Button) itemView.findViewById(R.id.barbie_view);
        mEthnicDollsView = (Button) itemView.findViewById(R.id.ethnicity_view);
    }



}
