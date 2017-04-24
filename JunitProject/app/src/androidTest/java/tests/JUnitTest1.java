package tests;

import android.support.test.rule.ActivityTestRule;
import android.widget.TextView;

import com.example.luujfer.junitproject.MainActivity;
import com.example.luujfer.junitproject.R;

import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by luujfer on 4/24/17.
 */

public class JUnitTest1 {

    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void test(){
        TextView textView = (TextView) mainActivity.getActivity().findViewById(R.id.tv_sum);
        String value = textView.getText().toString();
        //int sum = Integer.parseInt(value);

        //assertEquals(4,sum);
    }
}
