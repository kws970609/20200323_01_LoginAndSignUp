package kr.co.tjoeun.a20200323_01_loginandsignup;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import kr.co.tjoeun.a20200320_02_pizzastorelist.databinding.ActivityMainBinding;

public abstract class BaseActivity extends AppCompatActivity {

    ActivityMainBinding binding = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
    }

    public Context mContext = this;

    public abstract void setupEvents();

    public abstract void setValues();

}
