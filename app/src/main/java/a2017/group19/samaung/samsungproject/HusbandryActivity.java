package a2017.group19.samaung.samsungproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HusbandryActivity extends AppCompatActivity {

    private TextView textView;
    private WebView webView;
    private int index;
    String title="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_husbandry);
        Toolbar toolbar=(Toolbar)findViewById(R.id.web_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView=(WebView)findViewById(R.id.webView);
        index=getIntent().getIntExtra("id",0);
        title=getIntent().getStringExtra("husbandry_name");

        switch (index){
            case 1: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/husbandry/prepare.html");
                break;
            case 2: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/husbandry/ground.html");
                break;
            case 3: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/husbandry/building.html");
                break;
            case 4:
               getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/husbandry/bio.html");
                break;
            case 5: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/husbandry/water.html");
                break;
            case 6: getSupportActionBar().setTitle(title);
                webView.loadUrl("file:///android_asset/husbandry/food.html");
                break;
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
