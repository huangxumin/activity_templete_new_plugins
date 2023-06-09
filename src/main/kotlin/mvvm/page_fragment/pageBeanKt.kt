package mvvm.page_fragment

fun pageBeanKt(
        basePackageName: String,
        packageName: String,
        beanName: String,
) =
    """
package ${packageName}


data class ${beanName}Bean(
     var xx: String = "",
) 
"""