package a2017.group19.samaung.samsungproject.DiseaseAndVaccineFragment;


import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import a2017.group19.samaung.samsungproject.DiseaseClass;
import a2017.group19.samaung.samsungproject.R;
import a2017.group19.samaung.samsungproject.adapter.DiseaseAdapter;


public class DiseaseFragment extends Fragment {
    private RecyclerView recyclerView;
    private DiseaseAdapter diseaseAdapter;
    private List<DiseaseClass> diseaseList;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disease, container, false);

        recyclerView = (RecyclerView)view. findViewById(R.id.recycler_view);

        diseaseList= new ArrayList<>();
        diseaseAdapter = new DiseaseAdapter(getActivity(), diseaseList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(diseaseAdapter);

        prepareDisease();
        return view;
    }

    private void prepareDisease() {
        int[] covers = new int[]{
                R.drawable.disease_2,
                R.drawable.disease_3,
                R.drawable.disease_4,
                R.drawable.disease_5,
                R.drawable.disease_6,
                R.drawable.disease_7,
                R.drawable.disease_8,
                R.drawable.disease_9,

        };


        DiseaseClass a = new DiseaseClass("အသည္းေရာင္ေရာဂါ",covers[0],1);
        diseaseList.add(a);
        DiseaseClass a1= new DiseaseClass("ခ်က္တိုင္ေရာဂါ",covers[1],2);
        diseaseList.add(a1);
        DiseaseClass a2 = new DiseaseClass("ေခ်းျဖဴေရာဂါ",covers[2],3);
        diseaseList.add(a2);
        DiseaseClass a3 = new DiseaseClass("လည္လိမ္ေရာဂါ",covers[3],4);
        diseaseList.add(a3);
        DiseaseClass a4 = new DiseaseClass("ဆီးႀကိတ္ေရာင္ေရာဂါ  ",covers[4],5);
        diseaseList.add(a4);
        DiseaseClass a5 = new DiseaseClass("ေကာ္႐ိုဇာေရာဂါ",covers[5],6);
        diseaseList.add(a5);
        DiseaseClass a6 = new DiseaseClass("ေလႁပြန္ေရာင္ေရာဂါ",covers[6],7);
        diseaseList.add(a6);
        DiseaseClass a7 = new DiseaseClass("အစာစုပ္ယူမႈညံဖ်င္းေရာဂါ",covers[7],8);
        diseaseList.add(a7);
        diseaseAdapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
