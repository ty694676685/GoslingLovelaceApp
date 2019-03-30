package com.example.goslinglovelaceapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_Body(R.raw.james_gosling);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            startActivity(new Intent(MainActivity.this,Activity_2.class));
        }
    }



    public void text_Body(int f){
        InputStream input = getResources().openRawResource(f);
        Reader reader=new InputStreamReader(input);
        StringBuffer sb=new StringBuffer();
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        try {
            while((line = br.readLine())!=null){
                sb.append(line+ "\n");
            }
            br.close();
        }catch (IOException e){
            Log.e("ReadingFile","IOException");
        }
        String string=sb.toString();
        ((TextView)findViewById(R.id.textView_body)).setText(string);
    }
}
