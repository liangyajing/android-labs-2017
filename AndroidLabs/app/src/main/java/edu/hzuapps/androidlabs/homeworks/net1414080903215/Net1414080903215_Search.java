package edu.hzuapps.androidlabs.homeworks.net1414080903215;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by acer on 2018/4/27.
 */

public class Net1414080903215_Search extends Activity {
    private EditText search_edit;
    private Button search;
    private WebView myWebView1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_net1414080903215);
        search_edit=(EditText) findViewById(R.id.search_edit);
        search=(Button) findViewById(R.id.search);
        myWebView1=(WebView) findViewById(R.id.myWebView1);
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String strURI = (search_edit.getText().toString());
                strURI = strURI.trim();
                if(strURI.length()==0)
                {
                    Toast.makeText(Net1414080903215_Search.this, "查询内容不能为空！", Toast.LENGTH_LONG).show();
                }
                else
                {
                    String strURL = "http://xh.5156edu.com/m/search_net1414080903215?keyfrom=dict.mindex&q="+strURI;
                    myWebView1.loadUrl(strURL);
                }
            }
        });

    }

}

