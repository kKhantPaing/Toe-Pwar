package a2017.group19.samaung.samsungproject.fragment;
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
import a2017.group19.samaung.samsungproject.HusbandryClass;
import a2017.group19.samaung.samsungproject.R;
import a2017.group19.samaung.samsungproject.adapter.HusbandryAdapter;

public class HusbandryFragment extends Fragment {
    private HusbandryAdapter husbandryAdapter;
    private List<HusbandryClass> husbandryClassList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_husbandry, container, false);

        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.husbandry_recycler_view);

        husbandryClassList= new ArrayList<>();
        husbandryAdapter = new HusbandryAdapter(getActivity(),husbandryClassList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(husbandryAdapter);

        prepareDisease();
        return view;
    }

    private void prepareDisease() {
        int[] covers = new int[]{
                R.drawable.husbandry_img1,
                R.drawable.husbandry_img2,
                R.drawable.husbandry_img3,
                R.drawable.husbandry_img4,
                R.drawable.husbandry_img5,
                R.drawable.husbandry_img6,        };

        HusbandryClass a0 = new HusbandryClass("ႀကိဳတင္ျပင္ဆင္ရန္",covers[0],1);
        husbandryClassList.add(a0);
        HusbandryClass a1 = new HusbandryClass("သင့္ေလ်ာ္ေသာေျမ",covers[1],2);
        husbandryClassList.add(a1);
        HusbandryClass a2 = new HusbandryClass("ၾကက္ၿခံ",covers[2],3);
        husbandryClassList.add(a2);
        HusbandryClass a3 = new HusbandryClass("ဇီဝလုံၿခဳံေရး",covers[3],4);
        husbandryClassList.add(a3);
        HusbandryClass a4 = new HusbandryClass("ေရ",covers[4],5);
        husbandryClassList.add(a4);
        HusbandryClass a5 = new HusbandryClass("အစာ",covers[5],6);
        husbandryClassList.add(a5);

        husbandryAdapter.notifyDataSetChanged();
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
