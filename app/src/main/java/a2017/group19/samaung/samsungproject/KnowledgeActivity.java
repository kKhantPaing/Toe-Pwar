package a2017.group19.samaung.samsungproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class KnowledgeActivity extends AppCompatActivity {

   private WebView webView;
   private int index;
   private  String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);

        Toolbar toolbar=(Toolbar)findViewById(R.id.knowledge_toolbar);
        setSupportActionBar(toolbar);
        webView=(WebView)findViewById(R.id.web_knowledge) ;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        index=getIntent().getIntExtra("id",0);
        title=getIntent().getStringExtra("knowledge");

        switch (index){

            case 1: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/knowledge/1.html");
                break;
            case 2: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/knowledge/2.html");
                break;
            case 3: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/knowledge/3.html");
                break;
            case 4: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/knowledge/4.html");
                break;
            case 5: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/knowledge/5.html");
                break;
            case 6: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/knowledge/6.html");
                break;
            case 7: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/knowledge/7.html");
                break;
            case 8: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/knowledge/8.html");
                break;
            case 9: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/knowledge/9.html");
                break;

        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
