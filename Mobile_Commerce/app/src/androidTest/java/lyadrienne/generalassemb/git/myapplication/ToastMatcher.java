package lyadrienne.generalassemb.git.myapplication;

import android.os.IBinder;
import android.support.test.espresso.Root;
import android.view.WindowManager;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Admin on 4/13/17.
 */

public class ToastMatcher extends TypeSafeMatcher<Root> {


    //possible solution for catching the toast.

    @Override
    public void describeTo(Description description) {
        description.appendText("is toast");
    }

    @Override
    protected boolean matchesSafely(Root item) {
        int type = item.getWindowLayoutParams().get().type;
        if ((type == WindowManager.LayoutParams.TYPE_TOAST)){
            IBinder windowToken = item.getDecorView().getWindowToken();
            IBinder appToken = item.getDecorView().getApplicationWindowToken();
            if(windowToken == appToken){

            }
        }
        return true;
    }
}
