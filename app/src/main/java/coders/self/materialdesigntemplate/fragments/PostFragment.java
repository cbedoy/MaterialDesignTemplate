package coders.self.materialdesigntemplate.fragments;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import coders.self.materialdesigntemplate.R;
import coders.self.materialdesigntemplate.adapters.PostAdapter;
import coders.self.materialdesigntemplate.items.PostItem;

/**
 * Created by Carlos Bedoy on 8/6/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 * <p/>
 * Pademobile
 */
public class PostFragment extends Fragment
{
    private List<Integer> mRandomColors;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_fragment, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);

        floatingActionButton.attachToListView(listView);

        List<PostItem> postItemList = new ArrayList<>();

        Resources resources = getActivity().getResources();
        String loremString = resources.getString(R.string.Lorem);

        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar, "Carlos Bedoy", loremString, getRandomColor()));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_eigth, "Zabdiel Sue", loremString, getRandomColor()));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_five, "David Israel", loremString, getRandomColor()));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_four, "Alejandra Oregel", loremString, getRandomColor()));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_one, "Edna Jett", loremString, getRandomColor()));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_seven, "Alejandra Garcia", loremString, getRandomColor()));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_six, "Paulina Musí", loremString, getRandomColor()));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_three, "Jesus Cagide", loremString, getRandomColor()));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_two, "David Angel", loremString, getRandomColor()));

        Collections.shuffle(postItemList);


        listView.setAdapter(new PostAdapter(getActivity(), inflater, postItemList));

        return view;
    }

    public int getRandomColor(){
        if (mRandomColors == null){

            Resources resources = getActivity().getResources();

            mRandomColors = new ArrayList<>();

            mRandomColors.add(resources.getColor(R.color.Color1));
            mRandomColors.add(resources.getColor(R.color.Color2));
            mRandomColors.add(resources.getColor(R.color.Color3));
            mRandomColors.add(resources.getColor(R.color.Color4));
            mRandomColors.add(resources.getColor(R.color.Color5));
            mRandomColors.add(resources.getColor(R.color.Color6));
            mRandomColors.add(resources.getColor(R.color.Color7));
            mRandomColors.add(resources.getColor(R.color.Color8));
            mRandomColors.add(resources.getColor(R.color.Color9));
            mRandomColors.add(resources.getColor(R.color.Color10));
            mRandomColors.add(resources.getColor(R.color.Color11));
            mRandomColors.add(resources.getColor(R.color.Color12));
            mRandomColors.add(resources.getColor(R.color.Color13));
            mRandomColors.add(resources.getColor(R.color.Color14));
            mRandomColors.add(resources.getColor(R.color.Color15));
            mRandomColors.add(resources.getColor(R.color.Color16));
            mRandomColors.add(resources.getColor(R.color.Color17));
            mRandomColors.add(resources.getColor(R.color.Color18));
        }

        Collections.shuffle(mRandomColors);

        return mRandomColors.get(0);
    }
}