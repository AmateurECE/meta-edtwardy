FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://wireplumber-override.service"

FILES:${PN}:append = " \
${sysconfdir}/systemd/system/wireplumber.service.d/override.conf \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/system
    install -d ${D}${sysconfdir}/systemd/system/wireplumber.service.d
    install -m 0644 ${WORKDIR}/wireplumber-override.service ${D}${sysconfdir}/systemd/system/wireplumber.service.d/override.conf
}
