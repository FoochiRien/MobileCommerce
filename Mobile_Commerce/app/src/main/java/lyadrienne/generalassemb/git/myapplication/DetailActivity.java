package lyadrienne.generalassemb.git.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    public static final String SELECTED_ITEM_ID_KEY = "selectedItemIdKey";

    TextView mItemNameView, mDescriptionView,  mRetailPriceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        long id = getIntent().getLongExtra(SELECTED_ITEM_ID_KEY, -1);
        Doll doll = DollSQLiteOpenHelper.getInstance(this).getItemById(id);

        if(doll == null){
            Toast.makeText(this, "None to show", Toast.LENGTH_SHORT).show();
            finish();
        }
        //TODO on click for add to wishlist and add to cart
//

        //----Detail View
        mItemNameView = (TextView) findViewById(R.id.detail_titleview);
        mDescriptionView = (TextView) findViewById(R.id.detail_descripview);
        mRetailPriceView = (TextView) findViewById(R.id.detail_amountview);
//
//        (TextView) findViewById(R.id.detail_titleview).setText(doll.getItemName());
//        (TextView) findViewById(R.id.detail_descripview).setText(doll.getDescription());
//        (TextView) findViewById(R.id.detail_amountview).setText(String.valueOf(doll.getCurrentPrice()));

    }
}
