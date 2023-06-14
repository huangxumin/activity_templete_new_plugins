package mvvm.activity_with_fragment

fun mvvmViewModel(
    basePackageName: String,
    packageName: String,
    activityClass: String,
    beanName: String,
    needPaging3Enable: Boolean
) =

    """
package $packageName

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.afanticar.common.common_fragment_page.CommonPageViewModel
import com.afanticar.common.common_fragment_page.bean.CommonPageStatusBean
import com.afanticar.common.common_fragment_page.bean.LoadStatusBean
import kotlinx.coroutines.launch

class ${activityClass}ViewModel constructor(application: Application): CommonPageViewModel(application) {


    val repository: ${activityClass}Repository by lazy{${activityClass}Repository()}

    val m${activityClass}Data = MutableLiveData<CommonPageStatusBean<${beanName}Bean>>()

    fun get${activityClass}Data(loadStatus: LoadStatusBean) {

        viewModelScope.launch {
         
               val date= repository.get${activityClass}Data(loadStatus)
               m${activityClass}Data.postValue(date)
          
        }

    }
    
}
"""
