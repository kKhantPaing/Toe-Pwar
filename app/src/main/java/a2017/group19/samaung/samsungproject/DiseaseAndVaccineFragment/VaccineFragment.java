package a2017.group19.samaung.samsungproject.DiseaseAndVaccineFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import a2017.group19.samaung.samsungproject.R;
import a2017.group19.samaung.samsungproject.adapter.VaccineAdapter;

public class VaccineFragment extends Fragment {
    private ListView listView;
    private String vaccineList[]={"ပိုးသတ္ေဆးႏွင့္သုံးစြဲနည္း","ေရာေႏွာသုံးစြဲမႈမျပဳသင့္သည့္ေဆးဝါးမ်ား","အျခားေဆးဝါးမ်ား","ထုံးအသုံးျပဳပုံ","ေလႁပြန္ေရာင္ေရာဂါကာကြယ္ကုသနည္း","ဆီးႀကိတ္ေရာင္ေရာဂါကာကြယ္ကုသနည္း","ေသြးဝမ္းေရာဂါကာကြယ္ကုသနည္း","ေကာ္႐ိုင္ဇာေရာဂါကာကြယ္ကုသနည္း","အသည္းေရာင္ေရာဂါကာကြယ္ကုသနည္း","အစာစုပ္ယူမႈညံ့ဖ်င္းေရာဂါကာကြယ္ကုသနည္း","လည္လိမ္ေရာဂါကာကြယ္ကုသနည္း","ခ်က္တိုင္ေရာဂါကာကြယ္ကုသနည္း","ေခ်းျဖဴေရာဂါကာကြယ္ကုသနည္း"};

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vaccine, container, false);

        listView=(ListView)view.findViewById(R.id.listview_vaccine);
        listView.setAdapter(new VaccineAdapter(getActivity(),vaccineList));
        return view;
    }

}
