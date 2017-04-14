package lyadrienne.generalassemb.git.myapplication;

/**
 * Created by Admin on 4/7/17.
 */

public class Doll {

    private long mId;
    private int mHeight, mDiscount, mWishList, mCheckOut;
    private String mItemName, mCompany, mEthnicity, mDescription, mCurrentPrice, mRetailPrice, mProductView;


    public Doll(long id, String retailPrice, String currentPrice, int height, int discount, String itemName, String company, String ethnicity, String description, int wishList, int checkOut, String itemImage) {
        mId = id;
        mRetailPrice = retailPrice; // ****** price ******
        mCurrentPrice = currentPrice; //price after a discount
        mHeight = height; //additional search criteria not used
        mDiscount = discount; //additional search criteria not used
        mItemName = itemName; //*** item name***
        mCompany = company; //additional search criteria not used
        mEthnicity = ethnicity; //additional search criteria
        mDescription = description; //**** description *****
        mWishList = wishList; //additional search criteria not used
        mCheckOut = checkOut; //columns to hold if in or out of shoppingcart
        mProductView = itemImage; //***** url for image *****
    }

    public String getProductView() { return mProductView; }

    public long getId() {
        return mId;
    }

    public int getWishList() {
        return mWishList;
    }


    public String getCurrentPrice() {
        return mCurrentPrice;
    }

    public String getRetailPrice() {
        return mRetailPrice;
    }


    public String getItemName() {
        return mItemName;
    }


    public String getDescription() {
        return mDescription;
    }


}
