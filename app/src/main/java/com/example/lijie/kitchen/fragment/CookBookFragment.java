package com.example.lijie.kitchen.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lijie.kitchen.R;
import com.example.lijie.kitchen.SearchResultActivity;
import com.mancj.materialsearchbar.MaterialSearchBar;

/**
 * Created by Administrator on 2017-02-23.
 */

public class CookBookFragment extends Fragment {
    private MaterialSearchBar searchBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cookbookfragment,null);
        searchBar = (MaterialSearchBar) view.findViewById(R.id.searchBar);

        searchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
            }
            @Override
            public void onSearchConfirmed(CharSequence text) {
                String content = text.toString().trim();
                Intent intent = new Intent(getActivity(), SearchResultActivity.class);
                intent.putExtra("searchcontent",content);
                startActivity(intent);
            }

            @Override
            public void onButtonClicked(int buttonCode) {
            }
        });
        return view;
    }
}
