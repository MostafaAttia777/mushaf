package com.Mushaf.Quran.Online;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.mushaf.quran.R;

public class web2 extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);

        webView=findViewById(R.id.myweb);

        Intent intent=getIntent();
        String tab=intent.getStringExtra("t3");


        String b2=intent.getStringExtra("b1");
        String y1=intent.getStringExtra("y1");
        String man=intent.getStringExtra("man");
        String kk=intent.getStringExtra("k1");
        webView.setWebViewClient(new web2.MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(y1);
        webView.loadUrl(man);
        webView.loadUrl(b2);
        webView.loadUrl(tab);
        webView.loadUrl(kk);
    }


    private class  MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }

            }

