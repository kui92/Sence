package com.huami.sence;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/**
 * Created by zbk on 2019/11/5.
 */

public class NormalActivity extends FragmentActivity implements OnClickListener{

    private ViewGroup root;
    private Scene scene1,scene2;
    private boolean isScene2 = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_root);
        root = findViewById(R.id.root);
        findViewById(R.id.start).setOnClickListener(this);
        scene1=Scene.getSceneForLayout(root,R.layout.sence1,this);
        scene2=Scene.getSceneForLayout(root,R.layout.sence2,this);
        TransitionManager.go(scene1);
    }

    @Override
    public void onClick(View v) {
        TransitionManager.go(isScene2?scene1:scene2,new ChangeBounds());
        isScene2=!isScene2;
    }
}
