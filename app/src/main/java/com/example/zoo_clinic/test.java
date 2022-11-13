package com.example.zoo_clinic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

public class test extends AppCompatActivity implements View.OnCreateContextMenuListener {

    WebView WebView1 = (WebView) findViewById(R.id.WebView1);

    public void OnCreate(){
        WebView1.getSettings().setJavaScriptEnabled(true);
        WebView1.loadUrl("https://cdn.discordapp.com/attachments/1015602998577209414/1041358193353298010/image.png");
    }

}
