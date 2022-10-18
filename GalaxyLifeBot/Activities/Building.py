import time
from Management import WorkersChecker, MessageManagement, PictureManagement, FindPicture, StatusChecker


def upgrade(building_name):
    # Activate building process for every image found on screen
    buildings_on_screen = FindPicture.getAll(building_name)
    if buildings_on_screen:
        building_number = 0
        for _ in buildings_on_screen:
            openBuildingMenu(building_name, buildings_on_screen, building_number)
            building_number = building_number + 1
    else:
        MessageManagement.sendLine("Nie udało się znaleźć żadnego " + building_name + " na ekranie.")
        return False


def upgradeQuery(buildings):
    # Build query for buildings user chose to upgrade
    MessageManagement.sendLine("Aktywowano kolejkę budowy. Rozpoczynam próbę ulepszenia wszystkich wskazanych budynków.")
    for building in buildings:
        MessageManagement.sendLine("Rozpoczynam ulepszanie " + building + "...", 1)
        if not upgrade(building):
            MessageManagement.sendLine("Nie udało się ulepszyć " + building + ".", 1)


def openBuildingMenu(building_name, buildings_on_screen, counter):
    text = "Podejmuję próbę ulepszenia " + building_name + "..."
    # Check if there are any workers available
    if WorkersChecker.getNumber() == 0:
        MessageManagement.sendLine("Aktualnie nie ma żadnych wolnych robotników. [" + str((counter+1)) + "/" + str(len(buildings_on_screen)) + "]")
        return False

    # Looking for the upgrade button in right-down corner
    MessageManagement.sendLine(text + "[1/3] [" + str((counter+1)) + "/" + str(len(buildings_on_screen)) + "]")
    if not PictureManagement.clickPicture("options/upgrade.png"):
        MessageManagement.sendLine("Błąd. Nie udało się kliknąć przycisku ulepszenia.")
        return False

    # Looking for the building passed in the function argument
    MessageManagement.sendLine(text + "[2/3] [" + str(counter+1) + "/" + str(len(buildings_on_screen)) + "]")
    cords = PictureManagement.getPictureCords(buildings_on_screen[counter])
    PictureManagement.click(cords[0], cords[1])

    # Waiting for building info pop-up to fully show himself
    time.sleep(2)

    if FindPicture.get("buttons/upgrade_start.png"):
        MessageManagement.sendLine(text + "[3/3] [" + str(counter+1) + "/" + str(len(buildings_on_screen)) + "]", 1)

        MessageManagement.sendLine("Nazwa budynku: " + StatusChecker.getBuildingName())
        MessageManagement.sendLine("Koszt budowy: " + StatusChecker.getBuildingUpgradeCost())

        upgradeBuilding()

    return True


def upgradeBuilding():
    # Looking for upgrade button
    if not PictureManagement.clickPicture("buttons/upgrade_start.png"):
        MessageManagement.sendLine("Błąd. Nie udało się znaleźć przycisku potwierdzającego ulepszenie.")
        PictureManagement.clickPicture("buttons/x.png")
        time.sleep(1)
        PictureManagement.clickPicture("options/cancel.png")
        return False

    # Waiting for error pop-up to maybe show himself
    time.sleep(2)

    # Checking if there's an error about insufficient coins
    if FindPicture.get("errors/low_coins.png") or FindPicture.get("errors/req_low.png"):
        MessageManagement.sendLine("Błąd. Nie masz wystrczająco dużo monet lub wymagania budynku są zbyt wysokie.")
        PictureManagement.clickPicture("buttons/x.png")
        time.sleep(1)
        PictureManagement.clickPicture("options/cancel.png")
        return False

    # If everything went right, disable upgrade option
    if not PictureManagement.clickPicture("options/cancel.png"):
        MessageManagement.sendLine("Błąd. Nie udało się kliknąć przycisku anulowania ulepszenia.")
        return False

    MessageManagement.sendLine("Sukces! Udało się ulepszyć twój budynek.", 1)

    # Waiting some time before another activity
    MessageManagement.sendLine("Kolejna czynność zostanie wykonana za 3 sekundy.")
    time.sleep(3)
