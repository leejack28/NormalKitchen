package com.example.lijie.kitchen.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lijie.kitchen.NetWork.HttpUtil;
import com.example.lijie.kitchen.R;
import com.example.lijie.kitchen.db.CookMenu;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Created by Administrator on 2017-02-21.
 */

public class CookBookAdapter extends RecyclerView.Adapter<CookBookAdapter.ViewHolder> {

    private List<CookMenu> mCookMenuList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvCookBook;
        ImageView ivCookBook;
        public ViewHolder(View view) {
            super(view);
            tvCookBook = (TextView) view.findViewById(R.id.tv_cookbookitem);
            ivCookBook = (ImageView) view.findViewById(R.id.iv_cookbookitem);
        }
    }

    public CookBookAdapter(List<CookMenu> mCookMenuList) {
        this.mCookMenuList = mCookMenuList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cookbookitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        CookMenu cookMenu = mCookMenuList.get(position);
        String text = cookMenu.getTitle().trim();
        if (text.startsWith("家常菜")){
            text = text.substring(4);
        }
        holder.tvCookBook.setText(text);
        String imageUrl = cookMenu.getAlbums().get(0);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Bitmap bm = (Bitmap)msg.obj;
                holder.ivCookBook.setImageBitmap(bm);
            }
        };
        HttpUtil.sendOkHttpRequest(imageUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = response.body().byteStream();
                Bitmap bm = BitmapFactory.decodeStream(is);
                Message message = new Message();
                message.obj = bm;
                handler.sendMessage(message);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mCookMenuList.size();
    }


}
