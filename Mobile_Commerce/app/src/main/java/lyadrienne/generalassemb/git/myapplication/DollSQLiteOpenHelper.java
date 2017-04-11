package lyadrienne.generalassemb.git.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 4/7/17.
 */

public class DollSQLiteOpenHelper extends SQLiteOpenHelper {

    //------------Define Database -----------------

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DOLL_DB.DB";
    private static final String DOLL_TABLE_NAME = "DOLL";

    private static final String COL_ID = "id";
    private static final String COL_TITLE = "item_name";
    private static final String COL_COMPANY = "company";
    private static final String COL_ETHNICITY = "ethnicity";
    private static final String COL_RETAIL_PRICE = "retail_price";
    private static final String COL_HEIGHT = "height";
    private static final String COL_CURRENT_PRICE = "current_price";
    private static final String COL_DISCOUNT = "discount";
    private static final String COL_DESCRIPTION = "descrip";
    private static final String COL_WISH_LIST = "wish_list";
    private static final String COL_CHECK_OUT = "check_out";

    private static final String CREATE_DOLL_TABLE = "CREATE TABLE" + DOLL_TABLE_NAME + "(" +
            COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_TITLE + "TEXT, " +
            COL_COMPANY + "TEXT, " +
            COL_ETHNICITY + "TEXT, " +
            COL_RETAIL_PRICE + "TEXT " +
            COL_HEIGHT + "INTEGER, " +
            COL_CURRENT_PRICE + "TEXT, " +
            COL_DISCOUNT + "INTEGER, " +
            COL_DESCRIPTION + "TEXT, " +
            COL_WISH_LIST + "TEXT, " +
            COL_CHECK_OUT + "TEXT )";

    // ------ Singleton instance variable, static getter method, and private constructor

    private static DollSQLiteOpenHelper sInstance;

    public static DollSQLiteOpenHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DollSQLiteOpenHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DollSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    // --- Required SQLiteOpenHelper methods


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DOLL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DOLL_TABLE_NAME);
        this.onCreate(db);
    }
    // ------Queries for search

    public List<Doll> getAllDolls() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DOLL_TABLE_NAME,
                null, null, null, null, null, null);
        List<Doll> dolls = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                long id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String itemname = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                String company = cursor.getString(cursor.getColumnIndex(COL_COMPANY));
                String ethnicity = cursor.getString(cursor.getColumnIndex(COL_ETHNICITY));
                String retailPrice = cursor.getString(cursor.getColumnIndex(COL_RETAIL_PRICE));
                int height = cursor.getInt(cursor.getColumnIndex(COL_HEIGHT));
                String currentPrice = cursor.getString(cursor.getColumnIndex(COL_CURRENT_PRICE));
                int discount = cursor.getInt(cursor.getColumnIndex(COL_DISCOUNT));
                String descrip = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int wishlist = cursor.getInt(cursor.getColumnIndex(COL_WISH_LIST));
                int checkout = cursor.getInt(cursor.getColumnIndex(COL_CHECK_OUT));

                Doll doll = new Doll(id, retailPrice, currentPrice, height, discount, itemname, company,
                        ethnicity, descrip, wishlist, checkout);
                dolls.add(doll);

                cursor.moveToNext();
            }

        }
        cursor.close();
        return dolls;
    }

    public List<Doll> searchDollList(String query) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(DOLL_TABLE_NAME,
                null, //column names
                COL_TITLE + " LIKE ? " + " OR " + COL_DESCRIPTION + " Like ? ", //selections
                new String[]{"%"+ query + "%" + query + "%"},
                null,
                null,
                null,
                null);

        List<Doll> searchResults = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                searchResults.add(new Doll(cursor.getLong(cursor.getColumnIndex(COL_ID)),
                        cursor.getString(cursor.getColumnIndex(COL_RETAIL_PRICE)),
                        cursor.getString(cursor.getColumnIndex(COL_CURRENT_PRICE)),
                        cursor.getInt(cursor.getColumnIndex(COL_HEIGHT)),
                        cursor.getInt(cursor.getColumnIndex(COL_DISCOUNT)),
                        cursor.getString(cursor.getColumnIndex(COL_TITLE)),
                        cursor.getString(cursor.getColumnIndex(COL_COMPANY)),
                        cursor.getString(cursor.getColumnIndex(COL_ETHNICITY)),
                        cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION)),
                        cursor.getInt(cursor.getColumnIndex(COL_WISH_LIST)),
                        cursor.getInt(cursor.getColumnIndex(COL_CHECK_OUT))));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return searchResults;
    }

    public Doll getItemById(long id){

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DOLL_TABLE_NAME,
                null,
                COL_ID+ " = ? ",
                new String[]{String.valueOf(id)},
                null, null, null);

        Doll dolls = null;

        if (cursor.moveToFirst()) {
                dolls = new Doll(cursor.getLong(cursor.getColumnIndex(COL_ID)),
                        cursor.getString(cursor.getColumnIndex(COL_RETAIL_PRICE)),
                        cursor.getString(cursor.getColumnIndex(COL_CURRENT_PRICE)),
                        cursor.getInt(cursor.getColumnIndex(COL_HEIGHT)),
                        cursor.getInt(cursor.getColumnIndex(COL_DISCOUNT)),
                        cursor.getString(cursor.getColumnIndex(COL_TITLE)),
                        cursor.getString(cursor.getColumnIndex(COL_COMPANY)),
                        cursor.getString(cursor.getColumnIndex(COL_ETHNICITY)),
                        cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION)),
                        cursor.getInt(cursor.getColumnIndex(COL_WISH_LIST)),
                        cursor.getInt(cursor.getColumnIndex(COL_CHECK_OUT)));
            }
        cursor.close();
        return dolls;
    }


    // ----- Queries for e-commerce------------------------------------------------------

    // -----pre-defined queries for the homescreen Sale, Deal, Clearance, Barbie, and Ethnic
    // ----- sale 30% off retail price
    public List<Doll> getSaleItems() {
        SQLiteDatabase db = getReadableDatabase();

        String selection = COL_DISCOUNT + " = ? ";

        Cursor cursor = db.query(DOLL_TABLE_NAME,
                new String[]{},
                selection,
                new String[]{"30"},
                null,
                null,
                null);

        List<Doll> dolls = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                long id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String itemname = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                String company = cursor.getString(cursor.getColumnIndex(COL_COMPANY));
                String ethnicity = cursor.getString(cursor.getColumnIndex(COL_ETHNICITY));
                String retailPrice = cursor.getString(cursor.getColumnIndex(COL_RETAIL_PRICE));
                int height = cursor.getInt(cursor.getColumnIndex(COL_HEIGHT));
                String currentPrice = cursor.getString(cursor.getColumnIndex(COL_CURRENT_PRICE));
                int discount = cursor.getInt(cursor.getColumnIndex(COL_DISCOUNT));
                String descrip = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int wishlist = cursor.getInt(cursor.getColumnIndex(COL_WISH_LIST));
                int checkout = cursor.getInt(cursor.getColumnIndex(COL_CHECK_OUT));

                Doll doll = new Doll(id, retailPrice, currentPrice, height, discount, itemname, company,
                        ethnicity, descrip, wishlist, checkout);
                dolls.add(doll);

                cursor.moveToNext();
            }

        }
        cursor.close();
        return dolls;
    }

    // ----- deal 12% off retail price
    public List<Doll> getDealItems() {
        SQLiteDatabase db = getReadableDatabase();

        String selection = COL_DISCOUNT + " = ? ";

        Cursor cursor = db.query(DOLL_TABLE_NAME,
                null,
                selection,
                new String[]{"12"},
                null,
                null,
                null);

        List<Doll> dolls = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                long id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String itemname = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                String company = cursor.getString(cursor.getColumnIndex(COL_COMPANY));
                String ethnicity = cursor.getString(cursor.getColumnIndex(COL_ETHNICITY));
                String retailPrice = cursor.getString(cursor.getColumnIndex(COL_RETAIL_PRICE));
                int height = cursor.getInt(cursor.getColumnIndex(COL_HEIGHT));
                String currentPrice = cursor.getString(cursor.getColumnIndex(COL_CURRENT_PRICE));
                int discount = cursor.getInt(cursor.getColumnIndex(COL_DISCOUNT));
                String descrip = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int wishlist = cursor.getInt(cursor.getColumnIndex(COL_WISH_LIST));
                int checkout = cursor.getInt(cursor.getColumnIndex(COL_CHECK_OUT));

                Doll doll = new Doll(id, retailPrice, currentPrice, height, discount, itemname, company,
                        ethnicity, descrip, wishlist, checkout);
                dolls.add(doll);

                cursor.moveToNext();
            }

        }
        cursor.close();
        return dolls;
    }

    // ----- clearance 60% off retail price
    public List<Doll> getClearanceItems() {
        SQLiteDatabase db = getReadableDatabase();

        String selection = COL_DISCOUNT + " = ? ";

        Cursor cursor = db.query(DOLL_TABLE_NAME,
                new String[]{},
                selection,
                new String[]{"60"},
                null,
                null,
                null);

        List<Doll> dolls = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                long id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String itemname = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                String company = cursor.getString(cursor.getColumnIndex(COL_COMPANY));
                String ethnicity = cursor.getString(cursor.getColumnIndex(COL_ETHNICITY));
                String retailPrice = cursor.getString(cursor.getColumnIndex(COL_RETAIL_PRICE));
                int height = cursor.getInt(cursor.getColumnIndex(COL_HEIGHT));
                String currentPrice = cursor.getString(cursor.getColumnIndex(COL_CURRENT_PRICE));
                int discount = cursor.getInt(cursor.getColumnIndex(COL_DISCOUNT));
                String descrip = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int wishlist = cursor.getInt(cursor.getColumnIndex(COL_WISH_LIST));
                int checkout = cursor.getInt(cursor.getColumnIndex(COL_CHECK_OUT));

                Doll doll = new Doll(id, retailPrice, currentPrice, height, discount, itemname, company,
                        ethnicity, descrip, wishlist, checkout);
                dolls.add(doll);

                cursor.moveToNext();
            }

        }
        cursor.close();
        return dolls;
    }


    //--------add item to shopping car
    public void addItemToCart(long id) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_CHECK_OUT, "1");
        db.update(DOLL_TABLE_NAME,values,COL_ID+ " = "+ id,null );
        db.close();
    }

    // ------- delete item from cart changes the boolean from
    public void removeItemsFromCart(long id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_CHECK_OUT, "0");
        db.update(DOLL_TABLE_NAME,values,COL_ID+ " = "+ id,null );
        db.close();
    }

    // -------shopping_cart items
    public List<Doll> getShoppingCartItems(long id) {
        SQLiteDatabase db = getReadableDatabase();

        String selection = COL_CHECK_OUT + " = ?";

        Cursor cursor = db.query(DOLL_TABLE_NAME,
                new String[]{},
                selection,
                new String[]{"1"},
                null,
                null,
                null);

        List<Doll> dolls = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String itemname = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                String company = cursor.getString(cursor.getColumnIndex(COL_COMPANY));
                String ethnicity = cursor.getString(cursor.getColumnIndex(COL_ETHNICITY));
                String retailPrice = cursor.getString(cursor.getColumnIndex(COL_RETAIL_PRICE));
                int height = cursor.getInt(cursor.getColumnIndex(COL_HEIGHT));
                String currentPrice = cursor.getString(cursor.getColumnIndex(COL_CURRENT_PRICE));
                int discount = cursor.getInt(cursor.getColumnIndex(COL_DISCOUNT));
                String descrip = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int wishlist = cursor.getInt(cursor.getColumnIndex(COL_WISH_LIST));
                int checkout = cursor.getInt(cursor.getColumnIndex(COL_CHECK_OUT));

                Doll doll = new Doll(id, retailPrice, currentPrice, height, discount, itemname, company,
                        ethnicity, descrip, wishlist, checkout);
                dolls.add(doll);

                cursor.moveToNext();
            }

        }
        cursor.close();
        return dolls;
    }


    // ------- add item to wish list
    public void addItemWishList(long id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_WISH_LIST, "1");
        db.update(DOLL_TABLE_NAME,values,COL_ID+ " = "+ id,null );
        db.close();
    }


    // ------- remove item from wish list
    public void removeItemfromWishList(long id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_WISH_LIST, "0");
        db.update(DOLL_TABLE_NAME,values,COL_ID+ " = "+ id,null );
        db.close();
    }

    public List<Doll> getWishListItems() {
        SQLiteDatabase db = getReadableDatabase();

        String selection = COL_WISH_LIST + " = ?";

        Cursor cursor = db.query(DOLL_TABLE_NAME,
                new String[]{},
                selection,
                new String[]{"1"},
                null,
                null,
                null);

        List<Doll> dolls = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                long id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String itemname = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                String company = cursor.getString(cursor.getColumnIndex(COL_COMPANY));
                String ethnicity = cursor.getString(cursor.getColumnIndex(COL_ETHNICITY));
                String retailPrice = cursor.getString(cursor.getColumnIndex(COL_RETAIL_PRICE));
                int height = cursor.getInt(cursor.getColumnIndex(COL_HEIGHT));
                String currentPrice = cursor.getString(cursor.getColumnIndex(COL_CURRENT_PRICE));
                int discount = cursor.getInt(cursor.getColumnIndex(COL_DISCOUNT));
                String descrip = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int wishlist = cursor.getInt(cursor.getColumnIndex(COL_WISH_LIST));
                int checkout = cursor.getInt(cursor.getColumnIndex(COL_CHECK_OUT));

                Doll doll = new Doll(id, retailPrice, currentPrice, height, discount, itemname, company,
                        ethnicity, descrip, wishlist, checkout);
                dolls.add(doll);

                cursor.moveToNext();
            }

        }
        cursor.close();
        return dolls;
    }


// --------sort capability

}
