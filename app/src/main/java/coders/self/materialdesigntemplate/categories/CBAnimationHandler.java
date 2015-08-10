package coders.self.materialdesigntemplate.categories;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by Carlos Bedoy on 8/10/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 */
public class CBAnimationHandler
{
    public static void doInAlphaAnimationWithDurantionListenerAndView(int duration, Animation.AnimationListener listener, View view)
    {
        Animation animation = createAlphaAnimationWithDurationAndListener(duration, listener, true);
        view.startAnimation(animation);
    }

    public static void doOutAlphaAnimationWithDurantionListenerAndView(int duration, Animation.AnimationListener listener, View view)
    {
        Animation animation = createAlphaAnimationWithDurationAndListener(duration, listener, false);
        view.startAnimation(animation);
    }

    private static Animation createAlphaAnimationWithDurationAndListener(int duration, Animation.AnimationListener listener, boolean isIn)
    {
        Animation animation = new AlphaAnimation(isIn ? 0.0f : 1.0f, isIn ? 1.0f : 0.0f);
        animation.setDuration(duration);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setAnimationListener(listener);
        return animation;
    }
}
