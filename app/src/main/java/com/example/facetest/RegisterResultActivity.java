/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.example.facetest;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.faceget.R;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterResultActivity extends AppCompatActivity {

    public static final String KEY_LIVENESS_VALUE = "livenessValue";
    public static final String KEY_USER_NAME = "userName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_result);

        TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
        TextView infoTextView = (TextView) findViewById(R.id.info_text_view);
        TextView livenessTextView = (TextView) findViewById(R.id.liveness_value_text_view);

        double liveness = getIntent().getDoubleExtra(KEY_LIVENESS_VALUE, 0);
        String username = getIntent().getStringExtra(KEY_USER_NAME);

        if (username != null) {
            resultTextView.setText("注册成功！");
            infoTextView.setText(username);
        } else {
            resultTextView.setText("注册失败");
//            infoTextView.setText("活体验证失败");
        }
//        livenessTextView.setText(String.format(Locale.CHINESE, "活体分数:%f", liveness));

        findViewById(R.id.re_register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.back_home_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterResultActivity.this, SetActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
