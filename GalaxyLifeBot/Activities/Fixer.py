from Management import FindPicture
from Management import PictureManagement


def go():
    # Closing dialog boxes and other disturbing things

    # Unit upgraded in the lab or level up
    if FindPicture.get("errors/unit_done.png") or FindPicture.get("errors/lvl_up.png"):
        PictureManagement.clickPicture("buttons/ok.png")

    # Upgrade option activated
    if FindPicture.get("options/upgrade_active.png"):
        PictureManagement.clickPicture("options/cancel.png")
