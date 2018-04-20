package com.example.mangeshaher.admin;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mangeshaher on 16/4/18.
 */

public class MenuList extends ArrayAdapter<Row> {

    private Activity context;
    private List<Row> menulist;
    TextView date,id,item1,item2;

    public MenuList(Activity context, List<Row> menulist){
        super(context,R.layout.item_list,menulist);
        this.context=context;
        this.menulist=menulist;
    }

    @NonNull
    @Override
    public View getView(int pos, View convertview , ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listviewitem = inflater.inflate(R.layout.list_item,null,true);
        date = (TextView)listviewitem.findViewById(R.id.date);
        item1 = (TextView)listviewitem.findViewById(R.id.it1);
        item2 = (TextView)listviewitem.findViewById(R.id.it2);
        Row row = menulist.get(pos);
        date.setText(row.getDate());
        item1.setText(row.getItem1());
        item2.setText(row.getItem2());
        return listviewitem;
    }

}
