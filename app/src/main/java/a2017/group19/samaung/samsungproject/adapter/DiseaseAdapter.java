package a2017.group19.samaung.samsungproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import a2017.group19.samaung.samsungproject.DiseaseActivity;
import a2017.group19.samaung.samsungproject.DiseaseClass;
import a2017.group19.samaung.samsungproject.R;
import a2017.group19.samaung.samsungproject.SecondActivity;

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.MyViewHolder> {

    private Context mContext;
    private List<DiseaseClass> diseaseList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_disease;
        public ImageView imageView;
        private DiseaseClass disease;

        public MyViewHolder(View view) {
            super(view);
            imageView=(ImageView)view.findViewById(R.id.img);
            tv_disease=(TextView)view.findViewById(R.id.tv_disease);

       view.setOnClickListener(new View.OnClickListener() {
       @Override
           public void onClick(View v) {

           Intent intent = new Intent(mContext, DiseaseActivity.class);

           switch (disease.getCount()) {
               case 1:intent.putExtra("id", 1); intent.putExtra("disease_name",disease.getDisease());
                   break;
               case 2:intent.putExtra("id", 2); intent.putExtra("disease_name",disease.getDisease());
                   break;
               case 3: intent.putExtra("id", 3); intent.putExtra("disease_name",disease.getDisease());
                   break;
               case 4: intent.putExtra("id", 4); intent.putExtra("disease_name",disease.getDisease());
                   break;
               case 5:intent.putExtra("id", 5); intent.putExtra("disease_name",disease.getDisease());
                   break;
               case 6:intent.putExtra("id", 6); intent.putExtra("disease_name",disease.getDisease());
                   break;
               case 7:intent.putExtra("id", 7); intent.putExtra("disease_name",disease.getDisease());
                   break;
               case 8:intent.putExtra("id", 8); intent.putExtra("disease_name",disease.getDisease());
                   break;

           }
           mContext.startActivity(intent);
       }

    });
}
        public void bindData(DiseaseClass disease) {

            this.disease = disease;
          tv_disease.setText(disease.getDisease());
            // loading album cover using Glide library
            Glide.with(mContext).load(disease.getThumbnail()).into(imageView);
        }
    }

    public DiseaseAdapter(Context mContext, List<DiseaseClass> diseaseList) {
        this.mContext = mContext;
        this.diseaseList = diseaseList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.disease_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        DiseaseClass diseaseClass = diseaseList.get(position);
        holder.bindData(diseaseClass);
    }

    @Override
    public int getItemCount() {
        return diseaseList.size();
    }

}
