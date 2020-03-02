SUMMARY = "An image that is solely meant for creating a portal to another machine. Also called a 'thin client'"

inherit core-image

DEPENDS += "bcm2835-bootfiles"

XSERVER = " \
    xserver-xorg \
    xserver-xorg-extension-glx \
    xf86-video-fbdev \
    xf86-video-modesetting \
"
IMAGE_FEATURES += "x11"

WIFI = " \
    crda \
    iw \
    linux-firmware-rpidistro-bcm43430 \
    linux-firmware-rpidistro-bcm43455 \
    wpa-supplicant \
"

DEV_EXTRAS = " \
    mainapp-remmina \
    tcpdump \
    ethtool \
"

IMAGE_INSTALL += " \
    ${DEV_EXTRAS} \
    ${WIFI} \
"

export IMAGE_BASENAME = "thin-client-image"
