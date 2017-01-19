package com.custom.titlebar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import titleBar.act.CustomTitleAct;
import titleBar.act.CustomTitleViewAct;

public class MainActivity extends Activity {

    private Button mBtnCustomTitle, mBtnCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnCustomTitle = (Button) findViewById(R.id.btn_custom_title);
        mBtnCustomView = (Button) findViewById(R.id.btn_custom_view);

        mBtnCustomTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomTitleAct.class));
            }
        });
        mBtnCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomTitleViewAct.class));
            }
        });
    }
}
