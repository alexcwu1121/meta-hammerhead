inherit core-image
inherit extrausers

# Remove bluetooth
IMAGE_INSTALL:remove = "bluez5 pi-bluetooth"
