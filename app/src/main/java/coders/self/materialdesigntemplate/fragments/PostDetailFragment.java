package coders.self.materialdesigntemplate.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import coders.self.materialdesigntemplate.ApplicationLoader;
import coders.self.materialdesigntemplate.activity.MainActivity;
import coders.self.materialdesigntemplate.R;
import coders.self.materialdesigntemplate.items.BiographyItem;
import coders.self.materialdesigntemplate.items.PostItem;
import coders.self.materialdesigntemplate.services.blur.BlurService;
import coders.self.materialdesigntemplate.services.blur.algorithms.StackBlur;

/**
 * Created by Carlos Bedoy on 8/7/15.
 *
 * Mobile App Developer - MaterialDesignTemplate
 */
public class PostDetailFragment extends Fragment
{

    private PostItem postItem;




    private TextView name;
    private TextView content;
    private ImageView avatar;
    private ViewGroup rootView;
    private View overlay;
    private ImageView background;
    private FloatingActionButton floatingActionButton;

    public void setPostItem(PostItem postItem) {
        this.postItem = postItem;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_detail_fragment, container, false);

        name = (TextView) view.findViewById(R.id.name);
        content = (TextView) view.findViewById(R.id.content);
        avatar = (ImageView) view.findViewById(R.id.avatar);
        overlay = view.findViewById(R.id.overlay);
        background = (ImageView) view.findViewById(R.id.background);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        rootView = (ViewGroup) view;

        name.setText(postItem.getTitle());
        content.setText(postItem.getDescription());
        avatar.setImageResource(postItem.getImageResource());

        int position = (int) (Calendar.getInstance().getTimeInMillis() % 7);

        final int randomResource = (int) ApplicationLoader.RANDOM_WALLPAPERS.get(position);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), randomResource);

        if (bm != null)
        {
            Bitmap bitmap = BlurService.getInstance().performBlurFromBitmapWithRadiusAndClassOfAlgorithm(bm, 30, StackBlur.class);

            background.setImageBitmap(bitmap);
        }



        floatingActionButton.setColorNormal(postItem.getColor());
        floatingActionButton.setColorPressed(postItem.getColor());
        floatingActionButton.setColorRipple(postItem.getColor());

        if(getActivity() instanceof MainActivity){

            MainActivity mainActivity = (MainActivity) getActivity();

            ActionBar actionBar = mainActivity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setBackgroundDrawable(new ColorDrawable(postItem.getColor()));
            }


            int color = postItem.getColor();

            String newColor = "#"+Integer.toHexString(color & 0xCCffffff);

            overlay.setBackgroundColor(Color.parseColor(newColor));
        }


        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() instanceof MainActivity) {

                    MainActivity activity = (MainActivity) getActivity();

                    String mockEmail = postItem.getTitle().trim();

                    List<PostItem> postItemList = new ArrayList<>();

                    BiographyItem  biographyItem = new BiographyItem(postItem.getTitle(), mockEmail+"@gmail.com", postItem.getImageResource(), randomResource, postItemList);
                    biographyItem.setColor(postItem.getColor());


                    BiographyFragment biographyFragment = new BiographyFragment();

                    biographyFragment.setBiographyItem(biographyItem);

                    activity.presentFragment(biographyFragment);
                }
            }
        });

        return view;
    }

}
