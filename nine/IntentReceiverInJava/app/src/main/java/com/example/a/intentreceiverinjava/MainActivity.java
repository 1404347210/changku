package com.example.a.intentreceiverinjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    private Button registerButton = null;
    private Button unregisterButton = null;
    private Others smsReceiver = null;

    private static final String SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerButton = (Button)findViewById(R.id.register);
        registerButton.setOnClickListener(new RegisterReceiverListener());
        unregisterButton = (Button)findViewById(R.id.unregister);
        unregisterButton.setOnClickListener(new UnRegisterReceiverListener());

    }

    class RegisterReceiverListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            //生成一个BroiadcastReceiver对象
            smsReceiver = new Others();
            //生成一个IntentFilter对象
            IntentFilter filter = new IntentFilter();
            //为IntentFilter添加一个Action
            filter.addAction(SMS_ACTION);
            //将BroadcastReceiver对象注册到系统当中
            MainActivity.this.registerReceiver(smsReceiver, filter);
        }

    }

    class UnRegisterReceiverListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            //解除BroadcastReceiver对象的注册
            MainActivity.this.unregisterReceiver(smsReceiver);
        }

    }
}
