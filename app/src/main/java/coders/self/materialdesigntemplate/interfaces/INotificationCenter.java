package coders.self.materialdesigntemplate.interfaces;

/**
 * Created by Carlos Bedoy on 8/10/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 */
public interface INotificationCenter
{
    void postNotification(Integer type, Object... notification);

    void addListener(Integer type, INotificationListener listener);

    void removeListener(Integer type, INotificationListener listener);

    interface INotificationListener {

        void didReceivedNotification(Integer type, Object... args);

    }
}
