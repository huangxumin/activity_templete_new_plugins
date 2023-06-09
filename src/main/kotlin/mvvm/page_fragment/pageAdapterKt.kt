package mvvm.page_fragment

fun pageAdapterKt(
        basePackageName: String,
        packageName: String,
        beanName: String,
        adapterName: String,
        adapterLayoutName: String,
) =
    """
package ${packageName}


import ${packageName}.databinding.${beanName}ItemLayoutBinding
import com.afanticar.common.common_page_new_utils.adapter.CommonPageAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
        
class ${adapterName}() : CommonPageAdapter<${beanName}Bean,${beanName}ItemLayoutBinding>(
   R.layout.${adapterLayoutName}) {


    override fun areItemsTheSameFun(oldItem: ${beanName}Bean, newItem: ${beanName}Bean): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSameFun(oldItem: ${beanName}Bean, newItem: ${beanName}Bean): Boolean {
        return oldItem == newItem
    }
    
    
    override fun convert(holder: BaseDataBindingHolder<${beanName}ItemLayoutBinding>, item: ${beanName}Bean) {
        holder.dataBinding?.run {
            item.run {
            //do
            }}
            
    }

}
"""