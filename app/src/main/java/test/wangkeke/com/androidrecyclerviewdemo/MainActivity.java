package test.wangkeke.com.androidrecyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView()
    {
        btnOne = (Button) findViewById(R.id.btn_one);
        btnOne.setOnClickListener(this);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnTwo.setOnClickListener(this);
        btnThree = (Button) findViewById(R.id.btn_three);
        btnThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_one:
                Intent intent = new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_two:
                Intent intent2 = new Intent(MainActivity.this,DisTypeActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_three:

                break;


        }
    }
}
