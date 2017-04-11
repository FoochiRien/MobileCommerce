package lyadrienne.generalassemb.git.myapplication;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private DollRecyclerViewAdapter adapter;
    List<Doll> dolls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DollSQLiteOpenHelper helper = DollSQLiteOpenHelper.getInstance(this);


        Intent intent = getIntent();
        switch (intent.getIntExtra("search", -1))
        {
            case 0:
                dolls=helper.getDealItems();
                break;
            case 1:
                dolls=helper.getSaleItems();
                break;
            case 2:
                dolls=helper.getClearanceItems();
                break;
//            case 3:
//                dolls=helper.getBarbie();
//                break;
//            case 4:
//                dolls=helper.getEtnicity();
//                break;
            default:
                dolls=helper.getAllDolls();

        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
         adapter = new DollRecyclerViewAdapter(dolls);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.searchbar).getActionView();
        ComponentName component = new ComponentName(this, SearchActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(component));

        MenuItem menuItem = menu.findItem(R.id.searchbar);

        return true;
    }


    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    public void handleIntent(Intent intent){

        if(Intent.ACTION_SEARCH.equals(intent.getAction())){

            String query = intent.getStringExtra(SearchManager.QUERY);

            Log.d("hghg", "handleIntent: jhjgjhgjhgjhgjhgjgjhgjh");
            adapter.replaceAllDolls(DollSQLiteOpenHelper.getInstance(SearchActivity.this).searchDollList(query));
        }
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch(item.getItemId()) {
//
//            case R.id.action_shoppingcart:
//                startActivity(new Intent(SearchActivity.this,ShoppingCartActivity.class));
//                return true;
//            case R.id.action_wishlist:
//                //Todo go to wishlist
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
