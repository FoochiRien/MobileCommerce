package lyadrienne.generalassemb.git.myapplication;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Admin on 4/12/17.
 */

public class ShoppingCartRecyclerViewAdapater extends RecyclerView.Adapter<DollViewHolder>{
    private List<Doll> mDolls;

    public ShoppingCartRecyclerViewAdapater(List<Doll> dolls) {
        mDolls = dolls;
    }

    @Override
    public DollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new DollViewHolder(inflater.inflate(R.layout.custom_checkout_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(final DollViewHolder holder, final int position) {
        final Doll currentDoll = mDolls.get(position);

        holder.mItemNameView2.setText(currentDoll.getItemName());
        holder.mCurrentPriceView2.setText(String.valueOf(currentDoll.getRetailPrice()));
        holder.mRootView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DollSQLiteOpenHelper.getInstance(v.getContext()).removeItemsFromCart(currentDoll.getId());
                mDolls.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());

                return false;
            }
        });
        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Doll doll = mDolls.get(position);
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.SELECTED_ITEM_ID_KEY, doll.getId());
                v.getContext().startActivity(intent);
            }
        });
        Picasso.with(holder.mImageView2.getContext()).load(currentDoll.getProductView()).fit().into(holder.mImageView2);
        System.out.println(currentDoll.getProductView()+ "Test for Photo");
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
