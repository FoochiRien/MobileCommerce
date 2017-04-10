package lyadrienne.generalassemb.git.myapplication;

/**
 * Created by Admin on 4/7/17.
 */

public class Doll {

    private long mId;
    private int mHeight, mDiscount, mWishList, mCheckOut;
    private String mItemName, mCompany, mEthnicity, mDescription, mCurrentPrice, mRetailPrice;


    public Doll(long id, String retailPrice, String currentPrice, int height, int discount, String itemName, String company, String ethnicity, String description, int wishList, int checkOut) {
        mId = id;
        mRetailPrice = retailPrice;
        mCurrentPrice = currentPrice;
        mHeight = height;
        mDiscount = discount;
        mItemName = itemName;
        mCompany = company;
        mEthnicity = ethnicity;
        mDescription = description;
        mWishList = wishList;
        mCheckOut = checkOut;
    }


    public long getId() {
        return mId;
    }

    public int getWishList() {
        return mWishList;
    }

    public int getCheckOut() {
        return mCheckOut;
    }

    public String getCurrentPrice() {
        return mCurrentPrice;
    }

    public String getRetailPrice() {
        return mRetailPrice;
    }

    public int getHeight() {
        return mHeight;
    }

    public int getDiscount() {
        return mDiscount;
    }

    public String getItemName() {
        return mItemName;
    }

    public String getCompany() {
        return mCompany;
    }

    public String getEthnicity() {
        return mEthnicity;
    }

    public String getDescription() {
        return mDescription;
    }


}
