
SUMMARY = "Bluetooth gadget for my stereo system"

LICENSE = "MIT"

# The minimum necessary to boot
IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_INSTALL:append = " \
alsa-utils-aplay \
alsa-utils-speakertest \
iwd \
${VIRTUAL-RUNTIME_wireplumber-config} \
pipewire \
${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd-networkd-conf', '', d)} \
pipewire-alsa-card-profile \
"

IMAGE_FEATURES += "ssh-server-dropbear"

IMAGE_FSTYPES = "tar.gz wic"

inherit core-image
