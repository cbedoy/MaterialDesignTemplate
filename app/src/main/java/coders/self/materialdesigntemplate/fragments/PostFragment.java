package coders.self.materialdesigntemplate.fragments;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import coders.self.materialdesigntemplate.ApplicationLoader;
import coders.self.materialdesigntemplate.activity.MainActivity;
import coders.self.materialdesigntemplate.R;
import coders.self.materialdesigntemplate.adapters.PostAdapter;
import coders.self.materialdesigntemplate.items.PostItem;

/**
 * Created by Carlos Bedoy on 8/6/15.
 *
 * Mobile App Developer - MaterialDesignTemplate
 */
public class PostFragment extends Fragment
{

    private List<PostItem> postItemList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_fragment, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);

        floatingActionButton.attachToListView(listView);

        postItemList = new ArrayList<>();

        Resources resources = getActivity().getResources();
        String loremString = resources.getString(R.string.Lorem);

        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar, "Carlos Bedoy", loremString, getRandomColor(0)));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_eigth, "Zabdiel Sue", loremString, getRandomColor(1)));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_five, "David Israel", loremString, getRandomColor(2)));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_four, "Alejandra Oregel", loremString, getRandomColor(3)));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_one, "Edna Jett", loremString, getRandomColor(4)));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_seven, "Alejandra Garcia", loremString, getRandomColor(5)));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_six, "Paulina Musí", loremString, getRandomColor(6)));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_three, "Jesus Cagide", loremString, getRandomColor(7)));
        postItemList.add(new PostItem(Calendar.getInstance().getTime(), R.drawable.avatar_two, "David Angel", loremString, getRandomColor(8)));

        Collections.shuffle(postItemList);


        listView.setAdapter(new PostAdapter(getActivity(), inflater, postItemList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (getActivity() instanceof MainActivity) {

                    MainActivity activity = (MainActivity) getActivity();

                    PostItem postItem = postItemList.get(i);

                    PostDetailFragment detailFragment = new PostDetailFragment();
                    detailFragment.setPostItem(postItem);

                    activity.presentFragment(detailFragment);
                }
            }
        });

        if(getActivity() instanceof MainActivity){

            MainActivity mainActivity = (MainActivity) getActivity();

            ActionBar actionBar = mainActivity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.ColorPrimary)));
            }
        }

        return view;
    }

    public int getRandomColor(int position){

        return (int) ApplicationLoader.RANDOM_COLORS.get(position);

    }
}
