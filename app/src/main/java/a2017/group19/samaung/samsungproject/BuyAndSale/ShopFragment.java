package a2017.group19.samaung.samsungproject.BuyAndSale;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import a2017.group19.samaung.samsungproject.AddShopActivity;
import a2017.group19.samaung.samsungproject.R;
import a2017.group19.samaung.samsungproject.adapter.ExpandableListAdapter;
import a2017.group19.samaung.samsungproject.database.ShopClass;
import a2017.group19.samaung.samsungproject.database.ShopDao;


public class ShopFragment extends Fragment {
    private ShopDao shopDao;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);    //   LoadAllShop();
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
//        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                   Intent intent=new Intent(getActivity(),AddShopActivity.class);
//                    startActivity(intent);
//                getActivity().finish();
//
//            }
//        });
            return view;
    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        shopDao = new ShopDao(getActivity());

        shopDao = new ShopDao(getActivity());
        List<ShopClass> shopList = shopDao.getAllShop();
    int i=0;
        for (ShopClass shop : shopList) {
            // Adding child data
        listDataHeader.add(shop.getShopName()+"\n("+shop.getType()+")" );

        // Adding child data
        List<String> addInfo = new ArrayList<String>();
        addInfo.add( shop.getPhone() );
        addInfo.add(shop.getAddress() );
        addInfo.add( shop.getEmail());

        listDataChild.put(listDataHeader.get(i), addInfo); // Header, Child data
            i++;
    }
    }
}