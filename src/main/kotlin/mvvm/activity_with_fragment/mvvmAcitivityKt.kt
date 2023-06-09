package mvvm.activity_with_fragment

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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.afanticar.common.utils.setOnSingleClickListener
import com.afanticar.aft_base.base_page.activity.BaseMvvmActivity
import ${packageName}.databinding.Activity${activityClass}Binding



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
            context: Context
        ) {

            val activity = getActivity(context)
            context.startActivity(
                Intent(
                    context,
                    ${activityClass}Activity::class.java
                ).apply {
                    if (activity == null) {
                        //不是ac，需要
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }
                    // putExtra("medalId", medalId)

                })
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
