package a2017.group19.samaung.samsungproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private TextView unit, result, tv_pate, equal, tv_kg, pate, tv_kyat, kyat;
    private EditText number, kg;
    TextView help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.calc_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
getSupportActionBar().setTitle("တြက္ခ်က္ရန္");
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        unit = (TextView) findViewById(R.id.unit);
        result = (TextView) findViewById(R.id.res);
        tv_kg = (TextView) findViewById(R.id.tv_kg);
        tv_pate = (TextView) findViewById(R.id.tv_pate);
        tv_kyat = (TextView) findViewById(R.id.tv_kyat);
        equal = (TextView) findViewById(R.id.equal);
        number = (EditText) findViewById(R.id.et_number);
        pate = (TextView) findViewById(R.id.pate);
        kg = (EditText) findViewById(R.id.kg);
        kyat = (TextView) findViewById(R.id.kyat);
        kyat.setHint("0");
        kg.setHint("0");
        pate.setHint("0");
        kg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (kg.length() == 0) {
                    pate.setText("0");
                    kyat.setText("0");
                } else {
                    double unit = Double.parseDouble(kg.getText().toString());
                    double res = unit * 0.61239517;
                    int pa = (int) Math.floor(res);
                    int b = (int) ((res - pa) * 100);
                    pate.setText(pa + "");
                    kyat.setText(b + "");

                }
            }
        });
        help = (TextView) findViewById(R.id.textHelp);
        radioGroup.setOnCheckedChangeListener(this);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                help.setText("မိမိသိခ်င္ရာကိုေ႐ြး၍ ၾကက္ေကာင္ေရ(သို႔)ဧရိယာကိုထည့္ပါ။\n" +
                        "ဥပမာ-ၾကက္ေကာင္ေရ(၁၀၀)ေမြးရန္ဧရိယာမည္မွ်လိုသည္ကိုတြက္မည္ဆိုပါက" +
                        "ဧရိယာဟုေရးထားေသာစာရွိအဝိုင္းကိုေ႐ြး၍ \"ၾကက္ေကာင္ေရထည့္ပါ\"ဟု ျပထားေသာေနရာတြင္(၁၀၀) ထည့္ၿပီးတြက္ႏိုင္ပါသည္။");
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.byChicken:
                number.setHint("ၾကက္ေကာင္ေရျဖင့္");
                unit.setText("ေကာင္");
                break;
            case R.id.byArea:
                number.setHint("ဧရိယာျဖင့္");
                unit.setText("စတုရန္းေပ");
                break;
        }
    }

    public void onClickCala(View view) {
        int num;
        int i = radioGroup.getCheckedRadioButtonId();
        if (number.getText().toString().isEmpty() || Integer.parseInt(number.getText().toString()) == 0) {
            Toast.makeText(this, "တန္ဖိုးမရွိပါ", Toast.LENGTH_LONG).show();
        } else {
            num = Integer.parseInt(number.getText().toString());
            switch (i) {

                case R.id.byArea:
                    if (Integer.parseInt(number.getText().toString()) < 2) {
                        Toast.makeText(this, "ၾကက္တစ္ေကာင္ေမြးရန္အနည္းဆုံး (၂)ဧရိယာစတုရန္းေပ လိုအပ္ပါသည္။", Toast.LENGTH_LONG).show();
                        break;
                    } else {
                        int res = (int) (num / 1.40);
                        result.setText("(" + num + ")စတုရန္းေပတြင္ ၾကက္ေကာင္ေရ(" + res + ") ေမြးျမဴႏိုင္ပါသည္။ CP ၾကက္ေပါက္(" + res + ") ေကာင္အတြက္စုစုေပါင္း(" + res * 650 + ") က်ပ္ကုန္က်ပါမည္။");
                        break;
                    }
                case R.id.byChicken:
                    int tot = (int) Math.ceil(num * 1.40);
                    result.setText("(" + num + ")ၾကက္ေကာင္ေရအတြက္(" + tot + ")စတုရန္းေပ လိုအပ္ပါသည္။ CP ၾကက္ေပါက္(" + num + ")ေကာင္အတြက္စုစုေပါင္း(" + num * 650 + ")က်ပ္ကုန္က်ပါမည္။");
                    break;
            }
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
