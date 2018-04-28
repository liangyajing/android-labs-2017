package edu.hzuapps.androidlabs.homeworks.net1414080903215;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Net1414080903215Activity extends TabActivity {
private TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903215);
        tabHost=getTabHost();
              addTab("study",R.string.title_study,Net1414080903215_SelectCategory.class);
              addTab("search_net1414080903215",R.string.title_search,Net1414080903215_Search.class);
              addTab("save",R.string.title_save,Net1414080903215_Collection.class);
 }
    private void addTab(String tag,int title_introduction,Class ActivityClass) {
        tabHost.addTab(tabHost.newTabSpec(tag).setIndicator(getString(title_introduction)).setContent(new Intent(this,ActivityClass)));
    }
    }

