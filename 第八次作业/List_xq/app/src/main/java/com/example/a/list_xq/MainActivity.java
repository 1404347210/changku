package com.example.a.list_xq;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends ListActivity {
    String[] weekStrings = new String[]{"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,weekStrings);
        this.setListAdapter(adapter);
        this.getListView().setOnItemSelectedListener(
                new OnItemSelectedListener(){
                    public void onNothingSelected(AdapterView<?> arg0){
                        MainActivity.this.setTitle("NothingSelected");
                    }
                    public void onItemSelected(AdapterView<?> arg0,View arg1,int arg2,long arg3){
                        MainActivity.this.setTitle(((TextView)arg1).getText());
                    }

                }
        );
    }
}
