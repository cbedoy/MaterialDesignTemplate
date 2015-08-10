package coders.self.materialdesigntemplate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import coders.self.materialdesigntemplate.R;
import coders.self.materialdesigntemplate.artifacts.AbstractAdapter;
import coders.self.materialdesigntemplate.categories.CBAnimationHandler;
import coders.self.materialdesigntemplate.items.PostItem;

/**
 * Created by Carlos Bedoy on 8/6/15.
 *
 * Mobile App Developer - MaterialDesignTemplate
 */
public class PostAdapter extends AbstractAdapter<PostItem> {
    public PostAdapter(Context context, LayoutInflater layoutInflater, List<PostItem> dataModel) {
        super(context, layoutInflater, dataModel);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final PostHolder postHolder;
        if (view == null){
            view = getLayoutInflater().inflate(R.layout.post_view_cell, viewGroup, false);

            postHolder = new PostHolder();

            postHolder.avatarView = (ImageView) view.findViewById(R.id.avatar);
            postHolder.dateView = (TextView) view.findViewById(R.id.dateView);
            postHolder.titleView = (TextView) view.findViewById(R.id.titleView);
            postHolder.descriptionView = (TextView) view.findViewById(R.id.descriptionView);
            postHolder.postView = view.findViewById(R.id.postView);

            view.setTag(postHolder);
        }else {
            postHolder = (PostHolder) view.getTag();
        }

        PostItem postItem = getDataModel().get(i);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss ");
        String format = dateFormat.format(postItem.getDate());


        postHolder.titleView.setText(postItem.getTitle());
        postHolder.dateView.setText(format);
        postHolder.descriptionView.setText(postItem.getDescription());
        postHolder.avatarView.setImageResource(postItem.getImageResource());

        postHolder.dateView.setBackgroundColor(postItem.getColor());


        CBAnimationHandler.doInAlphaAnimationWithDurantionListenerAndView(350, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                postHolder.postView.setVisibility(View.INVISIBLE);


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                postHolder.postView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        }, postHolder.postView);


        return view;
    }

    private class PostHolder{
        View postView;
        ImageView avatarView;
        TextView titleView;
        TextView descriptionView;
        TextView dateView;
    }
}
