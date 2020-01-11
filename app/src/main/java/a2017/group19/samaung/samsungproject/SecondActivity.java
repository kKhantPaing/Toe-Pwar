package a2017.group19.samaung.samsungproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import a2017.group19.samaung.samsungproject.database.ShopClass;
import a2017.group19.samaung.samsungproject.database.ShopDao;
import a2017.group19.samaung.samsungproject.fragment.BuyAndSaleFragment;
import a2017.group19.samaung.samsungproject.fragment.DiseaseAndVaccineFragment;
import a2017.group19.samaung.samsungproject.fragment.HusbandryFragment;
import a2017.group19.samaung.samsungproject.fragment.KnowledgeFragment;

public class SecondActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ShopDao addShopDB;
    private int index = 1;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addShopDB = new ShopDao(this);
        if (addShopDB.getAllShop() == null)
            prepareShopData();
        //     index = getIntent().getIntExtra("id", 0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (index == 1) {
            //to active menu item auto select
            navigationView.getMenu().getItem(0).setChecked(true);
            //change fragment and change title
            changeFragment(new HusbandryFragment(), getResources().getStringArray(R.array.title_array)[index - 1]);
        } else if (index == 2) {
            navigationView.getMenu().getItem(1).setChecked(true);
            changeFragment(new DiseaseAndVaccineFragment(), getResources().getStringArray(R.array.title_array)[index - 1]);
        } else if (index == 3) {
            navigationView.getMenu().getItem(2).setChecked(true);
            changeFragment(new KnowledgeFragment(), getResources().getStringArray(R.array.title_array)[index - 1]);
        } else {
            navigationView.getMenu().getItem(3).setChecked(true);
            changeFragment(new BuyAndSaleFragment(), getResources().getStringArray(R.array.title_array)[index - 1]);
        }
    }

    private void changeFragment(Fragment fragment, String title) {
        this.setTitle(title);
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment, title).commit();
    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//
//            Intent main = new Intent(this, MainActivity.class);
//            startActivity(main);
//            finish();   //super.onBackPressed();
//        }


    //}

    public void onBackPressed() {
        alertDilalogExit(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            alertDilalogExit(this);
        } else if (id == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);

        } else if (id == R.id.calc_menu) {
            Intent intent = new Intent(this, CalculateActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent = new Intent(this, MainActivity.class);
        int id = item.getItemId();

        if (id == R.id.nav_husbandry) {
            changeFragment(new HusbandryFragment(), getResources().getStringArray(R.array.title_array)[0]);
        } else if (id == R.id.nav_diseaseAndVaccine) {
            changeFragment(new DiseaseAndVaccineFragment(), getResources().getStringArray(R.array.title_array)[1]);
        } else if (id == R.id.nav_toDoAndNotToDo) {
            changeFragment(new KnowledgeFragment(), getResources().getStringArray(R.array.title_array)[2]);
        } else if (id == R.id.nav_buyAndSale) {
            changeFragment(new BuyAndSaleFragment(), getResources().getStringArray(R.array.title_array)[3]);
        } else if (id == R.id.nav_feedback) {
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:09766086123")));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void alertDilalogExit(final Context context) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("ထြက္ဖို႔ ေသခ်ာပါသလား။")
                .setPositiveButton("ထြက္မယ္", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("မထြက္ဘူး", new DialogInterface.OnClickListener() {
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
