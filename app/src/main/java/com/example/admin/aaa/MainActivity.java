package com.example.admin.aaa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity  {
    private ExpandableListView myexpadlist;
    private MyAdapter MyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myexpadlist= (ExpandableListView) findViewById(R.id.myexpadlist);
        initData();
    }
    private void initData() {
        //group
        ArrayList<String> grouplist=new ArrayList<>();
        //
        ArrayList<ArrayList<String>>  childlist=new ArrayList<>();
        grouplist.add("第一组");
        grouplist.add("第二组");
        grouplist.add("第三组");
        ArrayList<String> templist   =new ArrayList<>();
        templist.add("wl");
        templist.add("ww");
        templist.add("lisi");
        for (int i=0;i<templist.size();i++){
            childlist.add(templist);
        }
        MyAdapter my=new MyAdapter(grouplist,childlist,MainActivity.this);
        myexpadlist.setAdapter(my);
    }


    }

