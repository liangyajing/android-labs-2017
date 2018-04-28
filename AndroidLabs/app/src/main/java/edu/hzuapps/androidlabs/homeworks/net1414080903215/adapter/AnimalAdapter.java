package edu.hzuapps.androidlabs.homeworks.net1414080903215.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import edu.hzuapps.androidlabs.homeworks.net1414080903215.Net1414080903215_DBHelper;
import edu.hzuapps.androidlabs.homeworks.net1414080903215.R;

public class AnimalAdapter extends ArrayAdapter<Animal>{
    private  Net1414080903215_DBHelper dbHelper;
    private int resourceId;
    private Context context;
    private List<Animal> list;
    public AnimalAdapter(Context context, int resource, List<Animal> objects) {
        super(context,resource, objects);
        this.context=context;
        resourceId=resource;
        this.list=objects;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Animal animal =getItem(position);//获取当前项的Animal实例
        View view;
        ViewHolder viewHolder;
        if(convertView==null){//判断是否第一次运行，如果是则进入，并将上下文环境保存进convertView
            view=LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();
            viewHolder.tvName=(TextView)view.findViewById(R.id.tvName);
            viewHolder.btnSave=(ImageButton)view.findViewById(R.id.btnSave);
            viewHolder.btnSave.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Dialog dialog = new AlertDialog.Builder(context)
                            .setTitle("收藏")
                            .setMessage("确定要将该成语添加入收藏夹吗？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
		                    /* User clicked OK so do some stuff */
                                    dbHelper=new Net1414080903215_DBHelper(context,"saveidiom.db",null,1);
                                    dbHelper.getWritableDatabase();
                                    dbHelper.addAttentionWord(list.get(position).getId()//将数据保存在表里
                                            , list.get(position).getName()
                                            , list.get(position).getPronounce(),list.get(position).getAntonym(),list.get(position).getHomoionym()
                                            , list.get(position).getDerivation(),list.get(position).getExamples(),list.get(position).getExplain());
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
		                    /* User clicked OK so do some stuff */
                                }
                            }).create();
                    dialog.show();
                }
            });
            view.setTag(viewHolder);
        }else{//如果不是第一次运行，convertView不为空，直接取出赋值给view
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.tvName.setText(animal.getName());//显示成语
        return view;
    }
    class ViewHolder{
        TextView tvName;
        ImageButton btnSave;
    }
}
