package a2017.group19.samaung.samsungproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;

import a2017.group19.samaung.samsungproject.Map.MapsActivity;
import a2017.group19.samaung.samsungproject.R;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);
        int[] icon = new int[]{
                R.drawable.phone_icon,
                R.drawable.address_icon,
                R.drawable.email_icon};

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }
        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.expand_tv_phone);
        ImageView img = (ImageView) convertView.findViewById(R.id.expand_image);

        txtListChild.setText(childText);
        // txtListChild.setCompoundDrawablesWithIntrinsicBounds(icon[childPosition], 0, 0, 0);
        Glide.with(convertView.getContext()).load(icon[childPosition]).into(img);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (childPosition) {
                    case 0:
                        if (!TextUtils.isEmpty(childText)) {
                            String dial = "tel:" + childText;
                            _context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                        }
                        break;
                    case 1:
                        Intent intent = new Intent(_context, MapsActivity.class);
                        if (true) {
                            intent.putExtra("id", groupPosition);
                        }
                        _context.startActivity(intent);
                        break;

                    case 2:
                        if (!childText.equals("မရှိပါ")) {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_EMAIL, new String[]{childText});
                            i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                            i.putExtra(Intent.EXTRA_TEXT, "body of email");
                            try {
                                _context.startActivity(Intent.createChooser(i, "Send mail..."));
                            } catch (android.content.ActivityNotFoundException ex) {
                                Toast.makeText(_context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;

                }
            }
        });


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        final LinearLayout header_layout = convertView.findViewById(R.id.header_layout);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        if (isExpanded) {
            Log.i("Is Expanded : ", "TRUE");
            //header_layout.setBackgroundColor(Color.parseColor("#ffffff"));

        } else {
            Log.i("Is Expanded : ", "False");
            // header_layout.setBackgroundColor(Color.TRANSPARENT);
        }


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}