package a2017.group19.samaung.samsungproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar_about);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
getSupportActionBar().setTitle("အေၾကာင္းအရာ");
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    public void onClickContent(View view)
    {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:09766086123")));
    }
}
