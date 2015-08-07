package hyjjr.cs160.com.safe_radius;

        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.media.AudioFormat;
        import android.media.AudioManager;
        import android.media.AudioTrack;
        import android.os.Bundle;

public class AlertActivity extends Activity {

    private static final int RECORDER_SAMPLERATE = 8000;
    private static final int RECORDER_CHANNELS = AudioFormat.CHANNEL_IN_MONO;
    private static final int RECORDER_AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_alert);
    }

    @Override
    protected void onStart() {
        super.onStart();
        CharSequence title = getIntent().getExtras().getCharSequence("title");
        CharSequence text = new String((byte[])getIntent().getExtras().get("text"));
        final byte[] voiceBytes = (byte[])getIntent().getExtras().get("voice");
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(text);
        if (voiceBytes != null) {
            alertDialog.setButton(0, "PLAY",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            AlertActivity.this.finish();
                            AudioTrack at = new AudioTrack(AudioManager.STREAM_NOTIFICATION,
                                    RECORDER_SAMPLERATE, RECORDER_CHANNELS, RECORDER_AUDIO_ENCODING,
                                    voiceBytes.length, AudioTrack.MODE_STATIC);
                            at.play();
                        }
                    });
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DISMISS",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        AlertActivity.this.finish();
                    }
                });
        if (!((Global)getApplication()).isForeground()) {
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "GO TO APP",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            startActivity(new Intent(AlertActivity.this, MainActivity.class));
                            AlertActivity.this.finish();
                        }
                    });
        }
        alertDialog.show();
    }
}

