package com.example.a.datepickerdialogwork;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.widget.Button;
import android.widget.DatePicker;
import android.view.View.OnClickListener;
import android.app.DatePickerDialog;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private TextView showdate;
    private Button setdate;
    private int year;
    private int month;
    private int day;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showdate = (TextView) this.findViewById(R.id.showtime);
        setdate = (Button) this.findViewById(R.id.setdate);
        //初始化Calendar日历对象
        Calendar c = Calendar.getInstance(Locale.CHINA);
        Date mydate = new Date(); //获取当前日期Date对象

        c.setTime(mydate);////为Calendar对象设置时间为当前日期

        year = c.get(Calendar.YEAR); //获取Calendar对象中的年
        month = c.get(Calendar.MONTH);//获取Calendar对象中的月
        day = c.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
        showdate.setText("当前日期:" + year + "-" + (month + 1) + "-" + day); //显示当前的年月日

        //添加单击事件--设置日期
        setdate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                //创建DatePickerDialog对象
                DatePickerDialog my_datePickerDialog = new DatePickerDialog(MainActivity.this, Datelistener, year, month, day);
                my_datePickerDialog.show();//显示DatePickerDialog组件
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private DatePickerDialog.OnDateSetListener Datelistener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker v, int y, int m, int d) {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            String time= y+"-"+m+"-"+ d;
            String nexttime = year+"-"+month+"-"+ day;
            Date date = null;
            Date nextdate = null;
            try{
                date = format.parse(time);
                nextdate=format.parse(nexttime);
            }catch(ParseException e){
                    e.printStackTrace();
            }

             if(date.getTime() <= nextdate.getTime()) {


                 //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
                 year = y;
                 month = m;
                 day = d;
                 //更新日期
                 updateDate();
             }else{
                 Toast.makeText(getApplicationContext(),"设置日期无效",Toast.LENGTH_SHORT).show();
             }

        }

        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate() {
            //在TextView上显示日期
            showdate.setText("当前日期：" + year + "-" + (month + 1) + "-" + day);
        }
    };


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
