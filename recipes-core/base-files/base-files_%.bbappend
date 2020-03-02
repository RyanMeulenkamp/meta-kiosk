FILESEXTRAPATHS_prepend := "${THISDIR}/base-files:"

SRC_URI += " \
    file://0001-boot-startx.patch \
    file://autologin \
    "

do_install_append() {
    install -d "${D}/${sbindir}"
    install -m 0755 "${WORKDIR}/autologin" "${D}/${sbindir}/autologin"
}
