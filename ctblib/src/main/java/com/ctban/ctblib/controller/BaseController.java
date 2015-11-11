/*
 * Copyright 2014 Chris Banes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ctban.ctblib.controller;


import android.content.Intent;

import com.ctban.ctblib.Display;


abstract class BaseController {

    private Display mDisplay;
    private boolean mInited;

    public final void init() {
        mInited = true;
        onInited();
    }

    public final void suspend() {
        onSuspended();
        mInited = false;
    }

    public final boolean isInited() {
        return mInited;
    }

    protected void onInited() {}

    protected void onSuspended() {}

    public boolean handleIntent(Intent intent) {
        return false;
    }

    protected void setDisplay(Display display) {
        mDisplay = display;
    }

    protected final Display getDisplay() {
        return mDisplay;
    }

    protected final void assertInited() {
    }
}
