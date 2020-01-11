package a2017.group19.samaung.samsungproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import a2017.group19.samaung.samsungproject.KnowledgeActivity;
import a2017.group19.samaung.samsungproject.R;

/**
 * Created by Lenovo on 10/30/2017.
 */

public class KnowledgeAdapter extends BaseAdapter {

    Context context;
    String[] data;
    private static LayoutInflater inflater = null;

    public KnowledgeAdapter(Context context, String[] data) {
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
            vi = inflater.inflate(R.layout.knowledge_layout,null);

        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, KnowledgeActivity.class);
                switch (position){
                    case 0:
                        intent.putExtra("id",1);intent.putExtra("knowledge",data[0]);
                        break;
                    case 1:
                        intent.putExtra("id",2);intent.putExtra("knowledge",data[1]);
                        break;
                    case 2:
                        intent.putExtra("id",3);intent.putExtra("knowledge",data[2]);
                        break;
                    case 3:
                        intent.putExtra("id",4);intent.putExtra("knowledge",data[3]);
                        break;
                    case 4:
                        intent.putExtra("id",5);intent.putExtra("knowledge",data[4]);
                        break;
                    case 5:
                        intent.putExtra("id",6);intent.putExtra("knowledge",data[5]);
                        break;
                    case 6:
                        intent.putExtra("id",7);intent.putExtra("knowledge",data[6]);
                        break;
                    case 7:
                        intent.putExtra("id",8);intent.putExtra("knowledge",data[7]);
                        break;
                    case 8:
                        intent.putExtra("id",9);intent.putExtra("knowledge",data[8]);
                        break;
                }
                context.startActivity(intent);
                //Toast.makeText(parent.getContext(),"you click position "+position,Toast.LENGTH_SHORT).show();
            }
        });


        TextView text = (TextView) vi.findViewById(R.id.tv_knowledge);
        text.setText(data[position]);
        return vi;
    }
}

