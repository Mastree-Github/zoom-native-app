/*Custom Native Module File.
* This Java file contains native module Java class.
* This class contains the logic for initialization of Zoom SDK and also other required Zoom functionalities (Join, Leave, etc.) */

package com.zoomnative;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import us.zoom.sdk.ZoomInstantSDK;
import us.zoom.sdk.ZoomInstantSDKErrors;
import us.zoom.sdk.ZoomInstantSDKInitParams;

public class ZoomVideoModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactApplicationContext;

    ZoomVideoModule(ReactApplicationContext context) {
        super(context);
        this.reactApplicationContext = context;
    }

    @Override
    public String getName() {
        return "ZoomVideoModule";
    }

    //Method to initialize the Zoom SDK
    @ReactMethod
    public void initializeZoom() {
        Log.d("ZoomVideoModule", "Initialize Zoom event called");

        try {
            this.getReactApplicationContext().getCurrentActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ZoomInstantSDKInitParams params = new ZoomInstantSDKInitParams();
                    params.domain = "https://zoom.us"; // Required
                    params.logFilePrefix = "Zoom SDK Test"; // Optional for debugging
                    params.enableLog = true; // Optional for debugging

                    ZoomInstantSDK sdk = ZoomInstantSDK.getInstance();
                    int initResult = sdk.initialize(reactApplicationContext.getCurrentActivity(), params);
                    if (initResult == ZoomInstantSDKErrors.Errors_Success) {
                        // You have successfully initialized the SDK
                        Log.d("ZoomVideoModule", "Successfully initialized");
                    } else {
                        // Something went wrong, see error code documentation
                        Log.d("ZoomVideoModule", "Error in initialization");
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
