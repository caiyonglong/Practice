package com.cyl.mvvm;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cyl.mvvm.basic.User;
import com.cyl.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(
                this,R.layout.activity_main);

        setContentView(R.layout.activity_main);
        User user = new User("ce","shi");
        binding.setUser(user);
    }
}
