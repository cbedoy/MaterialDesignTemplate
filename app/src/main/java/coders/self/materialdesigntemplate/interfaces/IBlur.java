package coders.self.materialdesigntemplate.interfaces;

import android.graphics.Bitmap;

/**
 * Created by Carlos Bedoy on 8/10/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 */
public interface IBlur
{
    Bitmap onBlurBitmap(int radius, Bitmap bitmap);
}
