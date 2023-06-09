package other.mvvm.activity_with_fragment

fun mvvmAcitivityKt(
    basePackageName: String,
    activityClass: String,
    layoutName: String,
    packageName: String,
    beanName: String,
    viewModelEnable: Boolean,
    needPaging3Enable: Boolean
) = if (viewModelEnable) {
    """
package $packageName

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.afanticar.common.utils.setOnSingleClickListener
import ${packageName}.databinding.Activity${activityClass}Binding
import com.afanticar.base.ui.BaseMvvmActivity
import com.afanticar.common.dialog.CommonDialog


class ${activityClass}Activity : BaseMvvmActivity<Activity${activityClass}Binding,${activityClass}ViewModel>(R.layout.${layoutName}) {



  //  val medalId by lazy { intent.getStringExtra("medalId") }

    val m${activityClass}Fragment by lazy {
        ${activityClass}Fragment.newInstance()
    }


    override fun initView(savedInstanceState: Bundle?)  {
         resetImmersionBar(R.color.color_171722,false)
         mBinding.activityBack.setOnSingleClickListener({
            onBackPressed()
        })
        
     
        val translation = supportFragmentManager.beginTransaction()
        translation.replace(R.id.fragment, m${activityClass}Fragment)
        translation.commitNowAllowingStateLoss()

    }

    override fun initData() {

    }

    
    companion object {

        fun launch(
            activity: Activity
        ) {
            activity.startActivity(
                Intent(
                    activity,
                    ${activityClass}Activity::class.java
                ).apply {

                   // putExtra("medalId", medalId)
              
                })
        }
        
        
        fun launchWithContext(
            context: Context
        ) {
            context.startActivity(
                Intent(
                    context,
                    DiagnosisActionCenterActivity::class.java
                ).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    // putExtra("medalId", medalId)

                })
        }

        fun launch(
            context: Context
        ) {

            val activity = CommonDialog.getActivity(context)


            if (activity != null) {
                launch(activity)
            } else {
                launchWithContext(context)
            }


        }
    }
}
"""
} else {
    """

package ${packageName}
import ${basePackageName}.ui.BaseActivity

class ${activityClass}Activity : BaseActivity(R.layout.${layoutName}) {
    override fun onEvent() {
      
    }
}
    
   """
}
