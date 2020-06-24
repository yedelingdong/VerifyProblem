1.
androidTest
在Module的build.gradle文件中添加以下代码：
apply plugin : 'com.android.application'
apply plugin: 'jacoco'

buildTypes {
    release {
        minifyEnabled false
        proguardFiles getDefaultProguardFile ('proguard-android.txt' ), 'proguard-rules.pro'
    }
    debug {
        testCoverageEnabled true
    }
}

添加完代码之后，打开右侧的Gradle面板运行connectedAndroidTest任务，
或在Terminal控制台输入 gradlew connectedAndroidTest，回车

在\app\build\reports\androidTests\connected\index.html 查看androidTest测试报告

在\app\build\reports\coverage\debug\index.html 查看androidTest覆盖率报告

androidTest包下未添加测试案例，所以Test Summary测试条数为0，覆盖率也都为0。可自行添加案例测试


build.gradle中自定义task -> hello所在目录:
app\Tasks\other\hello

