# Raspberry Pi 5 uses pisp, which is not supported by original libcamera source. Defer to raspberry pi's fork

SRC_URI = " \
    git://github.com/raspberrypi/libcamera.git;protocol=https;branch=main \
    file://0001-media_device-Add-bool-return-type-to-unlock.patch \
"

SRCREV = "29156679717bec7cc4784aeba3548807f2c27fca"

DEPENDS += "libpisp"

# Stop raspi layer from adding its own packageconfig options, we want to explicitly build pisp support
PACKAGECONFIG:remove:rpi = "raspberrypi"

# explicitly build pisp support
# TODO: consider removing vc4 support as we don't target pi 4
LIBCAMERA_PIPELINES = "rpi/vc4,rpi/pisp"
EXTRA_OEMESON = " \
    -Dpipelines=${LIBCAMERA_PIPELINES} \
    -Dipas=${LIBCAMERA_PIPELINES} \
    -Dv4l2=true \
    -Dcam=enabled \
    -Dlc-compliance=disabled \
    -Dtest=false \
    -Ddocumentation=disabled \
"
