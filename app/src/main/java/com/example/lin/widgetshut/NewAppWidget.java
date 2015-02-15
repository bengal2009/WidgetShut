package com.example.lin.widgetshut;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    private static final String TAG = "MainWidget";
    public static final String ACTION_WIDGET_AIRPLANE = "ActionReceiverAirplane";
    public static final String ACTION_WIDGET_WIFI = "ActionReceiverWifi";
    public static final String ACTION_WIDGET_BLUETOOTH = "ActionReceiverBluetooth";
    public static final String ACTION_WIDGET_DATA = "ActionReceiverData";
    public static final String ACTION_WIDGET_HOTSPOT = "ActionReceiverHotspot";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int N = appWidgetIds.length;
        RemoteViews remoteViews = new RemoteViews(
                context.getPackageName(), R.layout.new_app_widget);

        for (int i = 0; i < N; i++) {

            //
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
//        views.setTextViewText(R.id.appwidget_text, widgetText);
        Intent active = new Intent(context, AirplaneModeReceiver.class);
        active.setAction(ACTION_WIDGET_WIFI);
        PendingIntent actionPendingIntent = PendingIntent.getBroadcast(
                context, 0, active, 0);
        views.setOnClickPendingIntent(R.id.ShutBut,
                actionPendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}


