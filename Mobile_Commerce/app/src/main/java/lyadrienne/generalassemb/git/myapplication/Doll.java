package lyadrienne.generalassemb.git.myapplication;

/**
 * Created by Admin on 4/7/17.
 */

public class Doll {

    private long mId;
    private int mRetailPrice, mCurrentPrice, mHeight, mDiscount;
    private String mItemName, mCompany, mEthnicity, mDescription;
    private boolean mWishList, mCheckOut;

    public Doll(long id, int retailPrice, int currentPrice, int height, int discount, String itemName, String company, String ethnicity, String description, boolean wishList, boolean checkOut) {
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

    public int getRetailPrice() {
        return mRetailPrice;
    }

    public int getCurrentPrice() {
        return mCurrentPrice;
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

    public boolean isWishList() {
        return mWishList;
    }
    //TODO do i need setters?

    public boolean isCheckOut() {
        return mCheckOut;
    }
}
