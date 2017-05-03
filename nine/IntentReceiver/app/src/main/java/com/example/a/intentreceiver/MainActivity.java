package com.example.a.intentreceiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    /** Called when the activity is first created. */
    private Button myButton = null;
    private final String nobody ="Who.care.the.name";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button)findViewById(R.id.button);
        //为按钮对象设置监听器对象
        myButton.setOnClickListener(new MyButtonListener());
    }
    class MyButtonListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            //生成一个Intent对象
            Intent intent = new Intent(nobody);
            //在Intent对象当中添加一个键值对
            intent.putExtra("testIntent", "11111111111");
            sendBroadcast(intent);
        }
    }
}