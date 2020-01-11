package a2017.group19.samaung.samsungproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class DiseaseActivity extends AppCompatActivity {

    private int index = 0;
    private WebView webView;
    private    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        Toolbar toolbar=(Toolbar)findViewById(R.id.disesae_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        webView=(WebView)findViewById(R.id.disease_webView);
        index=getIntent().getIntExtra("id",0);
        title=getIntent().getStringExtra("disease_name");

        //webView.getSettings().setBuiltInZoomControls(true);

        switch (index){
            case 1: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/disease/hepatitis.html");
                break;
            case 2: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/disease/omphalitis.html");
                break;
            case 3: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/disease/pullorum.html");
                break;
            case 4:
                getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/disease/newcastle.html");
                break;
            case 5: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/disease/bursal.html");
                break;
            case 6: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/disease/coryza.html");
                break;
            case 7: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/disease/bronchitis.html");
                break;
            case 8: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/disease/malabsorption.html");
                break;
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
