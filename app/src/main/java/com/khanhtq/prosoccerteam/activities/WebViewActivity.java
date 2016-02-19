package com.khanhtq.prosoccerteam.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.khanhtq.prosoccerteam.R;

/**
 * Created by khanhtq on 2/19/16.
 */
public class WebViewActivity extends AppCompatActivity {

    public static final String URL_KEY = "URL_KEY";

    private TextView mTitleView;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        mTitleView = (TextView) toolbar.findViewById(R.id.title_txt_view);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setAppCacheEnabled(false);
        webSettings.setDisplayZoomControls(false);
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                mTitleView.setText(title);
            }
        });
        mWebView.setWebViewClient(new WebViewClient());
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String url = extra.getString(URL_KEY);
            if (url != null) {
                mWebView.loadUrl(url);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
