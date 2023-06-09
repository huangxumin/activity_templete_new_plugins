package mvvm.page_fragment
fun pageFragmentRepository(
        packageName: String,
        activityClass: String,
        beanName: String,
        needPaging3Enable: Boolean,
        pagingSourceName: String
)=if (needPaging3Enable) {
    """
package ${packageName}

import javax.inject.Inject
import ${packageName}.${beanName}Bean
import com.afanticar.network.bean.CommonPageBean

class ${activityClass}FragmentRepository @Inject constructor() {

    suspend fun 网络请求(page: Int, size: Int): CommonPageBean<${beanName}Bean> {
                   //测试数据
            CommonPageBean<RegisterSuccessBean>(
                1, 20, 10, 1,
                mutableListOf(
                    RegisterSuccessBean("xx"),
                    RegisterSuccessBean("xx"),
                    RegisterSuccessBean("xx"),
                    RegisterSuccessBean("xx"),
                    RegisterSuccessBean("xx"),
                )
            )

//            XService.create().getRegisterSuccessData(it.current, it.pageSize)
    }
}
"""
} else {

    """
package ${packageName}
import javax.inject.Inject

class ${activityClass}FragmentRepository @Inject constructor() {



}
"""

}

