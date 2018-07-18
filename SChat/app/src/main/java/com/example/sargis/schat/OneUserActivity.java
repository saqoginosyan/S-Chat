package com.example.sargis.schat;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sargis.schat.adapters.UsersCallAdapter;
import com.example.sargis.schat.adapters.UsersChatAdapter;
import com.example.sargis.schat.fragments.InfoFragment;
import com.example.sargis.schat.fragments.MessengerFragment;

public class OneUserActivity extends AppCompatActivity {

    public static final String INFO_KEY = "info key";
    public static final String MESSENGER_KEY = "messenger key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_user);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(OneUserActivity.this,
                    R.color.background_color_dark));
        }

        if (getIntent().getExtras().get(UsersChatAdapter.CHECK_KEY).equals("check1")) {
            final int position = getIntent().getIntExtra(UsersChatAdapter.POSITION_KEY, 0);

            MessengerFragment fragment = new MessengerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MESSENGER_KEY, position);
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, fragment).commit();

        } else if (getIntent().getExtras().get(UsersCallAdapter.CHECK_KEY).equals("check2")) {
            final int position = getIntent().getIntExtra(UsersCallAdapter.POSITION_KEY1, 0);

            InfoFragment fragment1 = new InfoFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(INFO_KEY, position);
            fragment1.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, fragment1).commit();
        }
    }
}