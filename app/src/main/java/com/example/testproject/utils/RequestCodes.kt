package com.example.testproject.utils

enum class RequestCodes {

    LOCATION_PERMISSION,
    STORAGE_PERMISSIONS,
    READ_PHONE_STATE,

    // Image
    CAPTURE_IMAGE_FROM_CAMERA,
    CHOOSE_IMAGE_FROM_GALLERY,

    // Video
    CAPTURE_VIDEO_FROM_CAMERA,
    CHOOSE_VIDEO_FROM_GALLERY,

    // Audio
    CHOOSE_AUDIO_FROM_RECORDER,
    CHOOSE_AUDIO_FROM_STORAGE,

    // Public Services
    NEARBY_POLICE_STATIONS,
    E_COMPLAINT,
    EMERGENCY_NUMBERS,
    REPORT_INCIDENT,
    PANIC_MODE,

    // Police Services
    ASSIGNED_INCIDENT_DETAILS,
    GEO_ATTENDANCE_EVENT_DETAILS,
    GPS_TRACKER,
    CIRCULAR,

    // Download Files
    DOWNLOAD_PDF,
    EXPORT_AS_CSV,
    CREATE_CSV_FILE,

    // Public Services
    PUBLIC_EYE,

    // App Update Manager
    IN_APP_UPDATE

    ;

    fun getCode(): Int {
        return this.ordinal
    }

}