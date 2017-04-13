package lyadrienne.generalassemb.git.myapplication;


import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;


/**
 * Created by Admin on 4/13/17.
 */

public class DetailActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =  new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void testMoveToShoppingCart (){ //Test move to shopping cart
        onView(withId(R.id.searchbar)).perform(click());
        onView(withId(R.id.recyclerview2)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detail_shoppingcart)).perform(click());
        onView(withId(R.id.checkout_button)).check(matches(isDisplayed()));

    }

    @Test
    public void testAddToShoppingCart(){ //Test add to shopping cart
        onView(withId(R.id.searchbar)).perform(click());
        onView(withId(R.id.recyclerview2)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.detail_addtocart)).perform(click());


    }

}
