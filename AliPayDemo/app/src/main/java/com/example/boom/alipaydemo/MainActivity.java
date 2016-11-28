package com.example.boom.alipaydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.boom.alipaydemo.pay.AliPay;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.payV2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AliPay.Builder builder=new AliPay.Builder(MainActivity.this);
                builder.setNotifyURL("")
                        .setSubTitle("")
                        .setPrice("0.01")
                        .setOrderTitle("")
                        .setPayCallBackListener(new AliPay.Builder.PayCallBackListener() {
                    @Override
                    public void onPayCallBack(int status, String resultStatus, String progress) {
                        Toast.makeText(MainActivity.this,progress,Toast.LENGTH_SHORT).show();
                    }
                });
                builder.pay();
            }
        });
    }
}
