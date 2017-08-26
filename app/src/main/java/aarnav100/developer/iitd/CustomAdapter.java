package aarnav100.developer.iitd;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anirudh on 26/8/17.
 */

public class CustomAdapter extends ArrayAdapter<DataItem>{
    Context context;
    int layoutResourceId;



    List<DataItem> data = null;
    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<DataItem> objects) {
        super(context, resource, objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = objects;
    }

    static  class DataHolder
    {
        ImageView ivFlag;
        TextView tvName;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       DataHolder holder = null;
        if(convertView == null){
            LayoutInflater inflator = ((Activity)context).getLayoutInflater();
            convertView = inflator.inflate(layoutResourceId,parent);
            holder = new DataHolder();
            holder.ivFlag = (ImageView)convertView.findViewById(R.id.ivImage);
            holder.tvName = (TextView)convertView.findViewById(R.id.tvText);
            convertView.setTag(holder);
        }
        else{
            holder = (DataHolder)convertView.getTag();
        }
        DataItem dataItem = data.get(position);
        holder.tvName.setText(dataItem.name);
        holder.ivFlag.setImageResource(dataItem.resIdThumbnail);
        return convertView;
    }
}
