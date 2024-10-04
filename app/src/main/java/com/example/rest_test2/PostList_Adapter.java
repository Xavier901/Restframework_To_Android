package com.example.rest_test2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PostList_Adapter extends ArrayAdapter<Post_data> {

    Context context;
    List<Post_data>objects;
    public PostList_Adapter(@NonNull Context context, int resource, @NonNull List<Post_data> objects) {
        super(context, resource, objects);

        this.context=context;
        this.objects=objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.post_list_template, parent, false);
        }

        Post_data item= objects.get(position);

        TextView IDP      =(TextView)row.findViewById(R.id.idp);
        TextView ID_AUTHER=(TextView)row.findViewById(R.id.id_Auther);
        TextView P_TITLE  =(TextView)row.findViewById(R.id.p_title);
        TextView P_BODY   =(TextView)row.findViewById(R.id.p_body);
        TextView P_DATE   =(TextView)row.findViewById(R.id.p_date);

        IDP.setText(Integer.toString(item.getId()));
        ID_AUTHER.setText(Integer.toString(item.getAuthor()));
        P_TITLE.setText(item.getTitle());
        P_BODY.setText(item.getBody());
        P_DATE.setText(item.getCreated_at().toString());


        return row;
    }
}
