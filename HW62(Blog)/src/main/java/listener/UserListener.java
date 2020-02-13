package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserListener implements HttpSessionListener {
    public static int count;

    public static int getCount() {
        return count;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;
    }
}
