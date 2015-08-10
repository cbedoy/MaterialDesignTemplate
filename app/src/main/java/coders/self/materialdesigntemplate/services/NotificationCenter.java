package coders.self.materialdesigntemplate.services;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.HashMap;

import coders.self.materialdesigntemplate.interfaces.INotificationCenter;

/**
 * Created by Carlos Bedoy on 8/10/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 */
public class NotificationCenter
{

    private final HashMap<Integer, ArrayList<INotificationCenter.INotificationListener>> mListeners;

    private static NotificationCenter instance;


    public static NotificationCenter getInstance(){
        if (instance == null)
            instance = new NotificationCenter();
        return instance;
    }

    @SuppressLint("UseSparseArrays")
    private NotificationCenter() {
        mListeners = new HashMap<>();
    }

    public void addListener(Integer type, INotificationCenter.INotificationListener listener) {
        synchronized (mListeners) {
            ArrayList<INotificationCenter.INotificationListener> listeners = mListeners.get(type);
            if (listeners == null) {
                listeners = new ArrayList<>();
            }

            if (!listeners.contains(listener)) {
                listeners.add(listener);
            }

            mListeners.put(type, listeners);
        }
    }

    public void removeListener(Integer type, INotificationCenter.INotificationListener listener) {
        synchronized (mListeners) {
            ArrayList<INotificationCenter.INotificationListener> listeners = mListeners.get(type);
            if (listeners != null && listeners.contains(listener)) {
                listeners.remove(listener);
            }

            if (listeners != null && listeners.size() > 0) {
                mListeners.put(type, listeners);
            } else {
                mListeners.remove(type);
            }
        }
    }

    public void postNotification(Integer type, Object... notification) {
        synchronized (mListeners) {
            ArrayList<INotificationCenter.INotificationListener> listeners = mListeners.get(type);
            if (listeners != null && listeners.size() > 0) {
                for (INotificationCenter.INotificationListener listener : listeners) {
                    listener.didReceivedNotification(type, notification);
                }
            }
        }
    }
}
