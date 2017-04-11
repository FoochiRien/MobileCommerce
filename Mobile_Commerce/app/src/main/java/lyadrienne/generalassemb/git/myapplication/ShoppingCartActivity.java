package lyadrienne.generalassemb.git.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity implements View.OnClickListener {

    private DollRecyclerViewAdapter adapter;
    List<Doll> dolls;

    TextView mSumTotal;
    Button mCheckOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.checkout_toolbar);
        setSupportActionBar(toolbar);

        DollSQLiteOpenHelper helper = DollSQLiteOpenHelper.getInstance(this);
        dolls = helper.getShoppingCartItems();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.shoppingcart_recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new DollRecyclerViewAdapter(dolls);
        recyclerView.setAdapter(adapter);

        mSumTotal = (TextView) findViewById(R.id.sum_textview);
        mCheckOutButton = (Button) findViewById(R.id.checkout_toolbar);

        mCheckOutButton.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.shoppingcart_searchbar);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.searchbar:
                //re-direct no search
                startActivity(new Intent(ShoppingCartActivity.this, SearchActivity.class));
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
        AlertDialog.Builder builder = new AlertDialog.Builder(ShoppingCartActivity.this);
        builder.setTitle("Checkout")
                .setMessage("Thank you for your purchase")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ShoppingCartActivity.this, "Purcahse complete", Toast.LENGTH_SHORT).show();
                    }
                });


        }

    }

