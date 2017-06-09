package com.jady.jsondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jady.jsondemo.origin.OriginalJsonActivity;
import com.jady.jsondemo.thirdparty.ThirdParthJsonActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnMainOriginal;
    private Button btnMainThirdParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMainOriginal = (Button) findViewById(R.id.btn_main_original);
        btnMainThirdParty = (Button) findViewById(R.id.btn_main_third_party);

        btnMainOriginal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OriginalJsonActivity.class));
            }
        });

        btnMainThirdParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThirdParthJsonActivity.class));
            }
        });
    }
}
