package edu.hzuapps.androidlabs.homeworks.net1414080903215;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import edu.hzuapps.androidlabs.homeworks.net1414080903215.adapter.Category;
import edu.hzuapps.androidlabs.homeworks.net1414080903215.adapter.CategoryAdapter;


public class Net1414080903215_SelectCategory extends Activity {
    private List<Category> categoryList;
    private String[] category_names;
    private int[] category_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcategory_net1414080903215);
        initCategories();
        CategoryAdapter adapter=new CategoryAdapter(this,R.layout.category_item_net1414080903215,categoryList);
        ListView listView=(ListView) findViewById(R.id.lvCategories);
        listView.setAdapter(adapter);//绑定适配器
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long id) {
                switch (position) {//position为0代表动物类
                    case 0:
                        Intent intent=new Intent(Net1414080903215_SelectCategory.this,Net1414080903215_Study.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }
    private void initCategories() {
        categoryList = new ArrayList<Category>();
        Resources resources = getResources();
		/*获取数据源*/
        category_names = resources.getStringArray(R.array.category);
        category_images = new int[] { R.drawable.category_animal,
                R.drawable.category_nature, R.drawable.category_human,
                R.drawable.category_season, R.drawable.category_number,
                R.drawable.category_fable, R.drawable.category_other };
        for(int i=0;i<category_names.length;i++){
            categoryList.add(new Category(category_names[i],category_images[i]));
        }
    }
}
