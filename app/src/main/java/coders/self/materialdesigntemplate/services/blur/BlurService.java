package coders.self.materialdesigntemplate.services.blur;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import coders.self.materialdesigntemplate.ApplicationLoader;
import coders.self.materialdesigntemplate.interfaces.IBlur;

/**
 * Created by Carlos Bedoy on 8/10/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 */
public class BlurService
{

    public static String TAG = BlurService.class.getSimpleName();

    private List<IBlur> mBlurServiceList;

    private static BlurService instance;

    public static BlurService getInstance(){
        if (instance == null)
            instance = new BlurService();
        return instance;
    }

    private BlurService(){
        mBlurServiceList = new ArrayList<>();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void attachBlurService(Class nameOfService)
    {
        try {
            Object o = nameOfService.newInstance();

            if (o instanceof IBlur)
            {
                mBlurServiceList.add((IBlur) o);
            }

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private IBlur getBlurFromClass(Class nameOfClass)
    {
        for (IBlur blur : mBlurServiceList){
            if (blur.getClass() == nameOfClass)
                return blur;
        }
        return null;
    }

    public Bitmap performBlurFromBitmapWithRadiusAndClassOfAlgorithm(Bitmap original, int radius, Class algoithm)
    {

        Log.e(TAG, "Start to blur the image");

        long startTime = System.nanoTime();

        float MAX_IMAGE_WIDTH = (float) (ApplicationLoader.WIDTH_SCREEN * .75);

        if (original.getWidth() > MAX_IMAGE_WIDTH){
            Bitmap scaleDownBitmap = scaleDown(original, MAX_IMAGE_WIDTH, true);

            if (!original.isRecycled()){
                original.recycle();
            }
            original = scaleDownBitmap;
        }

        IBlur blur = getBlurFromClass(algoithm);

        if (blur == null)
        {
            return original;
        }
        else
        {

            original = blur.onBlurBitmap(radius, original);

            long endTime = System.nanoTime();

            long duration = (endTime - startTime);

            Log.e(TAG, "Finished bluring");

            Log.e(TAG, "Image has blured on " + duration/1000000 + " miliseconds");

            return original;
        }
    }


    private Bitmap scaleDown(Bitmap realImage, float maxImageSize, boolean filter)
    {
        float ratio = Math.min(maxImageSize / realImage.getWidth(), maxImageSize / realImage.getHeight());

        int width = Math.round(ratio * realImage.getWidth());

        int height = Math.round(ratio * realImage.getHeight());

        return Bitmap.createScaledBitmap(realImage, width,  height, filter);
    }
}
