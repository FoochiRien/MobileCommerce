package lyadrienne.generalassemb.git.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String SELECTED_ITEM_ID_KEY = "selectedItemIdKey";

    TextView mItemNameView, mDescriptionView,  mRetailPriceView, mWishList;
    Button mAddtoCart;
    private List<Doll> mDolls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final long id = getIntent().getLongExtra(SELECTED_ITEM_ID_KEY, -1);
        Doll doll = DollSQLiteOpenHelper.getInstance(this).getItemById(id);


        //----Detail View
        mItemNameView = (TextView) findViewById(R.id.detail_titleview);
        mDescriptionView = (TextView) findViewById(R.id.detail_descripview);
        mRetailPriceView = (TextView) findViewById(R.id.detail_amountview);

        mItemNameView.setText(doll.getItemName());
        mDescriptionView.setText(doll.getDescription());
        mRetailPriceView.setText(String.valueOf(doll.getCurrentPrice()));

        mAddtoCart = (Button) findViewById(R.id.detail_addtocart);
        mWishList= (TextView) findViewById(R.id.detail_addwishlist);

        mAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DollSQLiteOpenHelper.getInstance(v.getContext()).addItemToCart(id);
                Toast.makeText(DetailActivity.this, "Item added to cart.", Toast.LENGTH_SHORT).show();

            }
        });

        mWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DollSQLiteOpenHelper.getInstance(v.getContext()).addItemWishList(id);
                Toast.makeText(DetailActivity.this, "Item added to wish list", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
