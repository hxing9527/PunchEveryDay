package hxing.com.puncheveryday.lbs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hxing.com.puncheveryday.R;
import hxing.com.puncheveryday.base.BaseFragment;

public class LbsfucFragment extends BaseFragment {

    public static LbsfucFragment newInstance(){
        return new LbsfucFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_lbs,container,false);
        return view;
    }
}
