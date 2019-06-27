//
// Created by Aagito on 2/3/2019.
//

#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_inficare_agentapp_Keys_getAPIKEY(JNIEnv *env, jobject instance) {

 return (*env)->  NewStringUTF(env, "adminhero");
}

JNIEXPORT jstring JNICALL
Java_com_inficare_agentapp_Keys_getAPISECRET(JNIEnv *env, jobject instance) {

 return (*env)->NewStringUTF(env, "testapp");
}
