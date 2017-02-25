package com.example.lijie.kitchen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lijie.kitchen.Consts.UrlMaker;
import com.example.lijie.kitchen.NetWork.HttpUtil;
import com.example.lijie.kitchen.adapter.CookBookAdapter;
import com.example.lijie.kitchen.db.CookMenu;
import com.example.lijie.kitchen.db.JsonBean;
import com.example.lijie.kitchen.db.ResultBean;
import com.google.gson.Gson;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchResultActivity extends AppCompatActivity {
    private MaterialSearchBar searchResulltBar;
    private List<CookMenu> mCookMenus;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        mRecyclerView = (RecyclerView) findViewById(R.id.search_result_recyview);
        searchResulltBar = (MaterialSearchBar) findViewById(R.id.searchBarResult);
        Intent intent = getIntent();
        String data = intent.getStringExtra("searchcontent");
        searchResulltBar.setText(data);
        Log.d("Lijieldfi",data);
        String searchurl = UrlMaker.getSearchurl(data,0,10);
        Log.d("李杰",searchurl);

        HttpUtil.sendOkHttpRequest(searchurl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                Log.d("胡建美",responseText);
                Gson gson = new Gson();
                JsonBean jsonBean = gson.fromJson(responseText,JsonBean.class);
                ResultBean resultBean = jsonBean.getResult();
                mCookMenus = resultBean.getData();
                Log.d("李岩松",mCookMenus.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        CookBookAdapter adapter = new CookBookAdapter(mCookMenus);
                        mRecyclerView.setAdapter(adapter);
                    }
                });

            }
        });
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
    }
}
