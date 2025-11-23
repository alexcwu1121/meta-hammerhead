LINUX_VERSION ?= "6.6.78"
LINUX_BRANCH ?= "hammerhead-6.6.y"
LINUX_KMETA_BRANCH ?= "yocto-6.6"

SRCREV_machine = "6f8e8eb116f64d51d4231157bfb9169d095c0545"
SRCREV_meta = "52ff0d75713ce61962b325a2090bd55e216f0cf3"

KMETA = "kernel-meta"

SRC_URI = " \
    git://github.com/alexcwu1121/raspberrypi-linux.git;name=machine;branch=${LINUX_BRANCH};protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_KMETA_BRANCH};destsuffix=${KMETA} \
    file://powersave.cfg;layersrc=meta-raspberrypi \
    "

require recipes-kernel/linux/linux-raspberrypi.inc

KERNEL_DTC_FLAGS += "-@ -H epapr"

RDEPENDS:${KERNEL_PACKAGE_NAME}:raspberrypi-armv7:append = " ${RASPBERRYPI_v7_KERNEL_PACKAGE_NAME}"
RDEPENDS:${KERNEL_PACKAGE_NAME}-base:raspberrypi-armv7:append = " ${RASPBERRYPI_v7_KERNEL_PACKAGE_NAME}-base"
RDEPENDS:${KERNEL_PACKAGE_NAME}-image:raspberrypi-armv7:append = " ${RASPBERRYPI_v7_KERNEL_PACKAGE_NAME}-image"
RDEPENDS:${KERNEL_PACKAGE_NAME}-dev:raspberrypi-armv7:append = " ${RASPBERRYPI_v7_KERNEL_PACKAGE_NAME}-dev"
RDEPENDS:${KERNEL_PACKAGE_NAME}-vmlinux:raspberrypi-armv7:append = " ${RASPBERRYPI_v7_KERNEL_PACKAGE_NAME}-vmlinux"
RDEPENDS:${KERNEL_PACKAGE_NAME}-modules:raspberrypi-armv7:append = " ${RASPBERRYPI_v7_KERNEL_PACKAGE_NAME}-modules"
RDEPENDS:${KERNEL_PACKAGE_NAME}-dbg:raspberrypi-armv7:append = " ${RASPBERRYPI_v7_KERNEL_PACKAGE_NAME}-dbg"

DEPLOYDEP = ""
DEPLOYDEP:raspberrypi-armv7 = "${RASPBERRYPI_v7_KERNEL}:do_deploy"
do_deploy[depends] += "${DEPLOYDEP}"
