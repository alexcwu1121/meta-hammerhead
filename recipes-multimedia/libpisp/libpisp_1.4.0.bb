
DESCRIPTION = "A helper library to generate run-time configuration for the Raspberry Pi \
ISP (PiSP), consisting of the Frontend and Backend hardware components."
HOMEPAGE = "https://github.com/raspberrypi/libpisp"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3417a46e992fdf62e5759fba9baef7a7"

S = "${WORKDIR}/git"

PV = "1.4.0"
SRC_URI = "git://github.com/raspberrypi/libpisp.git;protocol=https;branch=main;tag=v${PV}"

DEPENDS = "nlohmann-json"

inherit meson pkgconfig
