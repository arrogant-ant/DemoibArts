package inc.iris.demoibarts;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NotificationScreen extends AppCompatActivity {

EditText title,body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_screen);
        title=findViewById(R.id.noti_title);
        body=findViewById(R.id.noti_body);
    }

    public void showNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        Intent home_intent= new Intent(this,MainActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,home_intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setAutoCancel(true)
                .setContentTitle(title.getText().toString())
                .setContentText(body.getText().toString())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent);
        NotificationManager managerCompat= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        managerCompat.notify(1221,builder.build());



    }
}
