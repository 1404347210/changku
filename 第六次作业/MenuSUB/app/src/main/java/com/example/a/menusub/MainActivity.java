package com.example.a.menusub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        SubMenu sub=menu.addSubMenu( "搜索");
        sub.setIcon(android.R.drawable.ic_menu_search);
        sub.add(0,1,1,"本地");
        sub.add(0,2,2,"网络");
        return super.onCreateOptionsMenu(menu);
    }

}