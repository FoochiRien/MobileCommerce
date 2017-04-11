package lyadrienne.generalassemb.git.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import java.util.List;

import lyadrienne.generalassemb.git.myapplication.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {
    Button mSaleView, mDiscountView, mClearanceView, mBarbieView, mEthnicDollsView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        DollSQLiteOpenHelper helper = DollSQLiteOpenHelper.getInstance(this);
        List<Doll> dolls = helper.getAllDolls();

        //----------- Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Todo activity_search bar

        //TODO on click for 12/ 30/ clearance/ barbie / ethnic

        //---------Home screen buttons
        mSaleView = (Button) findViewById(R.id.thirtypercentoff_view);
        mDiscountView = (Button) findViewById(R.id.twelvepercentoff_view);
        mClearanceView = (Button) findViewById(R.id.clearance_view);
        mBarbieView = (Button) findViewById(R.id.barbie_view);
        mEthnicDollsView = (Button) findViewById(R.id.ethnicity_view);


//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview2);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        adapter = new DollRecyclerViewAdapter(dolls);
//        recyclerView.setAdapter(adapter);

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
}
