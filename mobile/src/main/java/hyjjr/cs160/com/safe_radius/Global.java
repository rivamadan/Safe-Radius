package hyjjr.cs160.com.safe_radius;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.android.gms.maps.model.LatLng;

import java.util.TreeMap;

/**
 * Created by main on 7/31/15.
 */
public class Global extends Application {

    public static final String TOPIC = "userTesting";
    private boolean power;
    private String[] messages;
    private int safeRadiusSelected;
    private int messageSelected;
    private Bitmap parentPicture;
    private Bitmap bckgrdPicture;
    private boolean isForeground;
    private LatLng childLatLng;
    private Double childAltitude;
    private String[] radii;
    private TreeMap<String, MyGcmListenerService.ByteArray> pendingResults; // <id, message>
    private boolean receivedMessageFromWearInInterval;
    private int connectionToWatchStatus;
    private Long sentMessageTime;
    private Long receiveMessageTime;
    private String messageHistory = "";

    public void disconenctToWatch() {
        connectionToWatchStatus = -1;
    }

    public void connectToWatch() {
        connectionToWatchStatus = 1;
    }

    public boolean isDisconnectedToWatch() {
        return connectionToWatchStatus == -1;
    }

    public boolean isConnectedToWatch() {
        return connectionToWatchStatus == 1;
    }

    public boolean isConnectionUndefinedToWatch() {
        return connectionToWatchStatus == 0;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        power = true;
        messages = getResources().getStringArray(R.array.message_choices);
        safeRadiusSelected = 1;
        messageSelected = 0;
        parentPicture = BitmapFactory.decodeResource(getResources(), R.drawable.ic_thumbnail_addyourpic);
        bckgrdPicture = BitmapFactory.decodeResource(getResources(), R.drawable.title_safe_radius);
        radii = getResources().getStringArray(R.array.radius_choices);
        pendingResults = new TreeMap<>();
        receivedMessageFromWearInInterval = true;
        connectionToWatchStatus = 0; // undefined connection
    }


    public boolean isTurnedOn() {
        return power;
    }

    public void turnOn() {
        power = true;
    }

    public void turnOff() {
        power = false;
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public int getSafeRadiusSelected() {
        return safeRadiusSelected;
    }

    public void setSafeRadiusSelected(int safeRadiusSelected) {
        this.safeRadiusSelected = safeRadiusSelected;
    }

    public int getMessageSelected() {
        return messageSelected;
    }

    public void setMessageSelected(int messageSelected) {
        this.messageSelected = messageSelected;
    }

    public double getSafeRadiusInMeter() {
        return Double.valueOf(radii[getSafeRadiusSelected()].
                replaceAll("[^\\d.]", "")) * 0.3048;
    }

    public String getMessage() {
        return messages[getMessageSelected()];
    }

    public Bitmap getParentPicture() {
        return parentPicture;
    }

    public void setParentPicture(Bitmap parentPicture) {
        this.parentPicture = parentPicture;
    }

    public void setBckgrdPicture(Bitmap bckgrdPicture) {
        this.bckgrdPicture = bckgrdPicture;
    }

    public Bitmap getBckgrdPicture() {
        return bckgrdPicture;
    }

    public boolean isForeground() {
        return isForeground;
    }

    public void setForeground(boolean foreground) {
        this.isForeground = foreground;
    }

    public LatLng getChildLatLng() {
        return childLatLng;
    }

    public void setChildLatLng(LatLng childLatLng) {
        this.childLatLng = childLatLng;
    }

    public Double getChildAltitude() {
        return childAltitude;
    }

    public void setChildAltitude(double childAltitude) {
        this.childAltitude = childAltitude;
    }

    public String[] getRadii() {
        return radii;
    }

    public void setRadii(String[] radii) {
        this.radii = radii;
    }

    public String getRadius() {
        return radii[safeRadiusSelected];
    }

    public TreeMap<String, MyGcmListenerService.ByteArray> getPendingResults() {
        return pendingResults;
    }

    public boolean isReceivedMessageFromWearInInterval() {
        return receivedMessageFromWearInInterval;
    }

    public void setReceivedMessageFromWearInInterval(boolean receivedMessageFromWearInInterval) {
        this.receivedMessageFromWearInInterval = receivedMessageFromWearInInterval;
    }

    public Long getSentMessageTime() {
        return sentMessageTime;
    }

    public void setSentMessageTime(Long sentMessageTime) {
        this.sentMessageTime = sentMessageTime;
    }

    public Long getReceiveMessageTime() {
        return receiveMessageTime;
    }

    public void setReceiveMessageTime(Long receiveMessageTime) {
        this.receiveMessageTime = receiveMessageTime;
    }

    public String getMessageHistory() {
        return messageHistory;
    }

    public void setMessageHistory(String messageHistory) {
        this.messageHistory = messageHistory;
    }
}
