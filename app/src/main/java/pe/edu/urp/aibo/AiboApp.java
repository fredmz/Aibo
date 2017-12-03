package pe.edu.urp.aibo;

import com.orm.SugarApp;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class AiboApp extends SugarApp {
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
    }
}
