package a2017.group19.samaung.samsungproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import a2017.group19.samaung.samsungproject.database.ShopClass;
import a2017.group19.samaung.samsungproject.database.ShopDao;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_husbandry, button_DiseaseAndVaccine, button_knowledge, button_BuyAndSale;
    private android.support.v7.widget.Toolbar toolbar;
    private List<ShopClass> shopClassList = new ArrayList<>();
    private ShopDao addShopDB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        addShopDB = new ShopDao(this);

        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.logo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //   toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        button_husbandry = findViewById(R.id.btn_husbandry);
        button_DiseaseAndVaccine = findViewById(R.id.btn_DiseaseAndVaccine);
        button_knowledge = findViewById(R.id.btn_ToDoAndNotToDo);
        button_BuyAndSale = findViewById(R.id.btn_BuyAndSale);

        button_husbandry.setOnClickListener(this);
        button_DiseaseAndVaccine.setOnClickListener(this);
        button_knowledge.setOnClickListener(this);
        button_BuyAndSale.setOnClickListener(this);

        if (addShopDB.getAllShop() == null)
            prepareShopData();
//
//        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
//        viewFlipper.setFlipInterval(2000);
//        viewFlipper.startFlipping();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit) {
            alertDilalogExit(this);
        } else if (id == R.id.about) {
            item.setTitle("About");
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        } else if (id == R.id.calc_menu) {

            Intent intent = new Intent(this, CalculateActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        switch (view.getId()) {
            case R.id.btn_husbandry:
                intent.putExtra("id", 1);
                finish();
                break;
            case R.id.btn_DiseaseAndVaccine:
                intent.putExtra("id", 2);
                finish();
                break;
            case R.id.btn_ToDoAndNotToDo:
                intent.putExtra("id", 3);
                finish();
                break;
            case R.id.btn_BuyAndSale:
                intent.putExtra("id", 4);
                finish();
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        alertDilalogExit(this);
    }

    public void alertDilalogExit(final Context context) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("ထွက်ဖို့ သေချာပါသလား။")
                .setPositiveButton("ထွက်မယ်", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("မထွက်ဘူး", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                }).show();
    }


    private void prepareShopData() {
        try {
            JSONArray arrJSON = new JSONArray(loadJSONFromAsset());
            for (int i = 0; i < arrJSON.length(); i++) {
                JSONObject objJSON = arrJSON.getJSONObject(i);

                ShopClass addShop = new ShopClass(objJSON.getString("shopName"), objJSON.getString("type"), objJSON.getString("phone"), objJSON.getString("address"), objJSON.getString("email"));
                addShopDB.addShop(addShop);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private String loadJSONFromAsset() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = getAssets().open("shop.json");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader.close();

            Log.d("RESPONSE ", stringBuilder.toString());

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}