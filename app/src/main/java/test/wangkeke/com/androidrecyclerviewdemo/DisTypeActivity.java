package test.wangkeke.com.androidrecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import test.wangkeke.com.androidrecyclerviewdemo.adapter.NormalRecyclerViewAdapter;
import test.wangkeke.com.androidrecyclerviewdemo.adapter.TypeRecyclerViewAdapter;
import test.wangkeke.com.androidrecyclerviewdemo.divider.DividerItemDecoration;

public class DisTypeActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private TypeRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis_type);

        initView();
    }

    private void initView()
    {
        recyclerView = (RecyclerView) findViewById(R.id.type_recyclerView);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        adapter = new TypeRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
    }
}

