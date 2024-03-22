# Assignment04 - Question01 - SimpleDesign - Part01

![question01](1.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <View
        android:layout_width="300dp"
        android:layout_height="30dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:background="@color/black"></View>

    <View
        android:layout_width="300dp"
        android:layout_height="30dp"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:background="@color/black"></View>
    
</RelativeLayout>

```

# Assignment04 - Question01 - SimpleDesign - Part02

![question2](2.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <View
        android:layout_width="300dp"
        android:layout_height="30dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:background="@color/black"></View>

    <View
        android:layout_width="300dp"
        android:layout_height="30dp"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:background="@color/black"></View>

    <View
        android:layout_width="30dp"
        android:layout_height="300dp"
        android:layout_alignParentStart="true"
        android:layout_centerVertical="true"
        android:background="@color/black"></View>

    <View
        android:layout_width="30dp"
        android:layout_height="300dp"
        android:layout_alignParentEnd="true"
        android:layout_centerVertical="true"
        android:background="@color/black"></View>

</RelativeLayout>
```

# Assignment04 - Question01 - SimpleDesign - Part03

![question3](3.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <View
        android:layout_width="180dp"
        android:layout_height="30dp"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:background="@color/black"></View>

    <View
        android:layout_width="180dp"
        android:layout_height="30dp"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:background="@color/black"></View>

    <View
        android:layout_width="180dp"
        android:layout_height="30dp"
        android:layout_alignParentStart="true"
        android:layout_alignParentBottom="true"
        android:background="@color/black"></View>

    <View
        android:layout_width="180dp"
        android:layout_height="30dp"
        android:layout_alignParentEnd="true"
        android:layout_alignParentBottom="true"
        android:background="@color/black"></View>

    <View
        android:layout_width="50dp"
        android:layout_height="640dp"
        android:layout_centerInParent="true"
        android:background="@color/black"></View>


</RelativeLayout>
```

# Assignment04 - Question01 - SimpleDesign - Part04

![question4](4.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <View
        android:id="@+id/btnCenter"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_centerInParent="true"
        android:layout_margin="10dp"
        android:background="@color/black"></View>

    <View
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_above="@id/btnCenter"
        android:layout_centerInParent="true"
        android:background="@color/black"></View>

    <View
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_below="@id/btnCenter"
        android:layout_centerInParent="true"
        android:background="@color/black"></View>


    <View
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_centerInParent="true"
        android:layout_toEndOf="@id/btnCenter"
        android:background="@color/black"></View>


    <View
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_centerInParent="true"
        android:layout_toStartOf="@id/btnCenter"
        android:background="@color/black"></View>


</RelativeLayout>
```

# Assignment04 - Question01 - SimpleDesign - Part05

![question5](5.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <View
        android:id="@+id/btn1"
        android:layout_width="210dp"
        android:layout_height="50dp"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:background="@color/black"></View>

    <View
        android:id="@+id/btn2"
        android:layout_width="210dp"
        android:layout_height="50dp"
        android:layout_below="@+id/btn1"
        android:layout_marginTop="@dimen/view_margin"
        android:layout_toEndOf="@+id/btn1"
        android:background="@color/black"></View>

    <View
        android:id="@+id/btn3"
        android:layout_width="210dp"
        android:layout_height="50dp"
        android:layout_below="@+id/btn2"
        android:layout_marginTop="@dimen/view_margin"
        android:layout_toStartOf="@+id/btn2"
        android:background="@color/black"></View>


    <View
        android:id="@+id/btn4"
        android:layout_width="210dp"
        android:layout_height="50dp"
        android:layout_below="@+id/btn3"
        android:layout_marginTop="@dimen/view_margin"
        android:layout_toEndOf="@+id/btn3"
        android:background="@color/black"></View>

    <View
        android:id="@+id/btn5"
        android:layout_width="210dp"
        android:layout_height="50dp"
        android:layout_below="@+id/btn4"
        android:layout_marginTop="@dimen/view_margin"
        android:layout_toStartOf="@+id/btn4"
        android:background="@color/black"></View>

    <View
        android:id="@+id/btn6"
        android:layout_width="210dp"
        android:layout_height="50dp"
        android:layout_below="@+id/btn5"
        android:layout_marginTop="@dimen/view_margin"
        android:layout_toEndOf="@+id/btn5"
        android:background="@color/black"></View>

    <View
        android:id="@+id/btn7"
        android:layout_width="210dp"
        android:layout_height="50dp"
        android:layout_below="@+id/btn6"
        android:layout_marginTop="@dimen/view_margin"
        android:layout_toStartOf="@+id/btn6"
        android:background="@color/black"></View>

    <View
        android:id="@+id/btn8"
        android:layout_width="210dp"
        android:layout_height="50dp"
        android:layout_below="@+id/btn7"
        android:layout_marginTop="@dimen/view_margin"
        android:layout_toEndOf="@+id/btn7"
        android:background="@color/black"></View>


</RelativeLayout>
```

# Assignment04 - Question01 - SimpleDesign - Part06

![question6](6.png)

## XML Codes

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <View
        android:layout_width="50dp"
        android:layout_margin="10dp"
        android:layout_height="180dp"
        android:id="@+id/btnCenter"
        android:layout_centerInParent="true"
        android:background="@color/black"></View>

    <View
        android:layout_width="180dp"
        android:layout_height="50dp"
        android:layout_margin="10dp"
        android:layout_alignParentStart="true"
        android:layout_above="@+id/btnCenter"
        android:background="@color/black"></View>
    <View
        android:layout_width="180dp"
        android:layout_height="50dp"
        android:layout_margin="10dp"
        android:layout_alignParentEnd="true"
        android:layout_above="@+id/btnCenter"
        android:background="@color/black"></View>

    <View
        android:layout_width="180dp"
        android:layout_height="50dp"
        android:layout_margin="10dp"
        android:layout_centerHorizontal="true"
        android:layout_below="@+id/btnCenter"
        android:background="@color/black"></View>
</RelativeLayout>
```
