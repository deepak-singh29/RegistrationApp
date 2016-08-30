package com.example.registrationapp;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.RawRes;
import android.util.Log;

public class MusicService extends Service{
	MediaPlayer mPlayer = new MediaPlayer();
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	   public int onStartCommand(Intent intent, int flags, int startId) {
	      // Let it continue running until it is stopped.
	      Log.i("MusicService", "MusicService started");
	      mPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music);
	      mPlayer.start();
	      return START_STICKY;
	   }
	   
	   @Override
	   public void onDestroy() {
	      super.onDestroy();
	      mPlayer.stop();
	      Log.i("MusicService", "MusicService destroyed");
	   }

}
