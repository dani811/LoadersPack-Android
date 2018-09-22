# LoadersPack
> Android Loaders

> A replacement of default android material progressbar with loaders

latest version : [ ![Download](https://api.bintray.com/packages/agrawalsuneet/androidlibs/loaderspack/images/download.svg) ](https://bintray.com/agrawalsuneet/androidlibs/loaderspack/_latestVersion)

### ClockLoader
![clockloader](https://user-images.githubusercontent.com/12999622/34564685-9690034c-f14f-11e7-8ea8-f0b7086b79be.gif)


### RippleLoader
![rippleloader](https://user-images.githubusercontent.com/12999622/33661635-ba4f9d3c-da80-11e7-8f0a-d551b4dca4e5.gif)


### RotatingCircularSticksLoader
![RotatingCircularSticksLoader](https://user-images.githubusercontent.com/12999622/34488210-6dafe19e-efcf-11e7-9558-5740e1d0a42b.gif)


### CircularSticksLoader
![circularsticksloader](https://user-images.githubusercontent.com/12999622/34639868-0a358574-f2e0-11e7-8b10-10ce9c6f3a6e.gif)


### MultipleRippleLoader
![multiplerippleloader](https://user-images.githubusercontent.com/12999622/39401278-296a4180-4b39-11e8-8a8b-208edde9cc65.gif)


### CurvesLoader
![curvesloader](https://user-images.githubusercontent.com/12999622/45126558-d6e8d400-b16b-11e8-89bd-973e11a8e54e.gif)


### RingAndCircleLoader
![ringandcircleloader](https://user-images.githubusercontent.com/12999622/45266388-59b2ad00-b452-11e8-9e51-28cdb5c538b3.gif)


### ArcProgressLoader
![arcprogressloader](https://user-images.githubusercontent.com/12999622/45809206-3fe05800-bce5-11e8-90ef-f68e46de64cc.gif)


### FidgetLoader
![arcprogressloader](https://user-images.githubusercontent.com/12999622/45809206-3fe05800-bce5-11e8-90ef-f68e46de64cc.gif)


Check all other loaders [here](https://agrawalsuneet.github.io/agrawalsuneet/opensourcecontribution/)

## How To use
include below dependency in build.gradle of application and compile it
```
implementation 'com.agrawalsuneet.androidlibs:loaderspack:0.8'
```

### ClockLoader
##### Through XML
```
<com.agrawalsuneet.loaderspack.loaders.ClockLoader
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:clock_animSpeedMultiplier="0.5"
        app:clock_bigCircleColor="@color/colorPrimary"
        app:clock_bigCircleRadius="80dp"
        app:clock_hourHandColor="@color/colorAccent"
        app:clock_hourHandLength="40dp"
        app:clock_innerCircleColor="@color/colorPrimaryDark"
        app:clock_innerCircleRadius="5dp"
        app:clock_minuteHandColor="@color/colorAccent"
        app:clock_minuteHandLength="60dp"
        app:clock_outerCircleBorderColor="@color/colorAccent"
        app:clock_outerCircleBorderWidth="10dp" />
```
##### Through Code
* Kotlin
```
        var clock = ClockLoader(this)
                .apply {
                    outerCircleBorderWidth = 8.0f
                    bigCircleRadius = 150.0f
                    minuteHandLength = 120.0f
                    hourHandLength = 80.0f
                    innerCircleRadius = 15.0f

                    outerCircleBorderColor = ContextCompat.getColor(context, R.color.colorAccent)
                    bigCircleColor = ContextCompat.getColor(context, R.color.colorPrimary)
                    innerCircleColor = ContextCompat.getColor(context, R.color.colorPrimaryDark)
                    hourHandColor = ContextCompat.getColor(context, R.color.colorAccent)
                    minuteHandColor = ContextCompat.getColor(context, R.color.colorAccent)

                    animSpeedMultiplier = 2.0f
                }


        containerLayout.addView(clock)
```

* Java
```
        ClockLoader clockLoader = new ClockLoader(this);
        clockLoader.setOuterCircleBorderWidth(8.0f);
        clockLoader.setBigCircleRadius(150.0f);
        clockLoader.setMinuteHandLength(120.0f);
        clockLoader.setHourHandLength(80.0f);
        clockLoader.setInnerCircleRadius(15.0f);
        
        clockLoader.setOuterCircleBorderColor(ContextCompat.getColor(this, R.color.colorAccent));
        clockLoader.setBigCircleColor(ContextCompat.getColor(this, R.color.colorPrimary));
        clockLoader.setInnerCircleColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        clockLoader.setHourHandColor(ContextCompat.getColor(this, R.color.colorAccent));
        clockLoader.setMinuteHandColor(ContextCompat.getColor(this, R.color.colorAccent));
        
        clockLoader.setAnimSpeedMultiplier(2.0f);
        
        container.addView(clockLoader);
```

### RippleLoader
##### Through XML
```
<com.agrawalsuneet.loaderspack.loaders.RippleLoader
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:ripple_animDuration="500"
        app:ripple_circleColor="@color/blue"
        app:ripple_circleInitialRadius="50dp"
        app:ripple_fromAlpha="1.0"
        app:ripple_interpolator="@android:anim/decelerate_interpolator"
        app:ripple_startLoadingDefault="true"
        app:ripple_toAplha="0.01" />
```
##### Through Code
* Kotlin
```
        val ripple = RippleLoader(baseContext).apply {
            circleInitialRadius = 80
            circleColor = resources.getColor(R.color.black)
            fromAlpha = 1.0f
            toAlpha = 0f
            animationDuration = 1000
            interpolator = DecelerateInterpolator()
        }


        containerLayout.addView(ripple)
```

* Java
```
        RippleLoader ripple = new RippleLoader(this);
        ripple.setCircleInitialRadius(80);
        ripple.setCircleColor(getResources().getColor(R.color.red));
        ripple.setFromAlpha(1.0f);
        ripple.setToAlpha(0.01f);
        ripple.setAnimationDuration(1000);
        ripple.setInterpolator(new DecelerateInterpolator());
        ripple.setStartLoadingDefault(true);
        
        container.addView(ripple);
```

### RotatingCircularSticksLoader
##### Through XML
```
<com.agrawalsuneet.loaderspack.loaders.RotatingCircularSticksLoader
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:rotatingsticks_noOfSticks="50"
        app:rotatingsticks_innerCircleRadius="15dp"
        app:rotatingsticks_outerCircleRadius="30dp"
        app:rotatingsticks_stickColor="@color/grey"
        app:rotatingsticks_viewBackgroundColor="@color/white"
        app:rotatingsticks_animDuration="5000"/>
```
##### Through Code
* Kotlin
```
        val loader = RotatingCircularSticksLoader(this, 16, 100f, 50f,
                        ContextCompat.getColor(this, R.color.blue),
                        ContextCompat.getColor(this, android.R.color.white))
                        .apply {
                            animDuration = 5000
                        }
        
                containerLayout.addView(loader)
```

* Java
```
        RotatingCircularSticksLoader loader = new RotatingCircularSticksLoader(this,
                        16, 100f, 50f,
                        ContextCompat.getColor(this, R.color.blue),
                        ContextCompat.getColor(this, android.R.color.white));
        
                loader.setAnimDuration(5000);
                container.addView(loader);
```

### CircularSticksLoader
##### Through XML
```
<com.agrawalsuneet.loaderspack.loaders.CircularSticksLoader
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        app:circularsticks_animDuration="100"
        app:circularsticks_firstShadowColor="#aa000000"
        app:circularsticks_innerCircleRadius="50dp"
        app:circularsticks_noOfSticks="32"
        app:circularsticks_outerCircleRadius="80dp"
        app:circularsticks_secondShadowColor="#77000000"
        app:circularsticks_selectedStickColor="@color/black"
        app:circularsticks_showRunningShadow="true"
        app:circularsticks_stickColor="@color/grey"
        app:circularsticks_viewBackgroundColor="@color/white" />
```
##### Through Code
* Kotlin
```
        val loader = CircularSticksLoader(this, 16, 200f, 100f,
                        ContextCompat.getColor(this, R.color.blue),
                        ContextCompat.getColor(this, R.color.red),
                        ContextCompat.getColor(this, android.R.color.white))
                        .apply {
                            showRunningShadow = true
                            firstShadowColor = ContextCompat.getColor(context, R.color.green)
                            secondShadowColor = ContextCompat.getColor(context, R.color.yellow)
                            animDuration = 100
                        }
        
                containerLayout.addView(loader)
```

* Java
```
        CircularSticksLoader loader = new CircularSticksLoader(this, 16,
                        200f, 100f,
                        ContextCompat.getColor(this, R.color.blue),
                        ContextCompat.getColor(this, R.color.red),
                        ContextCompat.getColor(this, android.R.color.white));
        
                loader.setShowRunningShadow(true);
                loader.setFirstShadowColor(ContextCompat.getColor(this, R.color.green));
                loader.setSecondShadowColor(ContextCompat.getColor(this, R.color.yellow));
                loader.setAnimDuration(100);
        
                container.addView(loader);
```

### MultipleRippleLoader
##### Through XML
```
<com.agrawalsuneet.loaderspack.loaders.MultipleRippleLoader
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:multipleripple_animDuration="6000"
            app:multipleripple_circleColor="@color/green"
            app:multipleripple_circleInitialRadius="20dp"
            app:multipleripple_fromAlpha="0.8"
            app:multipleripple_interpolator="@android:anim/decelerate_interpolator"
            app:multipleripple_noOfRipples="3"
            app:multipleripple_toAplha="0.1" />
```
##### Through Code
* Kotlin
```
        val multipleRippleLoader = MultipleRippleLoader(this,
                        40, 
                        ContextCompat.getColor(this, R.color.blue), 
                        2)
                        .apply {
                            fromAlpha = 0.9f
                            toAlpha = 0.2f
                            animationDuration = 2000
                            interpolator = LinearInterpolator()
                        }
        
                containerLayout.addView(multipleRippleLoader)
```

* Java
```
        MultipleRippleLoader multipleRippleLoader = new MultipleRippleLoader(this,
                        40,
                        ContextCompat.getColor(this, R.color.blue),
                        2);
        
                multipleRippleLoader.setFromAlpha(0.9f);
                multipleRippleLoader.setToAlpha(0.2f);
                multipleRippleLoader.setAnimationDuration(2000);
                multipleRippleLoader.setInterpolator(new LinearInterpolator());
        
        
                container.addView(multipleRippleLoader);
```

### CurvesLoaders
##### Through XML
```
<com.agrawalsuneet.loaderspack.loaders.CurvesLoader
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:curves_animDuration="1000"
        app:curves_curveColor="@color/blue_selected"
        app:curves_curveSweepAngle="160"
        app:curves_curveWidth="5dp"
        app:curves_distanceBetweenCurves="5dp"
        app:curves_interpolator="@android:anim/linear_interpolator"
        app:curves_noOfCurves="5"
        app:curves_outermostCurveRadius="80dp" />
```
##### Through Code
* Kotlin
```
        val curvesLoader = CurvesLoader(
                        this,
                        4,
                        100,
                        10,
                        10,
                        160.0f,
                        ContextCompat.getColor(this, R.color.blue_selected))
                        .apply {
                            animDuration = 1000
                            interpolator = LinearInterpolator()
                        }

                containerLayout.addView(curvesLoader)
```

* Java
```
        CurvesLoader curvesLoader = new CurvesLoader(
                        this,
                        4,
                        100,
                        10,
                        10,
                        160.0f,
                        ContextCompat.getColor(this, R.color.blue_selected));


                curvesLoader.setAnimDuration(1000);
                curvesLoader.setInterpolator(new LinearInterpolator());

                container.addView(curvesLoader);
```


### RingAndCircleLoader
##### Through XML
```
<com.agrawalsuneet.loaderspack.loaders.RingAndCircleLoader
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"g
            app:ringandcircle_animDuration="800"
            app:ringandcircle_circleColor="@color/green"
            app:ringandcircle_circleRadius="6dp"
            app:ringandcircle_ringColor="@color/green_default"
            app:ringandcircle_ringRadius="20dp"
            app:ringandcircle_ringWidth="4dp" />
```
##### Through Code
* Kotlin
```
        val ringAndCircleLoader = RingAndCircleLoader(
                        this,
                        20,
                        100,
                        10,
                        ContextCompat.getColor(this, R.color.blue),
                        ContextCompat.getColor(this, R.color.blue_delfault))
                        .apply {
                            animDuration = 1000
                        }

                containerLayout.addView(ringAndCircleLoader)
```

* Java
```
        RingAndCircleLoader ringAndCircleLoader = new RingAndCircleLoader(
                        this,
                        20,
                        100,
                        10,
                        ContextCompat.getColor(this, R.color.blue),
                        ContextCompat.getColor(this, R.color.blue_delfault));

                ringAndCircleLoader.setAnimDuration(1000);

                container.addView(ringAndCircleLoader);
```



### ArcProgressLoader
```
<array name="colors_rgb">
        <item>@color/red</item>
        <item>@color/amber</item>
        <item>@color/green</item>
        <item>@color/grey</item>
    </array>
```

##### Through XML
```
<com.agrawalsuneet.loaderspack.loaders.FidgetLoader
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:fidget_animDuration="3000"
        app:fidget_bodyColor="@color/blue_selected"
        app:fidget_fidgetRadius="30dp"
        app:fidget_interpolator="@android:anim/accelerate_decelerate_interpolator"
        app:fidget_noOfRotation="10"
        app:fidget_sideCirclesColor="@android:color/darker_gray" />
```
##### Through Code
* Kotlin
```
         val fidgetLoader = FidgetLoader(this,
                         20,
                         ContextCompat.getColor(this, R.color.blue_selected),
                         ContextCompat.getColor(this, R.color.amber))
                         .apply {
                             animDuration = 3000
                             noOfRotation = 1
                             interpolator = BounceInterpolator()
                         }

                 containerLayout.addView(fidgetLoader)
```

* Java
```
        FidgetLoader fidgetLoader = new FidgetLoader(this,
                        20,
                        ContextCompat.getColor(this, R.color.blue_selected),
                        ContextCompat.getColor(this, R.color.amber));

                fidgetLoader.setAnimDuration(3000);
                fidgetLoader.setNoOfRotation(1);
                fidgetLoader.setInterpolator(new BounceInterpolator());

                container.addView(fidgetLoader);
```


### FidgetLoader
##### Through XML
```
<com.agrawalsuneet.loaderspack.loaders.ArcProgressLoader
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:arcprogress_arcColorsArray="@array/colors_rgb"
        app:arcprogress_arcRadius="60dp"
        app:arcprogress_arcWidth="8dp"
        app:arcprogress_incrementalAngle="7.0"
        app:arcprogress_maxArcAngle="220.0" />
```
##### Through Code
* Kotlin
```
         val arcProgressLoader = ArcProgressLoader(this,
                        120, 20,
                        10.0f, 180.0f,
                        resources.getIntArray(R.array.colors_rgb))

                containerLayout.addView(arcProgressLoader)
```

* Java
```
        ArcProgressLoader arcProgressLoader = new ArcProgressLoader(this,
                        120, 20,
                        10.0f, 180.0f,
                        getResources().getIntArray(R.array.colors_rgb));

                container.addView(arcProgressLoader);
```


Please take a 2 mins survey to make this library better [here](https://goo.gl/forms/v0SZS0oI9rvInzdB3).
It won't take more than 2 mins I promise :) or feel free to drop an email at agrawalsuneet@gmail.com if face any issue or require any additional functionality in it.
```
Copyright 2018 Suneet Agrawal

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
