package com.example.sargis.schat.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sargis.schat.R;
import com.example.sargis.schat.models.WelcomeModel;

import java.util.List;

public class WelcomePagerAdapter extends PagerAdapter {
    private List<WelcomeModel> list;
    private Context context;

    public WelcomePagerAdapter(Context context, List<WelcomeModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        final LayoutInflater layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        final View view = layoutInflater.inflate(R.layout.welcome_item, container, false);
        final ImageView welcomeImg = view.findViewById(R.id.welcome_img);
        final TextView wlcomeTxt = view.findViewById(R.id.welcome_txt);
        final WelcomeModel welcomeModel = list.get(position);
        welcomeImg.setImageResource(welcomeModel.getImageId());
        wlcomeTxt.setText(welcomeModel.getTitle());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
