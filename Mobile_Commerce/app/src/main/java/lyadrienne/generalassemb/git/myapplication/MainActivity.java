package lyadrienne.generalassemb.git.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

import lyadrienne.generalassemb.git.myapplication.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mSaleView, mDiscountView, mClearanceView, mBarbieView, mEthnicDollsView;
//    public static final String SELECTED_ITEM_ID_KEY = "selectedItemIdKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();
//
//        DollSQLiteOpenHelper helper = DollSQLiteOpenHelper.getInstance(this);
//        List<Doll> dolls = helper.getAllDolls();
//
//        final long id = getIntent().getLongExtra(SELECTED_ITEM_ID_KEY, -1);
//        Doll doll = DollSQLiteOpenHelper.getInstance(this).getItemById(id);

        //----------- Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //---------Home screen buttons
        mSaleView = (Button) findViewById(R.id.sale_view);
        mDiscountView = (Button) findViewById(R.id.deal_view);
        mClearanceView = (Button) findViewById(R.id.clearance_view);
//        mBarbieView = (Button) findViewById(R.id.barbie_view);
//        mEthnicDollsView = (Button) findViewById(R.id.ethnicity_view);

        mSaleView.setOnClickListener(this);
        mDiscountView.setOnClickListener(this);
        mClearanceView.setOnClickListener(this);
//        mBarbieView.setOnClickListener(this);
//        mEthnicDollsView.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.searchbar:
                //
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                return true;
            case R.id.action_shoppingcart:
                startActivity(new Intent(MainActivity.this,ShoppingCartActivity.class));
                return true;
            case R.id.action_wishlist:
                //Todo go to wishlist
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sale_view:
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("search",0);
                startActivity(intent);
                break;
            case R.id.deal_view:
                Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
                intent1.putExtra("search",1);
                startActivity(intent1);
                break;
            case R.id.clearance_view:
                Intent intent2 = new Intent(MainActivity.this, SearchActivity.class);
                intent2.putExtra("search",2);
                startActivity(intent2);
                break;
//            case R.id.barbie_view: //todo create barbie and ethnicity view
//                Intent intent3 = new Intent(MainActivity.this, SearchActivity.class);
//                intent3.putExtra("search",3);
//                break;
//            case R.id.ethnicity_view:
//                Intent intent4 = new Intent(MainActivity.this, SearchActivity.class);
//                intent4.putExtra("search",4);
//                break;
            default:
                return;

        }

    }
}
