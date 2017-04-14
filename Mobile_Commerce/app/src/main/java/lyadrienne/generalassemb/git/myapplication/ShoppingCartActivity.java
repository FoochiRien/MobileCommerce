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

    // Activity where the user is able to update and/or purchase items in the cart
    private ShoppingCartRecyclerViewAdapater shoppingadapater;
    List<Doll> dolls;

    TextView mSumTotal;  //View that shows the sum of items in the cart
    Button mCheckOutButton; // Clicking will display message and remove all items from cart

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);

        // change the name in the toolbar to Shopping Cart
        Toolbar toolbar = (Toolbar) findViewById(R.id.checkout_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Shopping Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        DollSQLiteOpenHelper helper = DollSQLiteOpenHelper.getInstance(this);
        dolls = helper.getShoppingCartItems();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.shoppingcart_recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        shoppingadapater = new ShoppingCartRecyclerViewAdapater(dolls);
        recyclerView.setAdapter(shoppingadapater);

        //Gets total of items in cart
        mSumTotal = (TextView) findViewById(R.id.sum_textview);
        mSumTotal.setText(String.valueOf(helper.sumOfShoppingCart()));
        //user clicks button to activate the below alert dialogue, remove from cart and toast
        mCheckOutButton = (Button) findViewById(R.id.checkout_button);
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

    /*
    When the user is ready to checkout.
    An alert dialog displays message for checkout and removes all items from the cart.
     */
    @Override
    public void onClick(final View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ShoppingCartActivity.this);
        builder.setTitle("Checkout")
                .setMessage("Thank you for your purchase")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ShoppingCartActivity.this, "Purchase complete", Toast.LENGTH_SHORT).show();
                        DollSQLiteOpenHelper.getInstance(ShoppingCartActivity.this).removeAllItemsFromCart();
                        dolls = DollSQLiteOpenHelper.getInstance(ShoppingCartActivity.this).getShoppingCartItems();
                        shoppingadapater.replaceAllDolls(dolls);
                        mSumTotal.setText(String.valueOf(DollSQLiteOpenHelper.getInstance(v.getContext()).sumOfShoppingCart()));

                    }
                })
        .show();

        }

    }

