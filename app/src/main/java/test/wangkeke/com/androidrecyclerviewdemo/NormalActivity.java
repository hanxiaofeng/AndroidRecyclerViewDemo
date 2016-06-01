package test.wangkeke.com.androidrecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import test.wangkeke.com.androidrecyclerviewdemo.adapter.NormalRecyclerViewAdapter;
import test.wangkeke.com.androidrecyclerviewdemo.divider.DividerItemDecoration;
import test.wangkeke.com.androidrecyclerviewdemo.divider.RecycleViewDivider;

public class NormalActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private NormalRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        initView();
    }

    private void initView()
    {
        recyclerView = (RecyclerView) findViewById(R.id.my_recyclerView);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        recyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.VERTICAL));

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //添加默认动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new NormalRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
    }
}
