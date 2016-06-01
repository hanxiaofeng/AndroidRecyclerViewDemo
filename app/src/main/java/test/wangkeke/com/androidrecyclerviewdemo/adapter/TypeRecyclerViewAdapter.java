package test.wangkeke.com.androidrecyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import test.wangkeke.com.androidrecyclerviewdemo.R;

/**
 * Created by wangkeke on 2016/6/1.
 * 备注：
 */
public class TypeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private String imageOne = "http://5.133998.com/2014/pic/000/363/18107c4b46aa8a182776746ff43e49bf.jpg";
    private String imageTwo = "http://img3.imgtn.bdimg.com/it/u=3954782107,4019560836&fm=21&gp=0.jpg";

    private boolean flag = false;

    public static enum ITEM_TYPE {
        ITEM_TYPE_IMAGE,
        ITEM_TYPE_TEXT
    }

    private Context context;

    private final LayoutInflater mLayoutInflater;

    private String[] mTitles;

    public TypeRecyclerViewAdapter(Context context)
    {
        mTitles = context.getResources().getStringArray(R.array.sports);
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
        if (viewType == ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {
            return new ImageViewHolder(mLayoutInflater.inflate(R.layout.item_image, parent, false));
        } else {
            return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_card, parent, false));
        }
    }


    /**
     * 绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        //判断holder的类型，来显示不同的View
        if (holder instanceof NormalTextViewHolder) {
            ((NormalTextViewHolder) holder).text.setText(mTitles[position]);
            //将数据保存在itemView的Tag中，以便点击时进行获取
            ((NormalTextViewHolder) holder).layout.setTag(mTitles[position]);
        } else if (holder instanceof ImageViewHolder) {
            ((ImageViewHolder)holder).textView.setText(mTitles[position]);
            //将数据保存在itemView的Tag中，以便点击时进行获取
            ((ImageViewHolder)holder).layout.setTag(mTitles[position]);

            /**
             * 交叉加载图片，测试用
             */
            if(flag)
            {
                ImageLoader.getInstance().displayImage(imageOne,((ImageViewHolder)holder).imageView);
                flag = !flag;
            }
            else
            {
                ImageLoader.getInstance().displayImage(imageTwo,((ImageViewHolder)holder).imageView);
                flag = !flag;
            }
        }
    }

    @Override
    public int getItemCount()
    {
        return mTitles.length;
    }

    @Override
    public int getItemViewType(int position) {
        //返回类型标记
        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    /**
     * 纯textView布局holder
     */
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
                {
                    Toast.makeText(context, ""+v.getTag(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    /**
     * 带图片的布局holder
     */
    public class ImageViewHolder extends  RecyclerView.ViewHolder
    {
        private TextView textView;

        private ImageView imageView;

        private LinearLayout layout;

        public ImageViewHolder(View itemView)
        {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.image_text);
            layout = (LinearLayout) itemView.findViewById(R.id.layout);

            layout.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(context, ""+v.getTag(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
