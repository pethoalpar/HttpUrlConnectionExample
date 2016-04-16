package com.example.pethoalpar.httprequestexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) this.findViewById(R.id.textView);

        HttpCall httpCall = new HttpCall();
        httpCall.setMethodtype(HttpCall.GET);
        httpCall.setUrl("http://192.168.1.2:8080/JavaEeExample/Example");
        HashMap<String,String> params = new HashMap<>();
        params.put("name","James Bond");
        httpCall.setParams(params);
        new HttpRequest(){
            @Override
            public void onResponse(String response) {
                super.onResponse(response);
                textView.setText("Get:"+response);
            }
        }.execute(httpCall);

        HttpCall httpCallPost = new HttpCall();
        httpCallPost.setMethodtype(HttpCall.POST);
        httpCallPost.setUrl("http://192.168.1.2:8080/JavaEeExample/Example");
        HashMap<String,String> paramsPost = new HashMap<>();
        paramsPost.put("name","Julius Cesar");
        httpCallPost.setParams(paramsPost);
        new HttpRequest(){
            @Override
            public void onResponse(String response) {
                super.onResponse(response);
                textView.setText(textView.getText()+"\nPost:"+response);
            }
        }.execute(httpCallPost);
    }
}
