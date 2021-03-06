package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    private Button buttoncu,buttoncheng,buttonjian,buttonjia,buttonto0,buttonecho,buttonexit,buttonxiaoshu;
    private TextView txt;
    private double m,n;
    private String sr;
    private String sq;
    private Toast toast;
    private String xiaoshu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sq="!";
        xiaoshu="!";
        m=5201314;
        n=5201314;
        txt=(TextView)findViewById(R.id.txt);
        button0=(Button)findViewById(R.id.button0);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        button7=(Button)findViewById(R.id.button7);
        button8=(Button)findViewById(R.id.button8);
        button9=(Button)findViewById(R.id.button9);
        buttoncu=(Button)findViewById(R.id.buttoncu);
        buttoncheng=(Button)findViewById(R.id.buttoncheng);
        buttonjia=(Button)findViewById(R.id.buttonjia);
        buttonjian=(Button)findViewById(R.id.buttonjian);
        buttonecho=(Button)findViewById(R.id.buttonecho);
        buttonto0=(Button)findViewById(R.id.buttonto0);
        buttonxiaoshu=(Button)findViewById(R.id.buttonxiaoshu);
        button0.setOnClickListener(new myClick0());
        button1.setOnClickListener(new myClick0());
        button2.setOnClickListener(new myClick0());
        button3.setOnClickListener(new myClick0());
        button4.setOnClickListener(new myClick0());
        button5.setOnClickListener(new myClick0());
        button6.setOnClickListener(new myClick0());
        button7.setOnClickListener(new myClick0());
        button8.setOnClickListener(new myClick0());
        button9.setOnClickListener(new myClick0());
        buttonto0.setOnClickListener(new myClick1());
        buttonxiaoshu.setOnClickListener(new myClick1());
        buttonjia.setOnClickListener(new myClick1());
        buttonjian.setOnClickListener(new myClick1());
        buttoncheng.setOnClickListener(new myClick1());
        buttoncu.setOnClickListener(new myClick1());
        buttonecho.setOnClickListener(new myClick2());

    }
    class myClick0 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int flag=11;
            if (v == button0){
                flag=0;
            }

            if (v == button1){
                flag=1;
            }

            if (v == button2){
                flag=2;
            }
            if (v == button3){
                flag=3;
            }

            if (v == button4){
                flag=4;
            }

            if (v == button5){
                flag=5;
            }
            if (v == button6){
                flag=6;
            }

            if (v == button7){
                flag=7;
            }

            if (v == button8){
                flag=8;
            }
            if (v == button9){
                flag=9;
            }

            if (txt.getText().toString().equals("0")){
                txt.setText(Integer.toString(flag));
            }else {
                switch (flag) {
                    case 0:txt.setText(txt.getText().toString()+"0");break;
                    case 1:txt.setText(txt.getText().toString()+"1");break;
                    case 2:txt.setText(txt.getText().toString()+"2");break;
                    case 3:txt.setText(txt.getText().toString()+"3");break;
                    case 4:txt.setText(txt.getText().toString()+"4");break;
                    case 5:txt.setText(txt.getText().toString()+"5");break;
                    case 6:txt.setText(txt.getText().toString()+"6");break;
                    case 7:txt.setText(txt.getText().toString()+"7");break;
                    case 8:txt.setText(txt.getText().toString()+"8");break;
                    case 9:txt.setText(txt.getText().toString()+"9");break;
                    default:break;


                }
            }
        }
    }

    class myClick1 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String mm = txt.getText().toString();
            String nn = "";
            int flag1 = 0;
            String mn="";
            int flag2=0;
            char a[] = mm.toCharArray();
            for (int i = 0; i < mm.length(); i++) {
                if (flag1 == 1) {
                    nn = nn + a[i];
                }
                if (a[i] == '+' || (a[i] == '-' && i != 0) || a[i] == '*' || a[i] == '/') {      //??????i!=0??????????????????????????????flag1????????????1
                    flag1 = 1;
                }

            }
            flag1 = 0;
            for (int i = 0; i < mm.length(); i++) {

                if (a[i] == '+' || (a[i] == '-' && i != 0) || a[i] == '*' || a[i] == '/') {      //??????i!=0??????????????????????????????flag1????????????1
                    flag2 = 1;
                }
                if (flag2 == 0) {
                    mn = mn + a[i];
                }

            }
            flag2 = 0;
            if (v == buttonto0) {
                txt.setText("0");
                sq = "!";
                xiaoshu = "!";
            }
            if (v == buttonxiaoshu) {
                if (xiaoshu.equals("!")) {
                    txt.setText(txt.getText().toString() + ".");
                    xiaoshu = "!!";
                }
            }
            if (v == buttonjia) {
                if (sq.equals("!")) {
                    m = Double.valueOf(txt.getText().toString());
                    sr = "+";
                    txt.setText(txt.getText().toString() + "+");
                    sq = "+";
                    xiaoshu = "!";
                } else {
                    if (!(nn.equals("")||nn.equals("."))) {
                        if (sr.equals("+")) {
                            m = Double.valueOf(mn) + Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "+");

                        }
                        if (sr.equals("-")) {
                            m = Double.valueOf(mn) - Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "+");
                        }
                        if (sr.equals("*")) {
                            m = Double.valueOf(mn) * Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "+");
                        }
                        if (sr.equals("/")) {
                            if (Double.valueOf(nn) == 0) {
                                Toast.makeText(getApplicationContext(), "?????????0??????????????????", Toast.LENGTH_LONG).show();
                            } else {
                                m = Double.valueOf(mn) / Double.valueOf(nn);
                                txt.setText(Double.toString(m) + "+");
                            }
                        }
                        sr="+";
                        xiaoshu="!";
                    }
                }
            }
            if (v == buttonjian) {
                if (sq.equals("!")) {
                    m = Double.valueOf(txt.getText().toString());
                    sr = "-";
                    txt.setText(txt.getText().toString() + "-");
                    sq = "-";
                    xiaoshu = "!";
                }
                else {
                    if (!(nn.equals("")||nn.equals("."))) {
                        if (sr.equals("+")) {
                            m = Double.valueOf(mn) + Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "-");

                        }
                        if (sr.equals("-")) {
                            m = Double.valueOf(mn) - Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "-");
                        }
                        if (sr.equals("*")) {
                            m = Double.valueOf(mn) * Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "-");
                        }
                        if (sr.equals("/")) {
                            if (Double.valueOf(nn) == 0) {
                                Toast.makeText(getApplicationContext(), "?????????0??????????????????", Toast.LENGTH_LONG).show();
                            } else {
                                m = Double.valueOf(mn) / Double.valueOf(nn);
                                txt.setText(Double.toString(m) + "-");
                            }
                        }
                        sr="-";
                        xiaoshu="!";
                    }
                }
            }
            if (v == buttoncheng) {
                if (sq.equals("!")) {
                    m = Double.valueOf(txt.getText().toString());
                    sr = "*";
                    txt.setText(txt.getText().toString() + "*");
                    sq = "*";
                    xiaoshu = "!";
                } else {
                    if (!(nn.equals("")||nn.equals("."))) {
                        if (sr.equals("+")) {
                            m = Double.valueOf(mn) + Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "*");

                        }
                        if (sr.equals("-")) {
                            m = Double.valueOf(mn) - Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "*");
                        }
                        if (sr.equals("*")) {
                            m = Double.valueOf(mn) * Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "*");
                        }
                        if (sr.equals("/")) {
                            if (Double.valueOf(nn) == 0) {
                                Toast.makeText(getApplicationContext(), "?????????0??????????????????", Toast.LENGTH_LONG).show();
                            } else {
                                m = Double.valueOf(mn) / Double.valueOf(nn);
                                txt.setText(Double.toString(m) + "*");
                            }
                        }
                        sr="*";
                        xiaoshu="!";
                    }
                }
            }

            if (v == buttoncu) {
                if (sq.equals("!")) {
                    m = Double.valueOf(txt.getText().toString());
                    sr = "/";
                    txt.setText(txt.getText().toString() + "/");
                    sq = "/";
                    xiaoshu = "!";
                }else {
                    if (!(nn.equals("")||nn.equals("."))) {
                        if (sr.equals("+")) {
                            m = Double.valueOf(mn) + Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "/");

                        }
                        if (sr.equals("-")) {
                            m = Double.valueOf(mn) - Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "/");
                        }
                        if (sr.equals("*")) {
                            m = Double.valueOf(mn) * Double.valueOf(nn);
                            txt.setText(Double.toString(m) + "/");
                        }
                        if (sr.equals("/")) {
                            if (Double.valueOf(nn) == 0) {
                                Toast.makeText(getApplicationContext(), "?????????0??????????????????", Toast.LENGTH_LONG).show();
                            } else {
                                m = Double.valueOf(mn) / Double.valueOf(nn);
                                txt.setText(Double.toString(m) + "/");
                            }
                        }
                        sr="/";
                        xiaoshu="!";
                    }
                }
            }

        }
    }

    class myClick2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            boolean erro=false;
            String mm = txt.getText().toString();
            String nn = "";
            int flag1 = 0;

            xiaoshu = "!!";
            char a[] = mm.toCharArray();
            for (int i = 0; i < mm.length(); i++) {
                if (flag1 == 1) {
                    nn = nn + a[i];
                }
                if (a[i] == '+' || (a[i] == '-' && i != 0) || a[i] == '*' || a[i] == '/') {      //??????i!=0??????????????????????????????flag1????????????1
                    flag1 = 1;
                }

            }
            if (nn.equals(".")) {
                Toast.makeText(getApplicationContext(), "?????????.??????????????????", Toast.LENGTH_LONG).show();
                erro=true;
            } else {
                if (!nn.equals("")) {
                    n = Double.valueOf(nn);
                    if (sr.equals("+")) {
                        m = m + n;
                        txt.setText(Double.toString(m));
                    }
                    if (sr.equals("-")) {
                        m = m - n;
                        txt.setText(Double.toString(m));
                    }
                    if (sr.equals("*")) {
                        m = m * n;
                        txt.setText(Double.toString(m));
                    }
                    if (sr.equals("/")) {
                        if (n == 0) {
                            Toast.makeText(getApplicationContext(), "?????????0??????????????????", Toast.LENGTH_LONG).show();
                            erro=true;
                        } else {
                            m = m / n;
                            txt.setText(Double.toString(m));
                        }
                    }
                }
                if (!(n==0&&sr.equals("/"))) {
                    dialog.setTitle("????????????");
                    dialog.setMessage("??????????????????:" + m);
                    dialog.setPositiveButton("??????", new okClick());
                    dialog.create();
                    dialog.show();
                }
            }
            if (!erro){
                sq = "!";
            }
        }

    }

    class okClick implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }




}
