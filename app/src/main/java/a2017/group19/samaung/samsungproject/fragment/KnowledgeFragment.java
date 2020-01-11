package a2017.group19.samaung.samsungproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import a2017.group19.samaung.samsungproject.R;
import a2017.group19.samaung.samsungproject.adapter.KnowledgeAdapter;
import a2017.group19.samaung.samsungproject.adapter.VaccineAdapter;

public class KnowledgeFragment extends Fragment {

    ListView listView;
    String []listKnowledge={"ၾကက္ေဈးႏႈန္းေျပာင္းလဲေစသည့္အေၾကာင္းမ်ား","ခ်ိန္တြယ္ေရာင္းခ်ျခင္း","အစာကုန္က်စရိတ္ေလ်ာ့ခ်ရန္နည္းလမ္းမ်ား","လုပ္ငန္းေအာင္ျမင္မႈရရွိေရးအတြက္ အဓိကအေရးႀကီးသည့္အခ်က္မ်ား","မွန္ကန္ေသာလုပ္သားမ်ားေ႐ြးခ်ယ္ျခင္း","ဒဏ္","ေရတြင္ပါဝင္မႈအျမင့္ဆုံးလက္ခံႏိုင္သည့္ အဆင့္သတ္မွတ္ခ်က္မ်ား","ႂကြက္အႏၲရာယ္","ေနစဥ္ၿခံလုပ္ငန္းေဆာင္႐ြက္ျခင္း"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_knowledge, container, false);

        listView=(ListView)view.findViewById(R.id.listView_id);
        listView.setAdapter(new KnowledgeAdapter(getActivity(),listKnowledge));
        return view;
    }
}
