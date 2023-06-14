package mvvm.activity_with_fragment

fun mvvmRepository(
    packageName: String,
    activityClass: String,
    beanName: String,
    needPaging3Enable: Boolean,
    pagingSourceName: String
) =
    """
package ${packageName}

import com.afanticar.common.common_fragment_page.bean.CommonPageStatusBean
import com.afanticar.common.common_fragment_page.bean.LoadStatusBean
import com.afanticar.network.bean.CommonPageBean
import com.afanticar.common.net.executeReturnCommonBean


class ${activityClass}Repository @Inject constructor() {

    suspend fun get${activityClass}Data(loadStatus: LoadStatusBean): CommonPageStatusBean<${beanName}Bean> {

       return executeReturnCommonBean<${beanName}Bean>(loadStatus){
       
                   //测试数据
            CommonPageBean<${beanName}Bean}>(
                1, 20, 10, 1,
                mutableListOf(
                    ${beanName}Bean("xx"),
                    ${beanName}Bean("xx"),
                    ${beanName}Bean("xx"),
                    ${beanName}Bean("xx"),
                    ${beanName}Bean("xx"),
                )
            )
       
 //             XService.create().get${activityClass}Data(it.current, it.pageSize,)
       }
    }

}
"""

