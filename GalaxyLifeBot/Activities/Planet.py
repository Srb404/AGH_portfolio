import time

from Management import PictureManagement


def change():
    PictureManagement.click(655, 920)

    time.sleep(1)
    if not PictureManagement.clickPicture("planets/1.png"):
        if not PictureManagement.clickPicture("planets/2.png"):
            if not PictureManagement.clickPicture("planets/3.png"):
                return False
