package lyadrienne.generalassemb.git.myapplication;


import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;


/**
 * Created by Admin on 4/13/17.
 */

public class SearchActivityTest {

    @Rule
    public ActivityTestRule<SearchActivity> mActivityTestRule =  new ActivityTestRule<SearchActivity>(SearchActivity.class);

    @Test
    public void testMoveToShoppingCart (){ //Test move to shopping cart
        onView(withId(R.id.action_shoppingcart)).perform(click());
        onView(withId(R.id.shoppingcart_recycleview)).check(matches(isDisplayed()));
    }

    @Test
    public void testMoveToDetail(){ //Test move to detail activity
        onView(withId(R.id.recyclerview2)).perform(click());
        onView(withId(R.id.detail_imageview)).check(matches(isDisplayed()));

    }

//    @Test
//    public void testEnterSearchQuery(){
//        /*
//        Having several issues with getting the espresso to run on the search query. I used the
//        Record Espresso Test and was able to capture lines 50 to 73. However when I run the test,
//        I get an SQLite_Error due to searchAllDolls function receiving query in the Helper.
//         */
//        ViewInteraction actionMenuItemView = onView(
//                allOf(withId(R.id.searchbar), withContentDescription("Search Bar"), isDisplayed()));
//        actionMenuItemView.perform(click());
//
//        ViewInteraction actionMenuItemView2 = onView(
//                allOf(withId(R.id.searchbar), withContentDescription("Search Bar"), isDisplayed()));
//        actionMenuItemView2.perform(click());
//
//        ViewInteraction searchAutoComplete = onView(
//                allOf(withId(R.id.search_src_text),
//                        withParent(allOf(withId(R.id.search_plate),
//                                withParent(withId(R.id.search_edit_frame)))),
//                        isDisplayed()));
//        searchAutoComplete.perform(replaceText("barbie"), closeSoftKeyboard());
//
//        ViewInteraction searchAutoComplete2 = onView(
//                allOf(withId(R.id.search_src_text), withText("barbie"),
//                        withParent(allOf(withId(R.id.search_plate),
//                                withParent(withId(R.id.search_edit_frame)))),
//                        isDisplayed()));
//        searchAutoComplete2.perform(pressImeActionButton());
//
//        ViewInteraction recyclerView = onView(
//                allOf(withId(R.id.recyclerview2), isDisplayed()));
//        recyclerView.perform(actionOnItemAtPosition(0, click()));
//
//    }

}
