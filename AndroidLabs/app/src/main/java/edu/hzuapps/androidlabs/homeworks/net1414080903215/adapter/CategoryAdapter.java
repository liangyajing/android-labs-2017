package edu.hzuapps.androidlabs.homeworks.net1414080903215.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.hzuapps.androidlabs.homeworks.net1414080903215.R;

public class CategoryAdapter extends ArrayAdapter<Category>{

        private int resourceId;
        public CategoryAdapter(Context context, int resource,
                               List<Category> categoryList) {
                super(context,resource, categoryList);
                resourceId=resource;
        }
        public View getView(int position, View convertView, android.view.ViewGroup parent) {
                Category category=getItem(position);//获取当前项的Category实例
                View view;
                ViewHolder viewHolder;
                if(convertView==null){
                        view=LayoutInflater.from(getContext()).inflate(resourceId,null);
                        viewHolder=new ViewHolder();
                        viewHolder.categoryImage=(ImageView)view.findViewById(R.id.category_image);
                        viewHolder.categoryName=(TextView)view.findViewById(R.id.category_name);
                        view.setTag(viewHolder);
                }else{
                        view=convertView;
                        viewHolder=(ViewHolder) view.getTag();
                }
                viewHolder.categoryImage.setImageResource(category.getImageId());
                viewHolder.categoryName.setText(category.getName());
                return view;
        }
        class ViewHolder{
                ImageView categoryImage;
                TextView categoryName;
        }
}
