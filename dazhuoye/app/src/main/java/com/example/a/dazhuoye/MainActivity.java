package com.example.a.dazhuoye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView = null;
    Button button1 = null;
    Button button2 = null;
    Button button3 = null;
    Button button4 = null;
    Button button5 = null;
    Button button6 = null;
    Button button7 = null;
    Button button8 = null;
    Button button9 = null;
    Button button0 = null;
    Button add = null;//加
    Button cut = null;//减
    Button rid = null;//乘
    Button divide = null;//除
    Button result = null;
    Button  sin = null;
    Button cos = null;
    Button tan = null;
    Button point = null;
    Button clean = null;
    Button del = null;
    Button log = null;
    Button jiec = null;
    Button x2 = null;
    Button x3 = null;
    Button genhao = null;
    Button ln = null;
    int pointCount=0;
    int option = 0;//运算符状态
    boolean flag = true;//判断程序是否出错
    double a = 0,b = 0;//两个相加的数
    double sum = 0;
    double sumtype = 0;//判断输出的数是否有小数部分

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text);
        button1=(Button)findViewById(R.id.n1);
        button2=(Button)findViewById(R.id.n2);
        button3=(Button)findViewById(R.id.n3);
        button4=(Button)findViewById(R.id.n4);
        button5=(Button)findViewById(R.id.n5);
        button6=(Button)findViewById(R.id.n6);
        button7=(Button)findViewById(R.id.n7);
        button8=(Button)findViewById(R.id.n8);
        button9=(Button)findViewById(R.id.n9);
        button0=(Button)findViewById(R.id.n0);
        add=(Button)findViewById(R.id.add);
        cut=(Button)findViewById(R.id.cut);
        rid=(Button)findViewById(R.id.rid);
        divide=(Button)findViewById(R.id.div);
        result=(Button)findViewById(R.id.result);
        point=(Button)findViewById(R.id.point);
        clean=(Button)findViewById(R.id.clean);
        del=(Button)findViewById(R.id.del);
        sin=(Button)findViewById(R.id.sin);
        cos=(Button)findViewById(R.id.cos);
        tan=(Button)findViewById(R.id.tan);
        log=(Button)findViewById(R.id.log);
        jiec=(Button)findViewById(R.id.jiec);
        x2=(Button)findViewById(R.id.x2);
        x3=(Button)findViewById(R.id.x3);
        genhao=(Button)findViewById(R.id.genhao);
        ln=(Button)findViewById(R.id.ln);

        button0.setOnClickListener(lisenter);
        button1.setOnClickListener(lisenter);
        button2.setOnClickListener(lisenter);
        button3.setOnClickListener(lisenter);
        button4.setOnClickListener(lisenter);
        button5.setOnClickListener(lisenter);
        button6.setOnClickListener(lisenter);
        button7.setOnClickListener(lisenter);
        button8.setOnClickListener(lisenter);
        button9.setOnClickListener(lisenter);
        add.setOnClickListener(lisenter);
        cut.setOnClickListener(lisenter);
        rid.setOnClickListener(lisenter);
        divide.setOnClickListener(lisenter);
        result.setOnClickListener(lisenter);
        point.setOnClickListener(lisenter);
        clean.setOnClickListener(lisenter);
        del.setOnClickListener(lisenter);
        sin.setOnClickListener(lisenter);
        cos.setOnClickListener(lisenter);
        tan.setOnClickListener(lisenter);
        log.setOnClickListener(lisenter);
        jiec.setOnClickListener(lisenter);
        x2.setOnClickListener(lisenter);
        x3.setOnClickListener(lisenter);
        genhao.setOnClickListener(lisenter);
        ln.setOnClickListener(lisenter);
    }
    OnClickListener lisenter=new OnClickListener() {

        @Override
        public void onClick(View v) {
            TextView text = (TextView) findViewById(R.id.text);
            String s = text.getText().toString();//获取文本框显示的字符串
            Button btn =(Button)v;
            //数字的输入
            if(btn.getId()==R.id.n0||btn.getId()==R.id.n1||btn.getId()==R.id.n2||btn.getId()==R.id.n3
                    ||btn.getId()==R.id.n4||btn.getId()==R.id.n5||btn.getId()==R.id.n6||
                    btn.getId()==R.id.n7||btn.getId()==R.id.n8||btn.getId()==R.id.n9||btn.getId()==R.id.point)
            {
                if(btn.getId()==R.id.point){
                    if(null==s||s.equals("")){
                        s+="0"+btn.getText();
                    }else{
                        s+=btn.getText();
                    }
                    pointCount=1;
                }else{
                    s+=btn.getText();
                }
                text.setText(s);

            }
            //运算符的输入
            if(btn.getId()==R.id.add||btn.getId()==R.id.div||btn.getId()==R.id.cut||btn.getId()==R.id.rid){
                //如果已经有两个数，再按运算符就直接把结果运算出来保存到a中然后继续运算
                if(null==s||s.equals("")){
                    s="0";
                }
                if(option!=0){
                    b=Double.valueOf(s);
                    switch (option) {
                        case 1:
                            sum=a+b;
                            break;
                        case 2:
                            sum=a-b;
                            break;
                        case 3:
                            sum=a*b;
                            break;
                        case 4:
                            if(b==0){
                                Toast.makeText(MainActivity.this, "0不能为除数", Toast.LENGTH_LONG).show();
                                text.setText("");
                                break;
                            }
                            sum=a/b;
                            break;
                        default:
                            break;
                    }
                    a=sum;

                }
                if(option==0){
                    a=Double.valueOf(s);
                }
                switch (btn.getId()) {
                    case R.id.add:
                        option=1;
                        break;
                    case R.id.cut:
                        option=2;
                        break;
                    case R.id.rid:
                        option=3;
                        break;
                    case R.id.div:
                        option=4;
                        break;
                    default:
                        break;
                }
                text.setText("");
            }
            //等于，运算结果
            if(btn.getId()==R.id.result){
                if(null==s||s.equals("")){
                    s="0";
                }
                b=Double.valueOf(s);
                switch (option) {
                    case 1:
                        sum=a+b;
                        break;
                    case 2:
                        sum=a-b;
                        break;
                    case 3:
                        sum=a*b;
                        break;
                    case 4:
                        if(b==0){
                            Toast.makeText(MainActivity.this, "0不能为除数", Toast.LENGTH_LONG).show();
                            text.setText("");
                            flag=false;
                            break;
                        }
                        sum=a/b;
                        break;
                    default:
                        break;
                }

                sumtype=sum%1;
                s=""+sum;
                if(sumtype>0){
                    pointCount=1;
                }
                s=""+sum;
                if(sumtype==0){
                    int end=(s.toString()).lastIndexOf(".");
                    String str=(s.toString()).substring(0, end);
                    s=""+Integer.parseInt(str);
                    pointCount=0;
                }
                if(flag){
                    text.setText(s);
                }
                a=Double.valueOf(s);
                option=0;
                flag=true;

            }
            //清除
            if(btn.getId()==R.id.clean){
                text.setText("");
                pointCount=0;
                option=0;
                flag=true;
            }
            if(btn.getId()==R.id.del&&s.length()>0 ){//删除
                text.setText(s.substring(0, s.length() - 1));
            }
            if(btn.getId()==R.id.sin){
                if(s==null || s=="") {
                    s="0";
                }
                double m=Double.parseDouble(s);
                double a=Math.toRadians(m);
                sum =Math.sin(a);
                a=sum;
                s=String.valueOf(sum);
                text.setText(s);
            }
            if(btn.getId()==R.id.cos){
                if(s==null || s=="") s="0";
                double m=Double.parseDouble(s);
                double a=Math.toRadians(m);
                sum =Math.cos(a);
                a=sum;
                s=String.valueOf(sum);
                text.setText(s);
            }
            if(btn.getId()==R.id.tan){
                if(s==null || s=="") s="0";
                double m=Double.parseDouble(s);
                double a=Math.toRadians(m);
                sum =Math.tan(a);
                a=sum;
                s=String.valueOf(sum);
                text.setText(s);
            }
            if(btn.getId()==R.id.log){
                if(s==null || s=="") s="0";
                double m=Double.parseDouble(s);
                sum =Math.log(m);
                a=sum;
                s=String.valueOf(sum);
                text.setText(s);

            }
            if(btn.getId()==R.id.jiec){
                if(s==null || s=="") s="0";
                int f=1;
                double m=Double.parseDouble(s);
                for(int j=(int)m;j>0;j--){
                    f =j*f;
                }
                a=f;
                s=String.valueOf(f);
                text.setText(s);
            }
            if(btn.getId()==R.id.x2){
                if(s==null || s=="") s="0";
                double m=Double.parseDouble(s);
                sum =m*m;
                a=sum;
                s=String.valueOf(sum);
                text.setText(s);
            }
            if(btn.getId()==R.id.x3){
                if(s==null || s=="") s="0";
                double m=Double.parseDouble(s);
                sum =m*m*m;
                a=sum;
                s=String.valueOf(sum);
                text.setText(s);
            }
            if(btn.getId()==R.id.genhao){
                if(s==null || s=="") s="0";
                double m=Double.parseDouble(s);
                a=sum;
                s=String.valueOf(sum);
                text.setText(s);
            }
            if(btn.getId()==R.id.ln){
                if(s==null || s=="") s="0";
                double m=Double.parseDouble(s);
                sum= Math.log(m)/Math.log(2.718);
                a=sum;
                s=String.valueOf(sum);
                text.setText(s);
            }

        }
    };
}

