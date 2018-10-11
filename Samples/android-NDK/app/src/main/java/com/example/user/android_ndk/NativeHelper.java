package com.example.user.android_ndk;

/**
 * The type Native helper is used for wrapping all the native functions calls.
 */
public class NativeHelper {

    static {
        System.loadLibrary("native-lib");
    }


    /**
     * String from jni string.
     *
     * @return the string
     */
    public static native String stringFromJNI();


    /**
     * Gets member field from native.
     *
     * @param meshData the mesh data    Sample pojo class to test NDK sample
     * @return the member field from native
     */
    public static native float getMemberFieldFromNative(MeshData meshData);


    /**
     * Invoke member function from native int.
     *
     * @param meshData the mesh data
     * @return the int
     */
    public static native int invokeMemberFunctionFromNative(MeshData meshData);


    /**
     * Create object from native mesh data.
     *
     * @param facet the facet
     * @return the mesh data
     */
    public static native MeshData createObjectFromNative(int facet);


    // TODO: 10/4/18 Complete processing the array of objects
    public static native int processObjectArrayFromNative(MeshData[] meshArray);


}
