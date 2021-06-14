/**
* JS file to import the created Native Zoom module.
* This exposes the native ZoomVideoModule module as a JS module. 
* This file can be used to excess the exposed functions in Native Zoom Module.
*/

import { NativeModules } from 'react-native';

const { ZoomVideoModule } = NativeModules;

async function initZoom(){
    console.log("Calling Zoom Video Module", ZoomVideoModule);

    const response=await ZoomVideoModule.initializeZoom(); // Call to the Native Module Function.

    console.log("Initialization Response", response);
}

export default initZoom;