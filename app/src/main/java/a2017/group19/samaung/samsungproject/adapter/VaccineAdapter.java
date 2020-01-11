package a2017.group19.samaung.samsungproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import a2017.group19.samaung.samsungproject.R;
import a2017.group19.samaung.samsungproject.VaccineActivity;

/**
 * Created by Lenovo on 10/20/2017.
 */

public class VaccineAdapter extends BaseAdapter {

        Context context;
        String[] data;
        private static LayoutInflater inflater = null;

        public VaccineAdapter(Context context, String[] data) {
            // TODO Auto-generated constructor stub
            this.context = context;
            this.data = data;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(final int position, final View convertView, final ViewGroup parent) {
            // TODO Auto-generated method stub
            View vi = convertView;


            if (vi == null)
                vi = inflater.inflate(R.layout.vaccine_layout,null);

            vi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, VaccineActivity.class);
                    switch (position){
                        case 0:
                            intent.putExtra("id",1);intent.putExtra("vaccine_name",data[0]);
                            break;
                        case 1:
                            intent.putExtra("id",2);intent.putExtra("vaccine_name",data[1]);
                            break;
                        case 2:
                            intent.putExtra("id",3);intent.putExtra("vaccine_name",data[2]);
                            break;
                        case 3:
                            intent.putExtra("id",4);intent.putExtra("vaccine_name",data[3]);
                            break;
                        case 4:
                            intent.putExtra("id",5);intent.putExtra("vaccine_name",data[4]);
                            break;
                        case 5:
                            intent.putExtra("id",6);intent.putExtra("vaccine_name",data[5]);
                            break;
                        case 6:
                            intent.putExtra("id",7);intent.putExtra("vaccine_name",data[6]);
                            break;
                        case 7:
                            intent.putExtra("id",8);intent.putExtra("vaccine_name",data[7]);
                            break;
                        case 8:
                            intent.putExtra("id",9);intent.putExtra("vaccine_name",data[8]);
                            break;
                        case 9:
                            intent.putExtra("id",10);intent.putExtra("vaccine_name",data[9]);
                            break;
                        case 10:
                            intent.putExtra("id",11);intent.putExtra("vaccine_name",data[10]);
                            break;
                        case 11:
                            intent.putExtra("id",12);intent.putExtra("vaccine_name",data[11]);
                            break;
                        case 12:
                            intent.putExtra("id",13);intent.putExtra("vaccine_name",data[12]);
                            break;
                    }
                    context.startActivity(intent);
                   //Toast.makeText(parent.getContext(),"you click position "+position,Toast.LENGTH_SHORT).show();
                }
            });


            TextView text = (TextView) vi.findViewById(R.id.tv_vaccine);
            text.setText(data[position]);
            return vi;
        }
    }

