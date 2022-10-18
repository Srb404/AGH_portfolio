from datetime import datetime

from Management import StatusChecker


def getTime():
    currentDateAndTime = datetime.now()
    currentTime = currentDateAndTime.strftime("%H:%M:%S")
    return currentTime


def sendLine(message, blanks=0):
    print("[" + getTime() + "] " + message)
    for _ in range(blanks):
        print("[" + getTime() + "]")


def sendStatus():
    sendLine("Ilość złota: " + StatusChecker.getGold() + " | " + "Ilość kryształów: " + StatusChecker.getCrystals(), 1)
