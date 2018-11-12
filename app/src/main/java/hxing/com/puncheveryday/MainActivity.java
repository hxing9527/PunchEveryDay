package hxing.com.puncheveryday;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import hxing.com.puncheveryday.base.BaseActivity;
import hxing.com.puncheveryday.lbs.LbsfucFragment;
import hxing.com.puncheveryday.person.PersonFragment;
import hxing.com.puncheveryday.punch.PunchFragment;
import hxing.com.puncheveryday.util.ActivityUtils;

public class MainActivity extends BaseActivity {

    private TextView mTextMessage;
    private FrameLayout mContent_Frgm;
    private PunchFragment punch_Fragment;
    private LbsfucFragment lbsfuc_Fragment;
    private PersonFragment person_Fragment;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_punch:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_lbs:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_person:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContent_Frgm = findViewById(R.id.home_content_fragment);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    private boolean createPunchFrag(){
        if (punch_Fragment == null){
            punch_Fragment = punch_Fragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),punch_Fragment,R.id.home_content_fragment);
            return true;
        }else {
            return false;
        }
    }

    private boolean createLbsFrag(){
        if (lbsfuc_Fragment == null){
            lbsfuc_Fragment = lbsfuc_Fragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),lbsfuc_Fragment,R.id.home_content_fragment);
            return true;
        }else {
            return false;
        }
    }

    private boolean createPersonFrag(){
        if (person_Fragment == null){
            person_Fragment = person_Fragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),person_Fragment,R.id.home_content_fragment);
            return true;
        }else {
            return false;
        }
    }
}
