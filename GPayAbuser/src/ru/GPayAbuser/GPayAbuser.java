package ru.GPayAbuser;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class GPayAbuser extends UiAutomatorTestCase {
    String[] buttons = {
            "Google Pay",
            "Показать панель навигации",
            "Показать аккаунты",
            ""
    };

    public void main(String[] args) throws UiObjectNotFoundException {
        findAndRunApp();
    }

    private void findAndRunApp() throws UiObjectNotFoundException {
        getUiDevice().pressHome();
        UiObject allAppsButton = new UiObject(new UiSelector().description("Google Pay"));
        allAppsButton.clickAndWaitForNewWindow();

        allAppsButton = new UiObject(new UiSelector().description("Показать панель навигации"));
        allAppsButton.clickAndWaitForNewWindow();

        allAppsButton = new UiObject(new UiSelector().description("Показать аккаунты"));
        allAppsButton.clickAndWaitForNewWindow();

        allAppsButton = new UiObject(new UiSelector().resourceId("com.google.android.apps.walletnfcrel:id/manage_accounts_text"));
        allAppsButton.clickAndWaitForNewWindow();

    }
}
