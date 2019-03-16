
#### 1.  权限判断 ####
    KMPerMissionsManager.getInstance().hasPermissions(context, KMPerMissionsManager.WRITE_EXTERNAL_STORAGE,
				KMPerMissionsManager.READ_EXTERNAL_STORAGE);

#### 2.  权限申请 ####
     KMPerMissionsManager.getInstance().requestPermissions(new KMPerMissionsManager.PermissionListener() {
                    @Override
                    public void onPermissionsGranted(List<String> permissions) {
                        //ok
                        LogCat.d();
                    }

                    @Override
                    public void onPermissionsDenied(List<String> permissions) {
                        //拒绝
                        LogCat.d();
                    }

                    @Override
                    public void onPermissionsError(List<String> permissions) {
                        //拒绝 不再提醒
                        LogCat.d();

                    }
                }, context, KMPerMissionsManager.READ_PHONE_STATE, KMPerMissionsManager.WRITE_EXTERNAL_STORAGE, KMPerMissionsManager.READ_EXTERNAL_STORAGE);

#### 3. //拒绝 不再提醒 权限提示框 ####
//message 提示框中显示的信息
String message = KMPerMissionsManager.getInstance().getDialogTips(MainActivity.this, KMPerMissionsManager.WRITE_EXTERNAL_STORAGE, KMPerMissionsManager.READ_EXTERNAL_STORAGE);
// 三个参数 1， 0  默认，2 第二个 默认false， 3. 第三个 false，表示不隐藏左边的取消按钮，true表示隐藏取消按钮
KMPerMissionsManager.DialogType dialogType =  new KMPerMissionsManager.DialogType(0, message, "去设置", false, true);
// 三个参数 1. 2. 3. PERMISSION_GO_SETTINGS跳转到设置 PERMISSION_WRITE_SETTINGS 允许修改系统设置 PERMISSION_OVERLAY 悬浮窗
KMPerMissionsManager.getInstance().showTipsDialog(MainActivity.this, dialogType, PERMISSION_GO_SETTINGS);

#### 4. 也可以直接创建一个对话框弹出 ####

	/**
	 * 提示对话框
	 */
	public void showRationaleDialog(final List<String> permission) {

		String message = KMPerMissionsManager.getInstance().getDialogTipsSdcard(this);
		// 显示弹窗.

		KMPerMissionsManager.DialogType dialogType = null;
		LogCat.d("isPermissionError = " + isPermissionError);
		if(isPermissionError) {
			dialogType = new KMPerMissionsManager.DialogType(-1, message, "设置", DayNightGlobalObserver.getInstance().isEnableNight(), true);
		} else {
			dialogType = new KMPerMissionsManager.DialogType(-1, message, "确定", DayNightGlobalObserver.getInstance().isEnableNight(), true);
		}
        new PermissionsTipsDialog.DialogBuider(this)
                .dataBean(dialogType)
                .positiveClickListener(new PermissionsTipsDialog.IDialogClickListener() {
                    @Override
                    public void onClick() {
                        //submit
                        LogCat.d("ok");
                        if(isPermissionError) {
                            KMPerMissionsManager.getInstance().setPermission(new KMPerMissionsManager.PermissionSettingListener() {
                            @Override
                            public void settingsBack(int type) {
                                LogCat.d();
                                if(!hasPermissions()) {
                                    showRationaleDialog(permission);
                                } else {
                                    isPermissionError = false;
                                    LogCat.d();
                                }
                                }
                            }, LoadingActivity.this);
                        } else {
                            KMPerMissionsManager.getInstance().requestPermissions(LoadingActivity.this, LoadingActivity.this,  KMPerMissionsManager.WRITE_EXTERNAL_STORAGE,
                                KMPerMissionsManager.READ_EXTERNAL_STORAGE);
                       }
                    }
                })
                .negativeClickListener(new PermissionsTipsDialog.IDialogClickListener() {
                    @Override
                    public void onClick() {
                        //cancel

                    }
                })
                .build()
                .show();

	}
