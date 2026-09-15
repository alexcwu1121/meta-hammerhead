SUMMARY = "Hammerhead development image"
LICENSE = "MIT"

require recipes-core/images/hammerhead-core-image.inc

# Set default password
EXTRA_USERS_PARAMS = "\
    usermod -p '${PASSWD}' root; \
    "

IMAGE_INSTALL += " \
    python3 \
    python3-pip \
    python3-modules \
    python3-numpy \
    python3-spidev \
    python3-pyserial \
    python3-smbus \
    bash \
    nano \
    coreutils \
    util-linux \
    procps \
    psmisc \
    findutils \
    grep \
    sed \
    gawk \
    less \
    tar \
    iproute2 \
    iputils \
    tcpdump \
    curl \
    wget \
    i2c-tools \
    spidev-test \
    libgpiod \
    libgpiod-tools \
    usbutils \
    can-utils \
    lmsensors-sensors \
    lmsensors-libsensors \
    kmod \
    util-linux \
    dtc \
    "

EXTRA_IMAGE_FEATURES += "ssh-server-dropbear"

#SWUPDATE_IMAGES_FSTYPES[hammerhead-dev-image] = "wic.bz2"
#inherit swupdate-image
