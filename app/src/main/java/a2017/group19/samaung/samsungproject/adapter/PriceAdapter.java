package a2017.group19.samaung.samsungproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import a2017.group19.samaung.samsungproject.BuyAndSale.PriceClass;
import a2017.group19.samaung.samsungproject.R;

/**
 * Created by Lenovo on 10/29/2017.
 */

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.MyViewHolder> {

        private Context mContext;
        private List<PriceClass> priceClassList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_id_name,tv_id_price;
            private PriceClass priceClass;

            public MyViewHolder(View view) {
                super(view);
                tv_id_name=(TextView)view.findViewById(R.id.name_id);
                tv_id_price=(TextView)view.findViewById(R.id.price_id);
            }

            public void bindData(PriceClass priceClass) {
                this.priceClass = priceClass;
                tv_id_name.setText(priceClass.getName());
                tv_id_price.setText(priceClass.getPrice()+"");

            }
        }

    public PriceAdapter(Context mContext, List<PriceClass> priceClassList) {
            this.mContext = mContext;
            this.priceClassList = priceClassList;
        }

        @Override
        public PriceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.price_layout, parent, false);

            return new PriceAdapter.MyViewHolder(itemView);
        }


        public void onBindViewHolder(final PriceAdapter.MyViewHolder holder, int position) {
            PriceClass priceClass = priceClassList.get(position);
            holder.bindData(priceClass);
        }

        @Override
        public int getItemCount() {
            return priceClassList.size();
        }

    }
