package com.tutelar.core
/**
 * Created at: Aug 2022
 * Created by: Gowtham R
 */
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import com.tutelar.utils.*
import com.tutelar.utils.getDeviceId
import com.tutelar.utils.getIPAddress
import com.tutelar.utils.getImeiNumber
import com.tutelar.utils.isEmulator

@SuppressLint("NewApi")
internal fun getDetails(activity: Activity): Map<String, Any> {
    return mapOf(
        "is_real_device" to !isEmulator(),
        "device" to Build.DEVICE,
        "device_id" to getDeviceId(activity),
        "android_id" to Build.ID,
        "board" to Build.BOARD,
        "brand" to Build.BRAND,
        "display" to Build.DISPLAY,
        "boot_loader" to Build.BOOTLOADER,
        "finger_print" to Build.FINGERPRINT,
        "hardware" to Build.HARDWARE,
        "host" to Build.HOST,
        "manufacturer" to Build.MANUFACTURER,
        "model" to Build.MODEL,
        "product" to Build.PRODUCT,
        "user" to Build.USER,
        "type" to Build.TYPE,
        "is_emulator" to isEmulator(),
        "ip_address" to getIPAddress(),
        "imei_number" to getImeiNumber(activity),
        "battery_level" to getBatteryLevel(activity),
        "data_enabled" to isDataEnabled(activity),
        "serial_number" to getSimSerialNumber(activity),
        "network_type" to getNetworkType(activity),
        "data_roaming" to isRoamingEnabled(activity),
        "root_status" to isRooted(),
        "memory_information" to getMemoryInfo(activity),
        "kernel_version" to getKernelVersion(),
        "proximity_sensor" to getProximitySensor(activity),
        "language_info" to getDeviceLanguage(),
        "country_info" to getDeviceCountry(),
        "location_info" to getDeviceLocation(),
        "system_storage" to getStorageInfo(activity),
        "external_storage" to getSdCardInfo(activity),
        "screen_brightness" to getScreenBrightness(activity),
        "screen_size" to getScreenSize(activity),
        "developer_mode_enabled" to isDevMode(activity),
        "cell_info" to getAllCellInfo(activity)
    )
}
