LINUX_VERSION ?= "6.6.78"
LINUX_BRANCH ?= "hammerhead-6.6.y"
LINUX_KMETA_BRANCH ?= "yocto-6.6"
KMETA = "kernel-meta"

SRC_URI = "git://github.com/alexcwu1121/raspberrypi-linux.git;name=machine;branch=${LINUX_BRANCH};protocol=https \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_KMETA_BRANCH};destsuffix=${KMETA} \
           file://powersave.cfg;layersrc=meta-raspberrypi \
           ${@bb.utils.contains("INITRAMFS_IMAGE_BUNDLE", "1", "file://initramfs-image-bundle.cfg", "", d)} \
           ${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "file://vc4graphics.cfg", "", d)} \
           ${@bb.utils.contains("MACHINE_FEATURES", "wm8960", "file://wm8960.cfg", "", d)} \
           file://default-cpu-governor.cfg \
           file://can.cfg \
           "

SRCREV_machine = "a850ae30ea6078e788f7370db072cfc88a557df0"
SRCREV_meta = "52ff0d75713ce61962b325a2090bd55e216f0cf3"

require recipes-kernel/linux/linux-raspberrypi.inc

KERNEL_DTC_FLAGS += "-@ -H epapr"
