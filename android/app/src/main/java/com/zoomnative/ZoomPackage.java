/*Java Class to add our Custom Native Zoom Module to ReactPackage
* This file imports the native Zoom module and then instantiates the module within the createNativeModules() function and returns it as a list of NativeModules to register.
* If you add more native modules down the line, you can also instantiate them and add them to the list returned here. */

package com.zoomnative;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZoomPackage implements ReactPackage {

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {

        List<NativeModule> modules = new ArrayList<>();
        modules.add(new ZoomVideoModule(reactContext)); //Native Zoom Module instantiated and added to the list
        return modules;
    }


}
