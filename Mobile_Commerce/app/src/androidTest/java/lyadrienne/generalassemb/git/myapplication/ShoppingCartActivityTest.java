package lyadrienne.generalassemb.git.myapplication;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;


/**
 * Created by Admin on 4/13/17.
 */

public class ShoppingCartActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =  new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
     public void testCheckOutWorks() { //test that checkout clears the cart

        onView(withId(R.id.searchbar)).perform(click());
        onView(withId(R.id.recyclerview2)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detail_addtocart)).perform(click());
        onView(withId(R.id.detail_shoppingcart)).perform(click());
        onView(withId(R.id.checkout_button)).perform(click());
        onView(withText("Ok")).perform(click());
        onView(withId(R.id.sum_textview)).check(matches(withText("0.0")));
    }

    @Test
    public void moveToSearchActivity(){ //move to search activity
        onView(withId(R.id.action_shoppingcart)).perform(click());
        onView(withId(R.id.searchbar)).perform(click());
    }

    @Test
    public void moveToDetailActivity(){ //Move to Detail activity
        onView(withId(R.id.searchbar)).perform(click());
        onView(withId(R.id.recyclerview2)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detail_addtocart)).perform(click());
        onView(withId(R.id.detail_shoppingcart)).perform(click());
        onView(withId(R.id.shoppingcart_recycleview)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detail_imageview)).check(matches(isDisplayed()));

    }

    @Test
    public void removeItemFromCart(){ //check that item can be removed from cart
        onView(withId(R.id.searchbar)).perform(click());
        onView(withId(R.id.recyclerview2)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detail_addtocart)).perform(click());
        onView(withId(R.id.detail_shoppingcart)).perform(click());
        onView(withId(R.id.shoppingcart_recycleview)).perform(RecyclerViewActions.actionOnItemAtPosition(0, longClick()));

    }

}
