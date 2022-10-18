import pyautogui


path = "textures/"


def get(pic_name, x=0, y=100, x2=1900, y2=940, confidence=0.9):
    return pyautogui.locateOnScreen(path + pic_name, region=(x, y, x2, y2), grayscale=True, confidence=confidence)


def getAll(pic_name, x=0, y=100, x2=1900, y2=940, confidence=0.9):
    return list(pyautogui.locateAllOnScreen(path + pic_name, region=(x, y, x2, y2), grayscale=True, confidence=confidence))


def getAmountOfAll(pic_name, x=0, y=100, x2=1900, y2=940, confidence=0.9):
    return str(len(getAll(pic_name, x, y, x2, y2, confidence)))
