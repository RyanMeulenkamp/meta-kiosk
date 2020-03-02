
SYSVINIT_ENABLED_GETTYS = ""

do_install_append() {
    echo "1:12345:respawn:/sbin/getty -L -n -l /usr/sbin/autologin 38400 tty1" >> ${D}${sysconfdir}/inittab
    echo "" >> ${D}${sysconfdir}/inittab
}
