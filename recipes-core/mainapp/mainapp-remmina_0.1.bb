SUMMARY = "Boot directly into remmina"
LICENSE = "CLOSED"

SRC_URI += " \
    file://mainapp \
    file://remmina.pref \
    file://template.remmina \
    file://lookup_servers \
    file://update_remmina_configs \
    file://desktop.ini \
    file://usb_drive_desktop.ini \
    "

RDEPENDS_${PN} += "sysvinit-inittab remmina samba-client samba-server usbmount"

do_install () {
    install -d "${D}/home/root/.remmina"
    install -d "${D}/home/root/.remmina_backup"

    install -d "${D}/home/root/.config"
    install -m 0644 "${WORKDIR}/remmina.pref" "${D}/home/root/.config/remmina.pref"

    install -d "${D}/${sysconfdir}"
    install -m 0644 "${WORKDIR}/template.remmina" "${D}/${sysconfdir}/template.remmina"

    install -d "${D}/${bindir}"
    install -m 0755 "${WORKDIR}/lookup_servers" "${D}/${bindir}/lookup_servers"
    install -m 0755 "${WORKDIR}/update_remmina_configs" "${D}/${bindir}/update_remmina_configs"

    install -d "${D}/${sbindir}"
    install -m 0755 "${WORKDIR}/mainapp" "${D}/${sbindir}/mainapp"

    install -d "${D}/media"
    install -m 0644 "${WORKDIR}/desktop.ini" "${D}/media/desktop.ini"
    install -m 0644 "${WORKDIR}/usb_drive_desktop.ini" "${D}${sysconfdir}/usb_drive_desktop.ini"
}

FILES_${PN} = "/"
CONFFILES_${PN} = "${sysconfdir}"
