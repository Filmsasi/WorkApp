package com.sasina.workapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {

    private TextSwitcher mSwitcher;
    private TextSwitcher mSwitcher2;
    private int mCounter = 0;

    private String[] a = {
            "Android","ทำความรู้จักกับ Android Studio",
            "Software Development Kit (SDK)"
    };
    private String[] b = {"Android Studio เป็น Official IDE Tool จาก Google ไว้พัฒนา Android โดยเฉพาะ จากแนวคิดพื้นฐาน InteliJ IDEA คล้าย ๆ กับการทำงานของ Eclipse หรือ Netbean  และ Android ADT Plugin วัตถุประสงค์ของ Android Studio คือต้องการพัฒนาเครื่องมือ IDE ที่สามารถพัฒนา App บน Android โดยเฉพาะให้มีประสิทธิภาพมากขึ้น ทั้งด้านการออกแบบ GUI ที่ช่วยให้สามารถ Preview ตัว App มุมมองที่แตกต่างกันบน Smart Phone แต่ล่ะรุ่น สามารถแสดงผล preview ได้ทันทีโดยไม่ต้องทำการรัน App บน Emulator รวมทั้งยังแก้ไขปรับปรุงในเรื่องของความเร็วของ Emulator ที่ยังเจอปัญหากันอยู่ในปัจจุบัน",
            "ชุดพัฒนาซอฟต์แวร์(SDK)หมายถึงชุดของเครื่องมือที่ใช้ในการพัฒนาโปรแกรมให้โดยฮาร์ดแวร์และซอฟต์แวร์ให้บริการ SDKs มักจะประกอบด้วยโปรแกรมประยุกต์ interfaces (APIs) "
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the TextSwitcher view from the layout
        mSwitcher = findViewById(R.id.switcher);
        mSwitcher2 = findViewById(R.id.switcher2);

        // BEGIN_INCLUDE(setup)
        // Set the factory used to create TextViews to switch between.
        mSwitcher.setFactory(mFactory);
        mSwitcher2.setFactory(mFactory2);

        /*
         * Set the in and out animations. Using the fade_in/out animations
         * provided by the framework.
         */
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);

        mSwitcher2.setInAnimation(in);
        mSwitcher2.setOutAnimation(out);
        // END_INCLUDE(setup)

        /*
         * Setup the 'next' button. The counter is incremented when clicked and
         * the new value is displayed in the TextSwitcher. The change of text is
         * automatically animated using the in/out animations set above.
         */
        Button nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCounter++;
                if (mCounter >= 2) {
                    mCounter = 2;
                }
                // BEGIN_INCLUDE(settext)
                mSwitcher.setText(a[mCounter]);
                mSwitcher2.setText(b[mCounter]);
                // END_INCLUDE(settext)
            }
        });

        // Set the initial text without an animation
        mSwitcher.setCurrentText(a[mCounter]);
        mSwitcher2.setCurrentText(b[mCounter]);

    }

    // BEGIN_INCLUDE(factory)
    /**
     * The {@link android.widget.ViewSwitcher.ViewFactory} used to create {@link android.widget.TextView}s that the
     * {@link android.widget.TextSwitcher} will switch between.
     */
    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(MainActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };
    private ViewSwitcher.ViewFactory mFactory2 = new ViewSwitcher.ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(MainActivity.this, android.R.style.TextAppearance_Small);
            return t;
        }
    };
    // END_INCLUDE(factory)
}
