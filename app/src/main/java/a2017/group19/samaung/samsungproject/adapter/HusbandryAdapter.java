package a2017.group19.samaung.samsungproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import a2017.group19.samaung.samsungproject.DiseaseActivity;
import a2017.group19.samaung.samsungproject.DiseaseClass;
import a2017.group19.samaung.samsungproject.HusbandryActivity;
import a2017.group19.samaung.samsungproject.HusbandryClass;
import a2017.group19.samaung.samsungproject.R;

public class HusbandryAdapter extends RecyclerView.Adapter<HusbandryAdapter.MyViewHolder> {

    private Context mContext;
    private List<HusbandryClass> husbandryClassList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_husbandry;
        public ImageView imageView;
        private HusbandryClass husbandryClass;

        public MyViewHolder(View view) {
            super(view);
            imageView=(ImageView)view.findViewById(R.id.husbandry_image);
            tv_husbandry=(TextView)view.findViewById(R.id.tv_husbandry);

       view.setOnClickListener(new View.OnClickListener() {
       @Override
           public void onClick(View v) {

           Intent intent = new Intent(mContext, HusbandryActivity.class);

           switch (husbandryClass.getCount()) {
               case 1:
                   intent.putExtra("id", 1);
                   intent.putExtra("husbandry_name",husbandryClass.getHusbandry());
                   break;
               case 2:intent.putExtra("id", 2);
                   intent.putExtra("husbandry_name",husbandryClass.getHusbandry());
                   break;
               case 3: intent.putExtra("id", 3);
                   intent.putExtra("husbandry_name",husbandryClass.getHusbandry());
                   break;
               case 4: intent.putExtra("id", 4);
                   intent.putExtra("husbandry_name",husbandryClass.getHusbandry());
                   break;
               case 5:intent.putExtra("id", 5);
                   intent.putExtra("husbandry_name",husbandryClass.getHusbandry());
                   break;
               case 6:intent.putExtra("id", 6);
                   intent.putExtra("husbandry_name",husbandryClass.getHusbandry());
                   break;
           }
           mContext.startActivity(intent);
       }

    });
}
        public void bindData(HusbandryClass husbandryClass) {

            this.husbandryClass= husbandryClass;
          tv_husbandry.setText(husbandryClass.getHusbandry());
            // loading album cover using Glide library
            Glide.with(mContext).load(husbandryClass.getThumbnail()).into(imageView);
        }
    }

    public HusbandryAdapter(Context mContext, List<HusbandryClass> husbandryClassLists) {
        this.mContext = mContext;
        this.husbandryClassList = husbandryClassLists;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.husbandry_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        HusbandryClass husbandryClass = husbandryClassList.get(position);
        holder.bindData(husbandryClass);
    }

    @Override
    public int getItemCount() {
        return husbandryClassList.size();
    }

}
