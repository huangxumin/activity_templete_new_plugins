package mvvm.page_fragment

fun pageAdapterLayoutKt(
    packageName: String,
    beanName: String
) =
    """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>

    </data>
    
<androidx.constraintlayout.widget.ConstraintLayout 
    android:layout_width="match_parent"
    android:layout_height="match_parent">
   
    
    
        <TextView
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:gravity="center"
            android:text="测试"
            android:textSize="18sp"
            app:layout_constraintTop_toTopOf="parent" />

    
</androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""
