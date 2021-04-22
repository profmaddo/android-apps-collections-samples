package foo.appversion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getAppVersion() {

        String appVersion = "V.00";

        try {
            PackageInfo pInfo = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
            appVersion = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return appVersion;

    }

    @SuppressLint("SetTextI18n")
    public void showAppVersion(View view) {

        TextView txtAppVersion = findViewById(R.id.txtAppVersion);
        txtAppVersion.setText(getResources().getText(R.string.app_name)+" "+getAppVersion());

    }


}