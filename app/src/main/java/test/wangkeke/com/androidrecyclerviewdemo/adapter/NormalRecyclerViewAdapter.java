package test.wangkeke.com.androidrecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import test.wangkeke.com.androidrecyclerviewdemo.R;

/**
 * Created by wangkeke on 2016/6/1.
 * 备注：
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;

    private final LayoutInflater mLayoutInflater;

    private String[] mTitles;

    private List<String> titleList = new ArrayList<String>();

    public NormalRecyclerViewAdapter(Context context)
    {
        mTitles = context.getResources().getStringArray(R.array.sports);

        for (int i=0;i<mTitles.length;i++)
        {
            titleList.add(mTitles[i]);
        }

        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }


    /**
     * 导入布局文件
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item,parent,false));
    }

    /**
     * 绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ((NormalTextViewHolder)holder).text.setText(titleList.get(position));
        //将数据保存在itemView的Tag中，以便点击时进行获取
        ((NormalTextViewHolder)holder).layout.setTag(titleList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return titleList.size();
    }

    public class NormalTextViewHolder extends  RecyclerView.ViewHolder
    {
        private TextView text;

        private RelativeLayout layout;

        public NormalTextViewHolder(View itemView)
        {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);

            layout = (RelativeLayout) itemView.findViewById(R.id.layout);

            layout.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {    //
                    int pos =  titleList.indexOf(v.getTag());
//                    Toast.makeText(context, ""+v.getTag()+"---pos= "+pos, Toast.LENGTH_SHORT).show();
                    addItem("添加测试数据",pos);
                }
            });

            layout.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    removeItem((String)v.getTag());
                    return true;
                }
            });

        }
    }

    public class ImageViewHolder extends  RecyclerView.ViewHolder
    {
        private TextView textView;

        private ImageView imageView;

        public ImageViewHolder(View itemView)
        {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.image_text);

            textView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(context, ""+v.getTag(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * 添加数据
     * @param content
     * @param position
     */
    public void addItem(String content, int position) {
        titleList.add(position,content);
        notifyItemInserted(position); //Attention!
    }

    /**
     * 删除数据
     * @param content
     */
    public void removeItem(String content) {
        int position = titleList.indexOf(content);
        titleList.remove(position);
        notifyItemRemoved(position);//Attention!
    }
}
