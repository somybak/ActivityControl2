package com.example.somy.activitycontrol2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.button;

public class BrowserActivity extends AppCompatActivity implements View.OnClickListener {

    Button btb, btg;
    EditText et;
    WebView wv;

    /**
     * 웹뷰를 사용하는하는 커스텀 브라우저
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        //위젯 가져오기
        btb= (Button) findViewById(R.id.btb);
        btg= (Button) findViewById(R.id.btg);
        et= (EditText) findViewById(R.id.et);
        wv= (WebView) findViewById(R.id.wv);;

        //리스너
        btb.setOnClickListener(this);
        btg.setOnClickListener(this);

        wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //속도향상 검토필요

        wv.getSettings().setJavaScriptEnabled(true);
        //스크립트 사용설정

        wv.getSettings().setSupportZoom(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.getSettings().setLoadsImagesAutomatically(true);

        //zoom

        // 웹뷰 클라이언트를 지정...안하면 내장 웹브라우저가 팝업'
        wv.setWebViewClient(new WebViewClient());
        // 프로토콜에 따라 클라리언트가 선택되는 것..같음. 둘다 세팅하기.
        wv.setWebChromeClient(new WebChromeClient());

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btg:
                String url = et.getText().toString();

                wv.loadUrl(url);
                break;
            case R.id.btb:
                if(wv.canGoBack()) {
                    wv.goBack();
                } else{
                    Toast.makeText(this, "뒤로갈 수 없습니다!", Toast.LENGTH_SHORT).show();

                }



        }




    }
}
