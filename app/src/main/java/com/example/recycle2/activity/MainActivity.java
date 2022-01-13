package com.example.recycle2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recycle2.R;
import com.example.recycle2.adapter.CustomAdapter;
import com.example.recycle2.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        List<Member> members=prepareMemerList();
        refreshAdapter(members);
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter=new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
    private List<Member> prepareMemerList(){
        List<Member> members=new ArrayList<>();
        for (int i = 0; i <30 ; i++) {
           if (i==0||i==5||i==16||i==25){
               members.add(new Member("Mirzayev "+i,"Shaxzod "+i, false));
           } else{ members.add(new Member("Mirzayev "+i,"Shaxzod "+i, true));}
        } return members;
    }

}