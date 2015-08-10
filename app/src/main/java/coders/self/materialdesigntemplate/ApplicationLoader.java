package coders.self.materialdesigntemplate;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.orm.SugarApp;

import coders.self.materialdesigntemplate.services.blur.BlurService;
import coders.self.materialdesigntemplate.services.blur.algorithms.BoxBlur;
import coders.self.materialdesigntemplate.services.blur.algorithms.GaussianFastBlur;
import coders.self.materialdesigntemplate.services.blur.algorithms.StackBlur;

/**
 * Created by Carlos Bedoy on 8/10/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 */
public class ApplicationLoader extends SugarApp
{
    public static volatile LayoutInflater MAIN_LAYOUT_INFLATER;
    public static volatile Context MAIN_CONTEXT;
    public static volatile Handler MAIN_HANDLER;
    public static volatile int WIDTH_SCREEN;
    public static volatile int HEIGHT_SCREEN;

    @Override
    public void onCreate() {
        super.onCreate();

        MAIN_CONTEXT = getApplicationContext();

        MAIN_LAYOUT_INFLATER = (LayoutInflater) MAIN_CONTEXT.getSystemService(LAYOUT_INFLATER_SERVICE);

        MAIN_HANDLER = new Handler(getMainLooper());


        WindowManager wm = (WindowManager) MAIN_CONTEXT.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        WIDTH_SCREEN = size.x;

        HEIGHT_SCREEN = size.y;


        BlurService.getInstance().attachBlurService(StackBlur.class);
        BlurService.getInstance().attachBlurService(GaussianFastBlur.class);
        BlurService.getInstance().attachBlurService(BoxBlur.class);

    }



}
