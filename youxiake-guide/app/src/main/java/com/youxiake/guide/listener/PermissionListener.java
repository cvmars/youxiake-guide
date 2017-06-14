package com.youxiake.guide.listener;

import java.util.List;

/**
 * Created by Cvmars on 2017/6/13.
 */

public interface PermissionListener {

    void onGranted();

    void onDenied(List<String> deniedPermissions);
}
