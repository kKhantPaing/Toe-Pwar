package a2017.group19.samaung.samsungproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;

public class VaccineActivity extends AppCompatActivity {

    private TextView textView;
    private int index;
    private WebView webView;
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);

        Toolbar toolbar=(Toolbar)findViewById(R.id.vaccine_toolbar);
        setSupportActionBar(toolbar);
        webView=(WebView)findViewById(R.id.web_vaccine) ;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        index=getIntent().getIntExtra("id",0);
        title=getIntent().getStringExtra("vaccine_name");

        switch (index){

            case 1: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/1.html");
                break;
            case 2: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/2.html");
                break;
            case 3: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/3.html");
                break;
            case 4: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/4.html");
                break;
            case 5: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/5.html");
                break;
            case 6: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/6.html");
                break;
            case 7: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/7.html");
                break;
            case 8: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/8.html");
                break;
            case 9: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/9.html");
                break;
            case 10: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/10.html");
                break;
            case 11: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/11.html");
                break;
            case 12: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/12.html");
                break;
            case 13: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/vaccine/13.html");
                break;
        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
