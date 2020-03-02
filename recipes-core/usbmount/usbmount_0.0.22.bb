SUMMARY = "Auto mount USB drives"
LICENSE = "CLOSED"

SRCREV = "9a92e7d622662380f4329e0db17e263509715722"
SRC_URI = " \
    git://github.com/rbrito/usbmount.git;protocol=https \
"

S = "${WORKDIR}/git"

do_compile () {
    :
}

do_install () {
    install -d "${D}${sysconfdir}/usbmount/mount.d"
    install -d "${D}${sysconfdir}/usbmount/umount.d"

    install -m 644 "${S}/usbmount.conf" "${D}${sysconfdir}/usbmount/usbmount.conf"
    install -m 755 "${S}/00_create_model_symlink" "${D}${sysconfdir}/usbmount/mount.d/00_create_model_symlink"
    install -m 755 "${S}/00_remove_model_symlink" "${D}${sysconfdir}/usbmount/umount.d/00_remove_model_symlink"

    install -d "${D}${datadir}/usbmount"
    install -m 755 "${S}/usbmount" "${D}${datadir}/usbmount/usbmount"

    install -d "${D}${libdir}/udev/rules.d"
    install -m 644 "${S}/90-usbmount.rules" "${D}${libdir}/udev/rules.d/90-usbmount.rules"
}

FILES_${PN} = "/"
