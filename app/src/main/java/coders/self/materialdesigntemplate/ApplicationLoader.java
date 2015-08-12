package coders.self.materialdesigntemplate;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.orm.SugarApp;

import java.util.ArrayList;
import java.util.Collections;

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
    public static volatile ArrayList<Object> RANDOM_COLORS;
    public static volatile ArrayList<Object> RANDOM_WALLPAPERS;

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



        Resources resources  = getResources();

        RANDOM_COLORS = new ArrayList<>();

        RANDOM_COLORS.add(resources.getColor(R.color.Color1));
        RANDOM_COLORS.add(resources.getColor(R.color.Color2));
        RANDOM_COLORS.add(resources.getColor(R.color.Color3));
        RANDOM_COLORS.add(resources.getColor(R.color.Color4));
        RANDOM_COLORS.add(resources.getColor(R.color.Color5));
        RANDOM_COLORS.add(resources.getColor(R.color.Color6));
        RANDOM_COLORS.add(resources.getColor(R.color.Color7));
        RANDOM_COLORS.add(resources.getColor(R.color.Color8));
        RANDOM_COLORS.add(resources.getColor(R.color.Color9));
        RANDOM_COLORS.add(resources.getColor(R.color.Color10));
        RANDOM_COLORS.add(resources.getColor(R.color.Color11));
        RANDOM_COLORS.add(resources.getColor(R.color.Color12));
        RANDOM_COLORS.add(resources.getColor(R.color.Color13));
        RANDOM_COLORS.add(resources.getColor(R.color.Color14));
        RANDOM_COLORS.add(resources.getColor(R.color.Color15));
        RANDOM_COLORS.add(resources.getColor(R.color.Color16));
        RANDOM_COLORS.add(resources.getColor(R.color.Color17));
        RANDOM_COLORS.add(resources.getColor(R.color.Color18));

        Collections.shuffle(RANDOM_COLORS);


        RANDOM_WALLPAPERS = new ArrayList<>();

        RANDOM_WALLPAPERS.add(R.drawable.wallpaper_01);
        RANDOM_WALLPAPERS.add(R.drawable.wallpaper_02);
        RANDOM_WALLPAPERS.add(R.drawable.wallpaper_03);
        RANDOM_WALLPAPERS.add(R.drawable.wallpaper_04);
        RANDOM_WALLPAPERS.add(R.drawable.wallpaper_05);
        RANDOM_WALLPAPERS.add(R.drawable.wallpaper_06);
        RANDOM_WALLPAPERS.add(R.drawable.wallpaper_07);

        Collections.shuffle(RANDOM_WALLPAPERS);
    }



}
