package a2017.group19.samaung.samsungproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import a2017.group19.samaung.samsungproject.BuyAndSale.ShopFragment;
import a2017.group19.samaung.samsungproject.database.ShopClass;
import a2017.group19.samaung.samsungproject.database.ShopDao;

import static android.R.attr.type;

public class AddShopActivity extends AppCompatActivity {

    EditText shop_name,phone,address,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shop);

        shop_name=(EditText)findViewById(R.id.edt_shopName);
      //  type=(EditText)findViewById(R.id.edt_type);
        phone=(EditText)findViewById(R.id.edt_phone);
        address=(EditText)findViewById(R.id.edt_address);
        email=(EditText)findViewById(R.id.edt_email);
    }
    public void onClickAddShop(View view) {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        String shopName, Type = "", Phone, Address, Email;
        shopName = shop_name.getText().toString();


        Phone = phone.getText().toString();
        Address = address.getText().toString();
        Email = email.getText().toString();
        String error_msg = "အချက်အလတ်မပြည့်စုံပါ";


        if (shopName.isEmpty() || Type.isEmpty() || Phone.isEmpty() || Address.isEmpty()) {
            Toast.makeText(getApplicationContext(), error_msg, Toast.LENGTH_LONG).show();
        } else if (Email.isEmpty()) {
                ShopClass addShop = new ShopClass(shopName, Type, Phone, Address, "မရှိပါ");
                ShopDao addShopDB = new ShopDao(this);
                addShopDB.addShop(addShop);
                Toast.makeText(this,"ဆိုင်အသစ်ထည့်ပြီးပါပြီ။",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(this,SecondActivity.class);
                intent.putExtra("id", 4);
                startActivity(intent);
                finish();
            } else if (Email.matches(emailPattern)) {
                    ShopClass addShop = new ShopClass(shopName, Type, Phone, Address, Email);
                    ShopDao addShopDB = new ShopDao(this);
                    addShopDB.addShop(addShop);
                    Toast.makeText(this,"ဆိုင်အသစ်ထည့်ပြီးပါပြီ။",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(this,SecondActivity.class);
                    intent.putExtra("id", 4);
                    startActivity(intent);
                    finish();
                } else
            Toast.makeText(getApplicationContext(), "အီးမေးပုံစံမကျပါ", Toast.LENGTH_LONG).show();

            }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra("id", 4);
        startActivity(intent);
        finish();
    }
    public void onClickBack(View view){
        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra("id", 4);
        startActivity(intent);
        finish();
    }
}