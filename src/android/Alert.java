package br.com.farit.alert;
import android.app.AlertDialog;
import android.content.DialogInterface;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import java.lang.Override;

public class Alert extends CordovaPlugin{
    protected void pluginInitialize(){

    }

    public boolean execute(String action, JSONArray args, CallbackContext context) throws JSONException{
        if (action.equals("alert")) {
            alert(args.getString(0), args.getString(1), args.getString(2), context);
            return true;
        }
        return false;
    }

    private synchronized void alert(final String title, final String message, final String buttonLabel, final CallbackContext callbackContext){
         new AlertDialog.Builder(cordova.getActivity())
                 .setTitle(title)
                 .setMessage(message)
                 .setCancelable(false)
                 .setNeutralButton(buttonLabel, new AlertDialog.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         dialog.dismiss();
                         callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
            }
        })
        .create()
        .show();


    }
}