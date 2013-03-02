/*
 * Copyright (C) 2013 Koushik Dutta (@koush)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.koushikdutta.superuser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.widgets.NativeFragment;

@SuppressLint("NewApi")
public class PolicyNativeFragment extends NativeFragment<PolicyFragmentInternal> {
    ContextThemeWrapper mWrapper;
    @Override
    public Context getContext() {
        if (mWrapper != null)
            return mWrapper;
        mWrapper = new ContextThemeWrapper(super.getContext(), R.style.SuperuserDark_PolicyIcon);
        return mWrapper;
    }

    @Override
    public PolicyFragmentInternal createFragmentInterface() {
        return new PolicyFragmentInternal(this) {
            @Override
            public Context getContext() {
                return PolicyNativeFragment.this.getContext();
            }
            
            @Override
            protected int getListFragmentResource() {
                return R.layout.policy_list_content;
            }
            
            @Override
            protected void setPadding() {
                getListView().setPadding(0, 0, 0, 0);
                getContainer().setPadding(0, 0, 0, 0);
            }
        };
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView((LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE), container, savedInstanceState);
    }
}
