package com.example.timurkh.gpayabuser;

import android.content.Context;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.webkit.WebView;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static android.view.KeyEvent.KEYCODE_SPACE;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class GPayAbuser {
    UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    final String PIN = "ПИН КОД ОТ МОБИЛЫ";
    AccBank accBank = new AccBank("СЮДА ЧЕРЕЗ ПРОБЕЛ МЕЙЛ И ПАРОЛЬ ПИШЕШЬ");




//    @BeforeClass
//    public void bc() {
//    }

    @Test
    public void GoogleAccountsAdder() throws UiObjectNotFoundException, InterruptedException {

        /*
        *Запускать данный метод следует в окне добавления Пользовательских Аккаунтов
        */

//        mDevice.findObject(new UiSelector().description("Показать панель навигации")).clickAndWaitForNewWindow();
//        mDevice.findObject(new UiSelector().description("Показать аккаунты")).clickAndWaitForNewWindow();
//        mDevice.findObject(new UiSelector().text("Управление аккаунтами")).clickAndWaitForNewWindow();

        for (int i = 0; i < accBank.getSize(); i++) {
            try {
                new UiScrollable(new UiSelector()
                        .scrollable(true))
                        .scrollToEnd(20);
            } catch (Exception e) {}
            mDevice.wait(Until.hasObject(By.text("Добавить аккаунт")), 5000);
            mDevice.findObject(new UiSelector().text("Добавить аккаунт")).clickAndWaitForNewWindow();
            mDevice.findObject(new UiSelector().text("Google")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("PIN")), 20000);
            while (mDevice.findObject(new UiSelector().textContains("PIN")).exists()) {
                mDevice.findObject(new UiSelector().focused(true)).setText(PIN);
                mDevice.pressEnter();
                mDevice.wait(Until.hasObject(By.textContains("ДАЛЕЕ")), 1000);
            }
            mDevice.wait(Until.hasObject(By.textContains("ДАЛЕЕ")), 9000);
            mDevice.findObject(new UiSelector().className("android.widget.EditText")).setText(accBank.getEMail(i));
            mDevice.wait(Until.hasObject(By.textContains("111")),500);
            mDevice.findObject(new UiSelector().text("ДАЛЕЕ")).clickAndWaitForNewWindow();
            if (mDevice.findObject(new UiSelector().textContains("уже")).exists()) {
                while (!mDevice.findObject(new UiSelector().text("Добавить аккаунт")).exists()) {
                    mDevice.pressBack();
                    mDevice.wait(Until.hasObject(By.text("Добавить аккаунт")), 1000);
                }

                continue;
            }
            mDevice.wait(Until.hasObject(By.textContains("Добро")), 500);
            mDevice.findObject(new UiSelector().className("android.widget.EditText")).setText(accBank.getPass(i));
            mDevice.wait(Until.hasObject(By.textContains("111")),500);
            mDevice.findObject(new UiSelector().text("ДАЛЕЕ")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("")), 500);
            if (mDevice.findObject(new UiSelector().textContains("Добавить номер телефона?")).exists()) {
                new UiScrollable(new UiSelector()
                        .scrollable(true)
                        .textContains("Добавить номер телефона?"))
                        .scrollToEnd(10);
                mDevice.wait(Until.hasObject(By.text("ПРОПУСТИТЬ")), 5000);
                mDevice.findObject(new UiSelector().text("ПРОПУСТИТЬ").className("android.view.View")).clickAndWaitForNewWindow();
                mDevice.click(220,2236); // типо костыль (работает на Nexus 6P и устройствах с такимже разрешением)

            } else if (!mDevice.findObject(new UiSelector().textContains("ПРИНИМАЮ")).exists()) {
                while (!mDevice.findObject(new UiSelector().text("Добавить аккаунт")).exists()){
                    mDevice.pressBack();
                    mDevice.wait(Until.hasObject(By.text("Добавить аккаунт")), 1000);
                }
                i--;
                continue;
            }
            mDevice.wait(Until.hasObject(By.textContains("ПРИНИМАЮ")),500);
            mDevice.findObject(new UiSelector().text("ПРИНИМАЮ")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.text("Пользователи и аккаунты")),5000);
            while (!mDevice.findObject(new UiSelector().text("Пользователи и аккаунты")).exists()) {
                mDevice.pressBack();
                mDevice.wait(Until.hasObject(By.text("Пользователи и аккаунты")),5000);
            }
        }
    }

    @Test
    public void PayByAccounts() throws UiObjectNotFoundException {
        /*
        * Данный метод следыет запускать на страничке cloudpayments
        * с увеличенной ктопкой "Pay", расположенной по середине
        * */
        for (int i = 0; i < accBank.getSize(); i++) {
            while ((mDevice.findObject(new UiSelector().textContains("@")).exists()));
            while (!(mDevice.findObject(new UiSelector().text("Продолжить")).exists())) {
                mDevice.click(mDevice.getDisplayWidth() / 2, mDevice.getDisplayHeight() / 2);
                mDevice.wait(Until.hasObject(By.textContains("@")), 2000);
            }
            mDevice.findObject(new UiSelector().textContains("@")).click();
            while (!(mDevice.findObject(new UiSelector().text(accBank.getEMail(i).toLowerCase())).exists() &&
                    mDevice.findObject(new UiSelector().text(accBank.getEMail(i).toLowerCase())).click())) {
                mDevice.swipe(mDevice.getDisplayWidth() / 2,
                        mDevice.getDisplayHeight() - 20,
                        mDevice.getDisplayWidth() / 2,
                        mDevice.getDisplayHeight() - 320,
                        5);
                mDevice.wait(Until.hasObject(By.textContains(accBank.getEMail(i))), 500);
            }
            mDevice.wait(Until.hasObject(By.textContains("Задержка")), 500);
            mDevice.findObject(new UiSelector().text("Продолжить")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("PIN")), 5000);
            if (mDevice.findObject(new UiSelector().textContains("PIN")).exists()) {
                mDevice.findObject(new UiSelector().focused(true)).setText(PIN);
                mDevice.pressEnter();
            }
            mDevice.wait(Until.hasObject(By.textContains("Задержка")), 2000);
        }
    }

    @Test

    public void deleteAccounts() throws UiObjectNotFoundException {
        /*
         *Запускать данный метод следует в окне добавления Пользовательских Аккаунтов
         */

        for (int i = 0; i < accBank.getSize(); i++) {
            try {
                new UiScrollable(new UiSelector().scrollable(true)).flingToBeginning(20);
            } catch (Exception e){};
            while (!(mDevice.findObject(new UiSelector().text(accBank.getEMail(i).toLowerCase())).exists()
                    && mDevice.findObject(new UiSelector().text(accBank.getEMail(i).toLowerCase())).click())) {
                mDevice.swipe(mDevice.getDisplayWidth() / 2,
                        mDevice.getDisplayHeight() - 20,
                        mDevice.getDisplayWidth() / 2,
                        mDevice.getDisplayHeight() - 320,
                        5);
                mDevice.wait(Until.hasObject(By.textContains(accBank.getEMail(i))), 500);
            }
            mDevice.findObject(new UiSelector().text("УДАЛИТЬ АККАУНТ")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("Задержка")), 500);
            mDevice.findObject(new UiSelector().text("УДАЛИТЬ АККАУНТ")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("Задержка")), 500);
        }
    }

    @Test
    public void addMegafonCard() throws UiObjectNotFoundException, RemoteException {
        for (int i = 0; i < accBank.getSize(); i++) {
            mDevice.wait(Until.hasObject(By.textContains("Показать панель навигации")), 5000);
            if (!mDevice.findObject(new UiSelector().text("Настройки")).exists()) {
                mDevice.findObject(new UiSelector().description("Показать панель навигации")).clickAndWaitForNewWindow();
            }
            mDevice.findObject(new UiSelector().description("Показать аккаунты")).clickAndWaitForNewWindow();
            while (!(mDevice.findObject(new UiSelector().text(accBank.getEMail(i).toLowerCase())).exists()
                    && mDevice.findObject(new UiSelector().text(accBank.getEMail(i).toLowerCase())).click())) {
                mDevice.swipe(mDevice.getDisplayWidth() / 4,
                        mDevice.getDisplayHeight() - 20,
                        mDevice.getDisplayWidth() / 4,
                        mDevice.getDisplayHeight() - 320,
                        5);
                mDevice.wait(Until.hasObject(By.textContains(accBank.getEMail(i))), 500);
            }
            try {
                mDevice.wait(Until.hasObject(By.textContains("Начать")), 5000);
                mDevice.findObject(new UiSelector().text("Начать")).clickAndWaitForNewWindow();
            } catch (Exception e) {
            }
            mDevice.wait(Until.hasObject(By.textContains("Главная")), 9000);
            mDevice.pressRecentApps();
            mDevice.findObject(new UiSelector().textContains("MegaFon")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("Вход")), 5000);
            if (mDevice.findObject(new UiSelector().text("Вход")).exists()) {
                for (int j = 0; j < 4; j++) {
                    mDevice.findObject(new UiSelector().text("0")).click();
                    mDevice.wait(Until.hasObject(By.textContains("Задержка")), 10);
                }
            }
            mDevice.wait(Until.hasObject(By.textContains("*")), 50000);
            if (mDevice.findObject(new UiSelector().text("АКТИВНЫЕ")).exists()) {
                mDevice.findObject(new UiSelector().textContains("*")).clickAndWaitForNewWindow();
            }
            mDevice.findObject(new UiSelector().resourceId("com.megafon.bank:id/card_add_to_google_pay_button"))
                    .clickAndWaitForNewWindow();
            mDevice.findObject(new UiSelector().textContains("Продолжить")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("Личная информация")), 5000);
            mDevice.wait(Until.hasObject(By.textContains("Задержка")), 1000);
            new UiScrollable(new UiSelector().scrollable(true)).flingToBeginning(1);
            mDevice.findObject(new UiSelector().text("Страна")).clickAndWaitForNewWindow();
            while (!(mDevice.findObject(new UiSelector().textContains("Штаты")).exists()
                    && mDevice.findObject(new UiSelector().textContains("Штаты")).clickAndWaitForNewWindow())) {
                mDevice.swipe(mDevice.getDisplayWidth() / 2,
                        mDevice.getDisplayHeight() / 2 - 20,
                        mDevice.getDisplayWidth() / 2,
                        mDevice.getDisplayHeight() / 2 - 420,
                        5);
                mDevice.wait(Until.hasObject(By.textContains("Штаты")), 500);
            }
            mDevice.findObject(new UiSelector().text("Адрес")).click();
            mDevice.findObject(new UiSelector().focused(true)).setText("Z6 Richard Mine Road");
            mDevice.wait(Until.hasObject(By.textContains("ЗАДЕРЖКА")), 500);
            mDevice.findObject(new UiSelector().textContains("офис")).click();
            mDevice.findObject(new UiSelector().focused(true)).setText("Zz");
            mDevice.findObject(new UiSelector().textContains("Город")).click();
            mDevice.findObject(new UiSelector().focused(true)).setText("Wharton");
            mDevice.findObject(new UiSelector().textContains("Штат")).click();
            while (!(mDevice.findObject(new UiSelector().textContains("New Jersey")).exists()
                    && mDevice.findObject(new UiSelector().textContains("New Jersey")).clickAndWaitForNewWindow())) {
                mDevice.swipe(mDevice.getDisplayWidth() / 2,
                        mDevice.getDisplayHeight() / 2 - 20,
                        mDevice.getDisplayWidth() / 2,
                        mDevice.getDisplayHeight() / 2 - 420,
                        5);
                mDevice.wait(Until.hasObject(By.textContains("New Jersey")), 500);
            }
            mDevice.findObject(new UiSelector().textContains("индекс")).click();
            mDevice.findObject(new UiSelector().focused(true)).setText("07885");
            mDevice.findObject(new UiSelector().textContains("Номер")).click();
            mDevice.findObject(new UiSelector().focused(true)).setText("12345678900");
            new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10);
            mDevice.wait(Until.hasObject(By.textContains("Продолжить")), 5000);
            mDevice.findObject(new UiSelector().textContains("Продолжить")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("Ещё")), 5000);
            mDevice.wait(Until.hasObject(By.textContains("Термины")), 5000);
            mDevice.findObject(new UiSelector().textContains("Ещё")).click();
            mDevice.wait(Until.hasObject(By.textContains("Принять")), 5000);
            mDevice.findObject(new UiSelector().textContains("Принять")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("покупки")), 9000);
            try {
                mDevice.findObject(new UiSelector().clickable(true)).clickAndWaitForNewWindow();
            } catch (Exception e) {
            }
            mDevice.pressRecentApps();
            mDevice.findObject(new UiSelector().textContains("Pay")).clickAndWaitForNewWindow();
            try {
                mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.walletnfcrel:id/CloseButton"))
                        .clickAndWaitForNewWindow();
            } catch (Exception e) {}
        }
    }

    @Test
    public void addMegafonCardAgain() throws UiObjectNotFoundException, RemoteException {
        for (int i = 0; i < accBank.getSize(); i++) {
                mDevice.wait(Until.hasObject(By.textContains("Показать панель навигации")), 5000);
            if (!mDevice.findObject(new UiSelector().text("Настройки")).exists()) {
                mDevice.findObject(new UiSelector().description("Показать панель навигации")).clickAndWaitForNewWindow();
            }
            mDevice.findObject(new UiSelector().description("Показать аккаунты")).clickAndWaitForNewWindow();
            while (!(mDevice.findObject(new UiSelector().text(accBank.getEMail(i).toLowerCase())).exists()
                    && mDevice.findObject(new UiSelector().text(accBank.getEMail(i).toLowerCase())).clickAndWaitForNewWindow())) {
                mDevice.swipe(mDevice.getDisplayWidth() / 4,
                        mDevice.getDisplayHeight() - 20,
                        mDevice.getDisplayWidth() / 4,
                        mDevice.getDisplayHeight() - 320,
                        5);
                mDevice.wait(Until.hasObject(By.textContains(accBank.getEMail(i))), 500);
            }
            mDevice.wait(Until.hasObject(By.textContains("Главная")), 9000);
            mDevice.wait(Until.hasObject(By.textContains("Задержка")), 9000);
            if (mDevice.findObject(new UiSelector().text("Карта по умолчанию")).exists()) continue;
            mDevice.pressRecentApps();
            mDevice.findObject(new UiSelector().textContains("MegaFon")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("Вход")), 5000);
            if (mDevice.findObject(new UiSelector().text("Вход")).exists()) {
                for (int j = 0; j < 4; j++) {
                    mDevice.findObject(new UiSelector().text("0")).click();
                    mDevice.wait(Until.hasObject(By.textContains("Задержка")), 10);
                }
            }
            mDevice.wait(Until.hasObject(By.textContains("*")), 50000);
            if (mDevice.findObject(new UiSelector().text("АКТИВНЫЕ")).exists()) {
                mDevice.findObject(new UiSelector().textContains("*")).clickAndWaitForNewWindow();
            }
            mDevice.findObject(new UiSelector().resourceId("com.megafon.bank:id/card_add_to_google_pay_button"))
                    .clickAndWaitForNewWindow();
            mDevice.findObject(new UiSelector().textContains("Продолжить")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("Подтвердите данные")), 5000);
            new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(1);
            mDevice.findObject(new UiSelector().text("Продолжить")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("Ещё")), 5000);
            mDevice.wait(Until.hasObject(By.textContains("Термины")), 5000);
            mDevice.findObject(new UiSelector().textContains("Ещё")).click();
            mDevice.wait(Until.hasObject(By.textContains("Принять")), 5000);
            mDevice.findObject(new UiSelector().textContains("Принять")).clickAndWaitForNewWindow();
            mDevice.wait(Until.hasObject(By.textContains("покупки")), 9000);
            try {
                mDevice.findObject(new UiSelector().clickable(true)).clickAndWaitForNewWindow();
            } catch (Exception e) {
            }
            mDevice.pressRecentApps();
            mDevice.wait(Until.hasObject(By.textContains("Pay")), 5000);
            mDevice.findObject(new UiSelector().textContains("Pay")).clickAndWaitForNewWindow();
            try {
                mDevice.findObject(new UiSelector().resourceId("com.google.android.apps.walletnfcrel:id/CloseButton"))
                        .clickAndWaitForNewWindow();
            } catch (Exception e) {}
        }
    }



    @Test
    public void test2() throws UiObjectNotFoundException {
        mDevice.findObject(new UiSelector().text("Страна")).clickAndWaitForNewWindow();
        while (!(mDevice.findObject(new UiSelector().textContains("Штаты")).exists()
                && mDevice.findObject(new UiSelector().textContains("Штаты")).clickAndWaitForNewWindow())) {
            mDevice.swipe(mDevice.getDisplayWidth() / 2,
                    mDevice.getDisplayHeight() - 20,
                    mDevice.getDisplayWidth() / 2,
                    mDevice.getDisplayHeight() - 320,
                    20);
            mDevice.wait(Until.hasObject(By.textContains("Штаты")), 500);
        }
        mDevice.findObject(new UiSelector().text("Адрес")).click();
        mDevice.findObject(new UiSelector().focused(true)).setText("Z6 Richard Mine Road");
        mDevice.findObject(new UiSelector().textContains("офис")).click();
        mDevice.findObject(new UiSelector().focused(true)).setText("Zz");
        mDevice.findObject(new UiSelector().textContains("Город")).click();
        mDevice.findObject(new UiSelector().focused(true)).setText("Wharton");
        mDevice.findObject(new UiSelector().textContains("Штат")).click();
        while (!(mDevice.findObject(new UiSelector().textContains("New Jersey")).exists()
                && mDevice.findObject(new UiSelector().textContains("New Jersey")).clickAndWaitForNewWindow())) {
            mDevice.swipe(mDevice.getDisplayWidth() / 2,
                    mDevice.getDisplayHeight() / 2 - 20,
                    mDevice.getDisplayWidth() / 2,
                    mDevice.getDisplayHeight() / 2 - 320,
                    20);
            mDevice.wait(Until.hasObject(By.textContains("New Jersey")), 500);
        }
        mDevice.findObject(new UiSelector().focused(true)).setText("Zz");
        mDevice.findObject(new UiSelector().textContains("индекс")).click();
        mDevice.findObject(new UiSelector().focused(true)).setText("07885");
        mDevice.findObject(new UiSelector().textContains("Номер")).click();
        mDevice.findObject(new UiSelector().focused(true)).setText("12345678900");
        new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10);
        mDevice.wait(Until.hasObject(By.textContains("Продолжить")), 5000);
        mDevice.findObject(new UiSelector().textContains("Продолжить")).clickAndWaitForNewWindow();



    }


}
