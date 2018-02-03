package inc.iris.demoibarts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gridExample(View view) {
        startActivity(new Intent(this, GridExample.class));
    }

    public void gesture(View view) {
        startActivity(new Intent(this, Gesture.class));

    }

    public void memeGenerator(View view) {
        startActivity(new Intent(this, MemeGenerator.class));

    }

    public void animation(View view) {
        startActivity(new Intent(this, Animation.class));
    }

    public void broadcast(View view) {
        startActivity(new Intent(this, BroadcastActivity.class));
    }

    public void handler(View view) {
        startActivity(new Intent(this, HandlerEx.class));
    }

    public void service(View view) {
        startService(new Intent(this, MusicService.class));
        Toast.makeText(this, "Tone started on a service", Toast.LENGTH_SHORT).show();
    }

    public void getEmpList(View view) {
        startActivity(new Intent(this, EmployeeList.class));
    }

    public void getNotification(View view) {
        startActivity(new Intent(this, NotificationScreen.class));
    }

    public void invertImage(View view) {
        startActivity(new Intent(this, InvertImage.class));
    }

}
