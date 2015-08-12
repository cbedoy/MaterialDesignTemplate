package coders.self.materialdesigntemplate.fragments;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import coders.self.materialdesigntemplate.ApplicationLoader;
import coders.self.materialdesigntemplate.R;
import coders.self.materialdesigntemplate.adapters.PostAdapter;
import coders.self.materialdesigntemplate.items.BiographyItem;
import coders.self.materialdesigntemplate.items.PostItem;
import coders.self.materialdesigntemplate.services.blur.BlurService;
import coders.self.materialdesigntemplate.services.blur.algorithms.GaussianFastBlur;
import coders.self.materialdesigntemplate.services.blur.algorithms.StackBlur;

/**
 * Created by Carlos Bedoy on 8/10/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 */
public class BiographyFragment extends Fragment
{
    private BiographyItem biographyItem;
    private List<PostItem> postItemList;


    public void setBiographyItem(BiographyItem biographyItem) {
        this.biographyItem = biographyItem;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.biography_fragment, container, false);


        ImageView background = (ImageView) view.findViewById(R.id.background);
        ImageView avatar = (ImageView) view.findViewById(R.id.avatar);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView email = (TextView) view.findViewById(R.id.email);
        View overlay = (View) view.findViewById(R.id.overlay);
        ListView listView = (ListView) view.findViewById(R.id.biography_list_view);


        Bitmap bm = BitmapFactory.decodeResource(getResources(), biographyItem.getBackground());

        if (bm != null)
        {
            Bitmap bitmap = BlurService.getInstance().performBlurFromBitmapWithRadiusAndClassOfAlgorithm(bm, 30, StackBlur.class);

            background.setImageBitmap(bitmap);
        }

        Resources resources = getActivity().getResources();
        String loremString = resources.getString(R.string.Lorem);

        postItemList = new ArrayList<>();

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

        avatar.setImageResource(biographyItem.getAvatar());
        name.setText(biographyItem.getUsername());
        email.setText(biographyItem.getEmail());
        listView.setAdapter(new PostAdapter(getActivity(), inflater, postItemList));

        int color = biographyItem.getColor();

        String newColor = "#"+Integer.toHexString(color & 0xCCffffff);

        overlay.setBackgroundColor(Color.parseColor(newColor));


        return view;
    }

    public int getRandomColor(int position){

        return (int) ApplicationLoader.RANDOM_COLORS.get(position);

    }
}
