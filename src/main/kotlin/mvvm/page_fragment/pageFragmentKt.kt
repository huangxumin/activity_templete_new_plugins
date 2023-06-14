package mvvm.page_fragment

fun pageFragmentKt(
    basePackageName: String?,
    fragmentClass: String,
    layoutName: String,
    packageName: String,
    beanName: String,
    viewModelEnable: Boolean,
    needPaging3Enable: Boolean,
    adapterName: String,
) = if (viewModelEnable) {


    """
package ${packageName}

import android.os.Bundle
import android.view.View
import ${packageName}.R
import ${packageName}.${beanName}Adapter
import com.afanticar.aft_common.widget.LinearSpacingItemDecoration
import com.afanticar.common.common_fragment_page.PageNewFragment
import com.afanticar.common.common_fragment_page.bean.LoadStatusBean
import com.afanticar.common.common_fragment_page.bean.isFailed
import com.afanticar.common.common_fragment_page.bean.isSuccess
import ${packageName}. ${beanName}Bean
import ${packageName}.databinding.Fragment${fragmentClass}Binding



class ${fragmentClass}Fragment : PageNewFragment<Fragment${fragmentClass}Binding,${fragmentClass}ViewModel, ${beanName}Bean>(R.layout.${layoutName}) {

 private val m${beanName}Adapter by lazy { ${beanName}Adapter() }

    val mLinearSpacingItemDecoration by lazy {
        LinearSpacingItemDecoration(
            14,
            false,
            false,
            false,
            true,
        )
    }
    
    override fun initDataCallback() {
        mViewModel.m${fragmentClass}Data.observe(this){

            it.isSuccess { registerSuccessBean, list ->


            }
            it.isFailed { localizewdCode, localizewdMessage ->


            }

            setPageAdapterDataAndResetViewStatusWithDefaultAdapter(it)
        }
    }
    
     @InternalCoroutinesApi
    override fun loadData(loadStatus: LoadStatusBean) {
        mViewModel.get${fragmentClass}Data(loadStatus)
    }
    
    @InternalCoroutinesApi
    override fun initView() {
        prepareDefaultPageViewStatus(
            mBinding.refreshLayout,
            mBinding.recyclerview,
            m${beanName}Adapter,
            mBinding.loading,
        )

        mBinding.recyclerview.removeItemDecoration(mLinearSpacingItemDecoration)
        mBinding.recyclerview.addItemDecoration(
            mLinearSpacingItemDecoration
        )

    }
    
    
       companion object {
        fun newInstance() =
            ${fragmentClass}Fragment().apply {
                this.arguments = Bundle().apply {

                   // putString("medalId", medalId)
           
                }
            }
    }
    

}
"""


} else {
    """
package ${packageName}
import com.afanticar.base.ui.BaseFragment

class ${fragmentClass}Fragment : BaseFragment(R.layout.${layoutName}) {

    override fun initView() {
    }

    override fun initData() {
    }

    override fun onEvent() {
    }
}
    """
}
