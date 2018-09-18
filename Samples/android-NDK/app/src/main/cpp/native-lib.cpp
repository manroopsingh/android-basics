#include <jni.h>
#include <string>

//helper method to call a method in a java object
int getFacetCount(JNIEnv *env, jobject object);

//accessing a string from the native code
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_user_android_1ndk_NativeHelper_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

//accessing a java object value from the native code
extern "C"
JNIEXPORT jfloat JNICALL
Java_com_example_user_android_1ndk_NativeHelper_getMemberFieldFromNative(
        JNIEnv *env,
        jobject /* this */,
        jobject meshObj) {

    float result = 0.0f;

    //get the passed object for Mesh data
    jclass cls = env->GetObjectClass(meshObj);

    //get field ]F = Array of floats
    jfieldID fieldId = env->GetFieldID(cls, "VertexCoords", "[F");

    //get the object field, returns Jobject because its an array
    jobject objArray = env->GetObjectField(meshObj, fieldId);

    //cast the object to float array
    jfloatArray *fArray = reinterpret_cast<jfloatArray *>(&objArray);

    jsize len = env->GetArrayLength(*fArray);

    //Get the elements
    float *data = env->GetFloatArrayElements(*fArray, 0);

    for (int i = 0; i < len; ++i) {

        result += data[i];
    }

    //release the float array elements
    env->ReleaseFloatArrayElements(*fArray, data, 0);


    return result;
}


//accessing value from the java object passed
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_user_android_1ndk_NativeHelper_invokeMemberFunctionFromNative(
        JNIEnv *env,
        jobject callingObject,
        jobject meshData) {

    jclass cls = env->GetObjectClass(meshData);
    jmethodID methodId = env->GetMethodID(cls, "getFacetCount", "()I");
    int result = env->CallIntMethod(meshData, methodId);

    return result;

}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_example_user_android_1ndk_NativeHelper_createObjectFromNative(
        JNIEnv *env,
        jobject callingObject,
        jint param) {

    jclass cls = env->FindClass("com/example/user/android_ndk/MeshData");
    jmethodID methodId = env->GetMethodID(cls, "<init>", "(I)V");
    jobject object = env->NewObject(cls, methodId, param);
    return object;


}


extern "C"
JNIEXPORT jint JNICALL
Java_com_example_user_android_1ndk_NativeHelper_processObjectArrayFromNative(
        JNIEnv *env,
        jobject callingObject,
        jobjectArray meshArray) {

    int resultSum = 0;
    int len = env->GetArrayLength(meshArray);

//    Get all the objects in the array
    for (int i = 0; i < len; ++i) {
        jobject object = env->GetObjectArrayElement(meshArray, i);

//        resultSum += getFacetCount(env, object);

        jclass cls = env->GetObjectClass(object);
        jmethodID methodId = env->GetMethodID(cls, "getFacetCount", "()I");
        resultSum += env->CallIntMethod(cls, methodId);
    }
    return resultSum;
}


int getFacetCount(JNIEnv *env, jobject object) {

    int result = 0;
    jclass cls = env->GetObjectClass(object);
    jmethodID methodId = env->GetMethodID(cls, "getFacetCount", "()I");

    result = env->CallIntMethod(cls, methodId);

    return result;
}