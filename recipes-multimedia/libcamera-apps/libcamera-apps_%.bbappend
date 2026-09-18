FILES:${PN} += "${libdir}/rpicam_app.so.*"

# add libav support
PACKAGECONFIG:append = " libav"
