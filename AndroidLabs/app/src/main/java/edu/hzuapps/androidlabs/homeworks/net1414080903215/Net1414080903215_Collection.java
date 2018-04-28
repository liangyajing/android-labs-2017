package edu.hzuapps.androidlabs.homeworks.net1414080903215;

import java.util.ArrayList;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.hzuapps.androidlabs.homeworks.net1414080903215.adapter.Animal;


public class Net1414080903215_Collection extends ListActivity {
    private Net1414080903215_DBHelper dbHelper;
    private ArrayList<Animal> list=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("收藏夹");
        this.setContentView(R.layout.collection_net1414080903215);
        setAdapter();
    }
       private void setAdapter() {
        dbHelper=new Net1414080903215_DBHelper(Net1414080903215_Collection.this, "saveidiom.db", null, 1);
        list=dbHelper.QueryAllAttentionWord();
        ArrayList<String> showlist=new ArrayList<String>();
        for(int i=0;i<list.size();i++){
            showlist.add((i+1)+"."+list.get(i).getName()+"\n"+list.get(i).getPronounce()+"\n"+list.get(i).getAntonym()+"\n"
                    +list.get(i).getHomoionym()+"\n"+list.get(i).getDerivation()+"\n"+list.get(i).getExamples()+"\n"+list.get(i).getExplain());
        }
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.animal_item_net1414080903215, showlist));
    }
 @Override
         protected void onListItemClick(ListView l, View v, final int position, long id) {
        super.onListItemClick(l, v, position, id);
        Dialog dialog = new AlertDialog.Builder(Net1414080903215_Collection.this)
                .setTitle("操作")
                .setItems(new String[]{"成语删除"}, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Animal word = list.get(position);
                        Net1414080903215_DBHelper md = new Net1414080903215_DBHelper(Net1414080903215_Collection.this, "saveidiom.db", null, 1);
                        md.deleteAttentionWord(word.getId());
                        setAdapter();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
                    }
                })
                .create();
        dialog.show();
    }

}
