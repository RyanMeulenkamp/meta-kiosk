SUMMARY = "Boot directly into Chromium"
LICENSE = "CLOSED"

SRC_URI += " \
    file://mainapp \
    file://nedap.json \
    file://Preferences \
    "

RDEPENDS_${PN} += "sysvinit-inittab chromium-x11"

do_install () {
    install -m 0755 -d "${D}/${sysconfdir}/chromium/policies/managed"
    install -d "${D}/${sysconfdir}/chromium/policies/recommended"
    install -m 0644 "${WORKDIR}/nedap.json" "${D}/${sysconfdir}/chromium/policies/managed/nedap.json"

    install -d "${D}/${sbindir}"
    install -m 0755 "${WORKDIR}/mainapp" "${D}/${sbindir}/mainapp"

    install -d "${D}/home/root/.config/chromium/Default"
    install -m 0644 "${WORKDIR}/Preferences" "${D}/home/root/.config/chromium/Default/Preferences"
}

FILES_${PN} = "/"
CONFFILES_${PN} = "${sysconfdir}"
