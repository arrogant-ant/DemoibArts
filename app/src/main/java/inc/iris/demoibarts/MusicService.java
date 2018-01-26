package inc.iris.demoibarts;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Sud on 1/20/18.
 */

public class MusicService extends IntentService {
    public MusicService() {
        super("MusicService");

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        MediaPlayer player;
        player = MediaPlayer.create(getApplicationContext(), R.raw.tone1);
        player.start();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }
}
