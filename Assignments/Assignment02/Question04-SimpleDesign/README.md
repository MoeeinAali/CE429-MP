# Assignment02 - Question04 - SimpleDesign - Part01
![RegistrationForm](https://github.com/MoeeinAali/CE429-MP/blob/560b100b5412c11c364096dfbc6f625ac0369a2f/Assignments/Assignment02/Question04-SimpleDesign/Part01.png)
## XML Codes
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp"
        android:orientation="vertical">

    <TextView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="0.5"
            android:gravity="center"
            android:layout_marginStart="50dp"
            android:layout_marginEnd="50dp"
            android:background="@color/black" />

    <LinearLayout
            android:layout_width="match_parent"
            android:layout_marginTop="100dp"
            android:layout_marginBottom="100dp"
            android:layout_height="0dp"
            android:layout_weight="4"
            android:orientation="horizontal"
            android:gravity="center"
            android:background="@color/white">


        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="0.7"
                android:gravity="center"
                android:background="@color/black" />

        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="4"
                android:gravity="center"
                android:background="@color/white" />

        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="0.7"
                android:gravity="center"
                android:background="@color/black" />


    </LinearLayout>

    <TextView
            android:layout_width="match_parent"
            android:layout_marginStart="50dp"
            android:layout_marginEnd="50dp"
            android:layout_height="0dp"
            android:layout_weight="0.5"
            android:gravity="center"
            android:background="@color/black" />
</LinearLayout>
```

# Assignment02 - Question04 - SimpleDesign - Part02

![RegistrationForm](https://github.com/MoeeinAali/CE429-MP/blob/560b100b5412c11c364096dfbc6f625ac0369a2f/Assignments/Assignment02/Question04-SimpleDesign/Part02.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp"
        android:orientation="vertical">

    <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="0.5"
            android:gravity="center">

        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="0.7"
                android:gravity="center"
                android:background="@color/black" />

        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="0.2"
                android:gravity="center"
                android:background="@color/white" />

        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="0.7"
                android:gravity="center"
                android:background="@color/black" />
    </LinearLayout>

    <LinearLayout
            android:layout_width="match_parent"
            android:layout_marginTop="50dp"
            android:layout_marginBottom="50dp"
            android:layout_height="0dp"
            android:layout_weight="4"
            android:orientation="horizontal"
            android:gravity="center"
            android:background="@color/white">


        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="4"
                android:gravity="center"
                android:background="@color/white" />

        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="1"
                android:gravity="center"
                android:background="@color/black" />

        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="4"
                android:gravity="center"
                android:background="@color/white" />


    </LinearLayout>

    <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="0.5"
            android:gravity="center">

        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="0.7"
                android:gravity="center"
                android:background="@color/black" />

        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="0.2"
                android:gravity="center"
                android:background="@color/white" />

        <TextView
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_weight="0.7"
                android:gravity="center"
                android:background="@color/black" />
    </LinearLayout>

</LinearLayout>
```

# Assignment02 - Question04 - SimpleDesign - Part03

![RegistrationForm](https://github.com/MoeeinAali/CE429-MP/blob/560b100b5412c11c364096dfbc6f625ac0369a2f/Assignments/Assignment02/Question04-SimpleDesign/Part03.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp"
        android:gravity="center"
        android:orientation="vertical">

    <LinearLayout
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:gravity="center"
            android:layout_height="wrap_content">


        <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:layout_marginBottom="10dp"
                android:orientation="horizontal">

            <View
                    android:layout_width="100dp"
                    android:layout_height="100dp"
                    android:background="@color/black"></View>

        </LinearLayout>

        <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:orientation="horizontal">

            <View
                    android:layout_width="100dp"
                    android:layout_height="100dp"
                    android:layout_marginEnd="10dp"
                    android:background="@color/black"></View>

            <View
                    android:layout_width="100dp"
                    android:layout_height="100dp"
                    android:layout_gravity="center"
                    android:background="@color/black"></View>

            <View
                    android:layout_width="100dp"
                    android:layout_height="100dp"
                    android:layout_marginStart="10dp"
                    android:background="@color/black"></View>

        </LinearLayout>

        <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:gravity="center"
                android:layout_marginTop="10dp"
                android:orientation="horizontal">

            <View
                    android:layout_width="100dp"
                    android:layout_height="100dp"
                    android:background="@color/black"></View>

        </LinearLayout>
    </LinearLayout>
</LinearLayout>
```

# Assignment02 - Question04 - SimpleDesign - Part04

![RegistrationForm](https://github.com/MoeeinAali/CE429-MP/blob/560b100b5412c11c364096dfbc6f625ac0369a2f/Assignments/Assignment02/Question04-SimpleDesign/Part04.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp"
        android:orientation="horizontal">

    <LinearLayout
            android:layout_width="0dp"
            android:layout_weight="1"
            android:weightSum="16"
            android:layout_height="match_parent"
            android:orientation="vertical">

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>
    </LinearLayout>

    <LinearLayout
            android:layout_width="0dp"
            android:layout_weight="1"
            android:weightSum="16"
            android:layout_height="match_parent"
            android:orientation="vertical">

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="2"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>


        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>
    </LinearLayout>

</LinearLayout>
```

# Assignment02 - Question04 - SimpleDesign - Part05

![RegistrationForm](https://github.com/MoeeinAali/CE429-MP/blob/560b100b5412c11c364096dfbc6f625ac0369a2f/Assignments/Assignment02/Question04-SimpleDesign/Part05.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp"
        android:orientation="horizontal">

    <LinearLayout
            android:layout_width="0dp"
            android:layout_weight="1"
            android:weightSum="16"
            android:layout_height="match_parent"
            android:orientation="vertical">

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>
    </LinearLayout>

    <LinearLayout
            android:layout_width="0dp"
            android:layout_weight="1"
            android:weightSum="16"
            android:layout_height="match_parent"
            android:orientation="vertical">

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="2"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="@color/black"></TextView>

        <TextView
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="3"
                android:background="@color/white"></TextView>
```

# Assignment02 - Question04 - SimpleDesign - Part06

![RegistrationForm](https://github.com/MoeeinAali/CE429-MP/blob/560b100b5412c11c364096dfbc6f625ac0369a2f/Assignments/Assignment02/Question04-SimpleDesign/Part06.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp"
        android:gravity="center"
        android:weightSum="15"
        android:orientation="vertical">

    <View
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="5"
            android:background="@color/white"></View>

    <LinearLayout
            android:layout_width="match_parent"
            android:orientation="vertical"
            android:weightSum="5"
            android:layout_weight="6"
            android:gravity="center"
            android:layout_height="0dp">


        <LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="0dp"
                android:layout_weight="1">

            <View
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="5"
                    android:background="@color/black"></View>

            <View
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="1"
                    android:background="@color/white"></View>

            <View
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="5"
                    android:background="@color/black"></View>

        </LinearLayout>

        <LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="0dp"
                android:layout_marginTop="10dp"
                android:layout_weight="3">

            <View
                    android:layout_width="0dp"
                    android:background="@color/white"
                    android:layout_weight="4"
                    android:layout_height="match_parent"></View>

            <View
                    android:layout_width="0dp"
                    android:background="@color/black"
                    android:layout_weight="1"
                    android:layout_height="match_parent"></View>

            <View
                    android:layout_width="0dp"
                    android:background="@color/white"
                    android:layout_weight="4"
                    android:layout_height="match_parent"></View>
        </LinearLayout>

        <LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="0dp"
                android:layout_marginTop="10dp"
                android:layout_weight="1">


            <View
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="1"
                    android:background="@color/white"></View>

            <View
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="3"
                    android:background="@color/black"></View>

            <View
                    android:layout_width="0dp"
                    android:layout_height="match_parent"
                    android:layout_weight="1"
                    android:background="@color/white"></View>


        </LinearLayout>


    </LinearLayout>

    <View
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="5"
            android:background="@color/white"></View>
</LinearLayout>
```
