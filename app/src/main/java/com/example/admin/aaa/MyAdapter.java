package com.example.admin.aaa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 2017/4/5.
 */

public class MyAdapter extends BaseExpandableListAdapter {
   private  ArrayList<String> grouplist;
    private  ArrayList<ArrayList<String>> childlist;
    private Context context;
    public MyAdapter(ArrayList<String> grouplists, ArrayList<ArrayList<String>> childlists,
                     Context context) {
        this.grouplist=grouplists;
        this.childlist=childlists;
        this.context=context;

    }

    @Override
    public int getGroupCount() {
        return grouplist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childlist.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return grouplist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childlist.get(groupPosition).get(childPosition);

    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        GroupViewHolder groupholder;
if (convertView==null){
    groupholder=new GroupViewHolder();
    convertView=LayoutInflater.from(context).inflate(R.layout.group,null);
    groupholder.group_title= (TextView) convertView.findViewById(R.id.group_title);
    convertView.setTag(groupholder);
}else {
    groupholder=(GroupViewHolder) convertView.getTag();
}
        groupholder.group_title.setText(grouplist.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if(convertView==null){
            childViewHolder=new ChildViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.child,null);
            childViewHolder.child_name= (TextView) convertView.findViewById(R.id.child_title);
            convertView.setTag(childViewHolder);
        }else{
            childViewHolder=(ChildViewHolder) convertView.getTag();
        }
        childViewHolder.child_name.setText(childlist.get(groupPosition).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    class GroupViewHolder{
        TextView group_title;
    }
    class ChildViewHolder{
        TextView child_name;
    }

}
