import time
from Management import MessageManagement, PictureManagement, FindPicture


def collect():
    # Collects gold
    if not PictureManagement.clickPicture("banks/bank.png"):
        MessageManagement.sendLine("Na ekranie nie znaleziono żadnych banków. Pomijam zbieranie złota.", 1)
    else:
        if FindPicture.get("errors/upgrading_is_in_progress.png"):
            PictureManagement.clickPicture("errors/upgrading_is_in_progress.png")
            MessageManagement.sendLine("Ten bank aktualnie jest ulepszany. Zbieranie monet nie powiodło się.")
        else:
            MessageManagement.sendLine("Zebrano złoto.")

    # Wait, beacuse we are not bots, ok?
    time.sleep(0.2)

    # Collects crystals
    if not PictureManagement.clickPicture("banks/silo.png"):
        MessageManagement.sendLine("Na ekranie nie znaleziono żadnych silosów. Pomijam zbieranie kryształów.", 1)
    else:
        if FindPicture.get("errors/upgrading_is_in_progress.png"):
            PictureManagement.clickPicture("errors/upgrading_is_in_progress.png")
            MessageManagement.sendLine("Ten silos aktualnie jest ulepszany. Zbieranie kryształów nie powiodło się.")
        else:
            MessageManagement.sendLine("Zebrano kryształy.")
