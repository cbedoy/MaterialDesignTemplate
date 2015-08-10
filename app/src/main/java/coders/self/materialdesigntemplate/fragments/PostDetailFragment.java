package coders.self.materialdesigntemplate.fragments;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import coders.self.materialdesigntemplate.activity.MainActivity;
import coders.self.materialdesigntemplate.R;
import coders.self.materialdesigntemplate.items.PostItem;

/**
 * Created by Carlos Bedoy on 8/7/15.
 *
 * Mobile App Developer - MaterialDesignTemplate
 */
public class PostDetailFragment extends Fragment
{

    private PostItem postItem;

    private TextView date;
    private TextView name;
    private TextView content;
    private ImageView avatar;
    private ViewGroup rootView;
    private FloatingActionButton floatingActionButton;

    public void setPostItem(PostItem postItem) {
        this.postItem = postItem;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_detail_fragment, container, false);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss ");
        String format = dateFormat.format(postItem.getDate());


        date = (TextView) view.findViewById(R.id.date);
        name = (TextView) view.findViewById(R.id.title);
        content = (TextView) view.findViewById(R.id.content);
        avatar = (ImageView) view.findViewById(R.id.avatar);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        rootView = (ViewGroup) view;

        date.setText(format);
        name.setText(postItem.getTitle());
        content.setText(postItem.getDescription());
        avatar.setImageResource(postItem.getImageResource());

        date.setBackgroundColor(postItem.getColor());

        floatingActionButton.setColorNormal(postItem.getColor());
        floatingActionButton.setColorPressed(postItem.getColor());
        floatingActionButton.setColorRipple(postItem.getColor());

        if(getActivity() instanceof MainActivity){

            MainActivity mainActivity = (MainActivity) getActivity();

            ActionBar actionBar = mainActivity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setBackgroundDrawable(new ColorDrawable(postItem.getColor()));
            }
        }

        return view;
    }

}
