package edu.hzuapps.androidlabs.homeworks.net1414080903215;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.List;

import android.widget.AdapterView.OnItemClickListener;

import edu.hzuapps.androidlabs.homeworks.net1414080903215.adapter.Animal;
import edu.hzuapps.androidlabs.homeworks.net1414080903215.adapter.AnimalAdapter;

public class Net1414080903215_Study extends Activity{
    private List<Animal> animalList;
    private Net1414080903215_StudyDao animalDao;
    private ListView lvAnimalList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_net1414080903215);
        initAnimals();
        lvAnimalList=(ListView)findViewById(R.id.lvAnimalList);
        AnimalAdapter animalAdapter=new AnimalAdapter(this,R.layout.animal_item_net1414080903215,animalList);
        lvAnimalList.setAdapter(animalAdapter);
        lvAnimalList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,long id) {
                Animal animal=animalList.get(position);
				/*定义对话框中提示语句*/
                String result=animal.getName()+"\n"+
                        animal.getPronounce()+
                        "\n【解释】："+animal.getExplain()+
                        "\n【近义词】："+animal.getHomoionym()+
                        "\n【反义词】："+animal.getAntonym()+
                        "\n【来源】："+animal.getDerivation()+
                        "\n【示例】："+animal.getExamples();
                final AlertDialog.Builder dialog=new AlertDialog.Builder(Net1414080903215_Study.this);
                dialog.setMessage(result);
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.show();
            }
        });
    }
    /*获取成语数据*/
    private void initAnimals() {
        animalDao= Net1414080903215_StudyDao.getInstance(this);
        animalList=animalDao.getAllAnimals();
    }
}
