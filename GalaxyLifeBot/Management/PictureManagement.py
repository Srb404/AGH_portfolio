import time

import pyautogui
import win32api
import win32con

from Management import FindPicture


def click(x, y):
    win32api.SetCursorPos((x, y))
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN, 0, 0)
    time.sleep(0.05)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP, 0, 0)


def getPictureCords(picture):
    x, y = pyautogui.center(picture)
    return [x, y]


def clickPicture(pic, x=0, y=100, x2=1900, y2=940):
    pic_on_screen = FindPicture.get(pic, x, y, x2, y2)
    if pic_on_screen:
        cords = getPictureCords(pic_on_screen)
        click(cords[0], cords[1])
        return True
    else:
        return False
