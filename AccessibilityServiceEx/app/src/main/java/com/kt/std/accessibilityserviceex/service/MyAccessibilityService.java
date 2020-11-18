package com.kt.std.accessibilityserviceex.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;
import com.kt.std.accessibilityserviceex.MainActivity;
import java.util.List;

public class MyAccessibilityService extends AccessibilityService {
    public static int COUNT;
    private static final String TAG = "ACTag";

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        setServiceInfo(info);

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
        if (launchIntent != null) {
            launchIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(launchIntent);
        } else {
            Toast.makeText(this, "There are no Instagram on your device", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        if ((event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) && (COUNT == 0)) {
            COUNT++;
            actionClick(event);
        }
    }

    private void actionClick(AccessibilityEvent event) {
        AccessibilityNodeInfo nodeInfo = event.getSource();
        if (nodeInfo == null) return;

        List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId("com.instagram.android:id/profile_tab");
        AccessibilityNodeInfo node1 = list.get(0);
        node1.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        nodeInfo.refresh();

        List<AccessibilityNodeInfo> list2 = nodeInfo.findAccessibilityNodeInfosByViewId("com.instagram.android:id/action_bar_large_title");
        AccessibilityNodeInfo node2 = list2.get(0);
        String instaLogin = node2.getText().toString();
        Log.d(TAG, instaLogin);

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("loginName", instaLogin);
        startActivity(intent);
    }

    @Override
    public void onInterrupt() {
    }
}
