package com.youxiake_guide.linstener;

import java.util.List;

/**
 * Created by Cvmars on 2017/6/13.
 */

public interface PermissionListener {

    void onGranted();

    void onDenied(List<String> deniedPermissions);
}
