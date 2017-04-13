package lyadrienne.generalassemb.git.myapplication;


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

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =  new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testMoveToSearchActivity (){ //Test move to search activity
        onView(withId(R.id.searchbar)).perform(click());
        onView(withId(R.id.recyclerview2)).check(matches(isDisplayed()));
    }

    @Test
    public void testMoveToShoppingCart (){ //Test move to shopping cart
        onView(withId(R.id.action_shoppingcart)).perform(click());
        onView(withId(R.id.shoppingcart_recycleview)).check(matches(isDisplayed()));
    }

    @Test
    public void testOnClickToSearchActivity(){ //Test to move to search activity
        onView(withId(R.id.sale_view)).perform(click());
        onView(withId(R.id.recyclerview2)).check(matches(isDisplayed()));
    }

}
