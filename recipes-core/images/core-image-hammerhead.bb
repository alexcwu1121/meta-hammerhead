SUMMARY = "Hammerhead core image"
LICENSE = "MIT"

inherit core-image
inherit extrausers

# Set default password
EXTRA_USERS_PARAMS = "\
    usermod -p '${PASSWD}' root; \
    "
